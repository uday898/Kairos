<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
  <html>
   <head>
   
   <style type="text/css">
   hr{
border: solid 100px #eee;
color:black;
}
.divider{
margin: 0px 0;
}

  
   </style>
    <%@include file="include/header.jsp" %>
  

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Watches</title>

	<%@include file="include/Navbar.jsp" %>
	</head>
<body>
<div class="container-wrapper">
<div class="container">
 <div class="row">
            
        <div class="page-header">
            <h2>Cart</h2>
        </div>
        </div>
<div ng-app="watchapp" ng-controller="watchController">       
<div ng-init="getCart(${cartId})">


<div>
<br>
<a class="btn btn-danger pull-left" ng-click = "clearCart()">
 <span class="glyphicon glyphicon-remove-sign"></span> Clear Cart</a>
 
 
 <span style="padding-left:100px;"><a href="<c:url value="/MyWishList" />" class="btn btn-primar">Add From Wishlist</a></span>
 
 <a href="<c:url value="/order/${cartId}" />" class="btn btn-success pull-right">
 <span class="glyphicon glyphicon-shopping-cart"></span>Check out</a>
</div>
<br>
<br>
<h3>No.of CartItems:{{cart.cartItems.length}}</h3>


<div ng-repeat="cartitem in cart.cartItems">

  
<div class="panel panel-default">
  <div class="panel-heading" style="background-color:#1abc9c; ">
  <h5 style="color:white;">{{cartitem.watch.watchName}}<span style="padding-left:700px; color:white;"></span>
  
  <a href="#" class="label label-danger" 
 ng-click="removeFromCart(cartitem.cartItemId)">
<span class="glyphicon glyphicon-remove"></span>remove</a>
  
  </h5>
  
  </div>
  
  <div class="panel-body" >
 
<div class="row">

<div class="col-md-3">
<c:url value="resources/images/watches/{{cartitem.watch.watchid}}.jpg" var="img" />
 <img src="${img}" style="width:45%" alt="Watch"/>
</div>
 
<div class="col-md-4"> <h5>
Name:{{cartitem.watch.watchName}}<br><br>
Brand:{{cartitem.watch.brand.brandName}}<br><br>
Type:{{cartitem.watch.displaytype.typeName}}
</h5>
</div>

<div class="col-md-3">
<h4>
Price&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;{{cartitem.price}}
<br><br>
Quantity:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*{{cartitem.quantity}}</h4>
<br>
<hr class="divider">
<hr class="divider">

<br><h4>
TotalPrice:&nbsp;&nbsp;&nbsp;{{cartitem.totalprice}}
</h4>
</div>





</div>
</div>
</div>
</div>


</div>
<h3><a href="<c:url value="/getAllWatches"/>" class="btn btn-primar">Continue shopping</a>
<span style="padding-left:500px;">GrandTotal Price:{{calculateGrandTotal()}}</span></h3>
</div>
</div></div>
<br>
<br>
<br>
<br>
<br>
</body>
</html>


