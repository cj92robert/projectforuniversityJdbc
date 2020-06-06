package com.example.projectforuniversity.controllers;


import com.example.projectforuniversity.models.Car;
import com.example.projectforuniversity.models.CarPage;
import com.example.projectforuniversity.repositories.CarDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins= "*" ,allowedHeaders = "*")
@RestController
public class CarController {

    CarDao carRepository;

    public CarController(CarDao carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public CarPage findAllByColour(
            @RequestParam(required=false,defaultValue = "") String colour,
            @RequestParam int page){
        return carRepository.findAllByColourStartWith(colour,page);
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable long id){
        return carRepository.getById(id);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Car car){
       return carRepository.save(car)==0?
                new ResponseEntity(HttpStatus.NOT_FOUND):
                new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Car car, @PathVariable long id){
        return carRepository.update(id,car)==0?
                new ResponseEntity(HttpStatus.NOT_FOUND):
                new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id){
        return carRepository.deleteById(id)==0?
                new ResponseEntity(HttpStatus.NOT_FOUND):
                new ResponseEntity(HttpStatus.OK);
    }
}
