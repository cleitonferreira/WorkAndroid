package nuvemapp.com.br.exemplojobscheduler.domain;

/**
 * Created by viniciusthiengo on 3/8/15.
 */
public class MessageEB {
    private String result;


    public MessageEB(String r){
        result = r;
    }


    public String getResult() {
        return result;
    }


    public void setResult(String result) {
        this.result = result;
    }
}
