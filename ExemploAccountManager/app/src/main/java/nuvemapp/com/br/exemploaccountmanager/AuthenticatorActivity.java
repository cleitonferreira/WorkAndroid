package nuvemapp.com.br.exemploaccountmanager;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import nuvemapp.com.br.exemploaccountmanager.application.MyApplication;
import nuvemapp.com.br.exemploaccountmanager.conf.Constant;
import nuvemapp.com.br.exemploaccountmanager.connection.HttpConnection;
import nuvemapp.com.br.exemploaccountmanager.domain.MainRequest;
import nuvemapp.com.br.exemploaccountmanager.domain.User;

public class AuthenticatorActivity extends AccountAuthenticatorActivity {
    private AccountManager mAccountManager;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authenticator);
        Log.i("Script", "AuthenticatorActivity.onCreate()");

        user = ((MyApplication) getApplication()).getUser();
        user.setAccountType(getIntent().getStringExtra(Constant.ARG_ACCOUNT_TYPE));
        user.setAccountName(getIntent().getStringExtra(Constant.ARG_ACCOUNT_NAME));
        user.setAuthTokenType(getIntent().getStringExtra(Constant.ARG_AUTH_TYPE));

        mAccountManager = AccountManager.get(AuthenticatorActivity.this);
    }


    // LISTENER
    public void signIn(View view) {
        Log.i("Script", "AuthenticatorActivity.signIn()");

        findViewById(R.id.btLogin).setEnabled(false);
        user.setEmail(((EditText) findViewById(R.id.tvEmail)).getText().toString());
        user.setPassword(((EditText) findViewById(R.id.tvPassword)).getText().toString());

        new AsyncTask<Void, Void, Intent>() {
            @Override
            protected Intent doInBackground(Void... params) {
                Log.i("Script", "AuthenticatorActivity.signIn().AsyncTask.doInBackground()");
                JSONObject jo = HttpConnection.getSetDataWeb(new MainRequest(Constant.SERVER_URL, "mob-token-by-credentials", user));
                Intent it = new Intent();

                try {
                    it.putExtra(AccountManager.KEY_ACCOUNT_TYPE, user.getAccountType());
                    it.putExtra(AccountManager.KEY_ACCOUNT_NAME, user.getEmail());
                    it.putExtra(AccountManager.KEY_AUTHTOKEN, jo.getString("token"));
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }

                return(it);
            }
            @Override
            protected void onPostExecute(Intent it) {
                Log.i("Script", "AuthenticatorActivity.signIn().AsyncTask.onPostExecute()");
                finish(it);
            }
        }.execute();
    }


    public void finish(Intent it){
        Log.i("Script", "AuthenticatorActivity.finish()");

        String accountType = it.getStringExtra(AccountManager.KEY_ACCOUNT_TYPE);
        String accountName = it.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
        String token = it.getStringExtra(AccountManager.KEY_AUTHTOKEN);
        Account account = new Account(accountName, accountType);
        int countAccounts = mAccountManager.getAccountsByType(accountType).length;

        if(token.equalsIgnoreCase("null")){
            Log.i("Script", "AuthenticatorActivity.finish() : if(token.equalsIgnoreCase(\"null\"))");
            Toast.makeText(AuthenticatorActivity.this, "Dados de acesso incorretos!", Toast.LENGTH_SHORT).show();
            findViewById(R.id.btLogin).setEnabled(true);
            return;
        }

        mAccountManager.addAccountExplicitly(account, null, null);
        mAccountManager.setAuthToken(account, user.getAuthTokenType(), token);

        setAccountAuthenticatorResult(it.getExtras());
        finish();

        if(countAccounts == 0){
            startActivity(new Intent(AuthenticatorActivity.this, MainActivity.class));
        }
    }
}
