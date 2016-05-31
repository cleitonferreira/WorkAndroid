package nuvemapp.com.br.exemploapilocationiii;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import de.greenrobot.event.EventBus;
import nuvemapp.com.br.exemploapilocationiii.domain.MessageEB;
import nuvemapp.com.br.exemploapilocationiii.service.LocationIntentService;

public class AddressLocationActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener{

    public static final String LOCATION = "location";
    public static final String TYPE = "type";
    public static final String ADDRESS = "address";

    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;

    private EditText etAddress;
    private TextView tvAddressLocation;
    private Button btNameToCoord;
    private Button btCoordToName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_location);

        EventBus.getDefault().register(this);

        etAddress = (EditText) findViewById(R.id.et_address);
        tvAddressLocation = (TextView) findViewById(R.id.tv_address_location);
        btNameToCoord = (Button) findViewById(R.id.bt_name_to_coord);
        btCoordToName = (Button) findViewById(R.id.bt_coord_to_name);

        callConnection();
    }


    private synchronized void callConnection(){
        Log.i("LOG", "AddressLocationActivity.callConnection()");
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addOnConnectionFailedListener(this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }


    public void callIntentService(int type, String address){
        Intent it = new Intent(this, LocationIntentService.class);
        it.putExtra(TYPE, type);
        it.putExtra(ADDRESS, address);
        it.putExtra(LOCATION, mLastLocation);
        startService(it);
    }


    // LISTERNERS
    @Override
    public void onConnected(Bundle bundle) {
        Log.i("LOG", "AddressLocationActivity.onConnected(" + bundle + ")");

        Location l = LocationServices
                .FusedLocationApi
                .getLastLocation(mGoogleApiClient);

        if(l != null){
            mLastLocation = l;
            btNameToCoord.setEnabled(true);
            btCoordToName.setEnabled(true);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i("LOG", "AddressLocationActivity.onConnectionSuspended(" + i + ")");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i("LOG", "AddressLocationActivity.onConnectionFailed(" + connectionResult + ")");
    }

    public void getLocationListener(View view){
        int type;
        String address = null;

        if(view.getId() == R.id.bt_name_to_coord){
            type = 1;
            address = etAddress.getText().toString();
        }
        else{
            type = 2;
        }

        callIntentService(type, address);
    }

    public void onEvent(final MessageEB m){
        runOnUiThread(new Runnable(){
            @Override
            public void run() {
                Log.i("LOG", m.getResultMessage());
                tvAddressLocation.setText("Data: "+m.getResultMessage());
            }
        });
    }
}
