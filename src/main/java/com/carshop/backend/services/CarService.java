package com.carshop.backend.services;

import com.carshop.backend.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    Car findById(long id);
    Car save(Car theCar);
    void delete(long id);

}
