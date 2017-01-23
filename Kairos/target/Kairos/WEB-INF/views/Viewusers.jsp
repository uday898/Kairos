
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="include/links.jsp" %>
<html>
<head>
<c:url value="resources/bs/css/style.css" var="css" />
 <link rel="stylesheet" href="${css}">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Review</title>

<%@include file="include/header.jsp" %>
   <%@include file="include/Navbar.jsp" %>
</head>
<body>


<div class="container" >
   <div class="jumbotron" style="background-color:#ccffff;">
   <div class="row">
   <div class="col-md-3 col-sm-4 col-xs-12"></div>
   <div class="col-md-7 col-sm-4 col-xs-12">

<div class="row"><div class="page-header"><h2>Users</h2></div></div>

<table class="table table-responsive table-condensed table-striped table-border">
<thead>
	<th>User Name</th><th>User Enabled</th><th>Enable/Disable</th>
</thead>

<c:forEach var="user" items="${userlist}">
<tr>
<td>${user.username}</td> <td>${user.enabled}</td>
<td>
 <security:authorize access="hasRole('ROLE_DBA')">
<c:url var="url" value="${user.enabled}"></c:url>
<c:choose>
    <c:when test="${url==true}">
       <a href="disableUser/${user.userId}" style="text-decoration:none;">Disable</a>        
    </c:when>  
    <c:when test="${url==false}">
        <a href="enableUser/${user.userId}" style="text-decoration:none;">Enable</a>         
    </c:when>     
</c:choose>
</security:authorize>
</td>
</tr>
</c:forEach>
</table>


</div>
</div>
</div>
</div>


</body>
</html>