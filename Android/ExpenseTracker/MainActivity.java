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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

//Christopher Masferrer
//011894127

//main application page that allows the user to enter the expense menu or go to the calculator
public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void trackerBtn(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ExpenseMenu.class);
        startActivity(intent);
    }

    public void calcBtn(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Calculator.class);
        startActivity(intent);
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
