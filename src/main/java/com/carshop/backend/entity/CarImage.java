package com.carshop.backend.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarImage {

    public Long imageId;

    //This will be a foreign key to cars
    private Long carId;


    private String imageUrl;


}
