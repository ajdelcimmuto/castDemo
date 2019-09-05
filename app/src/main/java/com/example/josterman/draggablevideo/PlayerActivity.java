package com.example.josterman.draggablevideo;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Switch;

import com.google.android.exoplayer2.ui.PlayerControlView;

public class PlayerActivity extends AppCompatActivity implements myExoPlayer.OnFragmentInteractionListener {

    private static final String TAG = "myExoPlayerTag";
    private Switch videoSwitch;
    private myExoPlayer mExoPlayer;
    private PlayerControlView castControlView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);


        castControlView = findViewById(R.id.cast_control_view);


        if (savedInstanceState != null) {
            mExoPlayer = (myExoPlayer) getSupportFragmentManager().findFragmentByTag(TAG);
        } else if (mExoPlayer == null) {
            mExoPlayer = myExoPlayer.newInstance(castControlView);

        }

        if (!mExoPlayer.isInLayout()) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer, mExoPlayer, TAG);
            fragmentTransaction.commit();
        }


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
