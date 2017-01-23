<%@ page isELIgnored="false" %>
  
   <html>
    <head>
    <title>Stats</title>
   <style type="text/css">
</style>
   
    <%@include file="include/header.jsp" %>
   <%@include file="include/Navbar.jsp" %>
   </head>
   
   <body>
   <br>
   <br> 
   <div class="container" >
   <div class="jumbotron" style="background-color:#ccffff;">
   <div class="row">
   <div class="col-md-3 col-sm-4 col-xs-12"></div>
   <div class="col-md-7 col-sm-4 col-xs-12">
<h2>Statistics So Far</h2>
<div class="table-responsive">
	<table  class="table table-striped table-condensed">
		<tr>
			
			<th>WatchId</th>
			<th>SupplierId</th>
			<th>sold</th>
		
		</tr>
		<c:forEach items="${stats}" var="ws">
		<tr>
		
		<td>${ws.watchid}</td>
		<td>${ws.sid}</td>
		<td>${ws.soldout}</td>
		
		 </tr>
		
		</c:forEach>
	</table>	
</div>
</div>

</div>
</div>
</div>
</body>
</html>