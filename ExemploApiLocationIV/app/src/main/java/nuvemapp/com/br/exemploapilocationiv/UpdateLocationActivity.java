package nuvemapp.com.br.exemploapilocationiv;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.text.DateFormat;
import java.util.Date;

public class UpdateLocationActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {


    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private TextView tvUpdateLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_location);
        Log.i("LOG", "UpdateLocationActivity.onCreate()");

        tvUpdateLocation = (TextView) findViewById(R.id.tv_update_location);

        callConnection();
    }


    @Override
    public void onResume(){
        super.onResume();

        if(mGoogleApiClient !=null && mGoogleApiClient.isConnected()){
            startLocationUpdate();
        }
    }


    @Override
    public void onPause(){
        super.onPause();

        if(mGoogleApiClient != null){
            stopLocationUpdate();
        }
    }


    private synchronized void callConnection(){
        Log.i("LOG", "UpdateLocationActivity.callConnection()");
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addOnConnectionFailedListener(this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }


    private void initLocationRequest(){
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(5000);
        mLocationRequest.setFastestInterval(2000);
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
        Log.i("LOG", "UpdateLocationActivity.onConnected(" + bundle + ")");

        Location l = LocationServices
                .FusedLocationApi
                .getLastLocation(mGoogleApiClient); // PARA JÁ TER UMA COORDENADA PARA O UPDATE FEATURE UTILIZAR

        startLocationUpdate();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i("LOG", "UpdateLocationActivity.onConnectionSuspended(" + i + ")");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i("LOG", "UpdateLocationActivity.onConnectionFailed(" + connectionResult + ")");
    }

    @Override
    public void onLocationChanged(Location location) {
        tvUpdateLocation.setText(Html.fromHtml("Location: " + location.getLatitude() + "<br />" +
                "Longitude: " + location.getLongitude() + "<br />" +
                "Bearing: " + location.getBearing() + "<br />" +
                "Altitude: " + location.getAltitude() + "<br />" +
                "Speed: " + location.getSpeed() + "<br />" +
                "Provider: " + location.getProvider() + "<br />" +
                "Accuracy: " + location.getAccuracy() + "<br />" +
                "Speed: " + DateFormat.getTimeInstance().format(new Date()) + "<br />"));
    }
}
