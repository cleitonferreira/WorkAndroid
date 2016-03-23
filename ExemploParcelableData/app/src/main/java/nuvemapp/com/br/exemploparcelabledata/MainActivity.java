package nuvemapp.com.br.exemploparcelabledata;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import nuvemapp.com.br.exemploparcelabledata.domain.Discipline;
import nuvemapp.com.br.exemploparcelabledata.domain.Student;
import nuvemapp.com.br.exemploparcelabledata.domain.Team;

public class MainActivity extends Activity {
    private ArrayList<Student> students;
    private List<Discipline> disciplines;
    private Team team;
    private Student student;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        students = new ArrayList<Student>();

        // Student 1
        disciplines = new ArrayList<Discipline>();
        disciplines.add(new Discipline(1, "Matemática"));
        disciplines.add(new Discipline(2, "Português"));
        team = new Team("Time 1", 15);
        student = new Student("Estudante 1", 18, BitmapFactory.decodeResource(getResources(), R.drawable.student_1), team, disciplines);
        students.add(student);

        // Student 2
        disciplines = new ArrayList<Discipline>();
        disciplines.add(new Discipline(1, "Matemática"));
        disciplines.add(new Discipline(3, "História"));
        team = new Team("Time 2", 15);
        student = new Student("Estudante 2", 17, BitmapFactory.decodeResource(getResources(), R.drawable.student_2), team, disciplines);
        students.add(student);

        // Student 3
        disciplines = new ArrayList<Discipline>();
        disciplines.add(new Discipline(2, "Português"));
        disciplines.add(new Discipline(4, "Geografia"));
        team = new Team("Time 3", 20);
        student = new Student("Estudante 3", 19, BitmapFactory.decodeResource(getResources(), R.drawable.student_3), team, disciplines);
        students.add(student);

        // Student 4
        disciplines = new ArrayList<Discipline>();
        disciplines.add(new Discipline(1, "Matemática"));
        disciplines.add(new Discipline(2, "Português"));
        team = new Team("Time 4", 16);
        student = new Student("Estudante 4", 16, BitmapFactory.decodeResource(getResources(), R.drawable.student_4), team, disciplines);
        students.add(student);

        // Student 5
        disciplines = new ArrayList<Discipline>();
        disciplines.add(new Discipline(5, "Inglês"));
        disciplines.add(new Discipline(6, "Estudos Sociais"));
        team = new Team("Time 5", 9);
        student = new Student("Estudante 5", 16, BitmapFactory.decodeResource(getResources(), R.drawable.student_5), team, disciplines);
        students.add(student);
    }


    public void callClass(View view){
        Intent it = new Intent(this, ClassActivity.class);
        it.putParcelableArrayListExtra("students", students);
        startActivity(it);
    }


}
