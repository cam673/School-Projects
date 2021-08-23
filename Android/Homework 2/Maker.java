package com.example.homework2;

public class Maker
{
    private int id;
    private String vehicle_make;

    public Maker(int id, String vehicle_make) {
        this.id = id;
        this.vehicle_make = vehicle_make;
    }

    public int getId() {
        return id;
    }

    public String getVehicle_make() {
        return vehicle_make;
    }
}
