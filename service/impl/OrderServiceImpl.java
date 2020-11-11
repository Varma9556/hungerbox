package com.hungerbox.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hungerbox.dto.FoodItemRequestDto;
import com.hungerbox.dto.FoodOrdersDto;
import com.hungerbox.dto.UserOrderRequestDto;
import com.hungerbox.dto.UserTransactionRequestDto;
import com.hungerbox.entity.FoodMenu;
import com.hungerbox.entity.FoodOrders;
import com.hungerbox.entity.User;
import com.hungerbox.entity.Vendor;
import com.hungerbox.feignclients.MyBankClient;
import com.hungerbox.repository.FoodMenuRepository;
import com.hungerbox.repository.OrderRepository;
import com.hungerbox.repository.UserRepository;
import com.hungerbox.repository.VendorRepository;
import com.hungerbox.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	FoodMenuRepository foodmenuRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	VendorRepository vendorRepository;

	@Autowired
	MyBankClient myBankClient;

	@Override
	public void saveOrder(UserOrderRequestDto userOrderRequestDto) {
		FoodOrders foodOrders = new FoodOrders();
		Optional<User> optionalUser = userRepository.findById(userOrderRequestDto.getUserId());
		long totalprice = 0;
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			foodOrders.setUserId(user.getUserId());
			for (FoodItemRequestDto foodItemRequestDto : userOrderRequestDto.getFoodItems()) 
				//userOrderRequestDto.getFoodItems().stream().forEach(foodItemRequestDto->
				{
				Optional<FoodMenu> optionalfoodmenu = foodmenuRepository.findById(foodItemRequestDto.getFoodId());
				if (optionalfoodmenu.isPresent()) {
					FoodMenu foodmenu = optionalfoodmenu.get();
					long selecteditemprice = foodmenu.getFoodPrice();
					long selecteditemtotal = (selecteditemprice * foodItemRequestDto.getQuantity());
					totalprice = (totalprice + selecteditemtotal);
					foodOrders.setTotalPrice(totalprice);
					foodOrders.setFoodId(foodmenu.getFoodId());
					foodOrders.setFoodName(foodmenu.getFoodName());
					foodOrders.setVendorId(foodmenu.getVendorId());
					foodOrders.setOrderStatus("pending");
					orderRepository.save(foodOrders);

					Optional<Vendor> optionalVendor = vendorRepository.findById(foodmenu.getVendorId());
					if (optionalVendor.isPresent()) {
						Vendor vendor = optionalVendor.get();
						UserTransactionRequestDto userTransactionRequestDto = new UserTransactionRequestDto();
						userTransactionRequestDto.setToAccount(vendor.getAccountNumber());
						userTransactionRequestDto.setFromAccounNumber(userOrderRequestDto.getFromAccountNumber());
						userTransactionRequestDto.setAmount(totalprice);
						userTransactionRequestDto.setRemarks("foodapp");

						myBankClient.fundTransfer(userTransactionRequestDto);

					}

				}

			}

			foodOrders.setOrderStatus("success");
			orderRepository.save(foodOrders);
		}
	}

	@Override
	public List<FoodOrdersDto> getOrderList(int userId, int pageNumber, int pageSize) {

		List<FoodOrders> foodOrdersList = new ArrayList();
		List<FoodOrdersDto> foodOrderDtoList = new ArrayList();

		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Direction.ASC, "foodName"));
		foodOrdersList = orderRepository.findByuserId(userId, pageable);

		//for (FoodOrders foodOrders : foodOrdersList)
			foodOrdersList.stream().forEach(foodOrders->{
			FoodOrdersDto foodOrdersDto = new FoodOrdersDto();
			BeanUtils.copyProperties(foodOrders, foodOrdersDto);
			foodOrderDtoList.add(foodOrdersDto);
		});
		return foodOrderDtoList;
	}

	@Override
	public String getInfo() {
		return myBankClient.getInfo();
	}
}
