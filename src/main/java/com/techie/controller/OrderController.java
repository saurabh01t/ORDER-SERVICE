package com.techie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techie.common.TransactionRequest;
import com.techie.common.TransactionResponse;
import com.techie.service.OrderService;

@RestController
@RequestMapping("/oder")
public class OrderController {
	@Autowired
	private OrderService orderSrv;
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest txReq) {
		return orderSrv.saveOrder(txReq);
		//do a rest call to payment-service and pass the order-id
	}

}
