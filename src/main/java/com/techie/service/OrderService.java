package com.techie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.techie.common.Payment;
import com.techie.common.TransactionRequest;
import com.techie.common.TransactionResponse;
import com.techie.repository.OrderRepository;
import com.techie.repository.entity.Order;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private RestTemplate template;
	
	public TransactionResponse saveOrder(TransactionRequest txReq) {
		String response = "";
		Order order = txReq.getOrder();
		Payment payment = txReq.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		//restCall
		Payment paymentRes = template.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
		response = paymentRes.getPaymentSts().equalsIgnoreCase("success")?
				"payment processing is successful and order placed!":
					"payment processing is failed and order is added to cart";
		 orderRepo.save(order);
		 return new TransactionResponse(order,paymentRes.getAmount(),paymentRes.getTxId()
				, response);
	}

}
