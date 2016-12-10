package nuvemapp.com.br.exemplogcmnotification.extra;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Pref {
    public static final String PREF_KEY_NICKNAME = "nuvemapp.com.br.exemplogcmnotification.extra.Pref.PREF_KEY_NICKNAME";
    public static final String PREF_KEY_ID = "nuvemapp.com.br.exemplogcmnotification.extra.Pref.PREF_KEY_ID";

    public static final String PREF_KEY_NOTIFICATION_STATUS = "nuvemapp.com.br.exemplogcmnotification.extra.Pref.PREF_NOTIFICATION_STATUS_KEY_ID";
    public static final String PREF_KEY_NOTIFICATION_STATUS_OLD = "nuvemapp.com.br.exemplogcmnotification.extra.Pref.PREF_KEY_NOTIFICATION_STATUS_OLD";


    public static void savePrefKeyValue( Context context, String key, String value ){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor e = sp.edit();
        e.putString( key, value );
        e.apply();
    }
    public static String retrievePrefKeyValue( Context context, String key, String... defaultValue ){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences( context );
        String dValue = defaultValue != null && defaultValue.length > 0 ? defaultValue[0] : "";
        sp.getString(key, dValue );
        return( sp.getString( key, dValue ) );
    }
}
