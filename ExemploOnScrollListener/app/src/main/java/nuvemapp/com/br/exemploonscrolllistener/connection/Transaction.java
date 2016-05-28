package nuvemapp.com.br.exemploonscrolllistener.connection;


import nuvemapp.com.br.exemploonscrolllistener.domain.RequestData;

/**
 * Created by viniciusthiengo on 2/1/15.
 */
public interface Transaction {
    public void doBefore();
    public void doAfter(String answer);
    public RequestData getRequestData();
}
