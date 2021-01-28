package com.techie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techie.repository.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
