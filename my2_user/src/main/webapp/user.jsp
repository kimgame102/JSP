<%@page import="com.app.jdbc.user.vo.UserVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
<style>
	table {
		width: 700px;
		margin: 0 auto;
		text-align: center;
		border-collapse: collapse;
		border: 1px solid black;
	}
	
	td, th {
		border: 1px solid black;
	}
</style>
</head>
<body>
	<% List<UserVO> users = (List<UserVO>)request.getAttribute("users"); %>
	<button id="go-write">등록하기</button>
	<table>
		<tr>
			<th>번호</th>
			<th>상품명</th>
			<th>가격</th>
		</tr>
		<%for(UserVO userVO: users) {%>
			<tr>
				<td><%=userVO.getId()%></td>
				<td><a href="read?id=<%=userVO.getId() %>"><%=userVO.getUserName()%></a></td>
				<td><%=userVO.getUserAge()%></td>
			</tr>
		<%} %>
	</table>
</body>
<script>
	const goWriteButton = document.getElementById("go-write");
	goWriteButton.addEventListener("click", (e) => {
		// 이동
		location.href = "write";
	});
</script>
</html>