package nuvemapp.com.br.exemploaccountmanager.application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;

import nuvemapp.com.br.exemploaccountmanager.domain.User;

public class MyApplication extends Application {
	private RequestQueue rq;
	private User user;
	
	@Override
	public void onCreate(){
		super.onCreate();
		
		rq = Volley.newRequestQueue(this);
		user = new User();
	}
	
	
	public RequestQueue getRequestQueue(){
		return(rq);
	}

	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
