package com.logiflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.logiflow.entity.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrderId(Long orderId);

    @Query("SELECT oi FROM OrderItem oi JOIN oi.order o WHERE o.customer.id = :customerId")
    List<OrderItem> findByCustomerId(@Param("customerId") Long customerId);

    @Query("SELECT oi FROM OrderItem oi WHERE oi.sku = :sku")
    List<OrderItem> findBySku(@Param("sku") String sku);
}