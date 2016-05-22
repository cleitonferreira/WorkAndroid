package nuvemapp.com.br.exemploautocompletetextview.connection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import nuvemapp.com.br.exemploautocompletetextview.domain.State;


public class HttpConnection {
	public static List<State> getStateListWeb(String url, int country, String text){
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		String serverAnswer = "";
		
		try{
			ArrayList<NameValuePair> valores = new ArrayList<NameValuePair>();
			valores.add(new BasicNameValuePair("country", country+""));
			valores.add(new BasicNameValuePair("search", text));
			
			httpPost.setEntity(new UrlEncodedFormEntity(valores));
			HttpResponse resposta = httpClient.execute(httpPost);
			serverAnswer = EntityUtils.toString(resposta.getEntity());
		}
		catch(NumberFormatException e){ e.printStackTrace(); }
		catch(NullPointerException e){ e.printStackTrace(); }
		catch(ClientProtocolException e){ e.printStackTrace(); }
		catch(IOException e){ e.printStackTrace(); }
		return(getStateListJson(serverAnswer));
	}
	
	
	private static List<State> getStateListJson(String json){
		List<State> list = new ArrayList<State>();
		try{
			JSONArray ja = new JSONArray(json);
			for(int i = 0, tam = ja.length(); i < tam; i++){
				JSONObject jo = ja.getJSONObject(i);
				State s = new State(jo.getString("state"), State.imgMap.get(jo.getString("state")));
				list.add(s);
			}
		}
		catch(JSONException e){
			e.printStackTrace();
		}
		return(list);
	}
}
