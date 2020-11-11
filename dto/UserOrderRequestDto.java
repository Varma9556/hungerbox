package com.hungerbox.dto;

import java.util.ArrayList;
import java.util.List;

public class UserOrderRequestDto {

	private int userId;

	private List<FoodItemRequestDto> foodItems = new ArrayList();

	private long fromAccountNumber;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<FoodItemRequestDto> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItemRequestDto> foodItems) {
		this.foodItems = foodItems;
	}

	public long getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(long fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

}
