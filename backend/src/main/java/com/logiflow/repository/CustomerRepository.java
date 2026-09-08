package com.logiflow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.logiflow.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByUserId(Long userId);

    List<Customer> findByCity(String city);

    List<Customer> findByState(String state);

    @Query("SELECT c FROM Customer c JOIN c.user u WHERE u.email = :email")
    Optional<Customer> findByUserEmail(@Param("email") String email);
}