package com.example.projectforuniversity.controllers;


import com.example.projectforuniversity.models.Car;
import com.example.projectforuniversity.models.CarPage;
import com.example.projectforuniversity.repositories.CarDao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins= "*" ,allowedHeaders = "*")
@RestController
public class CarController {

    private static final Logger logger= LoggerFactory.getLogger(CarController.class);
    private final CarDao carRepository;

    public CarController(CarDao carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public CarPage findAllByColour(
            @RequestParam(required=false,defaultValue = "") String colour,
            @RequestParam int page){
        logger.info("findallbycolour");
        return carRepository.findAllByColourStartWith(colour,page);
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable long id){
        logger.info("/id = "+ id);

        return carRepository.getById(id);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Car car){
        logger.info("save");
       return carRepository.save(car)==0?
                new ResponseEntity(HttpStatus.NOT_FOUND):
                new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Car car, @PathVariable long id){
        logger.info("putmapping id");
        return carRepository.update(id,car)==0?
                new ResponseEntity(HttpStatus.NOT_FOUND):
                new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id){
        logger.info("deltemapping");
        return carRepository.deleteById(id)==0?
                new ResponseEntity(HttpStatus.NOT_FOUND):
                new ResponseEntity(HttpStatus.OK);
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity handlerEmptyResult(EmptyResultDataAccessException e){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
