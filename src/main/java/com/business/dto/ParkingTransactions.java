package com.business.dto;

import com.framework.dto.AbstractSessionDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "parking_transactions")
public class ParkingTransactions extends AbstractSessionDTO {

    @Id
    @Column(name = "session_id")
    private String sessionId;

    @Column(name = "prev_session_id")
    private String prevSessionId;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "carpark_number")
    private Integer carparkNumber;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getPrevSessionId() {
        return prevSessionId;
    }

    public void setPrevSessionId(String prevSessionId) {
        this.prevSessionId = prevSessionId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getCarparkNumber() {
        return carparkNumber;
    }

    public void setCarparkNumber(Integer carparkNumber) {
        this.carparkNumber = carparkNumber;
    }
}