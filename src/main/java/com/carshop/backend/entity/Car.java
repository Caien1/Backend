package com.carshop.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "cars")
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    //This will be a foreign key to users
    private Long sellerId;

    private String make;

    private String model;

    private Integer year;

    private BigDecimal price;

    private Integer mileage;

    @Enumerated(EnumType.STRING)
    private FuelType fuel;

    @Enumerated(EnumType.STRING)
    private TransmissionType transmission;

    private String color;

    @Enumerated(EnumType.STRING)
    private ConditionType condition;

    private String location;

    private LocalDateTime postedAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Status status;


    public void setCarId(Long carId) {
        this.carId = carId;
    }



}

enum FuelType{
    PETROL,DIESEL,ELECTRIC,HYBRID
}

enum TransmissionType{
    MANUAL, AUTOMATIC
}

enum Status{
    AVAILABLE,SOLD,NOTINSTOCK
}

enum ConditionType{
    NEW,USED
}
