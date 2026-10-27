<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="idusw.jwb200412345.jdbc.model.UserDTO" %>
<%@ page import="java.util.ArrayList" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <%-- out : JSP의 기본 객체로 출력을 담당 --%>
  <table border="1">
  <%
    // PrintWriter out = response.getWriter();
    ArrayList<UserDTO> dtos = (ArrayList<UserDTO>) request.getAttribute("users");
    for(UserDTO user : dtos) {
        out.print("<tr>");
        out.print("<td>" + user.getFirstField() + "</td>");
        out.print("<td>" + user.getSecondField() + "</td>");
        out.print("</tr>");
    }
  %>
  </table>
  </body>
</html>
