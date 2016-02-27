package nuvemapp.com.br.exemplobateriadispositivo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by XPredator on 27/02/2016.
 */
public class BroadcastBateria extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra("level", 0);
        Log.i("Script", "Bateria: "+level+"%");
    }
}
