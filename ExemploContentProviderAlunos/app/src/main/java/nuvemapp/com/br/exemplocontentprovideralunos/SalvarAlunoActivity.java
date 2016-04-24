package nuvemapp.com.br.exemplocontentprovideralunos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import nuvemapp.com.br.exemplocontentprovideralunos.domain.Aluno;
import nuvemapp.com.br.exemplocontentprovideralunos.util.ImageUtil;

public class SalvarAlunoActivity extends Activity {
    private static final int IMG_SDCARD_ACTIVITY = 4;

    private ImageView ivImg;
    private EditText etNome;
    private EditText etIdade;
    private EditText etMatricula;
    private EditText etTurma;
    private EditText etFaltas;

    private Aluno aluno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salvar_aluno);

        ivImg = (ImageView) findViewById(R.id.ivImg);

        etNome = (EditText) findViewById(R.id.etNome);
        etIdade = (EditText) findViewById(R.id.etIdade);
        etMatricula = (EditText) findViewById(R.id.etMatricula);
        etTurma = (EditText) findViewById(R.id.etTurma);
        etFaltas = (EditText) findViewById(R.id.etFaltas);

        if(getIntent() != null){
            aluno = (Aluno) getIntent().getParcelableExtra("aluno");
            if(aluno != null){
                if(aluno.getBitmap() == null){
                    aluno.setBitmap(ImageUtil.setPic(Uri.parse(aluno.getData()), 90, 90));
                    ivImg.setImageBitmap(BitmapFactory.decodeFile(aluno.getData()));
                }
                else{
                    ivImg.setImageBitmap(aluno.getBitmap());
                }
                ivImg.setContentDescription(aluno.getData());

                etNome.setText(aluno.getNome());
                etIdade.setText(aluno.getIdade()+"");
                etMatricula.setText(aluno.getMatricula());
                etTurma.setText(aluno.getTurma());
                etFaltas.setText(aluno.getFaltas()+"");
            }
        }
    }


    public void salvarAluno(View view){
        ContentValues values = new ContentValues();

        values.put("_data", ivImg.getContentDescription().toString());
        values.put("nome", etNome.getText().toString());
        values.put("idade", Integer.parseInt(etIdade.getText().toString()));
        values.put("matricula", etMatricula.getText().toString());
        values.put("turma", etTurma.getText().toString());
        values.put("faltas", Integer.parseInt(etFaltas.getText().toString()));


        Uri uriAlunos = Uri.parse("content://nuvemapp.com.br.exemplocontentprovider.aluno.provider/alunos");
        long success = 0;
        if(aluno == null){
            uriAlunos = getContentResolver().insert(uriAlunos, values);
            success = Long.parseLong(uriAlunos.getLastPathSegment());
        }
        else{
            uriAlunos = Uri.withAppendedPath(uriAlunos, aluno.getId()+"");
            success = getContentResolver().update(uriAlunos, values, null, null);
        }


        if(success > 0){

            OutputStream out = null;
            try{
                Bitmap bitmap = BitmapFactory.decodeFile((new File(ivImg.getContentDescription().toString()).getPath()));
                out = getContentResolver().openOutputStream(uriAlunos);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, out);
            }
            catch(FileNotFoundException e ){ e.printStackTrace(); }
            finally{
                if(out != null){
                    try {
                        out.close();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


            if(aluno == null)
                Toast.makeText(SalvarAlunoActivity.this, "Aluno adicionado com sucesso, id = "+success, Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(SalvarAlunoActivity.this, "Aluno "+aluno.getNome()+" atualizado com sucesso", Toast.LENGTH_SHORT).show();

            setResult(RESULT_OK);
            finish();
        }
        else{
            Toast.makeText(SalvarAlunoActivity.this, "Falhou!", Toast.LENGTH_SHORT).show();
        }
    }


    public void carregarImagem(View view){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, IMG_SDCARD_ACTIVITY);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        File file;
        String pass = null;

        if(requestCode == IMG_SDCARD_ACTIVITY && resultCode == Activity.RESULT_OK){
            try{
                Uri img = data.getData();
                String[] cols = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(img, cols, null, null, null);
                cursor.moveToFirst();

                int indexCol = cursor.getColumnIndex(cols[0]);
                String imgString = cursor.getString(indexCol);
                cursor.close();

                file = new File(imgString);
                ivImg.setImageBitmap(ImageUtil.setPic(Uri.fromFile(file), 100, 100));
                ivImg.setContentDescription(file.getPath());
                pass = "passou";
            }
            catch(NullPointerException e){ e.printStackTrace(); }
            catch(Exception e){ e.printStackTrace(); }
            finally{
                if(pass == null){
                    ivImg.setImageResource(R.drawable.person);
                    Toast.makeText(SalvarAlunoActivity.this, "Falhou! Tente novamente", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
