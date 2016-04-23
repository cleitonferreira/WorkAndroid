package nuvemapp.com.br.exemplologinfacebookcompartilhamentosharedialog;

import java.util.Arrays;
import java.util.List;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;
import com.facebook.widget.ProfilePictureView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private Button shareButton;

    private UiLifecycleHelper uiHelper;
    private Session.StatusCallback callback = new Session.StatusCallback() {
        @Override
        public void call(Session session, SessionState state, Exception exception) {
            onSessionStateChanged(session, state, exception);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiHelper = new UiLifecycleHelper(this, callback);
        uiHelper.onCreate(savedInstanceState);

        LoginButton lb = (LoginButton) findViewById(R.id.fbLogin);
        lb.setPublishPermissions(Arrays.asList("email", "public_profile", "user_friends"));


        shareButton = (Button) findViewById(R.id.shareButton);

        if(savedInstanceState != null){
            reauth = savedInstanceState.getBoolean(KEY, false);
        }

    }

    // METHODS FACEBOOK
    public void onSessionStateChanged(final Session session, SessionState state, Exception exception){
        if(session != null && session.isOpened()){

            shareButton.setVisibility(View.VISIBLE);

            if(reauth && state.equals(SessionState.OPENED_TOKEN_UPDATED)){
                reauth = false;
                shareContent(null);
            }

            Log.i("Script", "Usuário conectado");
            Request.newMeRequest(session, new Request.GraphUserCallback() {
                @Override
                public void onCompleted(GraphUser user, Response response) {
                    if(user != null){
                        TextView tv = (TextView) findViewById(R.id.nome);
                        tv.setText(user.getFirstName()+" "+user.getLastName());

//                        TextView mail = (TextView) findViewById(R.id.email);
//                        mail.setText(user.getProperty("email").toString());



                        TextView codigo = (TextView) findViewById(R.id.id);
                        codigo.setText(user.getId());

                        ProfilePictureView ppv = (ProfilePictureView) findViewById(R.id.fbImg);
                        ppv.setProfileId(user.getId());

                        getFriends(session);
                    }
                }
            }).executeAsync();
        }
        else{
            shareButton.setVisibility(View.INVISIBLE);
            Log.i("Script", "Usuário não conectado");
        }
    }


    public void getFriends(Session session){
        Request.newMyFriendsRequest(session, new Request.GraphUserListCallback() {
            @Override
            public void onCompleted(List<GraphUser> users, Response response) {
                if(users != null){
                    Log.i("Script", "Friends: "+users.size());
                }
                Log.i("Script", "response: "+response);
            }
        }).executeAsync();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Session session = Session.getActiveSession();
        if(session != null && (session.isClosed() || session.isOpened())){
            onSessionStateChanged(session, session.getState(), null);
        }

        uiHelper.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
        uiHelper.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }


    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(KEY, reauth);
        uiHelper.onSaveInstanceState(bundle);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiHelper.onActivityResult(requestCode, resultCode, data);
    }


    // SHARE
    private boolean reauth = false;
    private static final String KEY = "reauth";

    public void shareContent(View view){
        Session session = Session.getActiveSession();

        if(session != null){
            List<String> permissions = session.getPermissions();
            List<String> newPermissions = Arrays.asList("publish_actions");

            if(!verifyPermissions(permissions, newPermissions)){
                reauth = true;
                Session.NewPermissionsRequest npr = new Session.NewPermissionsRequest(this, newPermissions);
                session.requestNewPublishPermissions(npr);
                return;
            }


            Bitmap img = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            Request requestPhoto = Request.newUploadPhotoRequest(session, img, null);

            Bundle params = requestPhoto.getParameters(); //new Bundle();
            params.putString("name", "GoWalk");
            params.putString("caption", "Caption: Ficou fácil passear com seu Dog");
            params.putString("description", "Description: Ficou fácil passear com seu Dog");
            //params.putString("link", "http://www.gowalk.com.br");
            //params.putString("picture", "http://www.gowalk.com.br/img/system/bg/dog-in-field-04.jpg");


            Request.Callback callback2 = new Request.Callback(){
                @Override
                public void onCompleted(Response response) {
                    if(response.getError() == null){
                        Toast.makeText(MainActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "FAIL!", Toast.LENGTH_SHORT).show();
                    }
                }
            };


            //Request request = new Request(session, "me/feed", params, HttpMethod.POST, callback2);
            //request.executeAsync();

            requestPhoto.setParameters(params);
            requestPhoto.executeAsync();
        }
    }

    public boolean verifyPermissions(List<String> permissions, List<String> newPermissions){
        for(String p : permissions){
            if(newPermissions.contains(p)){
                return(true);
            }
        }
        return(false);
    }

}
