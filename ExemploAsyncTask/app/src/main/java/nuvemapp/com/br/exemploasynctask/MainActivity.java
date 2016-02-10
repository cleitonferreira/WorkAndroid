package nuvemapp.com.br.exemploasynctask;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements TarefaInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void baixarImagem(View view) {

        Tarefa tarefa = new Tarefa(this, this);
        tarefa.execute("http://www.thiengo.com.br/img/system/logo/thiengo-80-80.png", "teste");

       /* final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Carregando imagem...");
        progressDialog.show();

        new Thread() {
            public void run() {
                Bitmap img = null;

                try {
                    URL url = new URL("http://www.thiengo.com.br/img/system/logo/thiengo-80-80.png");
                    HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                    InputStream input = conexao.getInputStream();
                    img = BitmapFactory.decodeStream(input);
                } catch (IOException e) {
                }

                final Bitmap imgAux = img;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.setMessage("Imagem carregada!");
                        ImageView iv = (ImageView) findViewById(R.id.imageView);
                        iv.setImageBitmap(imgAux);
                        progressDialog.dismiss();
                    }
                });

            }
        }.start();
        */

    }


    @Override
    public void depoisDownload(Bitmap bitmap) {
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageBitmap(bitmap);
    }
}
