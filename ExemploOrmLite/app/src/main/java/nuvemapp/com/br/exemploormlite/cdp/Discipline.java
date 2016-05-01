package nuvemapp.com.br.exemploormlite.cdp;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="discipline")
public class Discipline {
	@DatabaseField(generatedId=true)
	private long id;
	
	@DatabaseField
	private String name;
	
	@DatabaseField
	private String code;
	
	@DatabaseField(foreign=true)
	private Student student;
	
	
	public Discipline(){}
	public Discipline(String name, String code){
		this.name = name;
		this.code = code;
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

	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
