package nuvemapp.com.br.exemploimageview;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadImg(View view){

        new Thread(){
            public void run(){
                Bitmap img = null;

                try{
                    URL url = new URL("http://www.thiengo.com.br/img/system/logo/thiengo-80-80.png");
                    HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                    InputStream input = conexao.getInputStream();
                    img = BitmapFactory.decodeStream(input);
                }
                catch(IOException e){}

                final Bitmap imgAux = img;
                handler.post(new Runnable(){
                    public void run(){
                        ImageView iv = new ImageView(getBaseContext());
                        iv.setImageBitmap(imgAux);

                        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);
                        ll.addView(iv);
                    }
                });
            }
        }.start();
    }

}
