package nuvemapp.com.br.exemploapilocationiv.service;

import android.annotation.TargetApi;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;


import de.greenrobot.event.EventBus;
import me.tatarka.support.job.JobParameters;
import me.tatarka.support.job.JobService;
import nuvemapp.com.br.exemploapilocationiv.TrackingActivity;
import nuvemapp.com.br.exemploapilocationiv.domain.MessageEB;
import nuvemapp.com.br.exemploapilocationiv.domain.User;
import nuvemapp.com.br.exemploapilocationiv.network.HttpConnection;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class JobSchedulerService extends JobService
        implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {


    public static final String TAG = "LOG";
    private GoogleApiClient mGoogleApiClient;
    private JobParameters mJobParameters;
    private MessageEB mMessageEB;
    private LocationRequest mLocationRequest;


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onStartJob(JobParameters params) {
        Log.i(TAG, "JobSchedulerService.onStartJob()");
        mJobParameters = params;
        callConnection();
        return true;
    }


    @Override
    public boolean onStopJob(JobParameters params) {
        Log.i(TAG, "JobSchedulerService.onStopJob()");
        return true;
    }


    private synchronized void callConnection(){
        mGoogleApiClient = new GoogleApiClient.Builder(this)
            .addOnConnectionFailedListener(this)
            .addConnectionCallbacks(this)
            .addApi(LocationServices.API)
            .build();
        mGoogleApiClient.connect();
    }

    private void initLocationRequest(){
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    private void startLocationUpdate(){
        initLocationRequest();
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }

    private void stopLocationUpdate(){
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
    }


    // LISTENERS
        @Override
        public void onConnected(Bundle bundle) {
            Log.i(TAG, "JobSchedulerService.onConnected()");
            Location location = LocationServices
                    .FusedLocationApi
                    .getLastLocation(mGoogleApiClient);

            if(location != null){
                Log.i(TAG, "if(location != null)");
                startLocationUpdate();
            }
            else{
                this.jobFinished(mJobParameters, true);
            }
        }
        @Override
        public void onConnectionSuspended(int i) {}
        @Override
        public void onConnectionFailed(ConnectionResult connectionResult) {}

        @Override
        public void onLocationChanged(Location location) {
            Log.i(TAG, "JobSchedulerService.onLocationChanged()");
            mMessageEB = new MessageEB();
            mMessageEB.setUser(new User( 1 ));
            mMessageEB.setLocation(location);
            mMessageEB.setClassName( TrackingActivity.class.getName() );

            EventBus.getDefault().post( mMessageEB );

            new MyAsyncTask(this).execute(mJobParameters);

            TrackingActivity.saveInSharedPreferences(this, TrackingActivity.LATITUDE_KEY, String.valueOf( location.getLatitude() ));
            TrackingActivity.saveInSharedPreferences(this, TrackingActivity.LONGITUDE_KEY, String.valueOf( location.getLongitude() ));
            TrackingActivity.saveInSharedPreferences(this, TrackingActivity.ALTITUDE_KEY, String.valueOf( location.getAltitude() ));

            stopLocationUpdate();
        }


    // INNER CLASS
        private class MyAsyncTask extends AsyncTask<JobParameters, Void, Void>{
            private JobSchedulerService jss;

            public MyAsyncTask(JobSchedulerService j){
                jss = j;
            }
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            protected Void doInBackground(JobParameters... params) {
                Log.i(TAG, "JobSchedulerService.doInBackground()");
                HttpConnection.getSetDataWeb("http://www.villopim.com.br/android/ExampleApiLocation/package/ctrl/CtrlMap.php",
                        "send-map-coords",
                        mMessageEB);

                jss.jobFinished(params[0], true);

                return(null);
            }
        }
}
