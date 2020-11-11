package com.hungerbox.dto;

import java.util.List;

import com.hungerbox.entity.FoodMenu;

public class VendorDto {

	private int vendorId;

	private String vendorName;

	private String vendor;

	private String vendorLocation;

	private String vendorPhoneNo;

	private String vendorEmail;

	private List<FoodMenu> foodMenu;

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVendorLocation() {
		return vendorLocation;
	}

	public void setVendorLocation(String vendorLocation) {
		this.vendorLocation = vendorLocation;
	}

	public String getVendorPhoneNo() {
		return vendorPhoneNo;
	}

	public void setVendorPhoneNo(String vendorPhoneNo) {
		this.vendorPhoneNo = vendorPhoneNo;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public List<FoodMenu> getFoodMenu() {
		return foodMenu;
	}

	public void setFoodMenu(List<FoodMenu> foodMenu) {
		this.foodMenu = foodMenu;
	}

}
