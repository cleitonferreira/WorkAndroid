package nuvemapp.com.br.exemploonscrolllistener.connection;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.ProgressBar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import nuvemapp.com.br.exemploonscrolllistener.application.CustomApplication;
import nuvemapp.com.br.exemploonscrolllistener.domain.Car;
import nuvemapp.com.br.exemploonscrolllistener.domain.RequestData;


/**
 * Created by viniciusthiengo on 2/1/15.
 */
public class VolleyConn {
    private Transaction transaction;
    private RequestQueue requestQueue;


    public VolleyConn(Context c, Transaction t){
        transaction = t;
        requestQueue = ((CustomApplication) ((Activity) c).getApplication()).getRequestQueue();
    }


    public void execute(){
        transaction.doBefore();
        callByStringRequest(transaction.getRequestData());
    }


    private void callByStringRequest(final RequestData requestData){
        StringRequest request = new StringRequest(Request.Method.POST,
            requestData.getUrl(),
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    transaction.doAfter(response);
                }
            },
            new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){
                    transaction.doAfter(null);
                }
        }){
            @Override
            public Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<String, String>();
                params.put("method", requestData.getMethod());

                if(requestData.getObj() != null){
                    Car car = (Car)requestData.getObj();
                    params.put("lastId", Integer.toString( car.getId() ));
                }

                return(params);
            }
        };

        request.setTag("conn");
        requestQueue.add(request);
    }
}
