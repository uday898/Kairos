<head>

<%@ include file="include/links.jsp" %>
<%@ include file="include/Navbar.jsp" %>

<style type="text/css">
body{
    font-size: 150%;
	background: url(resources/images/bg.jpg) no-repeat 0px 0px;
    background-size: cover;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    -ms-background-size: cover;
    background-attachment: fixed;
	
}

</style>
</head>
<html>
<body>
<br>
    <div class="container">
   
        <c:url value="/Editpassword" var="url"></c:url>
        <form:form action="${url}"  method="POST" commandName="customer">
     
      <div class="row">
            
        <div class="page-header">
        <h2>  <span style="color:white;"> Enter New Password</span></h2>
        </div>
        </div>
        <form:hidden path="customerId"  class="form-Control" readonly="true"/>
         <form:hidden path="users.userId"  class="form-Control" readonly="true"/>
          <form:hidden path="shippingAddress.shippingAddressId"  class="form-Control" readonly="true"/>
                    <form:hidden path="billingAddress.billingAddressId"  class="form-Control" readonly="true"/>
                              <form:hidden path="cart.cartId"  class="form-Control" readonly="true"/>
       <form:hidden path="users.enabled" class="form-Control" />
       <form:hidden path="cart.customer.customerId" class="form-Control" required="true" />
                
                
                
            <div class="col-md-6">
        <div class="form-group">
          <span style="color:white;">  <label for="password">New Password</label></span>
            <form:errors path="users.password" cssStyle="color: #ff0000" />
            <div class="input-group">
      <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>    
            <form:password path="users.password"   required="true" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" class="form-Control" />
        </div>
        </div>
          </div> 
           
                      
            <form:hidden path="customerName" id="name" class="form-Control" />
       
      
            <form:hidden path="customerEmail" id="email" class="form-Control" />
       
            <form:hidden path="customerPhone" id="phone" class="form-Control" />
       
        <form:hidden path="users.username"  class="form-Control" />



       
            <form:hidden path="billingAddress.streetName" id="billingStreet" class="form-Control" />
       

        
            <form:hidden path="billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-Control" />
        

        
            <form:hidden path="billingAddress.city" id="billingCity" class="form-Control" />
        
       
            <form:hidden path="billingAddress.state" id="billingState" class="form-Control" />
       

        
            <form:hidden path="billingAddress.country" id="billingCountry" class="form-Control" />
        

        
            <form:hidden path="billingAddress.zipcode" id="billingZip" class="form-Control" />
        
            <form:hidden path="shippingAddress.streetName"  class="form-Control" />
             <form:hidden path="shippingAddress.apartmentNumber"  class="form-Control" />
            <form:hidden path="shippingAddress.city"  class="form-Control" />
             <form:hidden path="shippingAddress.state"  class="form-Control" />
              <form:hidden path="shippingAddress.country"  class="form-Control" />
               <form:hidden path="shippingAddress.zipcode"  class="form-Control" />
               
               
               
               
        <br>
<div class="row">
            <div class="col-md-12">

        <input type="submit" value="Submit" class="btn btn-primar"><span style="padding-left:300px;"></span>
        <a href="<c:url value="/" />" class="btn btn-danger">Cancel</a>
     </div>
     </div>
           </form:form>
           </div>        