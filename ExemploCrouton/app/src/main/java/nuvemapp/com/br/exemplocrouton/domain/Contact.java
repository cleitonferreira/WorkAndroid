package nuvemapp.com.br.exemplocrouton.domain;

public class Contact {
    private String name;
    private int image;
    private int qtdMessages;


    public Contact(String n, int img, int q){
        name = n;
        image = img;
        qtdMessages = q;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }


    public int getQtdMessages() {
        return qtdMessages;
    }
    public void setQtdMessages(int qtdMessages) {
        this.qtdMessages = qtdMessages;
    }
}
