package com.example.josterman.draggablevideo;

import android.content.Context;

import com.google.android.gms.cast.CastMediaControlIntent;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.OptionsProvider;
import com.google.android.gms.cast.framework.SessionProvider;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.MediaIntentReceiver;
import com.google.android.gms.cast.framework.media.NotificationOptions;

import java.security.cert.PKIXRevocationChecker;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


public class CastOptionsProvider implements OptionsProvider {
    
    //TODO: Comment switch only for this sender demo, remove in reference app
    
    
//    @Override
//    public CastOptions getCastOptions(Context context) {
//        CastOptions castOptions = new CastOptions.Builder()
//                .setReceiverApplicationId(CastMediaControlIntent.DEFAULT_MEDIA_RECEIVER_APPLICATION_ID)
//                .build();
//        return castOptions;
//    }
    
    @Override
    public CastOptions getCastOptions(Context context) {
        NotificationOptions notificationOptions = new NotificationOptions.Builder()
                .setActions(Arrays.asList(
                        MediaIntentReceiver.ACTION_REWIND,
                        MediaIntentReceiver.ACTION_FORWARD,
                        MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK,
                        MediaIntentReceiver.ACTION_STOP_CASTING), new int[]{1, 2})
                .build();
        CastMediaOptions mediaOptions = new CastMediaOptions.Builder()
                .setNotificationOptions(notificationOptions)
                .build();
        /*
         return new CastOptions.Builder()
                .setReceiverApplicationId(CastMediaControlIntent.DEFAULT_MEDIA_RECEIVER_APPLICATION_ID)
                .setEnableReconnectionService(true)
                .setResumeSavedSession(true)
                .setStopReceiverApplicationWhenEndingSession(false)
                .setCastMediaOptions(mediaOptions)
                .build();
        /*/
        return new CastOptions.Builder()
                .setReceiverApplicationId(CastMediaControlIntent.DEFAULT_MEDIA_RECEIVER_APPLICATION_ID)
                .setEnableReconnectionService(true)
                .setStopReceiverApplicationWhenEndingSession(false)
                .setCastMediaOptions(mediaOptions)
                .build();
        //*/
    }
    
    @Override
    public List<SessionProvider> getAdditionalSessionProviders(Context context) {
        return null;
    }
}
