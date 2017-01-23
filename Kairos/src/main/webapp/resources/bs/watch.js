var watchapp=angular.module("watchapp",[])
.controller("watchController",function($scope,$http){
	
	
	$scope.getwatches=function(){
		$http.get('http://localhost:1010/Kairos/getWatchList').success(function(data){
			$scope.watches=data;
		})
	}
	
	
	
	$scope.kidwatches=function(){
		$http.get('http://localhost:1010/Kairos/kidwatchlist').success(function(data){
			$scope.gkwatches=data;
		})
	}
	
	
	$scope.menwatches=function(){
		$http.get('http://localhost:1010/Kairos/menwatchlist').success(function(data){
			$scope.gmwatches=data;
		})
	}
	
	$scope.womenwatches=function(){
		$http.get('http://localhost:1010/Kairos/womenwatchlist').success(function(data){
			$scope.gwwatches=data;
		})
	}

	$scope.addToCart=function(){
    		alert('Watch successfully added to the cart!')
    }
	
	$scope.addToWish=function(){
		alert('Watch successfully added to the WishList!')
}
	
    $scope.refreshCart=function(){
    	$http.get('http://localhost:1010/Kairos/cart/getCart/'+$scope.cartId).success(function(data){
    		$scope.cart=data;
    	})
    }
    
    
     $scope.getCart=function(cartId){
    	$scope.cartId=cartId;
    	$scope.refreshCart(cartId);
    }
     
    
    $scope.removeFromCart=function(cartItemId){
    	    	$http.put(
'http://localhost:1010/Kairos/cart/removecartitem/'+cartItemId)
    	.success(function(){
    		$scope.refreshCart();
    	
    	})
    }
    
    $scope.removeFromWishlist=function(wishId){
    	$http.put(
'http://localhost:1010/Kairos/removewishitem/'+wishId)
.success(function(){

})
}
    
    
    
    $scope.clearCart=function(){
    	    	$http.put(
'http://localhost:1010/Kairos/cart/removeAllItems/'+$scope.cartId)
    	.success(function(){
    		$scope.refreshCart();
    	});
    }
    
    $scope.calculateGrandTotal=function(){
    	var grandTotal=0.0;
    	for(var i=0;i<$scope.cart.cartItems.length;i++){
    		grandTotal=grandTotal+$scope.cart.cartItems[i].totalprice;
    	
    	}
    	return grandTotal;
    }
    
    $scope.countitems=function(){
	   	 $http.get('http://localhost:1010/Kairos/wishitems').success(function(data){
	   		 $scope.count=data;
	   		
	   	 })
	    
	    }
    

	
	$scope.getCartid=function(){
   	 $http.get('http://localhost:1010/Kairos/cart/getCartid').success(function(data){
   		 $scope.id=data;
   		
   	 })
    
    }
    
    
    
});
