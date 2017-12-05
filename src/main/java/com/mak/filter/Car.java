package com.mak.filter;
 
public class Car {
  private String make;
  private String model;
  private int year;
   
  public Car(String theMake, String theModel, int yearOfMake) {
    make = theMake;
    model = theModel;
    year = yearOfMake;
  }                   
   
  public String getMake() { return make; }
  public String getModel() { return model; }
  public int getYear() { return year; }


  @Override
  public String toString() {
    return "Car{" +
            "make='" + make + '\'' +
            ", model='" + model + '\'' +
            ", year=" + year +
            '}';
  }
}