package com.example.expensetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;

//add expense to the day the user entered for the month
public class DataAdd extends AppCompatActivity
{
    EditText amount;
    Button submit;
    String expense;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID, newID, updateID, month;
    int year, day;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_add);

        amount = (EditText) findViewById(R.id.expense_add);
        submit = (Button) findViewById(R.id.expense_add_btn);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();

        Intent intent = getIntent();
        year = intent.getIntExtra("year", 0);
        month = intent.getStringExtra("month");
        day = intent.getIntExtra("day", 0);
        updateID = userID + year;
        newID = userID + year + month + day;

        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                addExpense();
            }
        });
    }

    //add a new expense if the following validation checks are satisfied
    public void addExpense()
    {
        expense = amount.getText().toString().trim();
        df2.setRoundingMode(RoundingMode.DOWN);
        double enteredExpense;

        double tSavings = UserData.totalSavings.get(updateID);
        double daily = UserData.dailyExpense.get(updateID);
        double difference;
        Intent go;
        //if no expense entered
        if(expense.isEmpty())
        {
            amount.setError("Please Enter an amount.");
            Toast.makeText(getApplicationContext(), "Error! Enter an amount.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            enteredExpense = Double.parseDouble(expense);
            String tempE = df2.format(enteredExpense);
            enteredExpense = Double.parseDouble(tempE);
            //if expense exceeds total savings
            if(Double.compare(tSavings, enteredExpense) < 0)
            {
                amount.setError("Please enter an new amount.");
                Toast.makeText(getApplicationContext(), "Error! Expense cannot exceed total savings.", Toast.LENGTH_SHORT).show();
            }
            //if expense is the same as daily limit
            else if(Double.compare(daily, enteredExpense) == 0)
            {
                UserData.expenses.put(newID, enteredExpense);

                Toast.makeText(getApplicationContext(), "Expense Added!", Toast.LENGTH_SHORT).show();
                go = new Intent(getApplicationContext(), DataSelect.class);
                startActivity(go);
            }
            //if expense is greater than daily limit
            else if(Double.compare(daily, enteredExpense) < 0)
            {
                difference = enteredExpense - daily;
                tSavings = tSavings - difference;
                String tempT = df2.format(tSavings);
                tSavings = Double.parseDouble(tempT);

                UserData.expenses.put(newID, enteredExpense);
                UserData.totalSavings.put(updateID, tSavings);

                Toast.makeText(getApplicationContext(), "Expense Added!", Toast.LENGTH_SHORT).show();
                go = new Intent(getApplicationContext(), DataSelect.class);
                startActivity(go);
            }
            //if expense is less than daily limit
            else
            {
                difference = daily - enteredExpense;
                tSavings = tSavings + difference;
                String tempT = df2.format(tSavings);
                tSavings = Double.parseDouble(tempT);

                UserData.expenses.put(newID, enteredExpense);
                UserData.totalSavings.put(updateID, tSavings);

                Toast.makeText(getApplicationContext(), "Expense Added!", Toast.LENGTH_SHORT).show();
                go = new Intent(getApplicationContext(), DataSelect.class);
                startActivity(go);
            }
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
