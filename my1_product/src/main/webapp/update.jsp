<%@page import="com.app.jdbc.product.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
   <% ProductVO productVO = (ProductVO)request.getAttribute("product"); %>
   
   <form action="update/ok" method="post">
      <input type="text" name="productName" placeholder="이름을 작성하세요." value="<%=productVO.getProductName()%>">
      <input type="text" name="productPrice" value="<%=productVO.getProductPrice()%>">
      <input type="hidden" name="id" value="<%=productVO.getId() %>">
      <button>수정 완료</button>
   </form>
</body>
</html>