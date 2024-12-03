package com.carshop.backend.dao;

import com.carshop.backend.entity.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImageRepository extends JpaRepository<CarImage,Long> {
}
