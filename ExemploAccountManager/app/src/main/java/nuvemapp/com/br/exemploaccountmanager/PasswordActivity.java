package nuvemapp.com.br.exemploaccountmanager;

import org.json.JSONException;
import org.json.JSONObject;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import nuvemapp.com.br.exemploaccountmanager.application.MyApplication;
import nuvemapp.com.br.exemploaccountmanager.conf.Constant;
import nuvemapp.com.br.exemploaccountmanager.connection.HttpConnection;
import nuvemapp.com.br.exemploaccountmanager.domain.MainRequest;
import nuvemapp.com.br.exemploaccountmanager.domain.User;

public class PasswordActivity extends AccountAuthenticatorActivity {
    private EditText etActuallyPassword;
    private EditText etNewPassword;
    private Button btSend;
    private User user;
    private AccountManager mAccountManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        Log.i("Script", "PasswordActivity.onCreate()");

        etActuallyPassword = (EditText) findViewById(R.id.etActuallyPassword);
        etNewPassword = (EditText) findViewById(R.id.etNewPassword);
        btSend = (Button) findViewById(R.id.btSend);

        user = ((MyApplication) getApplication()).getUser();
        user.setAccountType(getIntent().getStringExtra(Constant.ARG_ACCOUNT_TYPE));
        user.setAccountName(getIntent().getStringExtra(Constant.ARG_ACCOUNT_NAME));
        user.setAuthTokenType(getIntent().getStringExtra(Constant.ARG_AUTH_TYPE));

        mAccountManager = AccountManager.get(PasswordActivity.this);
    }


    // UTIL
    public void enableViews(boolean status){
        etActuallyPassword.setEnabled(status);
        etNewPassword.setEnabled(status);
        btSend.setEnabled(status);
        btSend.setText(status ? "Atualizar" : "Atualizando...");
    }


    // LISTENER
    public void changePassword(View view){
        Log.i("Script", "PasswordActivity.changePassword()");

        enableViews(false);
        user.setPassword(etActuallyPassword.getText().toString());
        user.setNewPassword(etNewPassword.getText().toString());

        new AsyncTask<Void, Void, JSONObject>() {
            @Override
            protected JSONObject doInBackground(Void... params) {
                Log.i("Script", "PasswordActivity.changePassword().AsyncTask.doInBackground()");
                JSONObject jo = HttpConnection.getSetDataWeb(new MainRequest(Constant.SERVER_URL, "mob-change-password", user));
                return(jo);
            }
            @Override
            protected void onPostExecute(JSONObject jo) {
                Log.i("Script", "PasswordActivity.changePassword().AsyncTask.onPostExecute()");

                enableViews(true);
                etActuallyPassword.setText("");
                etNewPassword.setText("");
                Intent it = new Intent();

                try {
                    if(!jo.isNull("feedback") && jo.getInt("feedback") == 1){
                        it.putExtra(AccountManager.KEY_ACCOUNT_TYPE, user.getAccountType());
                        it.putExtra(AccountManager.KEY_ACCOUNT_NAME, user.getAccountName());
                        it.putExtra(AccountManager.KEY_AUTHTOKEN, jo.getString("token"));

                        Toast.makeText(PasswordActivity.this, "Senha alterada com sucesso!", Toast.LENGTH_SHORT).show();
                        finish(it);
                    }
                    else{
                        throw new JSONException("");
                    }
                }
                catch(JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(PasswordActivity.this, "Falhou! Tente novamente.", Toast.LENGTH_SHORT).show();
                }

            }
        }.execute();
    }


    public void finish(Intent it){
        Log.i("Script", "PasswordActivity.finish()");
        String accountType = it.getStringExtra(AccountManager.KEY_ACCOUNT_TYPE);
        String accountName = it.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
        String token = it.getStringExtra(AccountManager.KEY_AUTHTOKEN);
        Account account = new Account(accountName, accountType);

        mAccountManager.invalidateAuthToken(accountType, user.getToken());
        mAccountManager.setAuthToken(account, user.getAuthTokenType(), token);
        user.setToken(token);

        setAccountAuthenticatorResult(it.getExtras());
        finish();
    }
}
