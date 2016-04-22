package nuvemapp.com.br.exemplologinfacebook;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button btLogin;
    private Button btLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLogin = (Button) findViewById(R.id.login);
        btLogout = (Button) findViewById(R.id.logout);

        //loginFacebook(null);


    }

    public void loginFacebook(View view) {
        Session.openActiveSession(this, true, new Session.StatusCallback() {

            // callback when session changes state
            @Override
            public void call(Session session, SessionState state, Exception exception) {
                if (session.isOpened()) {

                    // make request to the /me API
                    Request.newMeRequest(session, new Request.GraphUserCallback() {

                        // callback after Graph API response with user object
                        @Override
                        public void onCompleted(GraphUser user, Response response) {
                            if (user != null) {
                                Log.i("Script", "Name: "+user.getName());

                                btLogin.setVisibility(View.GONE);
                                btLogout.setVisibility(View.VISIBLE);
                            }
                        }
                    }).executeAsync();
                }
            }
        });
    }

    public void logoutFacebook(View view) {
        if(Session.getActiveSession() != null){
            Session.getActiveSession().closeAndClearTokenInformation();
            Session.setActiveSession(null);

            btLogin.setVisibility(View.VISIBLE);
            btLogout.setVisibility(View.GONE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
    }

}
