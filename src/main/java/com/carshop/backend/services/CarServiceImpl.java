package com.carshop.backend.services;

import com.carshop.backend.dao.CarRepository;
import com.carshop.backend.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository theCarRepository){
        carRepository= theCarRepository;

    }


    @Override
    public List<Car> findAll() {



        return carRepository.findAll() ;
    }

    @Override
    public Car findById(long id) {
        Optional<Car> result = carRepository.findById(id);
        if(result.isEmpty()){
            throw new RuntimeException("No car with that id Found");
        }

        return result.get();
    }

    @Override
    public Car save(Car theCar) {
        return carRepository.save(theCar);
    }

    @Override
    public void delete(long id) {
        carRepository.deleteById(id);

    }
}
