package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class VehicleInfo extends AppCompatActivity
{
    // Default layout is one pane, not two.
    private boolean mTwoPane = false;

    //retrieve information for retrofit
    private String TAG = VehicleInfo.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    //api url links
    private static String carAPI = "https://thawing-beach-68207.herokuapp.com/cars";
    private static String getCars;

    //storage for each of the API's;
    ArrayList <HashMap<String, String>> carList;

    //set up retrofit support
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Car_API.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //grab base car api url
    Car_API api = retrofit.create(Car_API.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_info);

        //initialize the list view
        carList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.car_list);
        getCars = carAPI + "/" + 10 + "/" + 21 + "/92603";
        new GetCar().execute();

        //initialize the call to retrieve the car makers
        Call<List<Maker>> callM = api.getCarMakers();
        final List<String> makerNames = new ArrayList<String>();

        //generate the car maker list and populate the spinner
        callM.enqueue(new Callback<List<Maker>>() {
            @Override
            public void onResponse(Call<List<Maker>> call, Response<List<Maker>> response) {
                List<Maker> makers = response.body();
                String [] makerName = new String[makers.size()];
                final int [] makeID = new int[makers.size()];
                Spinner maker = (Spinner) findViewById(R.id.spinner);

                for(int i = 0; i < makers.size(); i++)
                {
                    makerName[i] = makers.get(i).getVehicle_make();
                    makeID[i] = makers.get(i).getId();
                    makerNames.add(makerName[i]);
                }

                ArrayAdapter<String> makeAdapter = new ArrayAdapter<String>(
                        getBaseContext(), android.R.layout.simple_spinner_item, makerName);

                makeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                maker.setAdapter(makeAdapter);

                //checks if new maker is selected then update the model spinner
                maker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        modelSpinner(makeID[position]);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onFailure(Call<List<Maker>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Is the container layout available? If so, set mTwoPane to true.
        if (findViewById(R.id.vehicle_detail_container) != null) {
            mTwoPane = true;
        }

    }

    public void modelSpinner(int id)
    {
        //initialize the call to retrieve the car models based on the maker
        Call<List<Models>> callMo = api.getCarModels(id);
        //generate the new model list
        callMo.enqueue(new Callback<List<Models>>() {
            @Override
            public void onResponse(Call<List<Models>> call, Response<List<Models>> response) {
                List<Models> models = response.body();
                String [] modelName = new String[models.size()];
                final int [] modelID = new int[models.size()];
                final int [] makerID = new int[models.size()];
                Spinner model = (Spinner) findViewById(R.id.spinner2);

                for(int i = 0; i < models.size(); i++)
                {
                    modelName[i] = models.get(i).getModel();
                    modelID[i] = models.get(i).getId();
                    makerID[i] = models.get(i).getVehicle_make_id();
                }

                ArrayAdapter<String> modelAdapter = new ArrayAdapter<String>(
                        getBaseContext(), android.R.layout.simple_spinner_item, modelName);

                modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                model.setAdapter(modelAdapter);

                //check if new model is selected then update the car list
                model.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        carList(makerID[position], modelID[position]);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onFailure(Call<List<Models>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void carList(int mkID, int mlID)
    {
        //grab the id's for make and model then generate the url and create the correct listview
        getCars = carAPI + "/" + mkID + "/" + mlID + "/92603";
        carList.clear();
        lv.setAdapter(null);
        new GetCar().execute();

        //check if tablet or phone
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mTwoPane)
                {
                    //Get selected car position in car list
                    int selectedCar;
                    //Create new instance of fragment and add it to
                    //the activity using fragment transaction

                }
                else
                {
                    HashMap<String, String> tempMap = carList.get(position);
                    String carMake = tempMap.get("vehicle_make");
                    String carModel = tempMap.get("model");
                    String carDesc = tempMap.get("veh_description");
                    String carUpdate = tempMap.get("created_at");
                    String carPrice = tempMap.get("price");
                    String carPicture = tempMap.get("image_url");

                    //send information to vehicle activity
                    Intent intent = new Intent(getBaseContext(), VehicleDetailActivity.class);
                    intent.putExtra("carMa", carMake);
                    intent.putExtra("carM", carModel);
                    intent.putExtra("carD", carDesc);
                    intent.putExtra("carU", carUpdate);
                    intent.putExtra("carPr", carPrice);
                    intent.putExtra("carP", carPicture);
                    startActivity(intent);
                }
                //original spot
            }
        });

    }

    //grab the car info based on url info
    private class GetCar extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            //Show progress dialog
            pDialog = new ProgressDialog(VehicleInfo.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0)
        {
            HttpHandler sh = new HttpHandler();

            //make a request to car url
            String jsonStr = sh.makeServiceCall(getCars);

            Log.e(TAG, "Response from car API: " + jsonStr);
            if(jsonStr != null)
            {
                try
                {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    //set up car array
                    JSONArray cars = jsonObj.getJSONArray("lists"); //not sure on the naming

                    //looping through all the cars
                    for(int i = 0; i < cars.length(); i++)
                    {
                        //grab a car from the list
                        JSONObject c = cars.getJSONObject(i);

                        //grab all the information from the API
                        String color = c.getString("color");
                        String created_at = c.getString("created_at");
                        String id = c.getString("id");
                        String image_url = c.getString("image_url");
                        String mileage = c.getString("mileage");
                        String model = c.getString("model");
                        String price = c.getString("price");
                        String veh_description = c.getString("veh_description");
                        String vehicle_make = c.getString("vehicle_make");
                        String vehicle_url = c.getString("vehicle_url");
                        String vin_number = c.getString("vin_number");

                        //create a temporary hash map to store all the information
                        HashMap<String, String> car = new HashMap<>();

                        // add each element to the temp hashmap
                        car.put("color", color);
                        car.put("created_at", created_at);
                        car.put("id", id);
                        car.put("model", model);
                        car.put("price", price);
                        car.put("vehicle_make", vehicle_make);
                        car.put("veh_description", veh_description);
                        car.put("image_url", image_url);

                        //add car to carList
                        carList.add(car);
                    }
                }
                catch (final JSONException e)
                {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });
                }
            }
            else
            {
                Log.e(TAG, "Couldn't get maker API from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result)
        {
            super.onPostExecute(result);
            //Dismiss the progress dialog
            if (pDialog.isShowing())
            {
                pDialog.dismiss();
            }
            //update the car adapter into the list view
            ListAdapter adapter = new SimpleAdapter(
                    VehicleInfo.this,
                    carList,
                    R.layout.maker_info,
                    new String[]{"model", "color", "price"},
                    new int[]{R.id.model, R.id.color, R.id.price});

            lv.setAdapter(adapter);
        }
    }
}
