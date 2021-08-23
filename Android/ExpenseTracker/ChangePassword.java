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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

//change the users password
public class ChangePassword extends AppCompatActivity
{
    EditText changeText;
    Button changeButton;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String newPass, userId;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        changeText = findViewById(R.id.enterNewPass);
        changeButton = findViewById(R.id.chg_pass_btn);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userId = fAuth.getCurrentUser().getUid();
        user = fAuth.getCurrentUser();

        changeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                newPass = changeText.getText().toString().trim();
                if(newPass.length() < 6)
                {
                    changeText.getText().clear();
                    Toast.makeText(getApplicationContext(), "Error! Password must be greater than 6 characters.", Toast.LENGTH_SHORT).show();
                    changeText.setError("Please enter another password.");
                }
                else
                {
                    user.updatePassword(newPass).addOnSuccessListener(new OnSuccessListener<Void>()
                    {
                        @Override
                        public void onSuccess(Void aVoid)
                        {
                            Toast.makeText(ChangePassword.this, "Password has been changed.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener()
                    {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {
                            Toast.makeText(ChangePassword.this, "Password Reset Failed.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
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
