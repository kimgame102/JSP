<%@page import="com.app.jdbc.post.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read</title>
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
   <%
   PostVO postVO = (PostVO) request.getAttribute("post");
   %>
   <button id="go-update">수정하기</button>
   <button id="go-delete">삭제하기</button>
   <table>
      <tr>
         <th>번호</th>
         <th>상품명</th>
         <th>가격</th>
      </tr>
      <tr>
         <td><%=postVO.getId()%></td>
         <td><%=postVO.getPostTitle()%></td>
         <td><%=postVO.getPostLiked()%></td>
      </tr>
   </table>
   <form action="update" name="go-update-form">
      <input type="hidden" name="id" value="<%=postVO.getId()%>">
   </form>
   <form action="delete/ok" name="go-delete-form">
   		<input type="hidden" name="id" value="<%=postVO.getId()%>">
   </form>
</body>
<script>
   const goUpdateButton = document.getElementById("go-update");
   goUpdateButton.addEventListener("click", (e) => {
      document["go-update-form"].submit();
   });
   const goDeleteButton = document.getElementById("go-delete");
   goDeleteButton.addEventListener("click", (e) => {
      document["go-delete-form"].submit();
   });
</script>
</html>