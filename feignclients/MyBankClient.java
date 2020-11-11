package com.hungerbox.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hungerbox.dto.UserTransactionRequestDto;

@FeignClient(name = "http://MYBANK-SERVICE/bank/SBI")

//  @FeignClient(value ="mybank-service", url = "http://localhost:8082/bank")

public interface MyBankClient {

	@PostMapping("/transfer")
	public String fundTransfer(@RequestBody UserTransactionRequestDto transactionRequestDto);

	@GetMapping("/port")
	public String getInfo();

}
