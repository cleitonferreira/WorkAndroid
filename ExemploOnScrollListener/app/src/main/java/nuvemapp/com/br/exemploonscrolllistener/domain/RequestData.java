package nuvemapp.com.br.exemploonscrolllistener.domain;

/**
 * Created by viniciusthiengo on 2/1/15.
 */
public class RequestData {
    private String url;
    private String method;
    private Object obj;


    public RequestData(String u, String m, Object o){
        url = u;
        method = m;
        obj = o;
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
    public void setObj(Object obj) {
        this.obj = obj;
    }
}
