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

  <style>
  .jumbotron{
  
    
    padding:0 !important;
    background: #eee;
    margin-top: 10px;
   margin-bottom:10px;
    
    background-color:#663300;
  color:white;
  
}
.container-fluid{
    padding:0 !important;
}
.col-xs-4{
    background:rgba(157,52,99,0.7);    
}
  

  </style>
</head>
<body >



<div class="container-fluid">
      <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-xs-12 col-sm-9 col-sm-push-3">
          <button type="button" class="pull-left btn btn-default visible-xs" data-toggle="offcanvas" aria-expanded="false" aria-controls="navbar">
            <i class="fa fa-navicon"></i>
          </button>
          
          
          
          <br>
          
          
          <div class="jumbotron">
          <div class="container" style="background-color:#ff6600; color:black; padding-bottom:5px; padding-top:8px;">
          <h2>Basic Profile</h2>
          </div>
        
        <div id="section12" style="padding-left:20px; padding-bottom:10px; padding-top:10px; margin-bottom:2px;">
        <h4>Name:&nbsp;${customer.customerName}<br><br>
        Email:&nbsp;${customer.customerEmail}<br><br>
        Phone:&nbsp;${customer.customerPhone}<br><br>
        Username:&nbsp;${customer.users.username}<br><br></h4>
        <a href="<c:url value="/EditProfile" />" class="btn btn-primar">Edit Basic Profile </a>
        <a href="<c:url value="/checkpassword" />" class="btn btn-primar">Reset Password </a>
        
      </div>
          </div>
          
          <div class=jumbotron>
          <div class="container" style="background-color:#ff6600;color:black; padding-bottom:5px; padding-top:8px;">
          <h2>Billing Address</h2>
          </div>
             <div id="section2" style="padding-left:20px; padding-bottom:10px; padding-top:10px; margin-bottom:2px;"> 
       <h4>
    StreetName:&nbsp;${customer.billingAddress.streetName}<br><br>
    ApartmentNo.:&nbsp;${customer.billingAddress.apartmentNumber}<br><br>
    State:&nbsp;${customer.billingAddress.state}<br><br>
    city:&nbsp;${customer.billingAddress.city}<br><br>
    country:&nbsp;${customer.billingAddress.country}<br><br>
    Zipcode:&nbsp;${customer.billingAddress.zipcode}<br><br>
</h4>      
             
            </div>
            </div><!--/.col-xs-6.col-lg-4-->
           
            <div class="jumbotron">
            <div class="container" style="background-color:#ff6600;color:black; padding-bottom:5px; padding-top:8px;">
          <h2>Shipping Address</h2>
          </div>
            <div id="section3" style="padding-left:20px; padding-bottom:10px; padding-top:10px; margin-bottom:2px;">         
        
        <h4>StreetName:&nbsp;${customer.shippingAddress.streetName}<br><br>
    ApartmentNo.:&nbsp;${customer.shippingAddress.apartmentNumber}<br><br>
    State:&nbsp;${customer.shippingAddress.state}<br><br>
    city:&nbsp;${customer.shippingAddress.city}<br><br>
    country:&nbsp;${customer.shippingAddress.country}<br><br>
    Zipcode:&nbsp;${customer.shippingAddress.zipcode}<br><br></h4>
      </div>
            
         </div>   
          </div><!--/row-->
      

        <div class="col-xs-6 col-sm-3 col-sm-pull-9 sidebar-offcanvas" id="sidebar">
          <div class="list-group">
            <a href="#section12" class="list-group-item active">User Details</a>
            <a href="#section2" class="list-group-item">Billing Address</a>
            <a href="#section3" class="list-group-item">Shipping Address</a>
            
            
          </div>
        </div><!--/.sidebar-offcanvas-->
      </div><!--/row-->

     
<br>
<br>
<br>
<br>
<br>
<br>


</body>
</html>
