package nuvemapp.com.br.exemploapilocationv;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import me.tatarka.support.job.JobInfo;
import me.tatarka.support.job.JobScheduler;
import nuvemapp.com.br.exemploapilocationv.domain.MessageEB;
import nuvemapp.com.br.exemploapilocationv.network.HttpConnection;
import nuvemapp.com.br.exemploapilocationv.service.JobSchedulerService;
import nuvemapp.com.br.exemploapilocationv.service.Place;


public class TrackingActivity extends AppCompatActivity {
    public static final String PREF_KEY = "pref_key";
    public static final String LATITUDE_KEY = "latitude_key";
    public static final String LONGITUDE_KEY = "longitude_key";
    public static final String ALTITUDE_KEY = "altitude_key";

    private SupportMapFragment mapFrag;
    private GoogleMap map;
    private Marker marker;

    protected TextView tvFeedbackPlaces;
    protected EditText etDistance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);
        Log.i("LOG", "TrackingActivity.onCreate()");

        EventBus.getDefault().register(this);

        tvFeedbackPlaces = (TextView) findViewById(R.id.tv_feedback_places);
        etDistance = (EditText) findViewById(R.id.et_distance);
        MyAsyncTaskPlaces.setWeakReference( this );

        mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.frag_maps);
        configMap();
    }


    public void configMap() {
        map = mapFrag.getMap();
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        double latitude = Double.parseDouble(TrackingActivity.getInSharedPreferences(this, LATITUDE_KEY, "-20.200404"));
        double longitude = Double.parseDouble(TrackingActivity.getInSharedPreferences(this, LONGITUDE_KEY, "-40.228925"));
        LatLng latLng = new LatLng(latitude, longitude);


        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(13).tilt(90).build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);
        map.moveCamera(update);

        customAddMarker(latLng, "Marcador 1", "O Marcador 1 foi reposicionado");
    }


    public void customAddMarker(LatLng latLng, String title, String snippet) {
        MarkerOptions options = new MarkerOptions();
        options.position(latLng).title(title).snippet(snippet).draggable(false);
        options.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin));

        marker = map.addMarker(options);
    }


    private void updatePosition(LatLng latLng) {
        map.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        marker.setPosition(latLng);
    }


    // METHODS AUX PLACES
    public void clearMap(){
        double latitude = Double.parseDouble(TrackingActivity.getInSharedPreferences(this, LATITUDE_KEY, "-20.200404"));
        double longitude = Double.parseDouble(TrackingActivity.getInSharedPreferences(this, LONGITUDE_KEY, "-40.228925"));
        LatLng latLng = new LatLng(latitude, longitude);

        map.clear();
        customAddMarker(latLng, "Marcador 1", "O Marcador 1 foi reposicionado");
    }

    private void addMarkerPlace(LatLng latLng, String title, String snippet, int category) {
        MarkerOptions options = new MarkerOptions();
        options.position(latLng).title(title).snippet(snippet).draggable(false);
        options.icon(BitmapDescriptorFactory.fromResource( Place.getCategorySource(category) ));

        map.addMarker(options);
    }


    public void addClosestPlaces(List<Place> list){
        for(Place p : list){
            addMarkerPlace(new LatLng(p.getLatitude(), p.getLongitude()),
                    p.getName(),
                    p.getDescription(),
                    p.getCategory());
        }
    }


    // LISTENERS
    public void startTracking(View view) {
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

    public void stopTracking(View view) {
        JobScheduler js = JobScheduler.getInstance(this);
        js.cancelAll();
    }

    public void onEvent(MessageEB m) {
        if (m.getClassName().equalsIgnoreCase(TrackingActivity.class.getName())) {
            LatLng latLng = new LatLng(m.getLocation().getLatitude(), m.getLocation().getLongitude());
            updatePosition(latLng);
        }
    }

    public void getClosestPlaces(View view) {
        try{
            Double.parseDouble( etDistance.getText().toString() );
            new MyAsyncTaskPlaces(this).execute();
        }
        catch(IllegalArgumentException e){
            Toast.makeText(this, "Entre com a distância máxima", Toast.LENGTH_SHORT).show();
        }
    }


    // SHARED PREFERENCES
    public static void saveInSharedPreferences(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getInSharedPreferences(Context context, String key, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        String auxValue = sharedPreferences.getString(key, defaultValue);
        return (auxValue);
    }


    // INNER CLASS
    private static class MyAsyncTaskPlaces extends AsyncTask<Void, Void, List<Place>> {
        private static WeakReference<TrackingActivity> weakReference;

        public MyAsyncTaskPlaces(TrackingActivity ta) {
            weakReference = new WeakReference<>(ta);
        }

        public static void setWeakReference(TrackingActivity ta){
            weakReference = new WeakReference<>(ta);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (weakReference.get() != null) {
                weakReference.get().tvFeedbackPlaces.setVisibility(View.VISIBLE);
                weakReference.get().tvFeedbackPlaces.setText("Buscando places...");
            }
        }

        @Override
        protected List<Place> doInBackground(Void... params) {
            List<Place> list = new ArrayList<>();
            SystemClock.sleep(3000);

            if (weakReference.get() != null) {
                double distance = Double.parseDouble( weakReference.get().etDistance.getText().toString() );
                double latitude = Double.parseDouble( getInSharedPreferences(weakReference.get(), weakReference.get().LATITUDE_KEY, "-20.200404") );
                double longitude = Double.parseDouble( getInSharedPreferences(weakReference.get(), weakReference.get().LONGITUDE_KEY, "-40.228925") );
                LatLng latLng = new LatLng(latitude, longitude);

                String answer = HttpConnection.getSetDataWeb("http://www.villopim.com.br/android/ExampleApiLocation/package/ctrl/CtrlMap.php",
                        "get-places-closest",
                        latLng,
                        distance);

                Log.i("LOG", " ANSWER: "+answer);
                try {
                    JSONObject json = new JSONObject(answer);

                    if (!json.isNull("places")) {
                        JSONArray ja = json.getJSONArray("places");

                        for (int i = 0, tamI = ja.length(); i < tamI; i++) {
                            JSONObject jo = null;

                            jo = ja.getJSONObject(i);

                            Place p = new Place();
                            p.setName(jo.getString("name"));
                            p.setDescription(jo.getString("description"));
                            p.setCategory(jo.getJSONObject("category").getInt("item"));
                            p.setLatitude(jo.getDouble("latitude"));
                            p.setLongitude(jo.getDouble("longitude"));

                            list.add( p );
                        }
                    }
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            return (list);
        }

        @Override
        protected void onPostExecute(List<Place> list) {
            super.onPostExecute(list);
            if (weakReference.get() != null) {
                weakReference.get().tvFeedbackPlaces.setVisibility(View.GONE);
                weakReference.get().clearMap();
                weakReference.get().addClosestPlaces( list );
            }
        }
    }
}
