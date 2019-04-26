package com.example.hellopanda;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hellopanda.models.User;
import com.example.hellopanda.test.Common;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {

    //declare views, database and user objects
    MaterialEditText editNewUser, editNewPassword, editNewEmail;
    MaterialEditText editUser, editPassword;
    Button btnSignUp, btnSignIn;
    FirebaseDatabase database;
    DatabaseReference users;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_main);

        //retrieve an instance of the firebase database
        database = FirebaseDatabase.getInstance();

        //declare users object with reference to "Users" database from Firebase
        users = database.getReference("Users");

        //reference views from activity_main_xml
        editUser = findViewById(R.id.editUser);
        editPassword = findViewById(R.id.editPassword);

        btnSignIn = findViewById(R.id.btn_sign_in);
        btnSignUp = findViewById(R.id.btn_sign_up);

        //create onClickListeners for Sign In and Sign Up buttons and call the corresponding onClick method
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSignUpDialog();
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                signIn(editUser.getText().toString(), editPassword.getText().toString());
            }
        } );

    }

    private void signIn(final String user, final String pwd) {
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(user).exists()) {
                    if(!user.isEmpty()) {
                        User login = dataSnapshot.child(user).getValue(User.class);
                        if(login.getPassword().equals(pwd)) {
                            Intent homeActivity = new Intent(MainActivity.this, Home.class);
                            Common.currentUser = login;
                            MainActivity.this.startActivity(homeActivity);
                            finish();
                        }
                        else
                            Toast.makeText(MainActivity.this, "Wrong password", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(MainActivity.this, "Please enter your username", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "User does not exist", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    //create showSignUpDialog method which is invoked by onClick for each button
    private void showSignUpDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Sign Up");
        alertDialog.setMessage("Please complete all fields");

        LayoutInflater inflater = this.getLayoutInflater();
        View sign_up_layout = inflater.inflate(R.layout.sign_up_layout, null);

        editNewUser = sign_up_layout.findViewById(R.id.editNewUser);
        editNewPassword = sign_up_layout.findViewById(R.id.editNewPassword);
        editNewEmail = sign_up_layout.findViewById(R.id.editNewEmail);

        alertDialog.setView(sign_up_layout);
        alertDialog.setIcon(R.drawable.ic_account_circle_black_24dp);

        alertDialog.setNegativeButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        alertDialog.setPositiveButton("Register", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                final User user = new User(editNewUser.getText().toString(),
                        editNewPassword.getText().toString(),
                        editNewEmail.getText().toString());

                users.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(user.getUser()).exists())
                            Toast.makeText(MainActivity.this, "Username is already taken",
                                    Toast.LENGTH_SHORT).show();
                        else {
                            users.child(user.getUser()).setValue(user);
                            Toast.makeText(MainActivity.this, "Registration successful!",
                                    Toast.LENGTH_SHORT).show();
                            Intent onboardActivity = new Intent(MainActivity.this, Onboarding.class);
                            Common.currentUser = user;
                            MainActivity.this.startActivity(onboardActivity);
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                dialog.dismiss();
            }
        });

        alertDialog.show();
    }

}