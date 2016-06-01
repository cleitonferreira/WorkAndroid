package nuvemapp.com.br.exemploapilocationv.service;


import nuvemapp.com.br.exemploapilocationv.R;

/**
 * Created by viniciusthiengo on 3/22/15.
 */
public class Place {
    private String name;
    private int category;
    private String description;
    private double latitude;
    private double longitude;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }



    public static int getCategorySource(int c) {
        switch ( c ){
            case 1:
                return(R.drawable.pub);
            case 2:
                return(R.drawable.university);
            case 3:
                return(R.drawable.gas_station);
            case 4:
                return(R.drawable.parking);
            case 5:
                return(R.drawable.hospital);
            case 6:
                return(R.drawable.bakery);
            case 7:
                return(R.drawable.restaurant);
            case 8:
                return(R.drawable.mall);
            default:
                return(R.drawable.grocery_store);
        }
    }
}
