package com.example.expensetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

//select the month users would like to view the chart of
public class ChartMonth extends AppCompatActivity
{
    private ListView chartMonth;
    public String [] monthList;
    ArrayAdapter<String> arrayAdapter;
    String year, month;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID, newID;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_month);

        chartMonth = findViewById(R.id.chartMonth);
        monthList = getResources().getStringArray(R.array.months);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, monthList);
        chartMonth.setAdapter(arrayAdapter);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();

        Intent intent = getIntent();
        year = intent.getStringExtra("selectedYear");

        chartMonth.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String val = arrayAdapter.getItem(position);
                month = val;
                validate();
            }
        });
    }

    //check if enough data has been entered for the month
    public void validate()
    {
        int accum = 0;
        //check for data entries
        for(int i = 1; i <= 31; i++)
        {
            newID = userID + year + month + i;
            if(UserData.expenses.containsKey(newID))
            {
                accum += 1;
            }
        }

        //String message = "There are " + accum + " data entries for " + month + ".";
        //Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

        if(accum < 3)
        {
            Toast.makeText(getApplicationContext(), "Error! 3 data entries must be entered for this month!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            getChart();
        }
    }

    //grab the days, expenses entered and send the user to the chart
    public void getChart()
    {
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Float> expense = new ArrayList<>();

        for(int i = 1; i <= 31; i++)
        {
            newID = userID + year + month + i;
            if(UserData.expenses.containsKey(newID))
            {
                String day = String.valueOf(i);
                double ex = UserData.expenses.get(newID);
                float e = (float) ex;
                days.add(day);
                expense.add(e);
            }
        }

        float [] expenses = new float[expense.size()];
        for(int i = 0; i < expense.size(); i++)
        {
            expenses[i] = expense.get(i);
        }

        Intent intent = new Intent(getApplicationContext(), ChartDisplay.class);
        intent.putExtra("selectedYear", year);
        intent.putExtra("selectedMonth", month);
        intent.putExtra("days", days);
        intent.putExtra("expense", expenses);
        startActivity(intent);
    }

    //cancel menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cancel, menu);
        return true;
    }

    //go back to ChartSelect menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        Intent intent;
        switch (item.getItemId())
        {
            case R.id.cancel_btn:
                intent = new Intent(getApplicationContext(), ChartSelect.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
