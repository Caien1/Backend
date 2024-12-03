package com.carshop.backend.rest;

import com.carshop.backend.entity.Car;
import com.carshop.backend.entity.CarImage;
import com.carshop.backend.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarController {

    private CarService carService;

    @Autowired
    public  CarController(CarService theCarService){
        carService= theCarService;
    }

    @GetMapping("/cars")
    public List<Car> getAllCars(){
        return carService.findAll();
    }


    @GetMapping("/cars/{carId}")
    public Car getCar(@PathVariable long carId){
        Car theCar = carService.findById(carId);
        if (theCar==null){
            throw new RuntimeException("This Car not found");
        }
        return theCar;
    }

    @PostMapping("/cars")
    public Car addCar(@RequestBody Car theCar){
        theCar.setCarId(0L);
        Car dbCar = carService.save(theCar);
        return dbCar;
    }

    @PutMapping("/cars")
    public Car updateCar(@RequestBody Car theCar){
        Car dbCar = carService.save(theCar);
        if(dbCar==null){
            throw new RuntimeException("Not found");
        }
        return dbCar;
    }


    @DeleteMapping("/cars/{carId}")
    public void deleteCar(@PathVariable long id){
        carService.delete(id);

    }


}
