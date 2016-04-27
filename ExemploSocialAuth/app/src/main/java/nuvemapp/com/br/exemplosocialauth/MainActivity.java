package nuvemapp.com.br.exemplosocialauth;

import java.util.List;
import java.util.Map;

import org.brickred.socialauth.Profile;
import org.brickred.socialauth.android.DialogListener;
import org.brickred.socialauth.android.SocialAuthAdapter;
import org.brickred.socialauth.android.SocialAuthAdapter.Provider;
import org.brickred.socialauth.android.SocialAuthError;
import org.brickred.socialauth.android.SocialAuthListener;
import org.brickred.socialauth.util.BirthDate;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import nuvemapp.com.br.exemplosocialauth.domain.Constant;
import nuvemapp.com.br.exemplosocialauth.domain.User;

public class MainActivity extends Activity {
    private SocialAuthAdapter socialAuth;
    private TextView tvInfo;
    private Button btLogin;
    private ProgressBar pbLoad;
    private int cont = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        socialAuth = new SocialAuthAdapter(new ResponseListener());

        // VIEWS
        tvInfo = (TextView) findViewById(R.id.tvInfo);
        btLogin = (Button) findViewById(R.id.btLogin);
        pbLoad = (ProgressBar) findViewById(R.id.pbLoad);

        // SHARED PREFERENCES
        SharedPreferences sp = getSharedPreferences(Constant.PREF_STATUS, MODE_PRIVATE);
        boolean status = sp.getBoolean(Constant.PREF_IS_LOGGED, false);

        if(status){
            enableViews(false);
            linkedInLogin(null);
        }
    }


    public void enableViewsMainThread(final boolean status){
        runOnUiThread(new Runnable(){
            public void run(){
                enableViews(status);
            }
        });
    }


    public void enableViews(boolean status){
        tvInfo.setVisibility(status ? View.VISIBLE : View.GONE);
        btLogin.setVisibility(status ? View.VISIBLE : View.GONE);
        pbLoad.setVisibility(status ? View.GONE : View.VISIBLE);
    }


    public void linkedInLogin(View view){
        enableViews(false);
        socialAuth.authorize(MainActivity.this, Provider.LINKEDIN);
    }


    // SOCIAL AUTH CLASS
    public class ResponseListener implements DialogListener{
        @Override
        public void onComplete(Bundle values) {
            socialAuth.getUserProfileAsync(new ProfileDataListener());
        }

        @Override
        public void onBack() {
            enableViewsMainThread(true);
        }

        @Override
        public void onCancel() {
            enableViewsMainThread(true);
        }

        @Override
        public void onError(SocialAuthError error) {
            enableViewsMainThread(true);
            Log.i("Script", error.getMessage());
        }
    }


    public class ProfileDataListener implements SocialAuthListener<Profile> {
        @Override
        public void onExecute(String plataform, Profile data) {
            User user = new User();
            user.setProviderId(data.getProviderId());
            user.setValidatedId(data.getValidatedId());
            user.setFirstName(data.getFirstName());
            user.setLastName(data.getLastName());
            user.setEmail(data.getEmail());
            user.setCountry(data.getCountry());
            user.setLanguage(data.getLanguage());
            user.setLocation(data.getLocation());
            user.setProfileImageURL(data.getProfileImageURL());
            user.setGender(data.getGender());
            user.setDisplayName(data.getDisplayName());
            user.setFullName(data.getFullName());
            user.setContactInfo(data.getContactInfo());
            user.setBirthDate(data.getDob());

            // START ACTIVITY
            if(cont == 0){
                cont++;
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        }

        @Override
        public void onError(SocialAuthError error) {
            enableViews(true);
            Log.i("Script", error.getMessage());
        }
    }
}
