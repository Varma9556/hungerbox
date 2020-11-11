package com.hungerbox.service;

import java.util.List;

import com.hungerbox.dto.VendorDto;

public interface VendorService {
	
	public List<VendorDto> findByvendorNameContains(String vendorName,int pageNumber, int pageSize);

}
