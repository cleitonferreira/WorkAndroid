package nuvemapp.com.br.exemplomaterialdesignsearchrecentsuggestions.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.mikepenz.materialdrawer.model.ProfileDrawerItem;


public class Person {
    private ProfileDrawerItem profile;
    private int background;


    public Person(){}

    public ProfileDrawerItem getProfile() {
        return profile;
    }

    public void setProfile(ProfileDrawerItem profile) {
        this.profile = profile;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }
}
