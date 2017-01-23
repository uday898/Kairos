<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
  <html>
   <head>
   <c:url value="resources/bs/css/style.css" var="css" />
 <link rel="stylesheet" href="${css }">
    <%@include file="include/links.jsp" %>
    <%@include file="include/header.jsp" %>
   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular-route.min.js"></script>

<c:url value="/resources/bs/watch.js" var="js" />
<script src="${js}"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Watches</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<%@include file="include/Navbar.jsp" %>
	</head>
<body data-spy="scroll">
<div ng-app="watchapp" ng-controller="watchController">

<br>
<div class="container">
<c:if test="${pageContext.request.userPrincipal.name==null}">
<div class="alert alert-info alert-dismissable">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
    <strong>Info!</strong> Login to Buy this Product
  </div>
  </c:if>

<div class="jumbotron" style="background-color:#ccffff; ">
<div class="row">
<div class="col-sm-6 col-md-4">
     <div class="thumbnail">
 <c:url value="resources/images/watches/${watchObj.watchid}.jpg" var="img" />
 <img src="${img}" alt="Watch"/>
 </div>
 </div>

 <div class="col-sm-6 col-md-6">
<h4>Name   : ${watchObj.watchName}</h4>
<h4><span style="color:yellow;"><span class="glyphicon glyphicon-star"></span>
<span class="glyphicon glyphicon-star"></span>
<span class="glyphicon glyphicon-star"></span>
<span class="glyphicon glyphicon-star"></span>
<span class="glyphicon glyphicon-star-empty"></span></span>
(${avg}/5)
</h4><br>

<p><a href="<c:url value="#details"/>" class="btn btn-primar">View Details</a> 
<a href="<c:url value="#review"/>" class="btn btn-primar">View Reviews</a>
<security:authorize access="hasRole('ROLE_USER')">
<a href="<c:url value="/other${watchObj.watchid}"/>" class="btn btn-primar">Buy from other Seller</a> 
</security:authorize></p>
<table class="table table-responsive table-hover table-condensed table-striped">
<title>Available Sellers:</title>
<thead>
<tr>
<th>Sellers</th>
<th>Price</th>
<th>Stock</th>
<th>Rating</th>
</tr>
</thead>
<c:forEach items="${sellers}" var="seller">
<tr><td>${seller.sname}</td><td>${seller.price}</td><td>${seller.stock}</td><td>${seller.rating}</td></tr>
</c:forEach>
</table>

<c:if test="${pageContext.request.userPrincipal.name==null}">
<div class="alert alert-info alert-dismissable">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
    <strong>Info!</strong> Login to Buy this Product
  </div>
  </c:if>
  
<security:authorize access="hasRole('ROLE_USER')">
<form action="cart/add/${watch.w_s_id}" method=POST>

<h4>Price:Rs.${watch.price}

<span style="padding-right:80px"> </span>

<label>Qty:</label>
<select name="quantity">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
</select></h4>
<br>

<c:choose>
    <c:when test="${watch.stock >= 3}">
       <button type="submit" class="btn btn-warning" ng-click="addToCart()" value="Add Cart">Add to Cart<span class="glyphicon glyphicon-shopping-cart"></span></button>
    </c:when>
    <c:otherwise>
           <button type="submit" class="btn btn-warning btn-large" ng-click="addToCart()" value="Add Cart" disabled="disabled">Add to Cart<span class="glyphicon glyphicon-shopping-cart"></span></button>
    <h3>OUT OF STOCK</h3>
    </c:otherwise>
</c:choose>
<a href="<c:url value="/wishit/${watch.w_s_id}" />" class="btn btn-warning" ng-click="addToWish()">AddWishList<span class="glyphicon glyphicon-heart"></span></a>
</form>
</security:authorize>
</div>
</div>
</div>
</div>
</div>


<div id="details" class="container">
<div class="row">
            
        <div class="page-header">
            <h3>Description</h3>
        </div>
        </div>

<!-- Nav tabs -->
<ul class="nav nav-tabs" role="tablist">
  <li class="active"><a href="#product" role="tab" data-toggle="tab">PRODUCT OVERVIEW</a></li>
  <li><a href="#sellers" role="tab" data-toggle="tab">About Sellers</a></li>
</ul>

<!-- Tab panes -->
<div class="tab-content">
 
  <div class="tab-pane fade in active" id="product">
  <h3>Details</h3>
  <table class="table table-responsive table-hover table-condensed">
   
   <tr><td>Name  &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        :</td> <td>${watchObj.watchName}</td></tr>
 <tr> <td>IdealFor&nbsp;   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;     :</td><td> ${watchObj.idealfor.idealforName}</td></tr>
<tr><td>  Brand   &nbsp;   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   &nbsp;   : </td><td>${watchObj.brand.brandName}</td> </tr>
<tr> <td> DisplayType &nbsp;     :</td><td> ${watchObj.displaytype.typeName }</td> </tr>
  </table>
  </div>
  <div class="tab-pane fade" id="sellers">
      <h3>About the Sellers</h3>
 <table class="table table-responsive table-hover table-condensed table-striped">
<title>Available Sellers:</title>
<thead>
<tr>
<th>Sellers</th>
<th>Price</th>
<th>Stock</th>
<th>Rating</th>
</tr>
</thead>
<c:forEach items="${sellers}" var="seller">
<tr><td>${seller.sname}</td><td>${seller.price}</td><td>${seller.stock}</td><td>${seller.rating}</td></tr>
</c:forEach>
</table>
  </div>
   
<br>
<br>
 <div class="row" id="review">
            
        <div class="page-header">
            <h3>Customer Reviews</h3>
        </div>
        </div>
         <c:choose>
    <c:when test="${empty reviews}">
       <h3>No Reviews Available</h3>
    </c:when>
    <c:otherwise>
      <div class="jumbotron" style="background-color:#ccffff; padding-top:20px; padding-bottom:20px; margin-bottom:10px;" >
      <h3><span style="color:yellow;"><span class="glyphicon glyphicon-star"></span>
<span class="glyphicon glyphicon-star"></span>
<span class="glyphicon glyphicon-star"></span>
<span class="glyphicon glyphicon-star"></span>
<span class="glyphicon glyphicon-star-empty"></span></span>
${avg}<span style="padding-left:10px;">Out of 5 stars</span>
</h3>
        <h4>No.of Reviews:${count}</h4>
        </div>
       <br>
  <div class="jumbotron" style="background-color:white; padding-top:5px; padding-bottom:5px; padding-left:15px;">     
<c:forEach items="${reviews}" var="review">
<div class="container">
<h4>${review.customer.customerName} <small>said on ${review.reviewdate}</small></h4>
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
</c:forEach>
</div></c:otherwise></c:choose></div></div>
<br>

<br>
<br>
<%@ include file="/WEB-INF/views/include/footer.jsp" %></body>
</html>