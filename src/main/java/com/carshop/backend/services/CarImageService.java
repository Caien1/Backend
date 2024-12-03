package com.carshop.backend.services;

import com.carshop.backend.entity.CarImage;

import java.util.List;

public interface CarImageService {
    List<CarImage> findAll();
    CarImage findById(long id);
    CarImage save(CarImage theCarImage);
    void deleteById(long id);
}
