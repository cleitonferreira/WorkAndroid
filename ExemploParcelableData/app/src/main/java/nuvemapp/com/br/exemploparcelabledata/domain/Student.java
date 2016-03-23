package nuvemapp.com.br.exemploparcelabledata.domain;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
	private String name;
	private int age;
	private Bitmap image;
	private Team team;
	private List<Discipline> disciplines;
	
	
	public Student(String name, int age, Bitmap image, Team team, List<Discipline> disciplines){
		this.name = name;
		this.age = age;
		this.image = image;
		this.team = team;
		this.disciplines = disciplines;
	}
	//Novo construtor
	public Student(Parcel parcel){
		this.name = parcel.readString();
		this.age = parcel.readInt();
		this.image = (Bitmap) parcel.readValue(Bitmap.class.getClassLoader());
		this.team = (Team) parcel.readValue(Team.class.getClassLoader());
		this.disciplines = new ArrayList<Discipline>();
		parcel.readList(this.disciplines, Discipline.class.getClassLoader());
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public Bitmap getImage() {
		return image;
	}
	public void setImage(Bitmap image) {
		this.image = image;
	}
	
	
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}


	public List<Discipline> getDisciplines() {
		return disciplines;
	}
	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
	}
	public String getDisciplinesAsString() {
		String aux = "";
		for(int i = 0, tam = disciplines.size(); i < tam; i++){
			aux += disciplines.get(i).getName()+" ("+disciplines.get(i).getId()+"); ";
		}
		return aux;
	}


	@Override
	public int describeContents() {
		return 0;
	}


	// Tem a mesma função de serializar um objeto
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeInt(age);
		dest.writeValue(image);
		dest.writeValue(team);
		dest.writeList(disciplines);
	}
	
	//responsavel de crear nosso objeto Student
	public static final Creator<Student> CREATOR = new Creator<Student>(){

		@Override
		public Student createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new Student(source);
		}

		@Override
		public Student[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Student[size];
		}
	};
}
