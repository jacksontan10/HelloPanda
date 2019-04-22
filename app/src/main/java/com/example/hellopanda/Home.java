package com.example.hellopanda;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


    public class Home extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            //-----MENU SECTION-----//
            //top Action Toolbar
            android.support.v7.widget.Toolbar toolbar = findViewById(R.id.action_bar);
            setSupportActionBar(toolbar);

            //centering of toolbar title and removing default title
            TextView centredTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            //bottom navigation view
            BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

            GridLayout outerGrid = (GridLayout) findViewById(R.id.outerGrid);

            //Set Event
            setSingleEvent(outerGrid);

        }

        private void setSingleEvent(GridLayout outerGrid) {
            //Loop all child item of Main Grid
            for (int i = 0; i < outerGrid.getChildCount(); i++) {
                //You can see , all child item is CardView , so we just cast object to CardView
                CardView cardView = (CardView) outerGrid.getChildAt(i);
                final int finalI = i;
                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(Home.this, Home.class);
                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);

                    }
                });
            }
        }

        //Toggle Event
        private void setToggleEvent(GridLayout outerGrid) {
            //Loop all child item of Outer grid
            for (int i = 0; i < outerGrid.getChildCount(); i++) {
                //You can see , all child item is CardView , so we just cast object to CardView
                final CardView cardView = (CardView) outerGrid.getChildAt(i);
                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                            //Change background color
                            cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                            Toast.makeText(Home.this, "State : True", Toast.LENGTH_SHORT).show();

                        } else {
                            //Change background color
                            cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                            Toast.makeText(Home.this, "State : False", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch(item.getItemId()){
                case R.id.settings:
                    Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.signout:
                    Toast.makeText(this, "Signout selected", Toast.LENGTH_SHORT).show();
                    return true;

                default:
                    return super.onOptionsItemSelected(item);
            }
        }
}
