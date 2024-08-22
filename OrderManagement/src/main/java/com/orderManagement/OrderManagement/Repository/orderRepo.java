package com.orderManagement.OrderManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderManagement.OrderManagement.entities.orderDo;

public interface orderRepo extends JpaRepository<orderDo, Long> {

}
