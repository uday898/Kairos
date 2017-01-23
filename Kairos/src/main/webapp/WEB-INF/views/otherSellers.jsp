<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
  <html>
   <head>
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
<br>
<div class="container">
<div class="jumbotron" style="background-color:#ccffff; color:white;">
<div class="row">
<div class="col-md-4">
     <div class="thumbnail">
 <c:url value="resources/images/watches/${watch.watchid}.jpg" var="img" />
 <img src="${img}" style="width:35%;" alt="Watch"/>
 </div>
</div>

<div class="col-md-6">
 
<table class="table table-responsive table-hover table-condensed">
   
   <tr><td>Name  &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        :</td> <td>${watch.watchName}</td></tr>
 <tr> <td>IdealFor&nbsp;   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;     :</td><td> ${watch.idealfor.idealforName}</td></tr>
<tr><td>  Brand   &nbsp;   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   &nbsp;   : </td><td>${watch.brand.brandName}</td> </tr>
<tr> <td> DisplayType &nbsp;     :</td><td> ${watch.displaytype.typeName }</td> </tr>
  </table>
  </div>
  </div>
  </div>
  </div>

 <div class="container">
 
 
<div class="row">
            
        <div class="page-header">
            <h3>Supplier Details</h3>
        </div>
        </div>
 
 
<div class="jumbotron" style="background-color:white; padding-top:5px; padding-bottom:5px; padding-left:15px;">
<c:choose>
    <c:when test="${empty sellers}">
       <p>No other sellers available</p>
    </c:when>
    <c:otherwise>
          
   
<c:forEach items="${sellers}" var="seller">
<div class="col-md-6">
<p>${seller.sname}<span style="padding-left:30px;"></span></p>

<h3><span style="color:yellow;"><span class="glyphicon glyphicon-star"></span>
<span class="glyphicon glyphicon-star"></span>
<span class="glyphicon glyphicon-star"></span>
<span class="glyphicon glyphicon-star"></span>
<span class="glyphicon glyphicon-star-empty"></span></span>
${seller.rating}<span style="padding-left:10px;">Out of 5 stars</span>
</h3>
<br>
<form action="cart/add/${seller.w_s_id}" method=POST>
<h4>Price:Rs.${seller.price}
<span style="padding-right:80px"> </span>
<label>Qty:</label>
<select name="quantity">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
</select></h4>
<br>
  
<security:authorize access="hasRole('ROLE_USER')">
<c:choose>
    <c:when test="${seller.stock >= 5}">
       <button type="submit" class="btn btn-warning btn-large" ng-click="addToCart()" value="Add Cart">Add to Cart<span class="glyphicon glyphicon-shopping-cart"></span></button>
    </c:when>
    <c:otherwise>
           <button type="submit" class="btn btn-warning btn-large" ng-click="addToCart()" value="Add Cart" disabled="disabled">Add to Cart<span class="glyphicon glyphicon-shopping-cart"></span></button>
    <h3>OUT OF STOCK</h3>
    </c:otherwise>
</c:choose>

</security:authorize>
</form>
</div>
</c:forEach>
</c:otherwise></c:choose>
</div>
</div>
<br>
<br>
<br>
<br>
</div>
</body>
</html>