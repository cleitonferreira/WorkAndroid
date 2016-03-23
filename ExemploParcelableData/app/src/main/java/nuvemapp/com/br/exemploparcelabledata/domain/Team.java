package nuvemapp.com.br.exemploparcelabledata.domain;

import android.os.Parcel;
import android.os.Parcelable;


public class Team implements Parcelable {
	private String name;
	private int qtdMembers;
	
	
	public Team(String name, int qtdMembers){
		this.name = name;
		this.qtdMembers = qtdMembers;
	}

	public Team(Parcel parcel){
		this.name = parcel.readString();
		this.qtdMembers = parcel.readInt();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getQtdMembers() {
		return qtdMembers;
	}
	public void setQtdMembers(int qtdMembers) {
		this.qtdMembers = qtdMembers;
	}


	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeInt(qtdMembers);
	}
	
	
	public static final Creator<Team> CREATOR = new Creator<Team>(){

		@Override
		public Team createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new Team(source);
		}

		@Override
		public Team[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Team[size];
		}
	};
}
