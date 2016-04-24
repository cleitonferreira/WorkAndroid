package nuvemapp.com.br.exemplocontentprovideralunos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import nuvemapp.com.br.exemplocontentprovideralunos.adapter.AlunoAdapter;
import nuvemapp.com.br.exemplocontentprovideralunos.domain.Aluno;

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


        Uri uriAlunos = Uri.parse("content://nuvemapp.com.br.exemplocontentprovider.aluno.provider/alunos");
        Cursor cursor = getContentResolver().query(uriAlunos, null, null, null, null);

        if(cursor != null){
            while(cursor.moveToNext()){
                Aluno a = new Aluno();
                a.setId(cursor.getLong(cursor.getColumnIndex("_id")));
                a.setData(cursor.getString(cursor.getColumnIndex("_data")));
                a.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                a.setIdade(cursor.getInt(cursor.getColumnIndex("idade")));
                a.setMatricula(cursor.getString(cursor.getColumnIndex("matricula")));
                a.setTurma(cursor.getString(cursor.getColumnIndex("turma")));
                a.setFaltas(cursor.getInt(cursor.getColumnIndex("faltas")));

                Uri uri = Uri.withAppendedPath(uriAlunos, a.getId()+"");
                InputStream inputStream = null;
                try{
                    inputStream = getContentResolver().openInputStream(uri);
                    if(inputStream != null){
                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                        a.setBitmap(bitmap);
                    }
                }
                catch(FileNotFoundException e){ e.printStackTrace(); }
                finally{
                    if(inputStream != null){
                        try{
                            inputStream.close();
                        }
                        catch (IOException e) { e.printStackTrace(); }
                    }
                }

                alunos.add(a);
            }
            cursor.close();
        }

        alunoAdapter = new AlunoAdapter(MainActivity.this, alunos);
    }
}
