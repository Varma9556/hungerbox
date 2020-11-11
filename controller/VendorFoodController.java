package com.hungerbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hungerbox.dto.FoodMenuDto;
import com.hungerbox.service.VendorFoodService;

@RestController
@RequestMapping("/foodmenu")
public class VendorFoodController {

	@Autowired
	VendorFoodService vendorFoodService;
	
	@GetMapping("/searchbyfoodname")
	public List<FoodMenuDto> getFoodNameWithVendor(@RequestParam String foodName, @RequestParam int pageNumber, @RequestParam int pageSize){
	
		return vendorFoodService.findByfoodNameContains(foodName,pageNumber,pageSize);
	}
	
}

