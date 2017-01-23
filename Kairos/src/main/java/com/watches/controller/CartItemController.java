package com.watches.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.watches.model.Cart;
import com.watches.model.CartItem;
import com.watches.model.Customer;
import com.watches.model.Suppliers;
import com.watches.model.Vw1;
import com.watches.model.Watch;
import com.watches.service.CartItemService;
import com.watches.service.CartService;
import com.watches.service.CustomerService;
import com.watches.service.SupplierService;
import com.watches.service.WatchService;

@Controller
public class CartItemController {
	
@Autowired	
private CustomerService customerService;
@Autowired
private WatchService watchservice;
@Autowired
private CartItemService cartItemService;
@Autowired
private CartService cartService;
@Autowired
private SupplierService supplierService;

@RequestMapping("/carft/add/{watchid}")
@ResponseStatus(value=HttpStatus.NO_CONTENT)
public void addItem(@PathVariable(value="watchid")String watchid,@RequestParam("quantity")String quantity,@RequestParam("price")String price){
	
	User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username= user.getUsername();
    Customer customer= customerService.getCustomerByUsername(username);
    System.out.println("CustomerService is:"+customer.getCustomerEmail());
    Cart cart = customer.getCart();
    int quantity1 =Integer.parseInt(quantity);
    double price1 =Double.parseDouble(price);
    List<CartItem> cartItems =cart.getCartItems();
    System.out.println(cartItems);
    Watch watch=watchservice.getWatchById(watchid);	
   
    CartItem cartItem =new CartItem();
    cartItem.setWatch(watch);
    cartItem.setQuantity(quantity1);
    cartItem.setPrice(price1);
    
    cartItem.setTotalprice(cartItem.getQuantity()*price1);
    cartItem.setCart(cart);
    cartItemService.addCartItem(cartItem);
    
    
}

@RequestMapping("/cart/add/{w_s_id}")
//@ResponseStatus(value=HttpStatus.NO_CONTENT)
public String addcItem(@PathVariable(value="w_s_id")String wsid,@RequestParam("quantity")String quantity,Model model){
	
	User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username= user.getUsername();
    Customer customer= customerService.getCustomerByUsername(username);
    System.out.println("CustomerService is:"+customer.getCustomerEmail());
    Cart cart = customer.getCart();
    int quantity1 =Integer.parseInt(quantity);
    Vw1 view =watchservice.getrecord(wsid);
    List<CartItem> cartItems =cart.getCartItems();
    System.out.println(cartItems);
    Watch watch=watchservice.getWatchById(view.getWatchid());	
   
    CartItem cartItem =new CartItem();
    cartItem.setWatch(watch);
    cartItem.setQuantity(quantity1);
    cartItem.setPrice(view.getPrice());
    cartItem.setW_s_id(wsid);
    cartItem.setTotalprice(cartItem.getQuantity()*view.getPrice());
    cartItem.setCart(cart);
    cartItemService.addCartItem(cartItem);
    model.addAttribute("wsid", wsid);
    return"redirect:/ViewWatch{wsid}";
}



@RequestMapping("/cart/removecartitem/{cartItemId}")
@ResponseStatus(value=HttpStatus.NO_CONTENT)
public void removeCartItem(
	@PathVariable(value="cartItemId") int cartItemId){
	cartItemService.removeCartItem(cartItemId);

}

@RequestMapping("/cart/removeAllItems/{cartId}")
@ResponseStatus(value=HttpStatus.NO_CONTENT)
public void removeAllCartItems(@PathVariable(value="cartId") int cartId){
	Cart cart=cartService.getCartByCartId(cartId);
	cartItemService.removeAllCartItems(cart);
	
}

@RequestMapping("/cart/getCartid")
public @ResponseBody int getcartid()
{
	User user =(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String username= user.getUsername();
	Customer customer =customerService.getCustomerByUsername(username);
	int cartid=customer.getCart().getCartId();
	int cartitems=cartItemService.countcartitems(cartid);
	
return cartitems;

}




}

