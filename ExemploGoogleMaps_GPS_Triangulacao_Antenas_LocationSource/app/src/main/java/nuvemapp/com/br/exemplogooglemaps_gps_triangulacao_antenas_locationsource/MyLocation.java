package nuvemapp.com.br.exemplogooglemaps_gps_triangulacao_antenas_locationsource;

import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by XPredator on 20/03/2016.
 */
public class MyLocation implements LocationSource {

    private OnLocationChangedListener listener;

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        this.listener = onLocationChangedListener;
        Log.i("Script", "activate()");
    }

    @Override
    public void deactivate() {
        Log.i("Script", "deactivate()");
    }

    public void setLocation(LatLng latLng) {

        Location location = new Location(LocationManager.GPS_PROVIDER);
        location.setLatitude(latLng.latitude);
        location.setLongitude(latLng.longitude);

        if (listener != null) {
            listener.onLocationChanged(location);
        }
    }
}
