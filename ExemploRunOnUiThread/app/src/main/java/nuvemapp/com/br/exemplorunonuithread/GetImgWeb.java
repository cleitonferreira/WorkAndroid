package nuvemapp.com.br.exemplorunonuithread;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by XPredator on 07/02/2016.
 */
public class GetImgWeb {

    private static Bitmap img;

    public static void getImgWeb(final Activity atividade, final ImageView iv) {
        new Thread(){
            public void run(){
                try {

                    URL url = new URL("http://thiengo.com.br/img/system/logo/thiengo-80-80.png");
                    HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                    InputStream input = conexao.getInputStream();
                    img = BitmapFactory.decodeStream(input);

                } catch (IOException e){

                }

                atividade.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iv.setImageBitmap(img);
                    }
                });



            }
        }.start();
    }

}
