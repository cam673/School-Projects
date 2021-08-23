package com.example.homework2;

public class Models
{
    private int id;
    private String model;
    private int vehicle_make_id;

    public Models(int id, String model, int vehicle_make_id) {
        this.id = id;
        this.model = model;
        this.vehicle_make_id = vehicle_make_id;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getVehicle_make_id() {
        return vehicle_make_id;
    }
}
