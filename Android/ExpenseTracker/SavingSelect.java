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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

//select the year the user would like to see savings for
public class SavingSelect extends AppCompatActivity
{
    private ListView savingList;
    public List<Integer> tempList;
    ArrayAdapter arrayAdapter;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_select);

        savingList = findViewById(R.id.savingList);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();

        if(UserData.years.containsKey(userID))
        {
            tempList = UserData.years.get(userID);
        }
        else
        {
            tempList = new ArrayList<>();
        }

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tempList);
        savingList.setAdapter(arrayAdapter);

        savingList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                final int val = (Integer) parent.getItemAtPosition(position);
                final String vals = String.valueOf(val);
                Intent intent = new Intent(getApplicationContext(), SavingDisplay.class);
                intent.putExtra("selectedYear", vals);
                startActivity(intent);
            }
        });
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
