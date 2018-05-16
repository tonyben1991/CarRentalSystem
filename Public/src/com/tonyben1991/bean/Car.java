package com.tonyben1991.bean;

/**
 * @author oaec
 * @date 2018-05-16
 **/
public class Car {
    private int id;
    private String carNumber;
    private String brand;
    private String model;
    private String color;
    private String category;
    private String comments;
    private double price;
    private double rent;
    private int status;
    private int useable;

    public Car() {
    }

    public Car(int id, String carNumber, String brand, String model,
               String color, String category, String comments,
               double price, double rent, int status, int useable) {
        this.id = id;
        this.carNumber = carNumber;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.category = category;
        this.comments = comments;
        this.price = price;
        this.rent = rent;
        this.status = status;
        this.useable = useable;
    }
}
