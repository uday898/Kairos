
<head>

<%@ include file="include/links.jsp" %>
<%@ include file="include/Navbar.jsp" %>

<style type="text/css">
body{
    font-size: 150%;
	background: url(resources/images/bg1.jpg) no-repeat 0px 0px;
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
   
        <c:url value="/registrationedit" var="url"></c:url>
        <form:form action="${url}"  method="POST" commandName="customer">
     
      <div class="row">
            
        <div class="page-header">
            <h2>User Details</h2>
        </div>
        </div>
        <form:hidden path="customerId"  class="form-Control" readonly="true"/>
         <form:hidden path="users.userId"  class="form-Control" readonly="true"/>
          <form:hidden path="shippingAddress.shippingAddressId"  class="form-Control" readonly="true"/>
                    <form:hidden path="billingAddress.billingAddressId"  class="form-Control" readonly="true"/>
                              <form:hidden path="cart.cartId"  class="form-Control" readonly="true"/>
       <form:hidden path="users.enabled" class="form-Control" />
       <form:hidden path="cart.customer.customerId" class="form-Control" required="true" />
                <form:hidden path="users.password"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" class="form-Control" />
                   
   <div class="row">
            <div class="col-md-12">
        <div class="form-group">
            <label for="name">Name</label><span style="color:red">*</span>
            <form:errors path="customerName" cssStyle="color: #ff0000" />
             <div class="input-group">
      <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>    
            <form:input path="customerName"  class="form-Control" required="true"/>
            </div>
           </div>
            </div>
    </div>

        
  
  <div class="row">
            <div class="col-md-6">
        
        <div class="form-group">
        <c:if test="${duplicateEmail !=null}">
            
          <div class="error" style="color:rgb(0,128,0);">  ${duplicateEmail}</div></c:if>
            <label for="email">Email</label><span style="color:red">*</span>
            <form:errors path="customerEmail" cssStyle="color: #ff0000" />
            <div class="input-group">
      <div class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></div>    
            <form:input path="customerEmail"  required="true"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Give Valid Email Id" class="form-Control" />
        </div></div>
       </div>
       
       
            <div class="col-md-6">
        <div class="form-group">
            <label for="phone">Phone</label>
            <div class="input-group">
      <div class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></div>    
            <form:input path="customerPhone"  class="form-Control" />
        </div>
        </div></div>
  </div>


 <div class="row">
            <div class="col-md-12">
        <div class="form-group">
        <c:if test="${duplicateUname !=null}">
            
          <div class="error" style="color:rgb(0,128,0);">  ${duplicateUname}</div></c:if>
            <label for="username">Username</label><span style="color:red">*</span>
            <form:errors path="users.username" cssStyle="color: #ff0000" />
            <div class="input-group">
      <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>    
            <form:input path="users.username"  class="form-Control"  required="true" />
            </div>
        </div>
        </div>
        </div>
        
      
               
   
       
   
     <div class="row">
            
            <div class="col-md-12">
        <div class="page-header">
            <h2>Billing Address</h2>
        </div>
        </div>
    </div>

<div class="row">
            <div class="col-md-6">
        <div class="form-group">
            <label for="billingStreet">Street Name</label>
            <form:input path="billingAddress.streetName"  class="form-Control" />
        </div>
        </div>
        
  
            <div class="col-md-6">
          <div class="form-group">
            <label for="billingApartmentNumber">Apartment Number</label>
            <form:input path="billingAddress.apartmentNumber"  class="form-Control" />
        </div>
        </div>
</div>


<div class="row">
            <div class="col-md-6">

        <div class="form-group">
            <label for="billingCity">City</label>
            <form:input path="billingAddress.city"  class="form-Control" />
        </div>
        </div>
        
        
            <div class="col-md-6">

        <div class="form-group">
            <label for="billingState">State</label>
            <form:input path="billingAddress.state" class="form-Control" />
        </div>
        </div>
</div>

<div class="row">
            <div class="col-md-6">

        <div class="form-group">
            <label for="billingCountry">Country</label>
            <form:input path="billingAddress.country"  class="form-Control" />
        </div>
        </div>
        
        
            <div class="col-md-6">
        <div class="form-group">
            <label for="billingZip">Zipcode</label>
            <form:input path="billingAddress.zipcode"  class="form-Control" />
        </div>
        </div>
</div>
   
 
 
 
    <div class="row">
            
            <div class="col-md-12">
        <div class="page-header">
            <h2>Shipping Address</h2>
        </div>
        </div>
    </div>


<div class="row">
            <div class="col-md-6">
        <div class="form-group">
            <label for="shippingStreet">Street Name</label>
            <form:input path="shippingAddress.streetName"  class="form-Control" />
        </div>
        </div>


            <div class="col-md-6">
        <div class="form-group">
            <label for="shippingApartmentNumber">Apartment Number</label>
            <form:input path="shippingAddress.apartmentNumber" class="form-Control" />
        </div>
        </div>
     </div>

<div class="row">
            <div class="col-md-6">
        <div class="form-group">
            <label for="shippingCity">City</label>
            <form:input path="shippingAddress.city" class="form-Control" />
        </div>
</div>

<div class="col-md-6">
        <div class="form-group">
            <label for="shippingState">State</label>
            <form:input path="shippingAddress.state"  class="form-Control" />
        </div>
</div>
</div>


<div class="row">
            <div class="col-md-6">
        <div class="form-group">
            <label for="shippingCountry">Country</label>
            <form:input path="shippingAddress.country"  class="form-Control" />
        </div>
        </div>

<div class="col-md-6">
        <div class="form-group">
            <label for="shippingZip">Zipcode</label>
            <form:input path="shippingAddress.zipcode" class="form-Control" />
        </div>
</div>
</div>
      <br/><br/>
 
   
   
   
       


        
<div class="row">
            <div class="col-md-12">

        <input type="submit" value="Submit" class="btn btn-primar"><span style="padding-left:900px;"></span>
        <a href="<c:url value="/" />" class="btn btn-danger">Cancel</a>
     </div>
     </div>   
  </form:form>
 <div class="row">
            <div class="col-md-12">
                <p class="text-muted"><strong> <span style="color:red">*</span></strong> These fields are required</p>
            </div>
        </div>
      
     </div>
        
    </body>
    </html>