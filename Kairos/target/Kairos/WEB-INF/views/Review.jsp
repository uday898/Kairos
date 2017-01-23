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
<br>

<c:url value="/submitReview" var="url"/>
<form:form action="${url}" commandName="review" method="POST">




<div class="container">
<div class="jumbotron" style="background-color:#ccffff; color:white;">
<div class="row">
<div class="col-md-4">
     <div class="thumbnail">
 <c:url value="resources/images/watches/${review.watch.watchid}.jpg" var="img" />
 <img src="${img}" style="width:35%;" alt="Watch"/>
 </div>
</div>

<div class="col-md-6">
 
<table class="table table-responsive table-hover table-condensed">
   
   <tr><td>Name  &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        :</td> <td>${review.watch.watchName}</td></tr>
 <tr> <td>IdealFor&nbsp;   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;     :</td><td> ${review.watch.idealfor.idealforName}</td></tr>
<tr><td>  Brand   &nbsp;   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   &nbsp;   : </td><td>${review.watch.brand.brandName}</td> </tr>
<tr> <td> DisplayType &nbsp;     :</td><td> ${review.watch.displaytype.typeName }</td> </tr>
  </table>
  </div>
  </div>
  </div>
  </div>



<div class="container" >

      <div class="row">
            
        <div class="page-header">
            <h2>Rate and Review</h2>
        </div>
        </div>
<div class="jumbotron">
 <div class="row">
            <div class="col-md-12">

<div class="form-group">
         <h3>   <form:label path="rating">Rate the Product</form:label> <span style="padding-left:75px;"></span>
	    <form:radiobutton path="rating" value="1.0"/>1
	     <form:radiobutton path="rating" value="2.0"/>2	
	      <form:radiobutton path="rating" value="3.0"/>3
	      <form:radiobutton path="rating" value="4.0"/>4
	      <form:radiobutton path="rating" value="5.0"/>5
        </h3></div>
        
<div class="form-group">
         <h3>   <form:label path="rating">Rate the Seller</form:label> <span style="padding-left:75px;"></span>
	    <form:radiobutton path="srating" value="1.0"/>1
	     <form:radiobutton path="srating" value="2.0"/>2	
	      <form:radiobutton path="srating" value="3.0"/>3
	      <form:radiobutton path="srating" value="4.0"/>4
	      <form:radiobutton path="srating" value="5.0"/>5
        </h3></div>        
        
        

   
<form:hidden path="watch.watchid" id="input"  class="rating rating-loading"/>
<form:hidden path="supplier.sid" id="input"  class="rating rating-loading"/>
<form:hidden path="customer.customerId" id="input"  class="rating rating-loading"/>        
  </div>
  </div>
        
 <div class="row">
            <div class="col-md-12">
        <div class="form-group">
            <label for="title">Title</label>
          <form:input path="title"  class="form-Control" required="true"/>
            </div>
           </div>
            </div>
                     
            
    <div class="row">
            <div class="col-md-12">
        <div class="form-group">
            <label for="title">Review</label>
          <form:textarea path="review"  class="form-Control" required="true"/>
            </div>
           </div>
            </div>
            
            
            <div class="row">
            <div class="col-md-12">

        <input type="submit" value="Submit" class="btn btn-primar ">
            </div>
          </div>
          </div>
          </div>
    </form:form>

</body>
</html>