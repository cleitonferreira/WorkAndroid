package nuvemapp.com.br.exemplosocialauth;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.brickred.socialauth.Contact;
import org.brickred.socialauth.android.DialogListener;
import org.brickred.socialauth.android.SocialAuthAdapter;
import org.brickred.socialauth.android.SocialAuthError;
import org.brickred.socialauth.android.SocialAuthListener;

import java.util.ArrayList;
import java.util.List;

import nuvemapp.com.br.exemplosocialauth.adapter.FriendsAdapter;
import nuvemapp.com.br.exemplosocialauth.domain.User;

public class PublishActivity extends AppCompatActivity {

    private SocialAuthAdapter socialAuth;
    private EditText etStatus;
    private Button btStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);

        socialAuth = new SocialAuthAdapter(new ResponseListener());

        // VIEWS
        etStatus = (EditText) findViewById(R.id.etStatus);
        btStatus = (Button) findViewById(R.id.btStatus);

    }

    public void updateStatus(View view) {
        socialAuth.authorize(PublishActivity.this, SocialAuthAdapter.Provider.LINKEDIN);
        enableViews(false);
    }

    public void enableViews(boolean status) {
        etStatus.setEnabled(status);
        btStatus.setEnabled(status);
        btStatus.setText(status ? "Publicar" : "Publicando");
    }

    // SOCIAL AUTH CLASS
    public class ResponseListener implements DialogListener {
        @Override
        public void onComplete(Bundle values) {

            socialAuth.updateStatus(etStatus.getText().toString(), new MessageDataListener(), true);
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


    public class MessageDataListener implements SocialAuthListener<Integer> {
        @Override
        public void onExecute(String plataform, Integer data) {

            enableViews(true);

            if(data != null){

                Log.i("Script", "Status code: "+data.intValue());

                if (data.intValue() == 200 || data.intValue() == 201 || data.intValue() == 204) {
                    Toast.makeText(PublishActivity.this, "Status atualizado com sucesso.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PublishActivity.this, "Status não atualizado. Tente novamente", Toast.LENGTH_SHORT).show();
                }
            }
        }

        @Override
        public void onError(SocialAuthError error) {
            Log.i("Script", error.getMessage());
        }
    }


}
