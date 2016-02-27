package nuvemapp.com.br.exemplobateriadispositivo;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private BroadcastBateria bb = new BroadcastBateria();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // registerReceiver(bb, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
       // registerReceiver(bb, new IntentFilter(Intent.ACTION_BATTERY_LOW));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //unregisterReceiver(bb);
    }
}
