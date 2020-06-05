package com.example.projectforuniversity.repositories;


import com.example.projectforuniversity.models.Car;
import com.example.projectforuniversity.models.CarPage;

public interface CarDao {

    CarPage findAllByColourStartWith(String colour, int currentPage);
    Car getById(long id);
    int save(Car car);
    int update(long id, Car car);
    int deleteById(long id);
}
