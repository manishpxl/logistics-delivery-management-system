package com.logiflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.logiflow.entity.ShipmentTracking;

@Repository
public interface ShipmentTrackingRepository extends JpaRepository<ShipmentTracking, Long> {

    List<ShipmentTracking> findByShipmentId(Long shipmentId);

    @Query("SELECT st FROM ShipmentTracking st WHERE st.shipment.id = :shipmentId ORDER BY st.statusTime DESC")
    List<ShipmentTracking> findTrackingHistory(@Param("shipmentId") Long shipmentId);
}