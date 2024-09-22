package com.demo.conductor.workflow.cab.dto;

import lombok.Data;

@Data
public class CabInput {
    private String pickUpLocation;
    private String dropOffLocation;
    private String riderId;
}
