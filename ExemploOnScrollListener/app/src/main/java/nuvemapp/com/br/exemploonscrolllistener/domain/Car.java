package nuvemapp.com.br.exemploonscrolllistener.domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by viniciusthiengo on 2/1/15.
 */
public class Car implements Parcelable {

    //public static final String CAR_URL = "http://www.villopim.com.br/android/exampleOnScrollListener/package/ctrl/CtrlCar.php";

    //localhost - Ip da máquina
    public static final String CAR_URL = "http://192.168.1.6/android/exampleOnScrollListener/package/ctrl/CtrlCar.php";

    private int id;
    private String model;
    private String brand;
    private int year;
    private String engine;
    private String imagePath;
    private String price;


    public Car(){}
    public Car(int i, String m, String b, int y, String e, String iPath, String p){
        id = i;
        model = m;
        brand = b;
        year = y;
        engine = e;
        imagePath = iPath;
        price = p;
    }
    public Car(Parcel parcel){
        setId(parcel.readInt());
        setModel(parcel.readString());
        setBrand(parcel.readString());
        setYear(parcel.readInt());
        setEngine(parcel.readString());
        setImagePath(parcel.readString());
        setPrice(parcel.readString());
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }


    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }


    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }


    public String getEngine() {
        return engine;
    }
    public void setEngine(String engine) {
        this.engine = engine;
    }


    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }


    @Override
    public String toString(){
        String aux = "<b>Model:<b> "+getModel()+"<br>";
        aux += "<b>Brand:<b> "+getBrand()+"<br>";
        aux += "<b>Engine:<b> "+getEngine()+"<br>";
        aux += "<b>Year:<b> "+getYear()+"<br>";
        aux += "<b>Price:<b> <font color=\"#0000cc\"><i>"+getPrice()+"</i></font>";
        return(aux);
    }


    // PARCELABLE
    @Override
    public int describeContents(){
        return(0);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(getId());
        dest.writeString(getModel());
        dest.writeString(getBrand());
        dest.writeInt(getYear());
        dest.writeString(getEngine());
        dest.writeString(getImagePath());
        dest.writeString(getPrice());
    }

    public static final Creator<Car> CREATOR = new Creator<Car>(){
        @Override
        public Car createFromParcel(Parcel source){
            return( new Car(source));
        }
        @Override
        public Car[] newArray(int size){
            return(new Car[size]);
        }
    };
}
