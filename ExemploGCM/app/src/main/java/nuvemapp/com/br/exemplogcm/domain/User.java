package nuvemapp.com.br.exemplogcm.domain;


public class User {

    private String registrationId;

    public User() {}
    public User(String registrationId) {
        this.registrationId = registrationId;
    }


    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

}
