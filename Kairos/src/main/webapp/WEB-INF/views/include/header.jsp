<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular-route.min.js"></script>

<%@include file="links.jsp"%>

<c:url value="resources/bs/css/style.css" var="css" />
 <link rel="stylesheet" href="${css }">

<c:url value="/resources/bs/watch.js" var="js" />
<script src="${js}"></script>

<c:url value="/resources/bs/WishList.js" var="js" />
<script src="${js}"></script>

<style type="text/css">
  body{
    font-size: 150%;
	background: honeydew ;		
	
 </style>

</head>
<body>

		<div class="header-top container-fluid" id="section1">
				
			<div class="header-top-in">			
				<div class="logo">
					<a href="<c:url value="/"/>"><img src="resources/images/chill.png" alt="Kairos" height=7%> </a>
				
				</div>&nbsp;
				<font size="6" color="red" face="Cambria, Georgia, serif">Kairos</font>
				
				<div class="header-in">
					<ul class="icon1 ">
					        
					        <c:if test="${pageContext.request.userPrincipal.name==null}">
							<li > <a href="<c:url value="/registration"/>"><span class="glyphicon glyphicon-user"></span>Register</a> </li>
							<li > <a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-lock"></span>Login</a> </li>	
							</c:if>
							
							<c:if test="${pageContext.request.userPrincipal.name!=null}" >
						  
						
							 <security:authorize access="hasRole('ROLE_ADMIN')">
				            <li><a href="<c:url value="/addWatch"/>">Add Watch</a></li>
		                    </security:authorize>
		                    
		                    
                            
                            <security:authorize access="hasRole('ROLE_USER')">
						  <li><a href="<c:url value="/contact"/>">24x7 Support</a></li>
				            
				           
				           
				              <li><a href="<c:url value="/Myprofile"/>">MyProfile</a></li>
		                    </security:authorize> 
                            
                            <security:authorize access="hasRole('ROLE_DBA')">
						  
				              <li><a href="<c:url value="/stats"/>">Statitics</a></li>
		                    </security:authorize> 
                            
                            </c:if>
						  
						</ul>
				</div>
			</div>
			</div>
		

