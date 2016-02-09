package nuvemapp.com.br.exemplobroadcastreceiveraux;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by XPredator on 09/02/2016.
 */
public class BroadcastReceiver4 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Script", "BroadcastReceiver4");
    }
}
