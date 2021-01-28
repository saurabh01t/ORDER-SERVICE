package com.techie.common;

import com.techie.repository.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
	private Order order;
	private Payment payment;

}
