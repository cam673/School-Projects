package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class VehicleDetailActivity extends AppCompatActivity
{
    TextView make, model, description, update, price;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_detail);

        //initialize the views
        make=(TextView) findViewById(R.id.vehicle_make);
        model=(TextView) findViewById(R.id.model);
        description=(TextView) findViewById(R.id.veh_description);
        update=(TextView) findViewById(R.id.created_at);
        price=(TextView) findViewById(R.id.price);
        image=(ImageView) findViewById(R.id.image_url);

        //Grab the view information
        Intent tempIntent = getIntent();
        String carMake = tempIntent.getStringExtra("carMa");
        String carModel = tempIntent.getStringExtra("carM");
        String carDesc = tempIntent.getStringExtra("carD");
        String carUpdate = tempIntent.getStringExtra("carU");
        String carPrice = tempIntent.getStringExtra("carPr");
        String carPicture = tempIntent.getStringExtra("carP");

        //Populate the views with appropriate information
        make.setText(carMake);
        model.setText(carModel);
        description.setText(carDesc);
        update.setText(carUpdate);
        price.setText(carPrice);
        Picasso.with(getBaseContext()).load(carPicture).resize(136, 145).into(image);
    }
}
