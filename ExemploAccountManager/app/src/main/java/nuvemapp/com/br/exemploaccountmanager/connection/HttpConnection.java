package nuvemapp.com.br.exemploaccountmanager.connection;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import nuvemapp.com.br.exemploaccountmanager.domain.MainRequest;
import nuvemapp.com.br.exemploaccountmanager.domain.User;


public class HttpConnection {
	public static JSONObject getSetDataWeb(MainRequest request){
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(request.getUrl());
		String answer = "";
		
		try{
			ArrayList<NameValuePair> valores = new ArrayList<NameValuePair>();
			valores.add(new BasicNameValuePair("method", request.getMethod()));
			
			if(request.getObj() instanceof User){
				User obj = (User) request.getObj();
				valores.add(new BasicNameValuePair("email", obj.getEmail()+""));
				valores.add(new BasicNameValuePair("password", obj.getPassword()+""));
				valores.add(new BasicNameValuePair("newPassword", obj.getNewPassword()+""));
				valores.add(new BasicNameValuePair("authTokenType", obj.getAuthTokenType()+""));
				valores.add(new BasicNameValuePair("token", obj.getToken()+""));
			}
			
			httpPost.setEntity(new UrlEncodedFormEntity(valores));
			HttpResponse resposta = httpClient.execute(httpPost);
			answer = EntityUtils.toString(resposta.getEntity());
		}
		catch(NumberFormatException e){ e.printStackTrace(); }
		catch(NullPointerException e){ e.printStackTrace(); }
		catch(ClientProtocolException e){ e.printStackTrace(); }
		catch(IOException e){ e.printStackTrace(); }
		return(jsonParse(answer));
	}
	
	public static JSONObject jsonParse(String json) {
	    JSONObject jo = null;
		try {
			jo = new JSONObject(json);
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		return(jo);
	}
}
