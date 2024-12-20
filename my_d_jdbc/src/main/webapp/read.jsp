<%@page import="com.app.jdbc.guest.vo.GuestVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest</title>
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
   <% GuestVO guestVO = (GuestVO)request.getAttribute("guest"); %>
   <button id="go-list">등록하기</button>
   <table>
      <tr>
         <th>번호</th>
         <th>이름</th>
         <th>생년월일</th>
      </tr>
      <% if (guestVO != null) { %>
         <tr>
            <td><%=guestVO.getId()%></td>
            <td><%=guestVO.getGuestName()%></td>
            <td><%=guestVO.getGuestBirth()%></td>
         </tr>
      <% } else { %>
         <tr>
            <td colspan="3">Guest not found</td>
         </tr>
      <% } %>
   </table>
</body>
<script>
   const goListButton = document.getElementById("go-list");
   goListButton.addEventListener("click", (e) => {
      // 이동
      location.href = "list";
   });
</script>
</html>
