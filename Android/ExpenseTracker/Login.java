package com.example.expensetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

//activity that logs in the user to the app
public class Login extends AppCompatActivity
{
    //create variables for the buttons and edit text
    Button login, register;
    EditText email, password;
    String eMail, passW;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    TextView forgotTextLink;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=(Button) findViewById(R.id.btnLogin);
        register=(Button) findViewById(R.id.btnSignup);
        email=(EditText) findViewById(R.id.txtEmail);
        password=(EditText) findViewById(R.id.txtPassword);
        forgotTextLink=(TextView) findViewById(R.id.forgotLink);

        //authentication tools
        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar2);

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

        //reset the user password
        forgotTextLink.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final EditText resetMail = new EditText(v.getContext());
                final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password?");
                passwordResetDialog.setMessage("Enter your Email to receive the reset link.");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        //extract the email and send the reset link
                        String mail = resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>()
                        {
                            @Override
                            public void onSuccess(Void aVoid)
                            {
                                Toast.makeText(Login.this, "Reset link was sent to your email.", Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener()
                        {
                            @Override
                            public void onFailure(@NonNull Exception e)
                            {
                                Toast.makeText(Login.this, "Error! Reset link not sent" + e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        //close dialog
                    }
                });

                passwordResetDialog.create().show();
            }
        });
    }

    //go to signup page if signup button was pressed
    public void openSignUp()
    {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    //log the user in of conditions are met
    public void login()
    {
        //progress bar
        progressBar.setVisibility(View.VISIBLE);

        eMail=email.getText().toString().trim();
        passW=password.getText().toString().trim();

        if(!validate())
        {
            Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.INVISIBLE);
            password.getText().clear();
        }
        else
        {
            fAuth.signInWithEmailAndPassword(eMail, passW).addOnCompleteListener(new OnCompleteListener<AuthResult>()
            {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Error ! " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.INVISIBLE);
                        password.getText().clear();
                    }
                }
            });
        }
    }

    //check if entered credentials are true
    public boolean validate()
    {
        boolean valid = true;
        if(eMail.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(eMail).matches())
        {
            email.setError("Please Enter an email");
            valid = false;
        }
        if(passW.isEmpty())
        {
            password.setError("Please Enter a password");
            valid = false;
        }
        return valid;
    }
}
