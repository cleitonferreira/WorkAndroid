package nuvemapp.com.br.exemplogcm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

import de.greenrobot.event.EventBus;
import nuvemapp.com.br.exemplogcm.domain.PushMessage;

public class MainActivity extends AppCompatActivity {

    private static final String SERVER_API_KEY = "AIzaSyBu2Kipf5ol-nE0UHx_zFzkr22AZ6KSp4o";
    private static final String SENDER_ID = "1089391497656";

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    private TextView tvTitle;
    private TextView tvMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        botaoPressionado();


        EventBus.getDefault().register(this);

        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvMessage = (TextView) findViewById(R.id.tv_message);

        if (checkPlayServices()) {
            Intent it = new Intent(this, RegistrationIntentService.class);
            startService(it);
        }


    }



    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Log.i("LOG", "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }

    // LISTENER
    public void onEvent(final PushMessage pushMessage) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvTitle.setText( pushMessage.getTitle());
                tvMessage.setText( pushMessage.getMessage());
            }
        });
    }















    private void botaoPressionado() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
