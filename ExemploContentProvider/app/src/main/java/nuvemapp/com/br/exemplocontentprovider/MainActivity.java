package nuvemapp.com.br.exemplocontentprovider;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import nuvemapp.com.br.exemplocontentprovider.adapter.AlunoAdapter;
import nuvemapp.com.br.exemplocontentprovider.database.AlunoDB;
import nuvemapp.com.br.exemplocontentprovider.domain.Aluno;

public class MainActivity extends Activity {
    private static final int SALVAR_ACTIVITY = 1;
    private static final int DETALHES_ACTIVITY = 2;
    private static final int DELETE_OK = 3;

    private ListView listView;
    private AlunoAdapter alunoAdapter;
    private List<Aluno> alunos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAlunosFull();

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(alunoAdapter);
        listView.setOnItemClickListener(new ListView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DetalhesAlunoActivity.class);
                intent.putExtra("aluno", alunos.get(position));

                startActivityForResult(intent, DETALHES_ACTIVITY);
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SALVAR_ACTIVITY || requestCode == DETALHES_ACTIVITY){
            if(resultCode == RESULT_OK || resultCode == DELETE_OK){
                getAlunosFull();
                listView.setAdapter(alunoAdapter);
            }
        }
    }


    public void callActivitySalvarAluno(View view){
        Intent intent = new Intent(MainActivity.this, SalvarAlunoActivity.class);
        startActivityForResult(intent, SALVAR_ACTIVITY);
    }


    public void getAlunosFull(){
        alunos = new ArrayList<Aluno>();

        AlunoDB alunoDb = new AlunoDB(this);
        Cursor cursor = alunoDb.query(null, null, null, null, null);

        if(cursor != null){
            while(cursor.moveToNext()){
                Aluno a = new Aluno();
                a.setId(cursor.getLong(cursor.getColumnIndex(AlunoDB.DB_COL_ID)));
                a.setData(cursor.getString(cursor.getColumnIndex(AlunoDB.DB_COL_DATA)));
                a.setNome(cursor.getString(cursor.getColumnIndex(AlunoDB.DB_COL_NOME)));
                a.setIdade(cursor.getInt(cursor.getColumnIndex(AlunoDB.DB_COL_IDADE)));
                a.setMatricula(cursor.getString(cursor.getColumnIndex(AlunoDB.DB_COL_MATRICULA)));
                a.setTurma(cursor.getString(cursor.getColumnIndex(AlunoDB.DB_COL_TURMA)));
                a.setFaltas(cursor.getInt(cursor.getColumnIndex(AlunoDB.DB_COL_FALTAS)));

                alunos.add(a);
            }
            cursor.close();
        }

        alunoAdapter = new AlunoAdapter(MainActivity.this, alunos);
    }
}
