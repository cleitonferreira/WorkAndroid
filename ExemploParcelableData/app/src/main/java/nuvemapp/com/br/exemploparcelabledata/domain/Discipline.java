package nuvemapp.com.br.exemploparcelabledata.domain;

import android.os.Parcel;
import android.os.Parcelable;


public class Discipline implements Parcelable {
	private long id;
	private String name;
	
	
	public Discipline(long id, String name){
		this.id = id;
		this.name = name;
	}

	public Discipline(Parcel parcel){
		this.id = parcel.readLong();
		this.name = parcel.readString();
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(id);
		dest.writeString(name);
	}
	
	
	public static final Creator<Discipline> CREATOR = new Creator<Discipline>(){

		@Override
		public Discipline createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new Discipline(source);
		}

		@Override
		public Discipline[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Discipline[size];
		}
	};
}
