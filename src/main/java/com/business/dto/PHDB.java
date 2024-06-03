package com.business.dto;

import com.framework.dto.AbstractPersistentDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "phdb_user")
public class PHDB extends AbstractPersistentDTO {
    
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "vehicle_type")
    private String vehicleType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
