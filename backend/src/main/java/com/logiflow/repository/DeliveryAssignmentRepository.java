package com.logiflow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.logiflow.entity.DeliveryAssignment;
import com.logiflow.entity.enums.DeliveryAssignmentStatus;

@Repository
public interface DeliveryAssignmentRepository extends JpaRepository<DeliveryAssignment, Long> {

    Optional<DeliveryAssignment> findByOrderId(Long orderId);

    List<DeliveryAssignment> findByDeliveryPartnerId(Long deliveryPartnerId);

    List<DeliveryAssignment> findByStatus(DeliveryAssignmentStatus status);

    @Query("SELECT da FROM DeliveryAssignment da WHERE da.deliveryPartner.id = :partnerId AND da.status = :status")
    List<DeliveryAssignment> findByPartnerIdAndStatus(@Param("partnerId") Long partnerId, @Param("status") DeliveryAssignmentStatus status);
}