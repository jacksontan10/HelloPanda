package com.example.hellopanda;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hellopanda.fragments.LearnFragment;
import com.example.hellopanda.fragments.ProgressFragment;
import com.example.hellopanda.fragments.RankingFragment;
import com.example.hellopanda.fragments.TestFragment;
import com.example.hellopanda.test.Common;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference userTable;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);

            database = FirebaseDatabase.getInstance();
            userTable = database.getReference("Users");

            //top Action Toolbar
            android.support.v7.widget.Toolbar toolbar = findViewById(R.id.action_bar);
            setSupportActionBar(toolbar);

            //centering of toolbar title and removing default title
            TextView centredTitle = toolbar.findViewById(R.id.toolbar_title);
            TextView userText=toolbar.findViewById(R.id.toolbar_user);
            userText.setText(Common.currentUser.getUser());
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            //to display a fragment since no item has been selected
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new LearnFragment()).commit();

            //bottom navigation view
            BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
            bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        }

        private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        Fragment selectedFragment = null; //reference to the fragment we want to open

                        switch (menuItem.getItemId()) {
                            case R.id.learn:
                                //define what we want to do when this item (defined in bottom_navigation) is clicked -> show XFragment!
                                selectedFragment = new LearnFragment(); //only created not shown yet
                                break; //to leave switch statement
                            case R.id.test:
                                selectedFragment = new TestFragment();
                                break;
                            case R.id.progress:
                                selectedFragment = new ProgressFragment();
                                break;
                            case R.id.ranking:
                                selectedFragment = new RankingFragment();
                                break;
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,
                                selectedFragment).commit(); //replace(container we want to display our fragment in)

                        return true; //true = we want to select the clicked item (false would still show but item would not be selected)
                    }

                };

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.signout:
                    Toast.makeText(this, "一会儿见! See you soon!", Toast.LENGTH_SHORT).show();
                    Intent logOut = new Intent(Home.this, MainActivity.class);
                    startActivity(logOut);
                    finish();
                    return true;

                case android.R.id.home:
                    getSupportFragmentManager().popBackStack();
                    hideUpButton();
                    return true;

                default:
                    return super.onOptionsItemSelected(item);
            }

        }

        //back button for fragments
        public void showUpButton() { getSupportActionBar().setDisplayHomeAsUpEnabled(true); }
        public void hideUpButton() { getSupportActionBar().setDisplayHomeAsUpEnabled(false); }

    }