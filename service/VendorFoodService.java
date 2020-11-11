package com.hungerbox.service;

import java.util.List;

import com.hungerbox.dto.FoodMenuDto;

public interface VendorFoodService {

	List<FoodMenuDto> findByfoodNameContains(String foodName, int pageNumber, int pageSize);

}
