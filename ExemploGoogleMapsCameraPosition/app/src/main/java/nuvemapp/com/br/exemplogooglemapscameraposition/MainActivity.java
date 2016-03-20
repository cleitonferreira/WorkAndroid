package nuvemapp.com.br.exemplogooglemapscameraposition;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends FragmentActivity {

    private SupportMapFragment mapFragment;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //resolve o problema de ter o navigator drawer debaixo do google maps
        GoogleMapOptions options = new GoogleMapOptions();
        options.zOrderOnTop(true);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1);
        map = mapFragment.getMap();

        /*mapFragment = SupportMapFragment.newInstance(options);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.llContainer, mapFragment);
        ft.commit();*/

        configMap();

    }

    @Override
    public void onResume() {
        super.onResume();

       /* new Thread() {
            public void run() {
                while (mapFragment.getMap() == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        configMap();
                    }
                });
            }
        }.start();*/
    }

    public void configMap() {
        map = mapFragment.getMap();
        //map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        LatLng latLng = new LatLng(-23.564224, -46.653156);

        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(18).bearing(0).tilt(90).build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);

        //map.moveCamera(update);
        map.animateCamera(update, 3000, new GoogleMap.CancelableCallback() {
            @Override
            public void onFinish() {
                Log.i("Script", "CancelableCallback.onFinish()");
            }

            @Override
            public void onCancel() {
                Log.i("Script", "CancelableCallback.onCancel()");
            }
        });
    }
}
