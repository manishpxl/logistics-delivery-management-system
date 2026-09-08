package com.logiflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.logiflow.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByAdminId(Long adminId);

    List<Notification> findByRead(Boolean read);

    @Query("SELECT n FROM Notification n WHERE n.admin.id = :adminId AND n.read = false")
    List<Notification> findUnreadByAdminId(@Param("adminId") Long adminId);

    @Query("SELECT n FROM Notification n WHERE n.admin.id = :adminId ORDER BY n.sentAt DESC")
    List<Notification> findByAdminIdOrderBySentAtDesc(@Param("adminId") Long adminId);
}