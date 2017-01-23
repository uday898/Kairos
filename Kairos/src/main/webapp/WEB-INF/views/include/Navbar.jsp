<c:url value="resources/bs/css/style.css" var="css" />
 <link rel="stylesheet" href="${css }">
  <c:if test="${pageContext.request.userPrincipal.name!=null}" >
							
		<security:authorize access="hasRole('ROLE_USER')">
<div ng-app="watchapp" ng-controller="watchController"></security:authorize></c:if>
 <div ng-init="getCartid()">
  <div ng-init="countitems()">

<nav class="navbar navbar-default" style="margin-bottom:0px;" >
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="<c:url value="/"/>">KA<span style="color:#1abc9c;">IR</span>OS</a>
    </div>

<span class="padding-left:1000px"></span>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      
        <li><a href="<c:url value="/"/>"><i></i>Home</a></li>
        
        <c:if test="${pageContext.request.userPrincipal.name!=null}" >
							
		<security:authorize access="hasRole('ROLE_ADMIN')">
				        
			<li class="dropdown">
          <a href="<c:url value="/admin/addWatch"/>" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Add Categories<span class="caret"></span></a>
          <ul class="dropdown-menu">
            
            <li><a href="<c:url value="/addWatch"/>">Add Watch</a></li>
            <li><a href="<c:url value="/addSupplier"/>">AddSupplier</a></li>
            <li><a href="<c:url value="/addWatch_Sup"/>">AddWatchSupplier</a></li>
           
          </ul>
        </li>    
        <li><a href="<c:url value="/stats"/>">Statitics</a></li>  
		     </security:authorize>
		     
		     <li><a href="<c:url value="/getAllWatches"/>">All Watches</a></li>
		     
	</c:if>
       
       
 		
         <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Men<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<c:url value="/MenWatches"/>">MenWatches</a></li>
             <li class="dropdown-submenu">
              <a href="#" >View By Brand</a>
              <ul class="dropdown-menu">
         <li><a href="<c:url value="/MenFastrack"/>">Fastrack</a></li>
            <li><a href="<c:url value="/MenCasio"/>">Casio</a></li>
            <li><a href="<c:url value="/MenFossil"/>">Fossil</a></li>
              </ul>
            </li></ul>

         <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Women<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<c:url value="/WomenWatches"/>">WomenWatches</a></li>
             <li class="dropdown-submenu">
              <a href="#" >View By Brand</a>
              <ul class="dropdown-menu">
         <li><a href="<c:url value="/WomenFastrack"/>">Fastrack</a></li>
            <li><a href="<c:url value="/WomenCasio"/>">Casio</a></li>
            <li><a href="<c:url value="/WomenFossil"/>">Fossil</a></li>
              </ul>
            </li>
            
             
            </ul>
           </li> 
        
             
          <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Kids<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<c:url value="/KidWatches"/>">KidsWatches</a></li>
             
             <li class="dropdown-submenu">
              <a href="#" >View By Brand</a>
              <ul class="dropdown-menu">
               <li><a href="<c:url value="/KidDisney"/>">Disney</a></li>
            <li><a href="<c:url value="/KidWatches"/>">Others</a></li>
              </ul>
            </li>
              </ul>
           </li>
           
               
   </ul>
     
      
  <ul class="nav navbar-nav navbar-right">
  
      <c:if test="${pageContext.request.userPrincipal.name!=null}" >
      <security:authorize access="hasRole('ROLE_USER')">
      <li ><a href="<c:url value="/cart"/>"><img src="resources/images/cart.png" alt="cart" height=auto width=auto><span class="badge" ng-show="id" style="background-color:orange;">{{id}}</span></a></li>
        </security:authorize>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" style="padding-left:5px;"></span>Hi ${pageContext.request.userPrincipal.name }&nbsp;<span class="badge" style="background-color:orange;" ng-show="count">{{count}}</span><span class="caret"></span></a>
          <ul class="dropdown-menu">
            
                            <security:authorize access="hasRole('ROLE_USER')">
                            <li><a href="<c:url value="/Myprofile"/>">My Profile</a></li>
                           
				        
				   
				           
				           <li> <a href="<c:url value="/MyWishList"/>">WishList<span class="badge" style="background-color:orange;" ng-show="count">{{count}}</span></a></li>
				             
				            <li ><a  href="<c:url value="/Myorders"/>">MyOrders</a></li>
		                    </security:authorize> 
							
							 <security:authorize access="hasRole('ROLE_DBA')">
				            <li><a href="<c:url value="/users"/>">View Users</a></li>
				             <li><a href="<c:url value="/stats"/>">Statitics</a></li>
		                    </security:authorize>
		                     <security:authorize access="hasRole('ROLE_ADMIN')">
				            <li><a href="<c:url value="/users"/>">View Users</a></li>
				            
		                    </security:authorize>
            
             <li><a href="<c:url value="/j_spring_security_logout"></c:url>">Logout</a></li>
         </ul>
         </li>
      </c:if>
          
          <c:if test="${pageContext.request.userPrincipal.name==null}" >
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="false" aria-expanded="false">24x7 Support<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<c:url value="/contact"/>">Contact Form</a></li>
            <li><div class="divider"></div></li>
            <li>Kairos.support@gmail.com</li>
            <li>Ph:1800 0050 2156</li>
           </ul>
           </li>    
    </c:if>
        
  </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</div>
