package nuvemapp.com.br.exemploopenstreetmap;

import org.osmdroid.bonuspack.overlays.Marker;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

public class MainActivity extends Activity implements LocationListener {
    private MapView osm;
    private MapController mc;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        osm = (MapView) findViewById(R.id.mapView);
        osm.setTileSource(TileSourceFactory.MAPNIK);
        osm.setBuiltInZoomControls(true);
        osm.setMultiTouchControls(true);


        mc = (MapController) osm.getController();
        mc.setZoom(12);

        GeoPoint center = new GeoPoint(-20.1698,-40.2487);
        mc.animateTo(center);
        addMarker(center);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
        }
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }



    public void addMarker(GeoPoint center){
        Marker marker = new Marker(osm);
        marker.setPosition(center);
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker.setIcon(getResources().getDrawable(R.drawable.pin));

        osm.getOverlays().clear();
        osm.getOverlays().add(marker);
        osm.invalidate();
    }



    @Override
    public void onLocationChanged(Location location) {
        GeoPoint center = new GeoPoint(location.getLatitude(), location.getLongitude());

        mc.animateTo(center);
        addMarker(center);
    }
    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        if(locationManager != null){

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
            }
            locationManager.removeUpdates(this);


        }
    }
}
