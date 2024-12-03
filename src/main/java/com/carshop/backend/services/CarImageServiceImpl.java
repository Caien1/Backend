package com.carshop.backend.services;

import com.carshop.backend.dao.CarImageRepository;
import com.carshop.backend.entity.CarImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarImageServiceImpl implements CarImageService{

    private CarImageRepository carImageRepository;

    @Autowired
    public CarImageServiceImpl(CarImageRepository theCarImageRepository){
        carImageRepository = theCarImageRepository;
    }

    @Override
    public List<CarImage> findAll() {
        return carImageRepository.findAll();
    }

    @Override
    public CarImage findById(long id) {
        Optional<CarImage> theCar = carImageRepository.findById(id);
        if(theCar.isEmpty()){
            throw new RuntimeException("This care has no images");
        }
        return theCar.get();
    }

    @Override
    public CarImage save(CarImage theCarImage) {
        return carImageRepository.save(theCarImage);
    }

    @Override
    public void deleteById(long id) {
        carImageRepository.deleteById(id);

    }
}
