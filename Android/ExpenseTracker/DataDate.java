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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

//select a day that the user wants to enter data for
public class DataDate extends AppCompatActivity
{
    Spinner month, day;
    Button add;
    TextView dataCheck;
    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter<Integer> numbers;
    List<Integer> list = new ArrayList<Integer>();
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID, newID;
    int year, selectDay;
    String selectMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_date);

        month = findViewById(R.id.monthPicker);
        day = findViewById(R.id.dayPicker);
        add = (Button) findViewById(R.id.data_pick_btn);
        dataCheck = (TextView) findViewById(R.id.data_check);

        adapter = ArrayAdapter.createFromResource(this, R.array.months, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        month.setAdapter(adapter);

        numbers = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_spinner_item, list);
        numbers.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day.setAdapter(numbers);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();

        Intent intent = getIntent();
        year = intent.getIntExtra("selectedYear", 0);

        //select the month
        month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                selectMonth = parent.getItemAtPosition(position).toString();
                setDay(position);
                newID = userID + year + selectMonth + selectDay;
                if(UserData.expenses.containsKey(newID))
                {
                    dataCheck.setText("Data exists");
                }
                else
                {
                    dataCheck.setText("Data doesn't exist");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //
            }
        });

        //select the day
        day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String tempDay = parent.getItemAtPosition(position).toString();
                selectDay = Integer.parseInt(tempDay);
                newID = userID + year + selectMonth + selectDay;
                if(UserData.expenses.containsKey(newID))
                {
                    dataCheck.setText("Data exists");
                }
                else
                {
                    dataCheck.setText("Data doesn't exist");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //
            }
        });

        //determine if data exists for that day, if it does direct to update, otherwise add
        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent;
                newID = userID + year + selectMonth + selectDay;
                if(UserData.expenses.containsKey(newID))
                {
                    intent = new Intent(getApplicationContext(), DataUpdate.class);
                    intent.putExtra("year", year);
                    intent.putExtra("month", selectMonth);
                    intent.putExtra("day", selectDay);
                    startActivity(intent);
                }
                else
                {
                    intent = new Intent(getApplicationContext(), DataAdd.class);
                    intent.putExtra("year", year);
                    intent.putExtra("month", selectMonth);
                    intent.putExtra("day", selectDay);
                    startActivity(intent);
                }
            }
        });
    }

    //called when a month is selected to determine the amount of valid days with that month
    public void setDay(int month)
    {
        if(month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11)
        {
            list.clear();
            for(int i = 1; i <= 31; i++)
            {
                list.add(i);
            }
            numbers.notifyDataSetChanged();
        }
        else if(month == 3 || month == 5 || month == 8 || month == 10)
        {
            list.clear();
            for(int i = 1; i <= 30; i++)
            {
                list.add(i);
            }
            numbers.notifyDataSetChanged();
        }
        else if(month == 1)
        {
            list.clear();
            int remainder = year % 4;
            if(remainder == 0)
            {
                for(int i = 1; i <= 29; i++)
                {
                    list.add(i);
                }
                numbers.notifyDataSetChanged();
            }
            else
            {
                for(int i = 1; i <= 28; i++)
                {
                    list.add(i);
                }
                numbers.notifyDataSetChanged();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "ERROR! Unknown Selection", Toast.LENGTH_SHORT).show();
        }
    }

    //cancel menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cancel, menu);
        return true;
    }

    //return to DataSelect
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        Intent intent;
        switch (item.getItemId())
        {
            case R.id.cancel_btn:
                intent = new Intent(getApplicationContext(), DataSelect.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
