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
<div class="container">
 <div class="row">
            
        <div class="page-header">
            <h2>Orders</h2><span style="padding-left:500px;"><a href="<c:url value="/myreviews" />" class="btn btn-primar">My Reviews</a></span>
        </div>
        </div>

<c:forEach items="${orders}" var="order">
<div class="panel panel-default">
  <div class="panel-heading" style="background-color:#1abc9c;">
 <h5 style="color:white;"> OrderId&nbsp;&nbsp;:${order.orderId}
<span Style="padding-left:150px;"></span>
Placed On:&nbsp;${order.orderdate}</h5>
  </div>
  
  <div class="panel-body">
 
<div class="row">

<div class="col-sm-5 col-md-3">
<c:url value="resources/images/watches/${order.watch.watchid}.jpg" var="img" />
 <img src="${img}"  style="width:35%"  alt="Watch" />
</div>
<div class="col-sm-4 col-md-4"> 
Name:${order.watch.watchName}
<br>
<br>
Brand:${order.watch.brand.brandName}<br><br>
Type:${order.watch.displaytype.typeName}
</div>

<div class="col-sm-4 col-md-3"><h4>
Price:${order.price}
<br><br>
Quantity:${order.quantity}
<br><br>
TotalPrice:${order.totalprice}
</div>
</h4>
<div class="col-sm-4 col-md-2">

<c:choose>
    <c:when test="${order.reviewed == false}">
<br>&nbsp;&nbsp;<span style="color:yellow;">
<span class="glyphicon glyphicon-star"></span>
<span class="glyphicon glyphicon-star"></span>
<span class="glyphicon glyphicon-star"></span>
<span class="glyphicon glyphicon-star"></span>
<span class="glyphicon glyphicon-star-empty"></span></span><br>
<a href="<c:url value="/review${order.orderId}" />" class="btn btn-primar">Rate & Review</a>
</c:when>
    <c:otherwise>
    <a href="#"  class="btn btn-primar" >Reviewed</a>
    </c:otherwise>
    </c:choose>
</div>

</div>
</div>
</div>
</c:forEach>
</div>

</body>
</html>