package nuvemapp.com.br.exemplogcm;

import android.os.Bundle;

import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;


import de.greenrobot.event.EventBus;
import nuvemapp.com.br.exemplogcm.domain.PushMessage;


/**
 * Classe para receber a mensagem
 */

public class MyGcmListenerService extends GcmListenerService  {
    public static final String TAG = "LOG";


    @Override
    public void onMessageReceived(String from, Bundle data) {
        //super.onMessageReceived(from, data);
        String title = data.getString("title");
        String message = data.getString("message");

        EventBus.getDefault().post(new PushMessage( title, message));

        }



}
