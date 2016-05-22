package nuvemapp.com.br.exemploaccountmanager;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;

import nuvemapp.com.br.exemploaccountmanager.application.MyApplication;
import nuvemapp.com.br.exemploaccountmanager.conf.Constant;
import nuvemapp.com.br.exemploaccountmanager.connection.HttpConnection;
import nuvemapp.com.br.exemploaccountmanager.domain.MainRequest;
import nuvemapp.com.br.exemploaccountmanager.domain.User;

public class MainActivity extends Activity {
    private ImageView ivProfile;
    private ProgressBar pbLoad;
    private TextView tvName;
    private TextView tvEmail;

    private User user;
    private AccountManager mAccountManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Script", "MainActivity.onCreate()");

        ivProfile = (ImageView) findViewById(R.id.ivProfile);
        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);

        user = ((MyApplication) getApplication()).getUser();
        mAccountManager = AccountManager.get(MainActivity.this);
        getAccounts(null);

        if(mAccountManager.getAccountsByType(Constant.ACCOUNT_TYPE).length == 0){
            finish();
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i("Script", "onStart()");
    }


    @Override
    public void onResume(){
        super.onResume();
        Log.i("Script", "onResume()");
    }


    @Override
    public void onPause(){
        super.onPause();
        Log.i("Script", "onPause()");
    }


    @Override
    public void onStop(){
        super.onStop();
        Log.i("Script", "onStop()");
    }


    // LISTENERS
    public void addAccount(View view){
        mAccountManager.addAccount(Constant.ACCOUNT_TYPE,
                Constant.ACCOUNT_TOKEN_TYPE,
                null,
                null,
                MainActivity.this,
                new AccountManagerCallback<Bundle>(){
                    @Override
                    public void run(AccountManagerFuture<Bundle> future) {
                        try {
                            Bundle bundle = future.getResult();
                            Log.i("Script", "MainActivity.addAccount()");
                            Log.i("Script", "MainActivity.addAccount() : AccountType = "+bundle.getString(AccountManager.KEY_ACCOUNT_TYPE));
                            Log.i("Script", "MainActivity.addAccount() : AccountName = "+bundle.getString(AccountManager.KEY_ACCOUNT_NAME));
                            Log.i("Script", "MainActivity.addAccount() : Token = "+bundle.getString(AccountManager.KEY_AUTHTOKEN));

                            getAccount(bundle.getString(AccountManager.KEY_ACCOUNT_NAME), bundle.getString(AccountManager.KEY_ACCOUNT_TYPE));
                        }
                        catch (OperationCanceledException e) {
                            e.printStackTrace();
                        }
                        catch (AuthenticatorException e) {
                            e.printStackTrace();
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                },
                null);
    }


    public void getAccount(String accountName, String AccountType){
        mAccountManager.getAuthToken(new Account(accountName, AccountType),
                Constant.ACCOUNT_TOKEN_TYPE,
                null,
                MainActivity.this,
                new AccountManagerCallback<Bundle>(){
                    @Override
                    public void run(AccountManagerFuture<Bundle> future) {
                        try {
                            Bundle bundle = future.getResult();
                            Log.i("Script", "MainActivity.getAccount()");
                            Log.i("Script", "MainActivity.getAccount() : AccountType = "+bundle.getString(AccountManager.KEY_ACCOUNT_TYPE));
                            Log.i("Script", "MainActivity.getAccount() : AccountName = "+bundle.getString(AccountManager.KEY_ACCOUNT_NAME));
                            Log.i("Script", "MainActivity.getAccount() : Token = "+bundle.getString(AccountManager.KEY_AUTHTOKEN));

                            user.setAccountType(bundle.getString(AccountManager.KEY_ACCOUNT_TYPE));
                            user.setAccountName(bundle.getString(AccountManager.KEY_ACCOUNT_NAME));
                            user.setToken(bundle.getString(AccountManager.KEY_AUTHTOKEN));

                            setUserDataFromServer();
                        }
                        catch (OperationCanceledException e) {
                            e.printStackTrace();
                        }
                        catch (AuthenticatorException e) {
                            e.printStackTrace();
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                },
                null);
    }


    public void getAccounts(View view){
        mAccountManager.getAuthTokenByFeatures(Constant.ACCOUNT_TYPE,
                Constant.ACCOUNT_TOKEN_TYPE,
                null,
                MainActivity.this,
                null,
                null,
                new AccountManagerCallback<Bundle>(){
                    @Override
                    public void run(AccountManagerFuture<Bundle> future) {
                        try {
                            Bundle bundle = future.getResult();
                            Log.i("Script", "MainActivity.getAccounts()");
                            Log.i("Script", "MainActivity.getAccounts() : AccountType = "+bundle.getString(AccountManager.KEY_ACCOUNT_TYPE));
                            Log.i("Script", "MainActivity.getAccounts() : AccountName = "+bundle.getString(AccountManager.KEY_ACCOUNT_NAME));
                            Log.i("Script", "MainActivity.getAccounts() : Token = "+bundle.getString(AccountManager.KEY_AUTHTOKEN));

                            user.setAccountType(bundle.getString(AccountManager.KEY_ACCOUNT_TYPE));
                            user.setAccountName(bundle.getString(AccountManager.KEY_ACCOUNT_NAME));
                            user.setToken(bundle.getString(AccountManager.KEY_AUTHTOKEN));


//                            Log.i("Script", "AccountName "+user.getAccountName());
//                            Log.i("Script", "Email "+user.getEmail());
//                            Log.i("Script", "Image "+user.getImage());
//                            Log.i("Script", "AuthTokenType "+user.getAuthTokenType());
//                            Log.i("Script", "Password "+user.getPassword());
//                            Log.i("Script", "Token "+user.getToken());


                            setUserDataFromServer();
                        }
                        catch (OperationCanceledException e) {
                            e.printStackTrace();
                        }
                        catch (AuthenticatorException e) {
                            e.printStackTrace();
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                },
                null);
    }


    public void invalidateAuthToken(View view){
        Log.i("Script", "MainActivity.invalidateAuthToken()");
        mAccountManager.invalidateAuthToken(user.getAccountType(), user.getToken());
        finish();
    }


    public void removeAccount(View view){
        Log.i("Script", "MainActivity.removeAccount()");

        final Account[] accounts = mAccountManager.getAccountsByType(Constant.ACCOUNT_TYPE);
        String[] name = new String[accounts.length];

        for(int i = 0; i < accounts.length; i++){
            name[i] = accounts[i].name;
        }

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Escolha Account")
                .setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, name), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mAccountManager.removeAccount(accounts[which], null, null);
                        if(user.getAccountName().equalsIgnoreCase(accounts[which].name)){
                            finish();
                        }
                    }
                }).create();
        alertDialog.show();
    }


    public void callChangePasswordActivity(View view){
        mAccountManager.updateCredentials(new Account(user.getAccountName(),
                        Constant.ACCOUNT_TYPE),
                Constant.ACCOUNT_TOKEN_TYPE,
                null,
                MainActivity.this,
                new AccountManagerCallback<Bundle>(){
                    @Override
                    public void run(AccountManagerFuture<Bundle> future) {
                        try {
                            Bundle bundle = future.getResult();
                            Log.i("Script", "MainActivity.updateCredentials()");
                            Log.i("Script", "MainActivity.updateCredentials() : AccountType = "+bundle.getString(AccountManager.KEY_ACCOUNT_TYPE));
                            Log.i("Script", "MainActivity.updateCredentials() : AccountName = "+bundle.getString(AccountManager.KEY_ACCOUNT_NAME));
                            Log.i("Script", "MainActivity.updateCredentials() : Token = "+bundle.getString(AccountManager.KEY_AUTHTOKEN));
                        }
                        catch (OperationCanceledException e) {
                            e.printStackTrace();
                        }
                        catch (AuthenticatorException e) {
                            e.printStackTrace();
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                },
                null);
    }


    public void signOut(View view){
        Log.i("Script", "MainActivity.signOut()");

        Account[] accounts = mAccountManager.getAccountsByType(Constant.ACCOUNT_TYPE);
        for(int i = 0; i < accounts.length; i++){
            if(user.getAccountName().equalsIgnoreCase(accounts[i].name)){
                mAccountManager.removeAccount(accounts[i], null, null);
                finish();
                return;
            }
        }
        Toast.makeText(MainActivity.this, "Falhou!", Toast.LENGTH_SHORT).show();
    }


    // UTIL
    private void setUserDataFromServer(){
        new AsyncTask<Void, Void, JSONObject>() {
            @Override
            protected JSONObject doInBackground(Void... params) {
                JSONObject jo = HttpConnection.getSetDataWeb(new MainRequest(Constant.SERVER_URL, "mob-get-user", user));
                return jo;
            }
            @Override
            protected void onPostExecute(JSONObject jo) {
                try {

                    if(jo.getLong("id") == 0){
                        mAccountManager.invalidateAuthToken(Constant.ACCOUNT_TYPE, user.getToken());
                        getAccounts(null);
                        finish();
                    }

                    user.setId(jo.getLong("id"));
                    user.setName(jo.getString("name"));
                    user.setEmail(jo.getString("email"));
                    user.setImage(jo.getString("image"));

                    tvName.setText(user.getName());
                    tvEmail.setText(user.getEmail());

                    RequestQueue rq = ((MyApplication) getApplication()).getRequestQueue();
                    pbLoad = (ProgressBar) findViewById(R.id.pbLoad);
                    ivProfile = (ImageView) findViewById(R.id.ivProfile);
                    ImageLoader imageLoader = new ImageLoader(rq, new ImageLoader.ImageCache() {
                        private final LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>(10);
                        @Override
                        public void putBitmap(String url, Bitmap bitmap) {
                            pbLoad.setVisibility(View.GONE);
                            cache.put(url, bitmap);
                        }
                        @Override
                        public Bitmap getBitmap(String url) {
                            return cache.get(url);
                        }
                    });
                    imageLoader.get(user.getImage(), ImageLoader.getImageListener(ivProfile, R.id.pbLoad, R.drawable.ic_launcher));

                }
                catch(JSONException e) {
                    e.printStackTrace();
                }
            }
        }.execute();
    }
}
