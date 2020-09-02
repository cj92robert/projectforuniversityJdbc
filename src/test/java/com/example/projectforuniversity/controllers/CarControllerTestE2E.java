package com.example.projectforuniversity.controllers;

import com.example.projectforuniversity.models.Car;
import com.example.projectforuniversity.repositories.CarDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarControllerTestE2E {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private CarDao carDao;

    @Test
    void httpGet_returnsAllCar() {
        //given
        var car = new Car(1, "126p", "Fiat", "red", 1960);
        carDao.save(car);

        //when

        ResponseEntity<Car> result = testRestTemplate.getForEntity("http://localhost:" + port + "/1", Car.class);

        //then

        assertThat(result.getBody()).isNotNull();
        assertEquals(result.getBody().getModel(), car.getModel());
        assertEquals(result.getStatusCode(), HttpStatus.OK);

    }
}
