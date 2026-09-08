package com.logiflow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.logiflow.entity.DeliveryPartner;

@Repository
public interface DeliveryPartnerRepository extends JpaRepository<DeliveryPartner, Long> {

    Optional<DeliveryPartner> findByUserId(Long userId);

    List<DeliveryPartner> findByAvailable(boolean available);

    List<DeliveryPartner> findByActive(boolean active);

    @Query("SELECT dp FROM DeliveryPartner dp WHERE dp.available = true AND dp.active = true")
    List<DeliveryPartner> findAvailableAndActive();
}