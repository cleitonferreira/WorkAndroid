package nuvemapp.com.br.exemploormlite.cdp;

import java.util.Collection;

import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

@DatabaseTable(tableName="student")
public class Student {
	@DatabaseField(generatedId=true)
	private int id;
	
	@DatabaseField
	private String name;
	
	@ForeignCollectionField
	private Collection<Discipline> disciplines;
	
	
	public Student(){}
	public Student(int id, String name){
		this.id = id;
		this.name = name;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Collection<Discipline> getDisciplines() {
		return disciplines;
	}
	public void setDisciplines(Collection<Discipline> disciplines) {
		this.disciplines = disciplines;
	}
}
