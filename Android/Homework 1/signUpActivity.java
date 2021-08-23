package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class signUpActivity extends AppCompatActivity
{
    //assigned variables for the buttons, edit text boxes, store entered information
    Button signUp;
    EditText ed_username, ed_password, ed_rePassword, ed_email, ed_phone;
    String name, pass, rpass, email, phone;
    HashMap<String, String> userInfo = new HashMap<String, String>();

    //initializing each of the variables except strings(used for verification) and storage
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUp=(Button) findViewById(R.id.button);
        ed_username=(EditText) findViewById(R.id.userNameR);
        ed_password=(EditText) findViewById(R.id.passwordR);
        ed_rePassword=(EditText) findViewById(R.id.rePasswordR);
        ed_email=(EditText) findViewById(R.id.email);
        ed_phone=(EditText) findViewById(R.id.phone);
        //wait for the sign up button to be pressed
        signUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                register();
            }
        });
    }

    //check if all credentials have been filled
    //if so, redirect to login, otherwise display an error
    public void register()
    {
        initialize();
        if(!validate())
        {
            Toast.makeText(this, "Signup has Failed", Toast.LENGTH_SHORT).show();
        }
        else
        {
            onSignupSuccess();
        }
    }

    //this code displays login success and pushes new credentials before switching to login page
    public void onSignupSuccess()
    {
        userInfo.put("password", pass);
        userInfo.put("email", email);
        userInfo.put("phone", phone);
        Toast.makeText(this, "Signup Successful!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("creName", name);
        intent.putExtra("creInfo", userInfo);
        startActivity(intent);
    }

    //checks through all the entries to see if they are filled out
    //additional password check to see if they match
    //check if username exists
    public boolean validate()
    {
        boolean userInput = UserCredentials.users.containsKey(name);
        boolean valid = true;
        if(name.isEmpty())
        {
            ed_username.setError("Please Enter a valid name");
            valid = false;
        }
        if(userInput == true)
        {
            ed_username.setError("Username exists!");
            valid = false;
        }
        if(pass.isEmpty())
        {
            ed_password.setError("Please Enter a password");
            valid = false;
        }
        if(rpass.isEmpty() || !rpass.equals(pass))
        {
            ed_password.getText().clear();
            ed_rePassword.getText().clear();
            ed_rePassword.setError("Please Re-enter the password");
            valid = false;
        }
        if(email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            ed_email.setError("Please Enter an email");
            valid = false;
        }
        if(phone.isEmpty())
        {
            ed_phone.setError("Please Enter a phone number");
            valid = false;
        }
        return valid;
    }

    //collects the user input for use in verification
    public void initialize()
    {
        name = ed_username.getText().toString().trim();
        pass = ed_password.getText().toString().trim();
        rpass = ed_rePassword.getText().toString().trim();
        email = ed_email.getText().toString().trim();
        phone = ed_phone.getText().toString().trim();
    }
}
