package com.logiflow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.logiflow.entity.Shipment;
import com.logiflow.entity.enums.ShipmentStatus;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    Optional<Shipment> findByTrackingNumber(String trackingNumber);

    Optional<Shipment> findByOrderId(Long orderId);

    List<Shipment> findByStatus(ShipmentStatus status);

    List<Shipment> findByWarehouseId(Long warehouseId);

    @Query("SELECT s FROM Shipment s WHERE s.status = :status AND s.warehouse.id = :warehouseId")
    List<Shipment> findByStatusAndWarehouseId(@Param("status") ShipmentStatus status, @Param("warehouseId") Long warehouseId);

    @Query("SELECT s FROM Shipment s JOIN s.order o WHERE o.customer.id = :customerId")
    List<Shipment> findByCustomerId(@Param("customerId") Long customerId);
}