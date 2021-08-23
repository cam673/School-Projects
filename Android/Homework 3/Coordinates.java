package com.example.homework3;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import java.util.LinkedList;

//holds the map and coordinate information for the activity and adapter to share
class Coordinates
{
    public static GoogleMap mMap;
    public static LinkedList<LatLng> coordinates = new LinkedList<>();
}
