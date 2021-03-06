package nuvemapp.com.br.exemplomaterialappwidget.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.google.android.gms.appinvite.AppInviteReferral;


public class InviteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent deepLinkIntent = AppInviteReferral.addPlayStoreReferrerToIntent(intent, new Intent("deepLink"));
        LocalBroadcastManager.getInstance(context).sendBroadcast(deepLinkIntent);
    }
}
