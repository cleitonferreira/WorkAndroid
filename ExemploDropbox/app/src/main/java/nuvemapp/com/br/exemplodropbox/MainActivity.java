package nuvemapp.com.br.exemplodropbox;

import java.util.ArrayList;
import java.util.List;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.AppKeyPair;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
    final static private String APP_KEY = "xxxxxxxxxx";
    final static private String APP_SECRET = "xxxxxxxxx";

    final static private String ACCOUNT_PREFS_NAME = "prefs_dropbox";
    final static private String ACCESS_TOKEN = "ACCESS_TOKEN";

    private ListView listView;
    private Button btLogin;
    private Button btLogout;
    private Button btList;
    private List<Entry> list;

    private DropboxAPI<AndroidAuthSession> dropboxApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<Entry>();

        AndroidAuthSession session = buildSession();
        dropboxApi = new DropboxAPI<AndroidAuthSession>(session);

        listView = (ListView) findViewById(R.id.listView);
        btLogin = (Button) findViewById(R.id.btLogin);
        btLogout = (Button) findViewById(R.id.btLogout);
        btList = (Button) findViewById(R.id.btList);

        enableViews(dropboxApi.getSession().isLinked());
    }

    @Override
    public void onResume(){
        super.onResume();
        AndroidAuthSession session = dropboxApi.getSession();

        if(session.authenticationSuccessful()){
            session.finishAuthentication();

            saveLogged(session);
            enableViews(true);
        }
    }


    // UTIL
    public void enableViews(boolean status){
        if(status){
            btLogin.setVisibility(View.GONE);
            btLogout.setVisibility(View.VISIBLE);
            btList.setVisibility(View.VISIBLE);
        }
        else{
            btList.setVisibility(View.GONE);
            btLogout.setVisibility(View.GONE);
            btLogin.setVisibility(View.VISIBLE);
        }
    }

    public AndroidAuthSession buildSession(){
        AppKeyPair akp = new AppKeyPair(APP_KEY, APP_SECRET);
        AndroidAuthSession session = new AndroidAuthSession(akp);
        loadSession(session);

        return(session);
    }

    public void loadSession(AndroidAuthSession session){
        SharedPreferences sp = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
        String token = sp.getString(ACCESS_TOKEN, null);

        if(token == null || token.length() == 0){
            return;
        }
        else{
            session.setOAuth2AccessToken(token);
        }
    }

    public void saveLogged(AndroidAuthSession session){
        String token = session.getOAuth2AccessToken();
        if(token != null){
            SharedPreferences sp = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString(ACCESS_TOKEN, token);
            edit.commit();
        }
    }

    // VIEWs METHODS
    public void login(View view){
        dropboxApi.getSession().startOAuth2Authentication(MainActivity.this);
    }


    public void logout(View view){
        dropboxApi.getSession().unlink();

        SharedPreferences sp = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
        SharedPreferences.Editor edit = sp.edit();
        edit.clear();
        edit.commit();

        enableViews(false);
    }


    public void loadList(View view){
        new Thread(){
            public void run(){

                try{
                    Entry e = dropboxApi.metadata("/DOWNLOADS", 0, null, true, null);
                    getDocs(e);
                }
                catch(DropboxException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable(){
                    public void run(){
                        listView.setAdapter(new AdapterDropbox(MainActivity.this, list));
                    }
                });
            }
        }.start();
    }

    public void getDocs(Entry entry) throws DropboxException{
        list.add(entry);
        List<Entry> eList = entry.contents;
        if(eList != null){
            for(Entry e : eList){
                //list.add(e);
                e = dropboxApi.metadata(e.path, 0, null, true, null);
                getDocs(e);
            }
        }
    }
}
