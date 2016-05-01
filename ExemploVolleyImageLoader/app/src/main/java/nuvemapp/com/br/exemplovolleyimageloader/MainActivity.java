package nuvemapp.com.br.exemplovolleyimageloader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import nuvemapp.com.br.exemplovolleyimageloader.cdp.CustomJsonArrayRequest;
import nuvemapp.com.br.exemplovolleyimageloader.cdp.CustomJsonObjectRequest;
import nuvemapp.com.br.exemplovolleyimageloader.cdp.Post;

public class MainActivity extends Activity {
    private RequestQueue rq;
    private Map<String, String> params;
    private EditText etEmail;
    private EditText etPassword;
    private String url;
    private ArrayList<Post> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = "http://192.168.1.7/android/volleyImageLoader/android-volley.php";

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        rq = Volley.newRequestQueue(MainActivity.this);

        //callByJsonObjectRequest(null);
    }


    public void enableViews(boolean status){
        etEmail.setEnabled(status);
        etPassword.setEnabled(status);
        findViewById(R.id.btJOR).setEnabled(status);
        findViewById(R.id.btJAR).setEnabled(status);
        findViewById(R.id.btSR).setEnabled(status);
    }


    // CALLS VOLLEY
    public void callByJsonObjectRequest(View view){
        Log.i("Script", "ENTREI: callByJsonObjectRequest()");
        enableViews(false);

        params = new HashMap<String, String>();
        params.put("email", etEmail.getText().toString());
        params.put("pasword", etPassword.getText().toString());
        params.put("method", "web-data-jor");

        CustomJsonObjectRequest request = new CustomJsonObjectRequest(Method.POST,
                url,
                params,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Script", "SUCCESS: "+response);
                        enableViews(true);
                        list = new ArrayList<Post>();

                        try{
                            JSONArray ja = response.getJSONArray("posts");

                            for(int i = 0, tam = ja.length(); i < tam; i++){
                                Post p = new Post();
                                p.setUrlImage(ja.getJSONObject(i).getString("image"));
                                p.setTitle(ja.getJSONObject(i).getString("title"));

                                list.add(p);
                            }
                        }
                        catch(JSONException e){
                            e.printStackTrace();
                        }

                        Intent it = new Intent(MainActivity.this, ProfileActivity.class);
                        it.putParcelableArrayListExtra("posts", list);
                        startActivity(it);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error: "+error.getMessage(), Toast.LENGTH_LONG).show();
                        enableViews(true);
                    }
                });

        request.setTag("tag");
        rq.add(request);
    }


    public void callByJsonArrayRequest(View view){
        enableViews(false);

        params = new HashMap<String, String>();
        params.put("email", etEmail.getText().toString());
        params.put("pasword", etPassword.getText().toString());
        params.put("method", "web-data-jar");

        CustomJsonArrayRequest request = new CustomJsonArrayRequest(Method.POST,
                url,
                params,
                new Response.Listener<JSONArray>(){
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.i("Script", "SUCCESS: "+response);
                        enableViews(true);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error: "+error.getMessage(), Toast.LENGTH_LONG).show();
                        enableViews(true);
                    }
                });

        request.setTag("tag");
        rq.add(request);
    }


    public void callByStringRequest(View view){
        enableViews(false);

        StringRequest request = new StringRequest(Method.POST,
                url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        Log.i("Script", "SUCCESS: "+response);
                        enableViews(true);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error: "+error.getMessage(), Toast.LENGTH_LONG).show();
                        enableViews(true);
                    }
                }){
            @Override
            public Map<String, String> getParams() throws AuthFailureError{
                params = new HashMap<String, String>();
                params.put("email", etEmail.getText().toString());
                params.put("pasword", etPassword.getText().toString());
                params.put("method", "web-data-sr");

                return(params);
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError{
                HashMap<String, String> header = new HashMap<String, String>();
                header.put("apiKey", "Essa e minha API KEY: sdvkjbsdjvkbskdv");

                return(header);
            }

            @Override
            public Priority getPriority(){
                return(Priority.NORMAL);
            }
        };

        request.setTag("tag");
        rq.add(request);
    }


    @Override
    public void onStop(){
        super.onStop();

        rq.cancelAll("tag");
    }
}
