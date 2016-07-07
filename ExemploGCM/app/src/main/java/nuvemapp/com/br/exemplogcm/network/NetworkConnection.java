package nuvemapp.com.br.exemplogcm.network;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;

import nuvemapp.com.br.exemplogcm.domain.WrapObjToNetwork;


public class NetworkConnection {
    public static final String TAG = "LOG";

    private static NetworkConnection instance;
    private Context mContext;
    private RequestQueue mRequestQueue;


    public NetworkConnection(Context c){
        mContext = c;
        mRequestQueue = getRequestQueue();
    }


    public static NetworkConnection getInstance( Context c ){
        if( instance == null ){
            instance = new NetworkConnection( c.getApplicationContext() );
        }
        return( instance );
    }


    public RequestQueue getRequestQueue(){
        if( mRequestQueue == null ){
            mRequestQueue = Volley.newRequestQueue(mContext);
        }
        return(mRequestQueue);
    }


    public <T> void addRequestQueue( Request<T> request ){
        getRequestQueue().add(request);
    }


    public void execute( final WrapObjToNetwork obj, String tag ){
        Gson gson = new Gson();

        if( obj == null ){
            return;
        }

        HashMap<String, String> params = new HashMap<>();
        params.put("jsonObject", gson.toJson(obj));

        CustomRequest request = new CustomRequest(Request.Method.POST,
                "http://192.168.25.221:8888/PushMessageSerie/package/ctrl/CtrlUser.php",
                params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, "onResponse(): " + response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, "onErrorResponse(): "+error.getMessage());
                    }
                });

        request.setTag(tag);
        request.setRetryPolicy(new DefaultRetryPolicy(5000,
                1,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Log.i(TAG, "--> "+DefaultRetryPolicy.DEFAULT_MAX_RETRIES);

        addRequestQueue(request);
    }
}
