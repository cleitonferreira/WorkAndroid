package nuvemapp.com.br.exemplosocialauth.domain;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class Image {
	public static void loadImg(final Context context, final String urlImg, final ImageView iv, final ProgressBar pb){
		pb.setVisibility(View.VISIBLE);
		
		new Thread(){
			public void run(){
				Bitmap img = null;
				
				try{
					URL url = new URL(urlImg);
					HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
					InputStream input = conexao.getInputStream();
					img = BitmapFactory.decodeStream(input);
				}
				catch(IOException e){ e.printStackTrace(); }
				
				final Bitmap imgAux = img;
				((Activity) context).runOnUiThread(new Runnable(){
					public void run(){
						pb.setVisibility(View.GONE);
						iv.setImageBitmap(imgAux);
					}
				});
			}
		}.start();
	}

}
