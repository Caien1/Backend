package com.carshop.backend.rest;

import com.carshop.backend.entity.CarImage;
import com.carshop.backend.services.CarImageService;
import com.carshop.backend.services.CarImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarImageController {

    private CarImageService carImageService;

    @Autowired
    public CarImageController(CarImageService theCarImageService){
        carImageService=theCarImageService;
    }

    @GetMapping("/carimages")
    public List<CarImage> getAllCarImages(){
        return carImageService.findAll();
    }

    @GetMapping("/carimages/{carImageId}")
    public CarImage getCarImage(@PathVariable long carImageId){

        CarImage theCar = carImageService.findById(carImageId);
        if(theCar==null){
            throw new RuntimeException("Not found");
        }
        return carImageService.findById(carImageId);
    }

    @PostMapping("/carimages")
    public CarImage addCarImage(@RequestBody CarImage theCarImage){
        theCarImage.setImageId(0L);
        CarImage dbCarImage = carImageService.save(theCarImage);

        return dbCarImage;
    }
    @PutMapping("/carimages")
    public CarImage update(@RequestBody CarImage theCarImage){
        CarImage dbCarImage = carImageService.save(theCarImage);
        return dbCarImage;
    }

    @DeleteMapping("/carimages/{carImageId}")
    public void deleteCarImage(@PathVariable long id){
        carImageService.deleteById(id);
    }
}
