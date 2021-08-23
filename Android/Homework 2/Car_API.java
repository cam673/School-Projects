package com.example.homework2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Car_API
{
    String BASE_URL = "https://thawing-beach-68207.herokuapp.com/";

    @GET("carmakes")
    Call<List<Maker>> getCarMakers();

    @GET("carmodelmakes/{vehicle_make_id}")
    Call<List<Models>> getCarModels(@Path("vehicle_make_id") int vehicle_make_id);

    @GET("cars/{vehicle_make_id}/{vehicle_model_id}/92603")
    Call<List<CarList>> getCars(@Path("vehicle_make_id") int vehicle_make_id, @Path("vehicle_model_id") int vehicle_model_id);
}
