package idusw.jwb200412345.jdbc;

import idusw.jwb200412345.jdbc.model.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/mysql-users")
public class JdbcController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    protected void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jdbcUrl = "jdbc:mysql://210.102.226.242:8080/mysql?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
        String dbUser = "root";
        String dbPass = "cometrue";
        // 드라이버 로딩
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        try {
            // 커넥션 생성
            conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
            // 문장 생성
            stmt = conn.createStatement();
            // 질의 수행
            rs = stmt.executeQuery("select * from time_zone_name");
            System.out.println("Connection Success - " + jdbcUrl);

            ArrayList<UserDTO> users = new ArrayList<UserDTO>();
            while (rs.next()) { // rs : result set (결과 집합) vs. db의 records
                UserDTO user = new UserDTO();
                user.setFirstField(rs.getString(1));
                user.setSecondField(rs.getString(2));
                users.add(user);
                //out.print(rs.getString(1) + "&nbsp;&nbsp;&nbsp;");
                //out.println(rs.getString(2) + "</br>");
            }
            request.setAttribute("users", users); // 속성으로 설정함
            request.getRequestDispatcher("/jdbc-result.jsp").forward(request, response);
            // 요청,응답 객체를 jdbc-result.jsp에 전달

        } catch (SQLException e) {
            System.out.println("Connection Fail - ");
        } finally { // 자원 회수
            if (rs != null) try {                rs.close();            } catch (Exception e) {            }
            if (pstmt != null) try {                pstmt.close();            } catch (Exception e) {            }
            if (stmt != null) try {                stmt.close();            } catch (Exception e) {            }
            if (conn != null) try {                conn.close();            } catch (Exception e) {            }
        }
        /*
    	try {
            if (conn.isClosed())
                System.out.println("Connection - close");
            else
                System.out.println("Connection - not close");
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

         */
    } // end of process()
} // end of class
