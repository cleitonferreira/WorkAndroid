package nuvemapp.com.br.exemplocontentprovideralunos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import nuvemapp.com.br.exemplocontentprovideralunos.domain.Aluno;
import nuvemapp.com.br.exemplocontentprovideralunos.util.ImageUtil;

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
        Uri uriAlunos = Uri.parse("content://nuvemapp.com.br.exemplocontentprovider.aluno.provider/alunos");
        uriAlunos = Uri.withAppendedPath(uriAlunos, aluno.getId()+"");
        int success = getContentResolver().delete(uriAlunos, null, null);

        if(success == 1){
            Toast.makeText(DetalhesAlunoActivity.this, "Aluno "+aluno.getNome()+" foi removido com sucesso.", Toast.LENGTH_SHORT).show();
            setResult(DELETE_OK);
            finish();
        }
        else{
            Toast.makeText(DetalhesAlunoActivity.this, "Falhou! Aluno "+aluno.getNome()+" não foi removido.", Toast.LENGTH_SHORT).show();
        }
    }


    public void callDetailsByIntent(View view){
        Uri uriAlunos = Uri.parse("content://nuvemapp.com.br.exemplocontentprovider.aluno.provider/alunos");
        uriAlunos = Uri.withAppendedPath(uriAlunos, aluno.getId()+"");

        Intent intent = new Intent("SHOW_ALUNO_DETAILS", uriAlunos);
        startActivity(intent);
    }
}
