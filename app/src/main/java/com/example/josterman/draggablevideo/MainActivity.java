package com.example.josterman.draggablevideo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.support.v7.widget.Toolbar;

// Casting Wire Up
import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastState;
import com.google.android.gms.cast.framework.CastStateListener;

public class MainActivity extends AppCompatActivity {
    private AppCompatButton playButton;
    private CastContext castContext;
    private MenuItem mMediaRouteMenuItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        castContext = CastContext.getSharedInstance(this);




        playButton = findViewById(R.id.playButton);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivities();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);

        mMediaRouteMenuItem = CastButtonFactory.setUpMediaRouteButton(getApplicationContext(),menu,R.id.media_route_menu_item);

        return true;

    }
    public void switchActivities() {
        Intent intent = new Intent(this, PlayerActivity.class);
        startActivity(intent);
    }


}