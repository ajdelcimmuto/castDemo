package com.example.koalatv;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.josterman.draggablevideo.R;
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
