package com.example.homework3;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{
    //set up variables
    private static final float zoom = 15f;
    EditText t_address;
    Button b_address;
    RecyclerView l_address;
    StreetListAdapter sAdapter;
    LinkedList<String> address = new LinkedList<>();
    String edit_address;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //initialize button and textview
        t_address = (EditText) findViewById(R.id.searchAddress);
        b_address = (Button) findViewById(R.id.searchButton);

        //create the array list with one entry
        l_address = (RecyclerView) findViewById(R.id.street_list);
        address.add("Cal State Long Beach");

        //initialize the adapter for the recycler
        sAdapter = new StreetListAdapter(this, address);
        l_address.setAdapter(sAdapter);
        l_address.setLayoutManager(new LinearLayoutManager(this));

        //set a header for the recycler
        //View headerView = getLayoutInflater().inflate(R.layout.header, null);
        //l_address.addHeaderView(headerView);

        //search button listener
        b_address.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                createAddress();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        //store map info
        Coordinates.mMap = googleMap;

        //Add a marker to Cal State Long Beach as the starting location, save the coordinates, and move the camera there
        LatLng beach = new LatLng(33.783850, -118.114106);
        Coordinates.coordinates.add(beach);
        Coordinates.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Coordinates.coordinates.get(0), zoom));
        Coordinates.mMap.addMarker(new MarkerOptions().position(beach).title("Marker in Cal State Long Beach"));
    }

    public void createAddress()
    {
        //retrieve user address input
        getAddress();

        //check if the text view is empty
        if(edit_address.isEmpty())
        {
            //display error message and move to starting location
            emptyText();
            Coordinates.mMap.animateCamera(CameraUpdateFactory.newLatLng(Coordinates.coordinates.get(0)));
        }
        else
        {
            //LatLng newAddress = findAddress(getApplicationContext(), "131 Roadrunner, Irvine CA 92603");
            //check if entered address is valid
            LatLng newAddress = findAddress(getApplicationContext(), edit_address);
            if(newAddress == null)
            {
                //display error message, reset the starting location, and clear the text view
                t_address.getText().clear();
                invalidAddress();
                Coordinates.mMap.animateCamera(CameraUpdateFactory.newLatLng(Coordinates.coordinates.get(0)));
            }
            else
            {
                //store the address information (name, and coordinates)
                int addressSize = address.size();
                address.add(edit_address);
                Coordinates.coordinates.add(newAddress);

                //notify the adapter, clear the text view, and move the camera to the address
                l_address.getAdapter().notifyItemInserted(addressSize);
                Coordinates.mMap.addMarker(new MarkerOptions().position(newAddress).title("Marker in " + edit_address));
                t_address.getText().clear();
                Coordinates.mMap.animateCamera(CameraUpdateFactory.newLatLng(Coordinates.coordinates.get(addressSize)));
            }


        }
    }

    //get the address the user entered
    public void getAddress()
    {
        edit_address = t_address.getText().toString().trim();
    }

    //find the address that was entered
    public LatLng findAddress(Context context, String strAddress)
    {
        Geocoder coder = new Geocoder(getApplicationContext());
        List<Address> address;
        LatLng p1 = null;

        try
        {
            address = coder.getFromLocationName(strAddress, 1);
            if (address == null)
            {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new LatLng(location.getLatitude(), location.getLongitude());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return p1;
    }

    //display dialog if no text is entered
    public void emptyText()
    {
        DialogEmpty empty = new DialogEmpty();
        empty.show(getSupportFragmentManager(), "empty dialog");
    }

    //display dialog if address entered is invalid
    public void invalidAddress()
    {
        DialogInvalid invalid = new DialogInvalid();
        invalid.show(getSupportFragmentManager(), "invalid dialog");
    }
}
