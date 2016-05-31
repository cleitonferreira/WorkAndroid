package nuvemapp.com.br.exemploapilocationiv.network;

import android.location.Location;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

import nuvemapp.com.br.exemploapilocationiv.domain.MessageEB;


public class HttpConnection {
	public static String getSetDataWeb(String url, String method, MessageEB m){
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		String answer = "";
		
		try{
			ArrayList<NameValuePair> valores = new ArrayList<NameValuePair>();
			valores.add(new BasicNameValuePair("method", method));
            valores.add(new BasicNameValuePair("id-user", m.getUser().getId()+"" ));
            valores.add(new BasicNameValuePair("latitude", m.getLocation().getLatitude()+"" ));
            valores.add(new BasicNameValuePair("longitude", m.getLocation().getLongitude()+"" ));
            valores.add(new BasicNameValuePair("altitude", m.getLocation().getAltitude()+"" ));

			httpPost.setEntity(new UrlEncodedFormEntity(valores));
			HttpResponse resposta = httpClient.execute(httpPost);
			answer = EntityUtils.toString(resposta.getEntity());
		}
		catch(NumberFormatException e){ e.printStackTrace(); }
		catch(ClientProtocolException e){ e.printStackTrace(); }
		catch(IOException e){ e.printStackTrace(); }
        catch(NullPointerException e){ e.printStackTrace(); }

		return(answer);
	}
}
