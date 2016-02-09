package nuvemapp.com.br.exemplobroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by XPredator on 09/02/2016.
 */
public class BroadcastReceiver3 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Script", "BroadcastReceiver3");
        Intent it = new Intent(context, Atividade1.class);
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(it);
    }
}
