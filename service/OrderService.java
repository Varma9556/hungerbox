package com.hungerbox.service;

import java.util.List;

import com.hungerbox.dto.FoodOrdersDto;
import com.hungerbox.dto.UserOrderRequestDto;

public interface OrderService {
	
	void saveOrder(UserOrderRequestDto  userOrderRequestDto);
	public List<FoodOrdersDto> getOrderList(int userId, int pageNumber, int pageSize);
	public String getInfo();

}
