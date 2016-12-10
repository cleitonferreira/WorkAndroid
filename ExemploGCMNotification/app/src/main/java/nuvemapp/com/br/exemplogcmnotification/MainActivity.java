package nuvemapp.com.br.exemplogcmnotification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

import de.greenrobot.event.EventBus;
import nuvemapp.com.br.exemplogcmnotification.domain.PushMessage;

public class MainActivity extends AppCompatActivity {

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    private TextView tvTitle;
    private TextView tvMessage;
    private Button btCallSActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvMessage = (TextView) findViewById(R.id.tv_message);

        btCallSActivity = (Button) findViewById(R.id.bt_call_s_activity);
        btCallSActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(it);
            }
        });

        if( checkPlayServices() ){
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
    public void onEvent( final PushMessage pushMessage ){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvTitle.setText( pushMessage.getTitle() );
                tvMessage.setText( pushMessage.getMessage() );
            }
        });
    }
}
