package nuvemapp.com.br.exemplosocialauth;

import java.util.ArrayList;
import java.util.List;

import org.brickred.socialauth.Contact;
import org.brickred.socialauth.Profile;
import org.brickred.socialauth.android.DialogListener;
import org.brickred.socialauth.android.SocialAuthAdapter;
import org.brickred.socialauth.android.SocialAuthAdapter.Provider;
import org.brickred.socialauth.android.SocialAuthError;
import org.brickred.socialauth.android.SocialAuthListener;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import nuvemapp.com.br.exemplosocialauth.adapter.FriendsAdapter;
import nuvemapp.com.br.exemplosocialauth.domain.User;

public class FriendsActivity extends Activity {
    private SocialAuthAdapter socialAuth;
    private ListView listView;
    private ProgressBar pbLoad;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        socialAuth = new SocialAuthAdapter(new ResponseListener());
        socialAuth.authorize(FriendsActivity.this, Provider.LINKEDIN);

        // VIEWS
        pbLoad = (ProgressBar) findViewById(R.id.pbLoad);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(user.getFriends().get(position).getProfileUrl()));
                startActivity(it);
            }

        });


        // INTENT
        if(getIntent() != null){
            user = (User) getIntent().getSerializableExtra("user");
            user.setFriends(new ArrayList<User>());
        }
    }


    // SOCIAL AUTH CLASS
    public class ResponseListener implements DialogListener{
        @Override
        public void onComplete(Bundle values) {
            socialAuth.getContactListAsync(new ContactDataListener());
        }

        @Override
        public void onBack() {}

        @Override
        public void onCancel() {}

        @Override
        public void onError(SocialAuthError error) {
            Log.i("Script", error.getMessage());
        }
    }


    public class ContactDataListener implements SocialAuthListener<List<Contact>> {
        @Override
        public void onExecute(String plataform, List<Contact> data) {
            if(data != null){
                for(Contact c : data){
                    User aux = new User();

                    aux.setDisplayName(c.getDisplayName());
                    aux.setEmail(c.getEmail());
                    aux.setFirstName(c.getFirstName());
                    aux.setLastName(c.getLastName());
                    aux.setValidatedId(c.getId());
                    aux.setOtherEmails(c.getOtherEmails());
                    aux.setProfileImageURL(c.getProfileImageURL());
                    aux.setProfileUrl(c.getProfileUrl());

                    if(aux.getProfileUrl() == null){
                        continue;
                    }

                    user.getFriends().add(aux);
                }

                pbLoad.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                listView.setAdapter(new FriendsAdapter(FriendsActivity.this, user.getFriends()));
            }
        }

        @Override
        public void onError(SocialAuthError error) {
            Log.i("Script", error.getMessage());
        }
    }
}
