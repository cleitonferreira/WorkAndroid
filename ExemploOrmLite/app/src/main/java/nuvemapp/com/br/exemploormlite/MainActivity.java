package nuvemapp.com.br.exemploormlite;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.RawRowMapper;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import nuvemapp.com.br.exemploormlite.cdp.Discipline;
import nuvemapp.com.br.exemploormlite.cdp.Student;
import nuvemapp.com.br.exemploormlite.dao.DatabaseHelper;
import nuvemapp.com.br.exemploormlite.dao.DisciplineDao;
import nuvemapp.com.br.exemploormlite.dao.StudentDao;

public class MainActivity extends Activity {
    private DatabaseHelper dh;
    private StudentDao studentDao;
    private DisciplineDao disciplineDao;
    private List<Student> students;
    private Student s;
    private int firstId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dh = new DatabaseHelper(MainActivity.this);

        students = new ArrayList<Student>();

        s = new Student();
        s.setName("Cleiton Ferreira");
        s.setDisciplines(Arrays.asList(new Discipline("Math", "MT"), new Discipline("History", "HI")));
        students.add(s);

        s = new Student();
        s.setName("Jones");
        s.setDisciplines(Arrays.asList(new Discipline("Geo", "GE"), new Discipline("Arts", "AR")));
        students.add(s);

        try {
            studentDao = new StudentDao(dh.getConnectionSource());
            //studentDao.delete(studentDao.queryForAll());
            disciplineDao = new DisciplineDao(dh.getConnectionSource());

            // CREATE
            for(Student student : students){
                int result = studentDao.create(student);

                if(result == 1){
                    for(Discipline d : student.getDisciplines()){
                        d.setStudent(student);
                        disciplineDao.create(d);
                    }
                    firstId = firstId == 0 ? student.getId() : firstId;
                }
            }

            // GET ALL LINES
            Log.i("Script", " ");
            Log.i("Script", "GET ALL LINES");
            students = studentDao.queryForAll();
            for(Student student : students){
                Log.i("Script", "Name: "+student.getName()+"\nID: "+student.getId()+"\nDisciplines: "+student.getDisciplines().size());
                for(Discipline d : student.getDisciplines()){
                    Log.i("Script", "Discipline: "+d.getName()+"\nID: "+d.getId()+"\nCode: "+d.getCode());
                }

                Discipline d = new Discipline("Portugues", "PT");
                d.setStudent(student);
                disciplineDao.create(d);

                student.setName(student.getName()+" - ANDROID CLASS");
                studentDao.update(student);
            }

            // GET ALL LINES AGAIN
            Log.i("Script", " ");
            Log.i("Script", "GET ALL LINES AGAIN");
            students = studentDao.queryForAll();
            for(Student student : students){
                Log.i("Script", "Name: "+student.getName()+"\nID: "+student.getId()+"\nDisciplines: "+student.getDisciplines().size());
                for(Discipline d : student.getDisciplines()){
                    Log.i("Script", "Discipline: "+d.getName()+"\nID: "+d.getId()+"\nCode: "+d.getCode());
                }
            }

            // GET SPECIFIC LINE BY ID
            Log.i("Script", " ");
            Log.i("Script", "GET SPECIFIC LINE BY ID");
            s = studentDao.queryForId(firstId);
            Log.i("Script", "Name: "+s.getName()+"\nID: "+s.getId()+"\nDisciplines: "+s.getDisciplines().size());
            for(Discipline d : s.getDisciplines()){
                Log.i("Script", "Discipline: "+d.getName()+"\nID: "+d.getId()+"\nCode: "+d.getCode());
            }
            disciplineDao.delete(s.getDisciplines());

            // GET SPECIFIC LINE BY NAME
            Log.i("Script", " ");
            Log.i("Script", "GET SPECIFIC LINE BY NAME");
            Map<String, Object> values = new HashMap<String, Object>();
            values.put("name", "Jones - ANDROID CLASS");
            students = studentDao.queryForFieldValues(values);
            for(Student student : students){
                Log.i("Script", "Name: "+student.getName()+"\nID: "+student.getId()+"\nDisciplines: "+student.getDisciplines().size());
                for(Discipline d : student.getDisciplines()){
                    Log.i("Script", "Discipline: "+d.getName()+"\nID: "+d.getId()+"\nCode: "+d.getCode());

                    disciplineDao.delete(d);
                }
            }

            // GET ALL LINES AGAIN
            Log.i("Script", " ");
            Log.i("Script", "GET ALL LINES AGAIN");
            students = studentDao.queryForAll();
            for(Student student : students){
                Log.i("Script", "Name: "+student.getName()+"\nID: "+student.getId()+"\nDisciplines: "+student.getDisciplines().size());
                for(Discipline d : student.getDisciplines()){
                    Log.i("Script", "Discipline: "+d.getName()+"\nID: "+d.getId()+"\nCode: "+d.getCode());
                }
            }

            // GET ALL LINES AGAIN BY RAW
            Log.i("Script", " ");
            Log.i("Script", "GET ALL LINES AGAIN BY RAW");
            GenericRawResults<Student> raw = studentDao.queryRaw("SELECT id, name FROM student WHERE name LIKE \"Cleiton%\"", new RawRowMapper<Student>(){
                @Override
                public Student mapRow(String[] columnNames, String[] results) throws SQLException {
                    return new Student(Integer.parseInt(results[0]), results[1]);
                }

            });
            for(Student student : raw){
                Log.i("Script", "Name: "+student.getName()+"\nID: "+student.getId());
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        dh.close();
    }
}
