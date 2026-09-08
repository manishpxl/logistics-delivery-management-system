package com.logiflow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "delivery_routes")
public class DeliveryRoute extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "delivery_assignment_id", nullable = false, unique = true)
    private DeliveryAssignment deliveryAssignment;

    @Column(nullable = false, length = 500)
    private String routeJson;

    @Column(nullable = false)
    private Integer totalDistanceKm;

    @Column(nullable = false)
    private Integer estimatedDurationMinutes;

    @Column(length = 500)
    private String driverNotes;

    public DeliveryAssignment getDeliveryAssignment() {
        return deliveryAssignment;
    }

    public void setDeliveryAssignment(DeliveryAssignment deliveryAssignment) {
        this.deliveryAssignment = deliveryAssignment;
    }

    public String getRouteJson() {
        return routeJson;
    }

    public void setRouteJson(String routeJson) {
        this.routeJson = routeJson;
    }

    public Integer getTotalDistanceKm() {
        return totalDistanceKm;
    }

    public void setTotalDistanceKm(Integer totalDistanceKm) {
        this.totalDistanceKm = totalDistanceKm;
    }

    public Integer getEstimatedDurationMinutes() {
        return estimatedDurationMinutes;
    }

    public void setEstimatedDurationMinutes(Integer estimatedDurationMinutes) {
        this.estimatedDurationMinutes = estimatedDurationMinutes;
    }

    public String getDriverNotes() {
        return driverNotes;
    }

    public void setDriverNotes(String driverNotes) {
        this.driverNotes = driverNotes;
    }
}