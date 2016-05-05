package nuvemapp.com.br.exemplogooglecloudmessaging.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;

import nuvemapp.com.br.exemplogooglecloudmessaging.MainActivity;
import nuvemapp.com.br.exemplogooglecloudmessaging.R;

public class NotificationCustomUtil {
	private static NotificationManager mNotificationManager;
	
	public static void sendNotification(Context context, String title, String author, String message) {
        mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
	        .setSmallIcon(R.mipmap.ic_launcher)
	        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
	        .setContentTitle(title)
			.setContentText(author+": "+message);
        
        mBuilder.setContentIntent(contentIntent);
        
        Notification notification = mBuilder.build();
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		mNotificationManager.notify(AndroidSystemUtil.randInt(), notification);
    }
}
