package com.example.projectforuniversity.models;


import com.google.common.base.Preconditions;

public class Car {


  private long id;
  private String model;
  private String carMake;
  private String colour;
  private long year;

  public Car() {
  }

  public Car(long id, String model, String carMake, String colour, long year) {
    this.id = id;
    this.model = model;
    this.carMake = carMake;
    this.colour = colour;
    this.year = year;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }


  public String getCarMake() {
    return carMake;
  }

  public void setCarMake(String carMake) {
    this.carMake = carMake;
  }


  public String getColour() {
    return colour;
  }

  public void setColour(String colour) {
    this.colour = colour.toLowerCase();
  }


  public long getYear() {
    return year;
  }

  public void setYear(long year) {
    Preconditions.checkArgument((year>0&& year<3000),"Not allow value of year");
    //if(year<0 || year>3000) throw new IllegalArgumentException("Year not alow value");
    this.year = year;
  }

}
