<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="include/links.jsp" %>
<html>
<head>
<style>

</style>
<c:url value="resources/bs/css/style.css" var="css" />
 <link rel="stylesheet" href="${css}">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyOrders</title>

<%@include file="include/header.jsp" %>
   <%@include file="include/Navbar.jsp" %>
</head>
<body>
<br>
<br>
<div class="jumbotron" style="background-color:white; padding-top:5px; padding-bottom:5px; padding-left:15px;">     
<c:forEach items="${reviews}" var="review">




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




<div class="container">

 <small>Reviewed on ${review.reviewdate}</small>
<div class="media">
  <div class="media-left">
    <h3><span class="label label-success">
     ${review.rating}&nbsp;<span style="color:yellow;"><span class="glyphicon glyphicon-star"></span></span>
    </span></h3>
  </div>
  <div class="media-body">
    <h4 class="media-heading">${review.title}</h4>
   
    ${review.review}
  </div>
</div>
</div> 
<br>
<br>
<br>
</c:forEach>



</body>
</html>