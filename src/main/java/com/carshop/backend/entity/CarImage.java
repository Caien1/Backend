package com.carshop.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car_images")
public class CarImage {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long imageId;

    //This will be a foreign key to cars
    private Long carId;


    private String imageUrl;


    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }
}
