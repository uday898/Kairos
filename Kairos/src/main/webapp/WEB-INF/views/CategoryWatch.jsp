<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="include/links.jsp" %>
<html>
<head>
<c:url value="resources/bs/css/style.css" var="css" />
 <link rel="stylesheet" href="${css}">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Watches</title>

<%@include file="include/header.jsp" %>
   <%@include file="include/Navbar.jsp" %>
</head>
<body>
<br>
<div class="container">
	<div class="row">	
<c:forEach items="${watches}" var="watch">
  <div class="col-sm-6 col-md-3">
     <div class="thumbnail">
     <c:url value="resources/images/watches/${watch.watchid}.jpg" var="img" />
	<img src="${img}"/>
	${watch.watchName}<br>
       <h3>Price:Rs.${watch.price}</h3>
        <c:url value="/ViewWatch${watch.w_s_id}" var="view" />
             <p><a href="${view}" class="btn btn-primar">Buy Now</a>
           <a href="${view}" class="btn btn-primar">View Details</a></p>
          
    </div>
   </div>
  
		
	
		
		</c:forEach>

</div>
</div>
<%@ include file="/WEB-INF/views/include/footer.jsp" %></body>
</html>