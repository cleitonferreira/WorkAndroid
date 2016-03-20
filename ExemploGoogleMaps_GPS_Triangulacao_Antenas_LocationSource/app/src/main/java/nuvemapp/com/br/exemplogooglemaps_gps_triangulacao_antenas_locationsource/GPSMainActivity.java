package nuvemapp.com.br.exemplogooglemaps_gps_triangulacao_antenas_locationsource;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;


public class GPSMainActivity extends FragmentActivity implements LocationListener {
    private SupportMapFragment mapFrag;
    private GoogleMap map;
    private LocationManager locationManager;
    private boolean allowNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpsmain);

        GoogleMapOptions options = new GoogleMapOptions();
        options.zOrderOnTop(true);
        mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1);
        map = mapFrag.getMap();
        configMap();
    }


    @Override
    public void onResume() {
        super.onResume();

        allowNetwork = true;
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Intent it = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(it);
        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.MAPS_RECEIVE)
                    == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

            }
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.MAPS_RECEIVE)
                == PackageManager.PERMISSION_GRANTED) {
            locationManager.removeUpdates(this);
        }

    }

    public void configMap() {
        map = mapFrag.getMap();
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        LatLng latLng = new LatLng(-20.230521, -40.314816);

        configLocation(latLng);
    }


	public void configLocation(LatLng latLng) {
        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(8).bearing(0).tilt(90).build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.MAPS_RECEIVE)
                == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);
            map.animateCamera(update);

            MyLocation myLocation = new MyLocation();
            map.setLocationSource(myLocation);
            myLocation.setLocation(latLng);
        }


    }

    @Override
    public void onLocationChanged(Location location) {
        if(location.getProvider().equals(LocationManager.GPS_PROVIDER)){
            allowNetwork = false;
        }

        if(allowNetwork || location.getProvider().equals(LocationManager.GPS_PROVIDER)){
            configLocation(new LatLng(location.getLatitude(), location.getLongitude()));
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
