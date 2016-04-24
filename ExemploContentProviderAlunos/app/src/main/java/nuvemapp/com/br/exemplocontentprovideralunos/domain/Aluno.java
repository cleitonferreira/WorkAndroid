package nuvemapp.com.br.exemplocontentprovideralunos.domain;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Aluno implements Parcelable {
	private long id;
	private String nome;
	private String matricula;
	private int idade;
	private String turma;
	private int faltas;
	private String data;
	private Bitmap bitmap;
	
	
	public Aluno() {
		super();
	}
	public Aluno(long id, String nome, String matricula, int idade, String turma, int faltas, String data, Bitmap bitmap) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.idade = idade;
		this.turma = turma;
		this.faltas = faltas;
		this.data = data;
		this.bitmap = bitmap;
	}
	public Aluno(Parcel parcel){
		this.id = parcel.readLong();
		this.nome = parcel.readString();
		this.matricula = parcel.readString();
		this.idade = parcel.readInt();
		this.turma = parcel.readString();
		this.faltas = parcel.readInt();
		this.bitmap = (Bitmap) parcel.readValue(Bitmap.class.getClassLoader());
		this.data = parcel.readString();
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	
	
	public int getFaltas() {
		return faltas;
	}
	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	public Bitmap getBitmap() {
		return bitmap;
	}
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
	
	
	// PARCELABLE
		@Override
		public int describeContents() {
			return 0;
		}
		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeLong(id);
			dest.writeString(nome);
			dest.writeString(matricula);
			dest.writeInt(idade);
			dest.writeString(turma);
			dest.writeInt(faltas);
			dest.writeValue(bitmap);
			dest.writeString(data);
			
		}
		public static final Creator<Aluno> CREATOR = new Creator<Aluno>(){
			@Override
			public Aluno createFromParcel(Parcel source) {
				return new Aluno(source);
			}
	
			@Override
			public Aluno[] newArray(int size) {
				return new Aluno[size];
			}
		};
}
