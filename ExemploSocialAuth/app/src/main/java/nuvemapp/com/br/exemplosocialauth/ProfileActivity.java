package nuvemapp.com.br.exemplosocialauth;

import java.util.Iterator;
import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import nuvemapp.com.br.exemplosocialauth.domain.Constant;
import nuvemapp.com.br.exemplosocialauth.domain.Image;
import nuvemapp.com.br.exemplosocialauth.domain.User;

public class ProfileActivity extends Activity {
    private ProgressBar pbLoad;
    private ImageView ivProfile;
    private TextView tvInfo;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // SHARED PREFERENCES
        SharedPreferences sp = getSharedPreferences(Constant.PREF_STATUS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(Constant.PREF_IS_LOGGED, true);
        editor.commit();

        // VIEWS
        pbLoad = (ProgressBar) findViewById(R.id.pbLoad);
        ivProfile = (ImageView) findViewById(R.id.ivProfile);
        tvInfo = (TextView) findViewById(R.id.tvInfo);

        if(getIntent() != null){
            user = (User) getIntent().getSerializableExtra("user");

            String contentInfo = user.getProviderId() != null ? "<b>Plataforma:</b> "+user.getProviderId()+"<br />" : "";
            contentInfo += user.getValidatedId() != null ? "<b>ID:</b> "+user.getValidatedId()+"<br />" : "";
            contentInfo += user.getFirstName() != null ? "<b>Primeiro nome:</b> "+user.getFirstName()+"<br />" : "";
            contentInfo += user.getLastName() != null ? "<b>Último nome:</b> "+user.getLastName()+"<br />" : "";
            contentInfo += user.getEmail() != null ? "<b>Email:</b> "+user.getEmail()+"<br />" : "";
            contentInfo += user.getCountry() != null ? "<b>País:</b> "+user.getCountry()+"<br />" : "";
            contentInfo += user.getLanguage() != null ? "<b>Língua:</b> "+user.getLanguage()+"<br />" : "";
            contentInfo += user.getLocation() != null ? "<b>Localização:</b> "+user.getLocation()+"<br />" : "";
            contentInfo += user.getGender() != null ? "<b>Gênero:</b> "+user.getGender()+"<br />" : "";
            contentInfo += user.getDisplayName() != null ? "<b>Nome em amostra:</b> "+user.getDisplayName()+"<br />" : "";
            contentInfo += user.getFullName() != null ? "<b>Nome completo:</b> "+user.getFullName()+"<br />" : "";
            contentInfo += user.getBirthDate() != null ? "<b>Nascimento:</b> "+user.getBirthDate().getDay()+"/"+user.getBirthDate().getMonth()+"/"+user.getBirthDate().getYear()+"<br />" : "";

            if(user.getContactInfo() != null){
                contentInfo += "<b>Informações de contato:</b> <br />";

                Set keys = user.getContactInfo().keySet();
                Iterator<String> i = keys.iterator();

                while(i.hasNext()){
                    String key = (String) i.next();
                    String value = (String) user.getContactInfo().get(key);
                    contentInfo += "&nbsp;&nbsp; <b>"+key+":</b> "+value+"<br />";
                }
            }

            tvInfo.setText( Html.fromHtml(contentInfo) );
            Image.loadImg(ProfileActivity.this, user.getProfileImageURL(), ivProfile, pbLoad);
        }
    }


    public void callFriendsActivity(View view){
        Intent it = new Intent(ProfileActivity.this, FriendsActivity.class);
        it.putExtra("user", user);
        startActivity(it);
    }


    public void signOut(View view){
        // SHARED PREFERENCES
        SharedPreferences sp = getSharedPreferences(Constant.PREF_STATUS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(Constant.PREF_IS_LOGGED, false);
        editor.commit();

        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
        finish();
    }
}
