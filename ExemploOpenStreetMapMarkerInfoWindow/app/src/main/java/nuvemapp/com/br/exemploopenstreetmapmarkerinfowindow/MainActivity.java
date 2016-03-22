package nuvemapp.com.br.exemploopenstreetmapmarkerinfowindow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.osmdroid.bonuspack.location.GeocoderNominatim;
import org.osmdroid.bonuspack.overlays.Marker;
import org.osmdroid.bonuspack.overlays.MarkerInfoWindow;
import org.osmdroid.bonuspack.overlays.Polyline;
import org.osmdroid.bonuspack.routing.OSRMRoadManager;
import org.osmdroid.bonuspack.routing.Road;
import org.osmdroid.bonuspack.routing.RoadManager;
import org.osmdroid.events.MapListener;
import org.osmdroid.events.ScrollEvent;
import org.osmdroid.events.ZoomEvent;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapView.Projection;
import org.osmdroid.views.overlay.Overlay;
import org.osmdroid.views.overlay.PathOverlay;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.location.Address;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements LocationListener {
    private MapView osm;
    private MapController mc;
    private LocationManager locationManager;
    private PathOverlay po;

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

        initPathOverlay();
        addMarker(center);


        osm.setMapListener(new MapListener(){

            @Override
            public boolean onScroll(ScrollEvent arg0) {
                Log.i("Script", "onScroll()");
                return false;
            }

            @Override
            public boolean onZoom(ZoomEvent arg0) {
                Log.i("Script", "onZoom()");
                return false;
            }

        });


        //locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }


    // PATH OVERLAY
    public void initPathOverlay(){
        po = new PathOverlay(0, this);
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setStyle(Style.STROKE);
        p.setStrokeWidth(5);
        po.setPaint(p);
    }


    public PathOverlay addPointsLine(GeoPoint gp){
        po.addPoint(gp);
        return(po);
    }


    public void addMarker(GeoPoint center){
        Marker marker = new Marker(osm);
        marker.setPosition(center);
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
        marker.setDraggable(true);

        marker.setTitle("Marker");
        marker.setSnippet("Snippet marker");
        marker.setSubDescription("SubDescription marker");

        marker.setInfoWindow(new CustomMarkerInfoWindow(osm));
        marker.setInfoWindowAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_TOP);

        marker.setOnMarkerClickListener(new Marker.OnMarkerClickListener(){

            @Override
            public boolean onMarkerClick(Marker m, MapView arg1) {
                Log.i("Script", "onMarkerClick()");
                m.showInfoWindow();
                return true;
            }

        });

        marker.setOnMarkerDragListener(new Marker.OnMarkerDragListener() {

            @Override
            public void onMarkerDragStart(Marker arg0) {
                Log.i("Script", "onMarkerDragStart()");
            }

            @Override
            public void onMarkerDragEnd(Marker arg0) {
                Log.i("Script", "onMarkerDragEnd()");
            }

            @Override
            public void onMarkerDrag(Marker arg0) {
                Log.i("Script", "onMarkerDrag()");
            }
        });


        osm.getOverlays().clear();
        osm.getOverlays().add(addPointsLine(center));
        osm.getOverlays().add(new MapOverlay(this));
        osm.getOverlays().add(marker);
        osm.invalidate();
    }


    // INFO WINDOW
    public class CustomMarkerInfoWindow extends MarkerInfoWindow{

        public CustomMarkerInfoWindow(MapView mapView) {
            //super(R.layout.bonuspack_bubble, mapView);
            super(R.layout.my_bubble, mapView);
        }


        @Override
        public void onOpen(Object item){
            Marker m = (Marker) item;

            ImageView iv = (ImageView) mView.findViewById(R.id.bubble_image);
            iv.setImageResource(R.drawable.pin);

            TextView title = (TextView) mView.findViewById(R.id.bubble_title);
            title.setText(m.getTitle());

            TextView snippet = (TextView) mView.findViewById(R.id.bubble_description);
            snippet.setText(m.getSnippet());

				/*Button bt = (Button) mView.findViewById(R.id.bubble_moreinfo);
				bt.setVisibility(View.VISIBLE);
				bt.setOnClickListener(new Button.OnClickListener(){

					@Override
					public void onClick(View v) {
						Toast.makeText(MainActivity.this, "Button working", Toast.LENGTH_SHORT).show();
					}

				});*/
        }
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
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
        }
        if(locationManager != null){
            locationManager.removeUpdates(this);
        }
    }



    class MapOverlay extends Overlay{

        public MapOverlay(Context ctx) {
            super(ctx);
        }

        @Override
        protected void draw(Canvas arg0, MapView arg1, boolean arg2) {}


        @Override
        public boolean onSingleTapConfirmed(MotionEvent me, MapView mv){
            Projection p = osm.getProjection();
            GeoPoint gp = (GeoPoint) p.fromPixels((int) me.getX(), (int) me.getY());
            //addMarker(gp);
            return(false);
        }

    }






    // ROUTE
    public void getRoute(View view){
        EditText etOrigin = (EditText) findViewById(R.id.origin);
        EditText etDestination = (EditText) findViewById(R.id.destination);
        final String o = etOrigin.getText().toString();
        final String d = etDestination.getText().toString();

        new Thread(){
            public void run(){
                GeoPoint start = getLocation(o);
                GeoPoint end = getLocation(d);

                if(start != null && end != null){
                    drawRoute(start, end);
                }
                else{
                    Toast.makeText(MainActivity.this, "FAIL!", Toast.LENGTH_SHORT);
                }
            }
        }.start();
    }


    public GeoPoint getLocation(String location){
        GeocoderNominatim gn = new GeocoderNominatim(MainActivity.this);
        GeoPoint gp = null;
        List<Address> al = new ArrayList<Address>();

        try{
            al = gn.getFromLocationName(location, 1);

            if(al != null && al.size() > 0){
                Log.i("Script", "Rua: "+al.get(0).getThoroughfare());
                Log.i("Script", "Cidade: "+al.get(0).getSubAdminArea());
                Log.i("Script", "Estado: "+al.get(0).getAdminArea());
                Log.i("Script", "País: "+al.get(0).getCountryName());

                gp = new GeoPoint(al.get(0).getLatitude(), al.get(0).getLongitude());
            }
        }
        catch(IOException e){ e.printStackTrace(); }

        return(gp);
    }

    public void drawRoute(GeoPoint start, GeoPoint end){
        RoadManager roadManager = new OSRMRoadManager();
        ArrayList<GeoPoint> points = new ArrayList<GeoPoint>();
        points.add(start);
        points.add(end);
        Road road = roadManager.getRoad(points);
        final Polyline roadOverlay = RoadManager.buildRoadOverlay(road, MainActivity.this);

        runOnUiThread(new Runnable(){
            public void run(){
                osm.getOverlays().add(roadOverlay);
            }
        });
    }
}
