package com.example.projectforuniversity.models;

import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

     Car car;
    @BeforeEach
    void setUp() {
        car= new Car();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void createCar() {
        assertEquals(0,car.getYear());
        assertNull(car.getColour());
        assertNull(car.getCarMake());
        assertNull(car.getModel());
    }

    @Disabled
    @Test
    void setModel() {
        car.setModel("octavia");
        assertEquals("octavia",car.getModel());
    }

    @Test
    void setCarMake() {
        var mark="skoda";
        car.setCarMake(mark);
        assertEquals(mark,car.getCarMake());
    }

    @Test
    void setColour() {
        var color="red";
        car.setColour(color);
        assertEquals(color,car.getColour());
    }

    @Test
    void setYear() {
        var year= 1992;
        car.setYear(year);
        assertEquals(year,car.getYear());
    }

    @Test()
    public void exceptionSetYearMinus() throws IOException {
        var year=-10;
        Assertions.assertThrows(IllegalArgumentException.class,()-> car.setYear(year));
    }
    @Test()
    public void exceptionSetYearAboveThreeThousand() throws IOException { ;
        var year=3001;
        Assertions.assertThrows(IllegalArgumentException.class,()-> car.setYear(year));
    }
}
