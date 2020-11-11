package com.hungerbox.dto;

public class UserTransactionRequestDto {

	private Long fromAccounNumber;

	private Long toAccount;

	private double amount;

	private String remarks;

	public Long getFromAccounNumber() {
		return fromAccounNumber;
	}

	public void setFromAccounNumber(Long fromAccounNumber) {
		this.fromAccounNumber = fromAccounNumber;
	}

	public Long getToAccount() {
		return toAccount;
	}

	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
