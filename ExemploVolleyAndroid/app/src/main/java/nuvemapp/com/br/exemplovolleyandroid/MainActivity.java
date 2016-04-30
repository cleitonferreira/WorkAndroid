package nuvemapp.com.br.exemplovolleyandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import nuvemapp.com.br.exemplovolleyandroid.cdp.CustomJsonArrayRequest;
import nuvemapp.com.br.exemplovolleyandroid.cdp.CustomJsonObjectRequest;

public class MainActivity extends AppCompatActivity {

    private RequestQueue rq;
    private Map<String, String> params;
    private EditText etEmail;
    private EditText etPassword;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pega o IP da máquina que está rodando o apache
        url = "http://192.168.1.6/android/volley/android-volley.php";

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        rq = Volley.newRequestQueue(MainActivity.this);

        callByJsonObjectRequest(null);

    }

    // CALLS VOLLEY
    public void callByJsonObjectRequest(View view){
        /* JsonObjectRequest jor = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }); */

        Log.i("Script", "ENTREI: callByJsonObjectRequest()");

        params = new HashMap<String, String>();
        params.put("email", etEmail.getText().toString());
        params.put("pasword", etPassword.getText().toString());
        params.put("method", "web-data-jor");

        CustomJsonObjectRequest request = new CustomJsonObjectRequest(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("Script", "SUCCESS"+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error"+error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        request.setTag("tag");
        rq.add(request);
    }

    public void callByJsonArrayRequest(View view){
        params = new HashMap<String, String>();
        params.put("email", etEmail.getText().toString());
        params.put("pasword", etPassword.getText().toString());
        params.put("method", "web-data-jar");

        CustomJsonArrayRequest request = new CustomJsonArrayRequest(Request.Method.POST,
                url,
                params,
                new Response.Listener<JSONArray>(){
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.i("Script", "SUCCESS: "+response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error: "+error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        request.setTag("tag");
        rq.add(request);
    }

    public void callByStringRequest(View view){
        StringRequest request = new StringRequest(Request.Method.POST,
                url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        Log.i("Script", "SUCCESS: "+response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error: "+error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
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
