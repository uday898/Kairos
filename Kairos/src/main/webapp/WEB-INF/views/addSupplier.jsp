<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
   
   <html> 
   <head>
   <style type="text/css">
.main{
    font-size: 150%;
	background: url(resources/images/bg.jpg) repeat 0px 0px;
    background-size: cover;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    -ms-background-size: cover;
    background-attachment: fixed;
	
}

</style>
<%@include file="include/header.jsp" %>
   <%@include file="include/Navbar.jsp" %>

   </head>
   <body>
 <div class="main"> 
   <br>
   <div class="container">
   <div class="jumbotron" style="background-color:#ccffff;">
   <div class="row">

<div class="col-md-3 col-sm-4 col-xs-12"></div>
<div class="col-md-9 col-sm-4 col-xs-12">
<h2>Existing Suppliers</h2>
	<table border="1">
		<tr>
			<th>Supplier Id</th>
			<th>Supplier Name</th>
			<th>Supplier Desc</th>
			<th>Rating</th>
		</tr>
		<c:forEach items="${suppliersdata}" var="s">
		<tr>
		<td>${s.sid}</td>
		<td>${s.sname}</td>
		<td>${s.supp_desc}</td>
		<td>${s.rating}</td>
        </tr>
		
		</c:forEach>
	</table>	
</div>
</div>
</div>
</div>
</div>
<div class="container-fluid">
<div class="row">

<div class="col-md-3 col-sm-4 col-xs-12">
</div>
<div class="col-md-9 col-sm-4 col-xs-12">
<h2>Add New Supplier</h2>
<form:form action="addSupplier1" commandName="supplier" method="POST">

<div class="form-group">
            <form:label path="sname">Supplier Name:</form:label>
            <form:input path="sname"/>
 </div>
 
<div class="form-group">
            <label for="supp_desc">Supplier Desc:</label>
<form:input path="supp_desc"/>
</div>

<div class="form-group">
            <label for="rating">Rating:</label>
<form:input path="rating"/>
</div>

<input type="submit" value="Add Supplier" class="btn btn-primar" />


</form:form>
</div>
</div>   
</div>
   </body>
   </html>