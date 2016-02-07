package nuvemapp.com.br.exemplorunonuithread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    // 1ª opção para acessa o recurso via internet
    //private Handler handler;
    private Bitmap img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //handler = new Handler();
    }

    public void baixarImg(View view) {
        new Thread(){
            public void run(){
                try {

                    URL url = new URL("http://thiengo.com.br/img/system/logo/thiengo-80-80.png");
                    HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                    InputStream input = conexao.getInputStream();
                    img = BitmapFactory.decodeStream(input);

                } catch (IOException e){

                }

                /*handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ImageView iv = (ImageView) findViewById(R.id.imageView);
                        iv.setImageBitmap(img);
                    }
                });*/

                // 2ª opção para acessa o recurso via internet - método runOnUiThread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ImageView iv = (ImageView) findViewById(R.id.imageView);
                        iv.setImageBitmap(img);
                    }
                });



            }
        }.start();
    }

    // 3ª opção para acessa o recurso via internet
    public void baixarImg2(View view) {
        GetImgWeb.getImgWeb(this, (ImageView) findViewById(R.id.imageView));
    }




}
