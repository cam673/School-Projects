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

import java.math.RoundingMode;
import java.text.DecimalFormat;

//update expense for the day the user entered
public class DataUpdate extends AppCompatActivity
{
    EditText amount;
    Button submit;
    String expense;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID, newID, updateID, month;
    int year, day;
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    double tempDouble;
    String tempString;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_update);

        amount = (EditText) findViewById(R.id.expense_update);
        submit = (Button) findViewById(R.id.expense_update_btn);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();

        Intent intent = getIntent();
        year = intent.getIntExtra("year", 0);
        month = intent.getStringExtra("month");
        day = intent.getIntExtra("day", 0);
        updateID = userID + year;
        newID = userID + year + month + day;

        tempDouble = UserData.expenses.get(newID);
        tempString = String.valueOf(tempDouble);
        amount.setText(tempString);

        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateExpense();
            }
        });
    }

    //update the expense if the following criteria is met
    public void updateExpense()
    {
        expense = amount.getText().toString().trim();
        df2.setRoundingMode(RoundingMode.DOWN);
        double enteredExpense;

        double tSavings = UserData.totalSavings.get(updateID);
        double previousExpense = UserData.expenses.get(newID);
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
            //if expense is the same as previous expense
            else if(Double.compare(previousExpense, enteredExpense) == 0)
            {
                UserData.expenses.put(newID, enteredExpense);

                Toast.makeText(getApplicationContext(), "Expense Updated!", Toast.LENGTH_SHORT).show();
                go = new Intent(getApplicationContext(), DataSelect.class);
                startActivity(go);
            }
            //if expense is greater than previous expense
            else if(Double.compare(previousExpense, enteredExpense) < 0)
            {
                difference = enteredExpense - previousExpense;
                tSavings = tSavings - difference;
                String tempT = df2.format(tSavings);
                tSavings = Double.parseDouble(tempT);

                UserData.expenses.put(newID, enteredExpense);
                UserData.totalSavings.put(updateID, tSavings);

                Toast.makeText(getApplicationContext(), "Expense Updated!", Toast.LENGTH_SHORT).show();
                go = new Intent(getApplicationContext(), DataSelect.class);
                startActivity(go);
            }
            //if expense is less than previous expense
            else
            {
                difference = previousExpense - enteredExpense;
                tSavings = tSavings + difference;
                String tempT = df2.format(tSavings);
                tSavings = Double.parseDouble(tempT);

                UserData.expenses.put(newID, enteredExpense);
                UserData.totalSavings.put(updateID, tSavings);

                Toast.makeText(getApplicationContext(), "Expense Updated!", Toast.LENGTH_SHORT).show();
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
