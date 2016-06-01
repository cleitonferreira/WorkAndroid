package nuvemapp.com.br.exemploapilocationv.domain;

/**
 * Created by viniciusthiengo on 3/15/15.
 */
public class User {
    private long id;

    public User(long id){
        this.id = id;
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
