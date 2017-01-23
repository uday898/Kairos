<%@ page isELIgnored="false" %>
  
   <html>
    <head>
    <title>Add Supplier</title>
   <style type="text/css">
</style>
   
    <%@include file="include/header.jsp" %>
   <%@include file="include/Navbar.jsp" %>
   </head>
   
   <body>
   <br>
   <br>
   <a href="#section21" class="btn btn-primar">Add New Record</a> 
   <div class="container" id="section20">
   <div class="jumbotron" style="background-color:#ccffff;">
   <div class="row">
   <div class="col-md-3 col-sm-4 col-xs-12"></div>
   <div class="col-md-7 col-sm-4 col-xs-12">
<h2>Existing Watch_Suppliers</h2>
<div class="table-responsive">
	<table  class="table table-striped table-condensed">
		<tr>
			<th>Watch_SupplierId</th>
			<th>WatchId</th>
			<th>SupplierId</th>
			<th>Price</th>
			<th>stock</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${Watch_sup}" var="ws">
		<tr>
		<td>${ws.w_S_id}</td>
		<td>${ws.watchid}</td>
		<td>${ws.sid}</td>
		<td>${ws.price}</td>
		<td>${ws.stock}</td>
		<td><a href="admin/deletews/${ws.w_S_id}"><span class="glyphicon glyphicon-trash"></span></a></td>
		 </tr>
		
		</c:forEach>
	</table>	
</div>
</div>

</div>
</div>
</div>

<div class="container" id="section21">
   <div class="jumbotron">
   <div class="row">
   <div class="col-md-4 col-sm-4 col-xs-12"></div>
   <div class="col-md-8 col-sm-4 col-xs-12">
<h2>Addd New Watch_Supplier</h2>
<form:form action="AddWatch_Supplier1" commandName="Watch_supplier" method="POST">
<table>
<tr>
    <th>Watchid:</th>
    <td><ul>
            <form:select path="watchid" items="${watchids}"/>
        </ul>
    </td>
    </tr>
    
<tr>
    <th>Sid:</th>
     <td><ul>
            <form:select path="sid" items="${sids}"/>
        </ul>
    </td>
    
    </tr>
<tr class="form-group">
            <th><form:label path="price">Price</form:label></th>
           <td> <form:input path="price"/></td>
</tr>
<tr class="form-group">
            <th><form:label path="stock">Stock</form:label></th>
           <td> <form:input path="stock"/></td>
</tr>

</table>
<input type="submit" value="AddWatchSupplier" />


</form:form>
</div>
</div>
</div>   
</div>
   </body>
   </html>