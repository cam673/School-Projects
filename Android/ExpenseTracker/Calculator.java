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
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.math.RoundingMode;
import java.text.DecimalFormat;

//Calculator to calculate a daily expense before being entered
public class Calculator extends AppCompatActivity
{
    Button results;
    EditText e_income, e_savings;
    String income, savings;
    TextView display;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        e_income = (EditText) findViewById(R.id.incomeField);
        e_savings = (EditText) findViewById(R.id.savingsField);
        results = (Button) findViewById(R.id.btnResults);
        display = (TextView) findViewById(R.id.generateText);

        results.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                calculate();
            }
        });
    }

    //calculate the daily expense
    public void calculate()
    {
        income = e_income.getText().toString().trim();
        savings = e_savings.getText().toString().trim();

        double i = Double.parseDouble(income);
        double s = Double.parseDouble(savings);
        double expenses;
        double leftOver;

        double verify = i * .90;

        //verify savings isn't higher than income
        if(s > verify)
        {
            Toast.makeText(getApplicationContext(), "Error! Savings must be less than 90% of total income!", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            leftOver = i - s;
            expenses = leftOver / 365;
            df2.setRoundingMode(RoundingMode.DOWN);
            String message = "Your daily expense is set to " + df2.format(expenses) + ".";
            display.setText(message);
            display.setVisibility(View.VISIBLE);
            return;
        }
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
                finish();
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
