
<html>
<head>

<title>Kairos</title>

<%@include file="include/links.jsp" %>
<%@include file="include/header.jsp" %>

<style type="text/css">

.marketing{
text-align: center;
margin-bottom:20px;
}
hr{
border: solid 1px #eee;
}
.divider{
margin: 80px 0;
}
</style>

<c:url value="resources/bs/css/style.css" var="css" />
 <link rel="stylesheet" href="${css }">
</head>
<body>

<%@include file="include/Navbar.jsp" %>

<%@include file="include/carousel.jsp" %>
<div class="container">
<div class="clearfix" style="margin-bottom:20px;"></div>
<!-- Marketing -->
<div class="container-fluid" >
<div class="row marketing">

<div class="col-md-4 col-sm-4 col-xs-12">
<img src="resources/images/i_m.jpg" alt="Men" class="img-circle">
<h2>Men Watches</h2>
<a href="<c:url value="/MenWatches"/>" class="btn btn-primar" role="button">View All</a>
</div>

<div class="col-md-4 col-sm-4 col-xs-12">
<img src="resources/images/i_wm.jpg" alt="Men" class="img-circle">
<h2>Women Watches</h2>
<a href="<c:url value="/WomenWatches"/>" class="btn btn-primar" role="button">View All</a>
</div>

<div class="col-md-4 col-sm-4 col-xs-12">
<img src="resources/images/i_kd.jpg" alt="Men" class="img-circle">
<h2>Kids Watches</h2>
<a href="<c:url value="/KidWatches"/>" class="btn btn-primar" role="button">View All</a>
</div>

</div>
</div>
<hr class="divider">
<!-- end marketing -->

<div class="container">
 <div class="row">
            
        <div class="page-header">
        <h2>New Arrivals</h2>
        </div>
        </div>
	<div class="row">	
<c:forEach items="${watches}" var="watch">
  <div class="col-sm-6 col-md-3">
    <label></label> <div class="thumbnail">
     <c:url value="resources/images/watches/${watch.watchid}.jpg" var="img" />
	<img src="${img}"/>
	${watch.watchName}<br>
       <h3>Price:Rs.${watch.price}</h3>
        <c:url value="/ViewWatch${watch.w_s_id}" var="view" />
           <p><a href="${view}" class="btn btn-primar">Buy Now</a>
           <button type="button" class="btn btn-primar" data-toggle="modal" data-target="#myModal${watch.watchid}">Quick View</button></p>
           
           
           <div class="container">
  <!-- Modal -->
  <div class="modal" id="myModal${watch.watchid}" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header" style="background-color:#1abc9c;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" >${watch.watchName}</h4>
        </div>
        <div class="modal-body">
  
     <div class="thumbnail">
 <c:url value="resources/images/watches/${watch.watchid}.jpg" var="img" />
 <img src="${img}" style="width:20%;" alt="Watch"/>
 </div>
</div> 
<div class="container-fluid">
<table class="table table-responsive table-hover table-condensed">
   
   <tr><td>Name  &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        :</td> <td>${watch.watchName}</td></tr>
 
<tr><td>  Brand   &nbsp;   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   &nbsp;   : </td><td>${watch.brand}</td> </tr>
<tr> <td> Price&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    :</td><td> ${watch.price}</td> </tr>
  <tr><td>Seller &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</td><td>${watch.sname}(${watch.rating})</td></tr>
  </table></div>
 
</div>
</div></div></div></div></div>
           
  </c:forEach>

</div>
</div>
</div>




  <%@ include file="/WEB-INF/views/include/footer.jsp" %>
  </body>
  </html>
  