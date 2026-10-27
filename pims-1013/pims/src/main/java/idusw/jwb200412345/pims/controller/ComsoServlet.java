package idusw.jwb200412345.pims.controller;

import idusw.jwb200412345.pims.model.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="comsoServlet", value="/comso")
public class ComsoServlet extends HttpServlet {
    Member member = new Member();
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        // request 객체에 파라미터 userId, userPw와 해당 값이 저장되어 있음
        // request 객체에 attribute를 추가, 기존 parameter도 존재함
        // attribute는 다양한 객체를 설정할 수 있음. parameter는 문자열 객체만 주소표시줄 또는 폼을 통해 설정
        //request.setAttribute("attrId", request.getParameter("userId"));
        //request.setAttribute("attrPw", request.getParameter("userPw"));
        member.setId(request.getParameter("userId"));
        member.setPw(request.getParameter("userPw"));
        request.setAttribute("attrName",member); // attrName라는 이름의 attribute로 member 객체를 전달
        request.setAttribute("mt", request.getMethod());
        request.getRequestDispatcher("./view.jsp").forward(request, response);
        /*
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "doPost " + request.getParameter("userId") + "</h1>");
        out.println("<h1>" + "doPost " + request.getParameter("userPw") + "</h1>");
        out.println("</body></html>");
         */
        // form 구성요소별 name 속성이 파라미터 이름이 됨, 표준 출력 stdout 에 결과를 출력
        // System.out.println("doPost " + request.getParameter("userId"));
        // System.out.println("doPost " + request.getParameter("userPw"));
        // PrintWriter out = response.getWriter(); 의 out은 응답 객체의 출력 객체 - 웹 페이지에 출력
        // System.out 의 out은 표준출력(standard output) 객체 - 콘솔창에 출력
    }
}
