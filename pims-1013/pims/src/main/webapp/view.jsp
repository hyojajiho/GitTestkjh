<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="idusw.jwb200412345.pims.model.Member" %>
<html>
  <head>
    <title>message.jsp</title>
  </head>
  <body>
  <table border=1>
  <%

        // attrName이라는 속성 객체를 Member 유형으로 형변환하여, m 참조변수에 배정
        Member m = (Member) request.getAttribute("attrName");
  %>

  <tr><td>ID : <%= m.getId() %></td></tr>
  <tr><td>PW : <%= m.getPw() %></td></tr>
  <tr><td>Method : <%= request.getAttribute("mt") %></td></tr>
  </table>
  </body>
</html>
