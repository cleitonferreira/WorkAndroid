package nuvemapp.com.br.exemplobutterknife.domain;

/**
 * Created by viniciusthiengo on 12/22/14.
 */
public class Product {
    private String name;
    private String category;
    private double price;


    public Product(String name, String category, double price){
        this.name = name;
        this.category = category;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPriceFormatted() {
        String p = price+"0";
        p = p.replace('.',',');
        return p;
    }
}
