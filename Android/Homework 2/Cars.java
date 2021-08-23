package com.example.homework2;

public class Cars
{
    private String color;
    private String created_at;
    private int id;
    private String image_url;
    private int mileage;
    private String model;
    private double price;
    private String veh_description;
    private String vehicle_make;
    private String vehicle_url;
    private String vin_number;

    public Cars(String color, String created_at, int id, String image_url, int mileage, String model, double price, String veh_description, String vehicle_make, String vehicle_url, String vin_number) {
        this.color = color;
        this.created_at = created_at;
        this.id = id;
        this.image_url = image_url;
        this.mileage = mileage;
        this.model = model;
        this.price = price;
        this.veh_description = veh_description;
        this.vehicle_make = vehicle_make;
        this.vehicle_url = vehicle_url;
        this.vin_number = vin_number;
    }

    public String getColor() {
        return color;
    }

    public String getCreated_at() {
        return created_at;
    }

    public int getId() {
        return id;
    }

    public String getImage_url() {
        return image_url;
    }

    public int getMileage() {
        return mileage;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public String getVeh_description() {
        return veh_description;
    }

    public String getVehicle_make() {
        return vehicle_make;
    }

    public String getVehicle_url() {
        return vehicle_url;
    }

    public String getVin_number() {
        return vin_number;
    }

    /*{
        "color":"white",
            "created_at":"Mon, 15 Jul 2019 02:11:34 GMT",
            "id":3200,
            "image_url":"https://images.autotrader.com/images/2019/5/15/515/871/43648981310.515871123.IM1.MAIN.1000x750_A.1000x750.jpg",
            "mileage":7300,
            "model":"V12 Vantage",
            "price":102000.0,
            "veh_description":"Location: Irvine, CA. This 2015 Aston Martin V12 Vantage includes Backup Camera, Bluetooth Hands-Free, CD Player, Cruise Control, Keyless Entry, Leather Seats, Navigation, Power Locks, Power Windows, Premium Wheels",
            "vehicle_make":"Aston Martin",
            "vehicle_url":"https://www.autotrader.com/cars-for-sale/vehicledetails.xhtml?listingId=515871123&zip=92603&referrer=%2Fcars-for-sale%2Fsearchresults.xhtml%3Fzip%3D92603%26sortBy%3Drelevance%26incremental%3Dall%26firstRecord%3D0%26marketExtension%3Don%26modelCodeList%3DV12VANT%26makeCodeList%3DASTON%26searchRadius%3D50&numRecords=25&firstRecord=0&modelCodeList=V12VANT&makeCodeList=ASTON&searchRadius=50&makeCode1=ASTON&modelCode1=V12VANT",
            "vin_number":""}*/
}
