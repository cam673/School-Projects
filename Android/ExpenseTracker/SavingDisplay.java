package com.example.expensetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

//display various data of the savings of the selected year
public class SavingDisplay extends AppCompatActivity
{
    TextView t_year, t_income, t_expense, t_goal, t_total;
    String year, income, expense, goal, total;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    double d_income, d_expense, d_goal, d_total;
    String newID;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_display);

        t_year = (TextView) findViewById(R.id.yearText);
        t_income = (TextView) findViewById(R.id.showIncome);
        t_expense = (TextView) findViewById(R.id.showExpense);
        t_goal = (TextView) findViewById(R.id.showGoal);
        t_total = (TextView) findViewById(R.id.showTotal);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();

        Intent intent = getIntent();
        year = intent.getStringExtra("selectedYear");
        t_year.setText(year);
        newID = userID + year;

        //grab finance data
        d_income = UserData.income.get(newID);
        d_expense = UserData.dailyExpense.get(newID);
        d_goal = UserData.goalSavings.get(newID);
        d_total = UserData.totalSavings.get(newID);

        //convert from double to string
        income = String.valueOf(d_income);
        expense = String.valueOf(d_expense);
        goal = String.valueOf(d_goal);
        total = String.valueOf(d_total);

        //enter data in textview
        t_income.setText(income);
        t_expense.setText(expense);
        t_goal.setText(goal);
        t_total.setText(total);
    }
}
