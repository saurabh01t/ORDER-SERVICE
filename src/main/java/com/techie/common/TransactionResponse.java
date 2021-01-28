package com.techie.common;

import com.techie.repository.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
	private Order order;
	private double amount;
	private String txId;
	private String msg;
	
}
