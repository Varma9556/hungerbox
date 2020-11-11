package com.hungerbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hungerbox.dto.FoodOrdersDto;
import com.hungerbox.dto.UserOrderRequestDto;
import com.hungerbox.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	

	@Autowired
	OrderService orderService;
	
	@GetMapping("/status")
	public String getStatus() {
		return "Success";
	}
	@GetMapping("/port")
    public String getPortNumber() {
        return orderService.getInfo();
    }
	
	@PostMapping("/orderfood")
	public String placeOrder(@RequestBody UserOrderRequestDto  userOrderRequestDto){
		
		orderService.saveOrder(userOrderRequestDto);
		 return "Order-Placed-Succssfully";
		 
	}
	
	
	
	@GetMapping("/vieworders")
	public List<FoodOrdersDto> getOrderList(@RequestParam int userId, @RequestParam int pageNumber, @RequestParam int pageSize){
	
		return orderService.getOrderList(userId,pageNumber,pageSize);
	}
	
	
}

