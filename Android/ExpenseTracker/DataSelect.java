package com.example.expensetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

//create a new expense tracker year or select a tracker year
public class DataSelect extends AppCompatActivity implements YearPopup.YearPopupListener
{
    private ListView dataList;
    public List<Integer> tempList;
    Button addYear;
    ArrayAdapter arrayAdapter;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    public static final String TAG = "TAG";
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    String newID;

    public ArrayList<String> experiment = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_select);

        dataList = findViewById(R.id.dataList);
        addYear = findViewById(R.id.add_year_btn);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();
        tempList = new ArrayList<>();

        //fill list
        //update changes
        if(UserData.years.containsKey(userID))
        {
            tempList = UserData.years.get(userID);
        }
        else
        {
            tempList = new ArrayList<>();
        }
        /*
        final DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task)
            {
                if(task.isSuccessful())
                {
                    DocumentSnapshot document = task.getResult();
                    if(document.exists())
                    {
                        if(document.get("years") != null)
                        {
                            Toast.makeText(getApplicationContext(), "Data exists", Toast.LENGTH_SHORT).show();
                            ArrayList<String> list = (ArrayList<String>) document.get("years");
                            experiment = list;
                            //tempList = (ArrayList) document.get("years");
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Data doesn't exist", Toast.LENGTH_SHORT).show();
                            //tempList = new ArrayList<>();
                        }
                    }
                }
            }
        });
        */
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tempList);
        dataList.setAdapter(arrayAdapter);

        addYear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                yearAddBox();
            }
        });

        dataList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                final int val = (Integer) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), DataDate.class);
                intent.putExtra("selectedYear", val);
                startActivity(intent);
            }
        });
    }

    //pop up box when a user wants to add a year
    public void yearAddBox()
    {
        YearPopup yearPopup = new YearPopup();
        yearPopup.show(getSupportFragmentManager(), "year popup");
    }

    //grab the entered data, store the information, and update the list view
    @Override
    public void applyText(int yearSubmit, double incomeSubmit, double savingsSubmit)
    {
        double verify = incomeSubmit * .90;

        if(yearSubmit < 2020)
        {
            Toast.makeText(this, "Error! Year must be 2020 or greater.", Toast.LENGTH_SHORT).show();
        }
        else if(tempList.contains(yearSubmit))
        {
            String message = "Error! The year " + yearSubmit + " has already been created.";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
        else if(savingsSubmit > verify)
        {
            Toast.makeText(getApplicationContext(), "Error! Savings must be less than 90% of total income!", Toast.LENGTH_LONG).show();
        }
        else
        {
            df2.setRoundingMode(RoundingMode.DOWN);
            //String year = String.valueOf(yearSubmit);
            //DocumentReference documentReference = fStore.collection(year).document("Savings");

            String tempI = df2.format(incomeSubmit);
            String tempS = df2.format(savingsSubmit);
            incomeSubmit = Double.parseDouble(tempI);
            savingsSubmit = Double.parseDouble(tempS);

            double expenses = calculate(incomeSubmit, savingsSubmit, yearSubmit);
            newID = userID + yearSubmit;

            UserData.income.put(newID, incomeSubmit);
            UserData.dailyExpense.put(newID, expenses);
            UserData.goalSavings.put(newID, savingsSubmit);
            UserData.totalSavings.put(newID, savingsSubmit);

            //store new savings information in firestore
            /*String yearSavings = yearSubmit + "Savings";
            HashMap<String, Object> tempSavings = new HashMap<>();
            tempSavings.put("Income", incomeSubmit);
            tempSavings.put("Daily_Expense", expenses);
            tempSavings.put("Goal_Savings", savingsSubmit);
            tempSavings.put("Total_Savings", savingsSubmit);

            DocumentReference dReference = fStore.collection(userID).document(yearSavings);
            dReference.set(tempSavings).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task)
                {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(getApplicationContext(), "Savings Created.", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Savings Failed.", Toast.LENGTH_SHORT).show();
                    }
                }
            });*/

            //add to list and sort
            tempList.add(yearSubmit);
            Collections.sort(tempList);

            //map set
            UserData.years.put(userID, tempList);

            //store in firestore
            /*DocumentReference documentReference = fStore.collection("users").document(userID);
            HashMap<String, Object> tempMap = new HashMap<>();
            tempMap.put("years", tempList);
            documentReference.update(tempMap);*/

            //update the adapter
            arrayAdapter.notifyDataSetChanged();
        }
    }

    //calculate the daily expense based on user entered data
    public double calculate(double i, double s, int y)
    {
        double expenses;
        double leftOver;

        leftOver = i - s;
        int remainder = y % 4;
        if(remainder == 0)
        {
            expenses = leftOver / 366;
        }
        else
        {
            expenses = leftOver / 365;
        }

        String tempE = df2.format(expenses);
        expenses = Double.parseDouble(tempE);

        return expenses;
    }

    //main menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.expense_menu, menu);
        return true;
    }

    //menu options
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        Intent intent;
        switch (item.getItemId())
        {
            case R.id.expenseMenu:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.info:
                return true;
            case R.id.about_us:
                intent = new Intent(getApplicationContext(), About.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.help:
                intent = new Intent(getApplicationContext(), Help.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.options:
                return true;
            case R.id.chg_profile:
                intent = new Intent(getApplicationContext(), ChangeProfile.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.chg_password:
                intent = new Intent(getApplicationContext(), ChangePassword.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
