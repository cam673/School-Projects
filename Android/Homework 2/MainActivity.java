//Christopher Masferrer
//011894127
package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity
{
    //create variables for the buttons and edit text
    Button login, register;
    EditText username, password;

    //create storage for user information
    HashMap<String, String> userInfo = new HashMap<String, String>();

    //initialize the variables and wait for either button to be pressed
    //additionally a root username and password is created
    //created users from sign up are added here
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button) findViewById(R.id.btnLogin);
        register=(Button) findViewById(R.id.btnSignup);
        username=(EditText) findViewById(R.id.txtUsername);
        password=(EditText) findViewById(R.id.txtPassword);
        userInfo.put("password", "root");
        userInfo.put("email", "email@email.com");
        userInfo.put("phone", "1112223333");
        UserCredentials.users.put("root", userInfo);

        //push newly created user credentials into storage
        Intent tempIntent = getIntent();
        String tName = tempIntent.getStringExtra("creName");
        HashMap<String, String> tInfo = (HashMap<String, String>)tempIntent.getSerializableExtra("creInfo");
        setCredentials(tName, tInfo) ;

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                login();

            }
        });
        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                openSignUp();
            }
        });

    }

    //place any new credentials from registration into storage
    public void setCredentials(String tempName, HashMap<String, String> tempInfo)
    {
        UserCredentials.users.put(tempName, tempInfo);
    }

    //check login credentials
    //if successful, redirect to welcome page
    //if unsuccessful display error
    public void login()
    {
        String userN=username.getText().toString().trim();
        String passW=password.getText().toString().trim();
        boolean userInput = UserCredentials.users.containsKey(userN);
        if(userInput == true)
        {
            String passM = UserCredentials.users.get(userN).get("password");
            boolean passInput = passM.equals(passW);
            if(passInput == true)
            {
                openWelcome();
            }
            else
            {
                Toast.makeText(this, "username and password do not match!", Toast.LENGTH_LONG).show();
                password.getText().clear();
            }
        }
        else
        {
            Toast.makeText(this, "invalid username!", Toast.LENGTH_LONG).show();
            password.getText().clear();
        }
    }
    //go to signup page if signup button was pressed
    public void openSignUp()
    {
        Intent intent = new Intent(this, signUpActivity.class);
        startActivity(intent);
    }
    //go to welcome page if login was successful
    public void openWelcome()
    {
        Intent intent = new Intent(this, VehicleInfo.class);
        startActivity(intent);
    }
}
