<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2026-09-15
  Time: 오후 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <form action="./comso" method="post"> <!-- localhost:8080/pims/comso 를 post 방식으로 요청 -->
      <p>
          <label for="userId">아이디 : </label>
          <input type="text" id="userId" name="userId" required>
      </p>
      <p>
          <label for="userPw">비밀번호 : </label>
          <input type="password" id="userPw" name="userPw" required>
      </p>
      <p>
          <button type="submit">로그인</button>
      </p>
    </form>
  </body>
</html>
