package nuvemapp.com.br.exemploaccountmanager.domain;

import java.io.Serializable;

public class MainRequest implements Serializable {
	private static final long serialVersionUID = 445236569887978L;
	private String url;
	private String method;
	private Object obj;
	
	
	public MainRequest(){
		url = "";
		method = "";
		obj = null;
	}
	public MainRequest(String url, String method, Object obj){
		this.url = url;
		this.method = method;
		this.obj = obj;
	}
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	
	public Object getObj() {
		return obj;
	}
	public void setObj(String obj) {
		this.obj = obj;
	}
}
