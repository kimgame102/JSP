<%@page import="com.app.jdbc.menu.vo.MenuVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
	<% MenuVO menuVO = (MenuVO)request.getAttribute("menu"); %>
   
   <form action="update/ok" method="post">
      <input type="text" name="menuName" placeholder="이름을 작성하세요." value="<%=menuVO.getMenuName()%>">
      <input type="text" name="menuPrice" value="<%=menuVO.getMenuPrice()%>">
      <input type="hidden" name="id" value="<%=menuVO.getId() %>">
      <button>수정 완료</button>
   </form>
</body>
</html>