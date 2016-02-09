package nuvemapp.com.br.exemplobroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by XPredator on 09/02/2016.
 */
public class BroadcastReceiver1 extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Script", "BroadcastReceiver1");
    }
}
