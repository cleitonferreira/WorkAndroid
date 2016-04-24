package nuvemapp.com.br.exemplocontentprovider;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import nuvemapp.com.br.exemplocontentprovider.database.AlunoDB;
import nuvemapp.com.br.exemplocontentprovider.domain.Aluno;
import nuvemapp.com.br.exemplocontentprovider.util.ImageUtil;

public class DetalhesAlunoActivity extends Activity {
    private static final int SALVAR_ACTIVITY = 1;
    private static final int DELETE_OK = 3;

    private ImageView ivImg;
    private TextView tvNome;
    private TextView tvIdade;
    private TextView tvMatricula;
    private TextView tvTurma;
    private TextView tvFaltas;

    private Aluno aluno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_aluno);

        ivImg = (ImageView) findViewById(R.id.ivImg);

        tvNome = (TextView) findViewById(R.id.tvNome);
        tvIdade = (TextView) findViewById(R.id.tvIdade);
        tvMatricula = (TextView) findViewById(R.id.tvMatricula);
        tvTurma = (TextView) findViewById(R.id.tvTurma);
        tvFaltas = (TextView) findViewById(R.id.tvFaltas);


        if(getIntent().getParcelableExtra("aluno") != null){
            aluno = (Aluno) getIntent().getParcelableExtra("aluno");

            if(aluno.getBitmap() == null){
                aluno.setBitmap(ImageUtil.setPic(Uri.parse(aluno.getData()), 90, 90));
                ivImg.setImageBitmap(BitmapFactory.decodeFile(aluno.getData()));
            }
            else
                ivImg.setImageBitmap(aluno.getBitmap());

            tvNome.setText(Html.fromHtml("<b>Aluno:</b> "+aluno.getNome()));
            tvIdade.setText(Html.fromHtml("<b>Idade:</b> "+aluno.getIdade()));
            tvMatricula.setText(Html.fromHtml("<b>Matricula:</b> "+aluno.getMatricula()));
            tvTurma.setText(Html.fromHtml("<b>Turma:</b> "+aluno.getTurma()));
            tvFaltas.setText(Html.fromHtml("<b>Faltas:</b> "+aluno.getFaltas()));
        }
        else if(getIntent() != null && getIntent().getData() != null){ // CALLED By ACTIVITY
            Uri uri = getIntent().getData();

            aluno = new Aluno();
            aluno.setId(Long.parseLong(uri.getLastPathSegment()));

            AlunoDB alunoDb = new AlunoDB(this);
            Cursor cursor = alunoDb.query(null, null, AlunoDB.DB_COL_ID+" = "+aluno.getId(), null, null);
            if(cursor != null){
                cursor.moveToFirst();

                aluno.setId(cursor.getLong(cursor.getColumnIndex(AlunoDB.DB_COL_ID)));
                aluno.setData(cursor.getString(cursor.getColumnIndex(AlunoDB.DB_COL_DATA)));
                aluno.setNome(cursor.getString(cursor.getColumnIndex(AlunoDB.DB_COL_NOME)));
                aluno.setIdade(cursor.getInt(cursor.getColumnIndex(AlunoDB.DB_COL_IDADE)));
                aluno.setMatricula(cursor.getString(cursor.getColumnIndex(AlunoDB.DB_COL_MATRICULA)));
                aluno.setTurma(cursor.getString(cursor.getColumnIndex(AlunoDB.DB_COL_TURMA)));
                aluno.setFaltas(cursor.getInt(cursor.getColumnIndex(AlunoDB.DB_COL_FALTAS)));

                cursor.close();

                aluno.setBitmap(ImageUtil.setPic(Uri.parse(aluno.getData()), 90, 90));
                ivImg.setImageBitmap(BitmapFactory.decodeFile(aluno.getData()));

                tvNome.setText(Html.fromHtml("<b>Aluno:</b> "+aluno.getNome()));
                tvIdade.setText(Html.fromHtml("<b>Idade:</b> "+aluno.getIdade()));
                tvMatricula.setText(Html.fromHtml("<b>Matricula:</b> "+aluno.getMatricula()));
                tvTurma.setText(Html.fromHtml("<b>Turma:</b> "+aluno.getTurma()));
                tvFaltas.setText(Html.fromHtml("<b>Faltas:</b> "+aluno.getFaltas()));
            }

            // HIDE BUTTONS
            findViewById(R.id.flContainerButtons).setVisibility(View.GONE);
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SALVAR_ACTIVITY && resultCode == RESULT_OK){
            setResult(RESULT_OK);
            finish();
        }
    }


    public void callActivitySalvarAluno(View view){
        Intent intent = new Intent(DetalhesAlunoActivity.this, SalvarAlunoActivity.class);
        intent.putExtra("aluno", aluno);
        startActivityForResult(intent, SALVAR_ACTIVITY);
    }


    public void removerAluno(View view){
        AlunoDB alunoDb = new AlunoDB(this);
        int success = alunoDb.delete(AlunoDB.DB_COL_ID+" = "+aluno.getId(), null);
        alunoDb.close();

        if(success == 1){
            Toast.makeText(DetalhesAlunoActivity.this, "Aluno "+aluno.getNome()+" foi removido com sucesso.", Toast.LENGTH_SHORT).show();
            setResult(DELETE_OK);
            finish();
        }
        else{
            Toast.makeText(DetalhesAlunoActivity.this, "Falhou! Aluno "+aluno.getNome()+" não foi removido.", Toast.LENGTH_SHORT).show();
        }
    }
}
