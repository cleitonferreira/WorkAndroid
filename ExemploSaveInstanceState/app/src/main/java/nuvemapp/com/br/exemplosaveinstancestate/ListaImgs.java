package nuvemapp.com.br.exemplosaveinstancestate;

import java.io.Serializable;
import java.util.ArrayList;

import android.graphics.Bitmap;

public class ListaImgs implements Serializable {
	public ArrayList<Bitmap> imgs;
	public static final String KEY = "imagens";
	
	public ListaImgs(ArrayList<Bitmap> imgs){
		this.imgs = imgs;
	}
}
