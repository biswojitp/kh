<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
      <div align="center">
        <table border="1">
           
            <tr>
                <th>UserID</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Password</th>
                <th>Phone</th>
                <th>Gender</th>
                
            </tr>
            <c:forEach var="appUser" items="${regUserList}">
                <tr>
                    <td><a href="http://localhost:8081/editAppUser.htm?userId=${appUser.userId}"><c:out value="${appUser.userId}" /></a></td>
                    <td><c:out value="${appUser.firstName}" /></td>
                    <td><c:out value="${appUser.lastName}" /></td>
                    <td><c:out value="${appUser.email}" /></td>
                    <td><c:out value="${appUser.password}" /></td>
                    <td><c:out value="${appUser.phone}" /></td>
                    <td><c:out value="${appUser.gender}" /></td>
                    
                    
                </tr>
            </c:forEach>
        </table>
    </div>
       
   </body>
</html>