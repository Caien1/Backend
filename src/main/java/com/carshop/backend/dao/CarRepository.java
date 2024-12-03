package com.carshop.backend.dao;

import com.carshop.backend.entity.Car
        ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
