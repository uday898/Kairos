
<html>
<head>
<%@include file="include/header.jsp" %>
<%@include file="include/Navbar.jsp" %>
<title>Edit Watch</title>
</head>
<body>
<br>
<br>
<div class=container>

<div class="row">
<div class="col-md-2 col-sm-4 col-xs-12"></div>
<div class="col-md-8 col-sm-4 col-xs-12">
<div class="jumbotron">





<h2>Edit Watch</h2><br>
<c:url value="/editit" var="url"></c:url> 
	<form:form method="post" action="${url}" commandName="watch" enctype="multipart/form-data">
		
		<form:hidden path="watchid"  class="form-Control" required="true"/>
        <div class="form-group">
            <label for="name">Name</label>
            <form:errors path="WatchName" cssStyle="color: #ff0000" />
            <form:input path="WatchName"  class="form-Control" required="true"/>
        </div>
       <br>
       <div class="form-group">
            <form:label path="idealfor">IdealFor</form:label><span style="padding-left:66px;"></span>
	    <form:radiobutton path="idealfor.gid" value="1"/>Men
	     <form:radiobutton path="idealfor.gid" value="2"/>Women	
	      <form:radiobutton path="idealfor.gid" value="3"/>Kids
        </div>
       <br>
        <div class="form-group">
            <form:label path="brand">Brand:</form:label> <span style="padding-left:75px;"></span>
	    <form:radiobutton path="brand.brandid" value="1"/>Fastrack
	     <form:radiobutton path="brand.brandid" value="2"/>Casio	
	      <form:radiobutton path="brand.brandid" value="3"/>Fossil
	      <form:radiobutton path="brand.brandid" value="4"/>Disney
	      <form:radiobutton path="brand.brandid" value="5"/>Others
        </div>
  
  <br>
        <div class="form-group">
            <form:label path="displaytype">Display Type:</form:label><span style="padding-left:30px;"></span>
	    <form:radiobutton path="displaytype.typeid" value="1"/>Analog
	     <form:radiobutton path="displaytype.typeid" value="2"/>Chronograph	
	      <form:radiobutton path="displaytype.typeid" value="3"/>Others
        </div>    
        
     <br>   
         <div class="form-group">
            <form:label path="strap">Strap Type:</form:label><span style="padding-left:45px;"></span>
	    <form:radiobutton path="strap.strapid" value="1"/>Leather
	     <form:radiobutton path="strap.strapid" value="2"/>Metal	
	      <form:radiobutton path="strap.strapid" value="3"/>Others
        </div>     
       
       <br>
         <div class="form-group">
	    <form:input type="file" path="Imagefile" />
	    </div>
	    <br>
	    <td colspan="2"><input type="submit" value="Edit Watch" class="btn btn-primar"></td>
	</form:form>
</div>
<div class="col-md-2 col-sm-4 col-xs-12">
</div>
</div>
</div>
</div>
</body>
</html>