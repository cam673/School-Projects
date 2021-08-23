package com.example.expensetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

//create a new user account
public class Register extends AppCompatActivity
{
    Button returnButton, signUp;
    EditText ed_username, ed_password, ed_rePassword, ed_email, ed_phone;
    String name, pass, rpass, email, phone;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    FirebaseFirestore fStore;
    String userID;
    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //set up variables for each of the page items
        returnButton=(Button) findViewById(R.id.btnReturn);
        signUp=(Button) findViewById(R.id.btnRegister);
        ed_username=(EditText) findViewById(R.id.userNameR);
        ed_password=(EditText) findViewById(R.id.passwordR);
        ed_rePassword=(EditText) findViewById(R.id.rePasswordR);
        ed_email=(EditText) findViewById(R.id.email);
        ed_phone=(EditText) findViewById(R.id.phone);

        //authentication tools
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        progressBar = findViewById(R.id.progressBar);

        //check if user is logged in
        //if so, redirect to main activity
        if(fAuth.getCurrentUser() != null)
        {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }

        //button click events
        signUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                register();
            }
        });
        returnButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                returnLogin();
            }
        });
    }

    //return to the login page
    public void returnLogin()
    {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    //check if all credentials have been filled
    //if so, redirect to login, otherwise display an error
    public void register()
    {
        //progress bar
        progressBar.setVisibility(View.VISIBLE);

        //grab the text fields
        initialize();

        //check if fields are entered correctly
        if(!validate())
        {
            Toast.makeText(this, "Signup has Failed", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.INVISIBLE);
        }
        else
        {
            onSignupSuccess();
        }
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

    //checks through all the entries to see if they are filled out
    //additional password check to see if they match
    //check if username exists
    public boolean validate()
    {
        //boolean userInput = UserCredentials.users.containsKey(name);
        boolean valid = true;
        if(name.isEmpty())
        {
            ed_username.setError("Please Enter a valid name.");
            valid = false;
        }
        if(name.length() > 50)
        {
            ed_username.setError("Name must be 50 characters long or less.");
            valid = false;
        }
        /*if(userInput == true)
        {
            ed_username.setError("Username exists!");
            valid = false;
        }*/
        if(pass.isEmpty())
        {
            ed_password.setError("Please enter a password");
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
            ed_email.setError("Please enter an email");
            valid = false;
        }
        if(phone.isEmpty())
        {
            ed_phone.setError("Please enter a phone number");
            valid = false;
        }
        return valid;
    }

    //this code displays login success and pushes new credentials before switching to login page
    public void onSignupSuccess()
    {
        //create the new account
        fAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Signup Successful!", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);

                    //store the data here
                    userID = fAuth.getCurrentUser().getUid();
                    DocumentReference documentReference = fStore.collection("users").document(userID);
                    Map<String, Object> user = new HashMap<>();
                    user.put("username", name);
                    user.put("email", email);
                    user.put("phone", phone);
                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>()
                    {
                        @Override
                        public void onSuccess(Void aVoid)
                        {
                            Log.d(TAG, "onSuccess: User profile has been created for " + userID);
                        }
                    }).addOnFailureListener(new OnFailureListener()
                    {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {
                            Log.d(TAG, "onFailure: " + e.toString());
                        }
                    });

                    //Go to home page
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
