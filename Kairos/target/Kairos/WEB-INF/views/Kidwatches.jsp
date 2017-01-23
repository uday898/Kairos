<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
  <html>
   <head>
   <style type="text/css">
 
.main{
    width: 100%;
	height: 63px;
	background: url(resources/images/back1.png)0px 0px ;
	display:block;
   
   
   }
   
   </style>
    <%@include file="include/header.jsp" %>
   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular-route.min.js"></script>

<c:url value="/resources/bs/watch.js" var="js" />
<script src="${js}"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>KidWatches</title>

	<%@include file="include/Navbar.jsp" %>
	</head>
<body>



<div ng-app="watchapp" ng-controller="watchController" ng-init="kidwatches()">
<div class="main">
			<div class="container">
			<div class="header-bottom-on">
			
			<div class="header-can">
				 
					<div class="search">
					
					<input type="text" ng-model="searchCondition"  placeholder="Search watches">
					</div>
		</div><p class="wel"><a href="#">Search for Brand,Type,Name: </a></p>
		</div></div>
</div>

<br>

<div class="container">
<div class="row">
<div ng-repeat="watch in gkwatches | filter:searchCondition">
 <div class="col-sm-6 col-md-3">
     <div class="thumbnail">
<c:url value="resources/images/watches/{{watch.watchid}}.jpg" var="src" />
		<img src="${src }"/>
		{{watch.watchName}}<br>
       <h3>Price:Rs.{{watch.price}}</h3>
        <c:url value="/ViewWatch{{watch.w_s_id}}" var="view" />
           <p><a href="${view}" class="btn btn-primar">Buy Now</a>
           <button type="button" class="btn btn-primar" data-toggle="modal" data-target="#myModal{{watch.watchid}}">Quick View</button></p>
           
           
           <div class="container">
  <!-- Modal -->
  <div class="modal" id="myModal{{watch.watchid}}" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header" style="background-color:#1abc9c;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" >{{watch.watchName}}</h4>
        </div>
        <div class="modal-body">
  
     <div class="thumbnail">
 <c:url value="resources/images/watches/{{watch.watchid}}.jpg" var="img" />
 <img src="${img}" style="width:20%;" alt="Watch"/>
 </div>
</div> 
<div class="container-fluid">
<table class="table table-responsive table-hover table-condensed">
   
   <tr><td>Name  &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        :</td> <td>{{watch.watchName}}</td></tr>
 
<tr><td>  Brand   &nbsp;   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   &nbsp;   : </td><td>{{watch.brand}}</td> </tr>
<tr> <td> Price&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    :</td><td> {{watch.price}}</td> </tr>
  <tr><td>Seller &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</td><td>{{watch.sname}}</td></tr>
  </table></div>
  </div>
  </div>
  </div>
  </div>

        </div>
        
      </div>
    </div>
  </div>
</div>
</div>
</div>



<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
