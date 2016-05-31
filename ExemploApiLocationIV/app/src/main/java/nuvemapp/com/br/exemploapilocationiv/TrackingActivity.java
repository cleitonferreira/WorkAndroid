package nuvemapp.com.br.exemploapilocationiv;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import de.greenrobot.event.EventBus;
import me.tatarka.support.job.JobInfo;
import me.tatarka.support.job.JobScheduler;
import nuvemapp.com.br.exemploapilocationiv.domain.MessageEB;
import nuvemapp.com.br.exemploapilocationiv.service.JobSchedulerService;


public class TrackingActivity extends AppCompatActivity {
    public static final String PREF_KEY = "pref_key";
    public static final String LATITUDE_KEY = "latitude_key";
    public static final String LONGITUDE_KEY = "longitude_key";
    public static final String ALTITUDE_KEY = "altitude_key";

    private SupportMapFragment mapFrag;
    private GoogleMap map;
    private Marker marker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);
        Log.i("LOG", "TrackingActivity.onCreate()");

        EventBus.getDefault().register(this);

        mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.frag_maps);
        configMap();
    }


    public void configMap(){
        map = mapFrag.getMap();
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        double latitude = Double.parseDouble( TrackingActivity.getInSharedPreferences(this, LATITUDE_KEY, "-20.312441") );
        double longitude = Double.parseDouble( TrackingActivity.getInSharedPreferences(this, LONGITUDE_KEY, "-40.287819") );
        LatLng latLng = new LatLng(latitude, longitude);


        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(13).tilt(90).build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);
        map.moveCamera(update);

        customAddMarker(latLng, "Marcador 1", "O Marcador 1 foi reposicionado");
    }


    public void customAddMarker(LatLng latLng, String title, String snippet){
        MarkerOptions options = new MarkerOptions();
        options.position(latLng).title(title).snippet(snippet).draggable(false);
        options.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin));

        marker = map.addMarker(options);
    }


    private void updatePosition(LatLng latLng){
        map.animateCamera(CameraUpdateFactory.newLatLng( latLng ));
        marker.setPosition( latLng );
    }


    // LISTENERS
    public void startTracking(View view){
        ComponentName cp = new ComponentName(this, JobSchedulerService.class);

        JobInfo jb = new JobInfo.Builder(1, cp)
                .setBackoffCriteria(4000, JobInfo.BACKOFF_POLICY_LINEAR)
                .setPersisted(true)
                .setPeriodic(2000)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setRequiresCharging(false)
                .setRequiresDeviceIdle(false)
                .build();

        JobScheduler js = JobScheduler.getInstance(this);
        js.schedule(jb);
    }

    public void stopTracking(View view){
        JobScheduler js = JobScheduler.getInstance(this);
        js.cancelAll();
    }

    public void onEvent(MessageEB m){
        if( m.getClassName().equalsIgnoreCase( TrackingActivity.class.getName() ) ) {
            LatLng latLng = new LatLng(m.getLocation().getLatitude(), m.getLocation().getLongitude());
            updatePosition( latLng );
        }
    }



    // SHARED PREFERENCES
    public static void saveInSharedPreferences(Context context, String key, String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
    public static String getInSharedPreferences(Context context, String key, String defaultValue){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        String auxValue = sharedPreferences.getString(key, defaultValue);
        return(auxValue);
    }
}
