package nuvemapp.com.br.exemplosaveinstancestate;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

        private Handler handler = new Handler();
        private ArrayList<Bitmap> imgs = new ArrayList<Bitmap>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            // savedInstanceState não for nulo, pegamos os dados Serializable da classe
            if(savedInstanceState != null){
                ListaImgs li = (ListaImgs) savedInstanceState.getSerializable(ListaImgs.KEY);
                imgs = li.imgs;
            }


            if(imgs == null || imgs.size() == 0){
                Log.i("Script", "Entrei 1");
                loadImg();
            }
            else{
                Log.i("Script", "Entrei 2");
                buildImgs();
            }
        }

        // Este método é chamado depois do onStart()
        @Override
        protected void onRestoreInstanceState(Bundle savedInstanceState) {

        }


        // BAIXA AS IMGS DA WEB
    public void loadImg(){

        new Thread(){
            public void run(){

                try{
                    for(int i = 0; i < 30; i++){
                        URL url = new URL("http://www.thiengo.com.br/img/system/logo/thiengo-80-80.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        imgs.add(BitmapFactory.decodeStream(input));
                    }
                }
                catch(IOException e){}

                handler.post(new Runnable(){
                    public void run(){
                        buildImgs();
                    }
                });
            }
        }.start();
    }


    // COLOCA AS IMGS NO LAYOUT
    public void buildImgs(){
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);

        for(int i = 0; i < imgs.size(); i++){
            ImageView iv = new ImageView(getBaseContext());
            iv.setImageBitmap(imgs.get(i));
            ll.addView(iv);
        }
    }

    //Melhora a performace e otimiza o app
    // pois não precisa consumir novamente os arquivos da web
    @Override
    protected void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);

        bundle.putSerializable(ListaImgs.KEY, new ListaImgs(imgs));
    }

}

