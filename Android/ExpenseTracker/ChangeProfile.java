package com.example.expensetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

//change the users profile information
public class ChangeProfile extends AppCompatActivity
{
    EditText chgName, chgEmail, chgPhone;
    Button saveChanges;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String newName, newEmail, newPhone, userId;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);

        chgName = findViewById(R.id.changeName);
        chgEmail = findViewById(R.id.changeEmail);
        chgPhone = findViewById(R.id.changePhone);
        saveChanges = findViewById(R.id.new_cred_btn);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userId = fAuth.getCurrentUser().getUid();
        user = fAuth.getCurrentUser();

        //set default text for all edit text fields
        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>()
        {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e)
            {
                chgName.setText(documentSnapshot.getString("username"));
                chgEmail.setText(documentSnapshot.getString("email"));
                chgPhone.setText(documentSnapshot.getString("phone"));
            }
        });

        saveChanges.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                changeCred();
            }
        });
    }

    //check if validation requirements are met before changing credentials
    public void changeCred()
    {
        //grab entered text
        initialize();

        //check if credentials are entered correctly
        if(!validate())
        {
            Toast.makeText(this, "Profile Change Failed", Toast.LENGTH_SHORT).show();
        }
        else
        {
            onValidateSuccess();
        }
    }

    //grab user input
    public void initialize()
    {
        newName = chgName.getText().toString().trim();
        newEmail = chgEmail.getText().toString().trim();
        newPhone = chgPhone.getText().toString().trim();
    }

    //validation checks
    public boolean validate()
    {
        boolean valid = true;
        if(newName.isEmpty())
        {
            chgName.setError("Please enter a valid name.");
            valid = false;
        }
        if(newName.length() > 50)
        {
            chgName.setError("Name must be 50 characters or less.");
            valid = false;
        }
        if(newEmail.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(newEmail).matches())
        {
            chgEmail.setError("Please enter an email.");
            valid = false;
        }
        if(newPhone.isEmpty())
        {
            chgPhone.setError("Please enter a phone number.");
            valid = false;
        }
        return valid;
    }

    //enter new credentials
    public void onValidateSuccess()
    {
        //update credentials
        user.updateEmail(newEmail).addOnSuccessListener(new OnSuccessListener<Void>()
        {
            @Override
            public void onSuccess(Void aVoid)
            {
                DocumentReference docRef = fStore.collection("users").document(user.getUid());
                Map<String, Object> edited = new HashMap<>();
                edited.put("email", newEmail);
                edited.put("phone", newPhone);
                edited.put("username", newName);
                docRef.update(edited).addOnSuccessListener(new OnSuccessListener<Void>()
                {
                    @Override
                    public void onSuccess(Void aVoid)
                    {
                        Toast.makeText(ChangeProfile.this, "Profile updated.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener()
        {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(ChangeProfile.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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
