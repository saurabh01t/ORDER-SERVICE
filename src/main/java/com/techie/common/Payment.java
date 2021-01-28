package com.techie.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	private int paymentId;
	private String paymentSts;
	private String txId;
	private int orderId;
	private double amount;

}
