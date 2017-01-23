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

<div ng-app="watchapp" ng-controller="watchController">
<div class="container-wrapper">
<div class="container">
<section>

<div class="container">
 <div class="row">
            
        <div class="page-header">
            <h2>WishList</h2>
        </div>
        </div>
</section>

<table class="table table-hover">
<thead>
<h3>No Of Items:{{count}}</h3>
<tr>
<th>WatchNAme</th>
<th>Brand</th>
<th>Image</th>
<th>Remove/Buy</th>
</tr>
</thead>
				<c:forEach items="${Items}" var="item">
					<tr><td>${item.watch.watchName}<br><br><small>Added on ${item.wishdate}</small></td>
					<td>${item.watch.brand.brandName}<br><br>
					
					Price:${item.price}</td>
					
					<td><c:url value="resources/images/watches/${item.watch.watchid}.jpg" var="img" />
 <img src="${img}" style="width:30%" alt="Watch"/></td>
					<td><a href="<c:url value="/removeitem/${item.wishId}" />" class="btn btn-danger"> <span class="glyphicon glyphicon-remove"></span>remove</a>
					<br><br><a href="<c:url value="/ViewWatch${item.w_s_id}" />" class="btn btn-primar" ng-click="removeFromWishlist(${item.wishId})">Buy Now</a></td>
					</tr>
					</c:forEach>
			</table>
<c:url value="/getAllWatches" var="url"></c:url>
<a href="${url }" class="btn btn-primar">Continue shopping</a>
</div>
</div>
</div>
</body></html>