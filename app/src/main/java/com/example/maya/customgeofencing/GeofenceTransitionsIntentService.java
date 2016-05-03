package com.example.maya.customgeofencing;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

import java.util.List;

/**
 * Created by maya on 4/27/2016.
 */

public class GeofenceTransitionsIntentService extends IntentService {
    protected static final String TAG = "geofence-transitions";
    //JUST a constructor
    public GeofenceTransitionsIntentService() {
        super(TAG);
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
    }
    //Main thing
    @Override
    protected void onHandleIntent(Intent intent)
    {
        //GET THE GEOFENCE FROM INTENT
        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        if (geofencingEvent.hasError())
        {
            String errorMessage = Integer.toString(geofencingEvent.getErrorCode());
            Log.e(TAG, errorMessage);
            return;

        }
        //GET THE TRANSITION OF THE GEOFENCE ENTER OR EXIT
        int geofencetransition= geofencingEvent.getGeofenceTransition();
        if(geofencetransition== Geofence.GEOFENCE_TRANSITION_ENTER || geofencetransition==Geofence.GEOFENCE_TRANSITION_EXIT)
        {
            //THE LIST OF GEOFENCES THAT TRIGGERED EITHER ENTER OR EXIT
            List<Geofence> triggeringGeofences=geofencingEvent.getTriggeringGeofences();
                for(Geofence i : triggeringGeofences)
                {
                    Log.e(TAG,i.getRequestId());
                }
        }

    }

}
