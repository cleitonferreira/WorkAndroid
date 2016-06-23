package nuvemapp.com.br.exemplomaterialdesignlibfresco.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;


public class Car implements Parcelable {
    public static final String PATH = "http://www.villopim.com.br/android/glide/__w-395-593-790-1185__/";

    private String model;
    private String brand;
    private String description;
    private int category;
    private String tel;
    private int photo;
    private String urlPhoto;

    public Car(){}
    public Car(String m, String b, int p, String up){
        model = m;
        brand = b;
        photo = p;
        urlPhoto = up;
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

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    // PARCELABLE
        public Car(Parcel parcel){
            setModel(parcel.readString());
            setBrand(parcel.readString());
            setDescription(parcel.readString());
            setCategory(parcel.readInt());
            setTel(parcel.readString());
            setPhoto(parcel.readInt());
            setUrlPhoto(parcel.readString());
        }
        @Override
        public int describeContents() {
            return 0;
        }
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString( getModel() );
            dest.writeString( getBrand() );
            dest.writeString( getDescription() );
            dest.writeInt( getCategory() );
            dest.writeString( getTel() );
            dest.writeInt( getPhoto() );
            dest.writeString( getUrlPhoto() );
        }
        public static final Creator<Car> CREATOR = new Creator<Car>(){
            @Override
            public Car createFromParcel(Parcel source) {
                return new Car(source);
            }
            @Override
            public Car[] newArray(int size) {
                return new Car[size];
            }
        };
}
