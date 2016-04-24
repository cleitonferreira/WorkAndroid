package nuvemapp.com.br.exemplocontentprovideralunos.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

public class ImageUtil {
	public static Bitmap setPic(Uri uriFile, int width, int height) {
	    // Get the dimensions of the View
		    int targetW = width;
		    int targetH = height;

	    // Get the dimensions of the bitmap
		    BitmapFactory.Options bmOptions = new BitmapFactory.Options();
		    bmOptions.inJustDecodeBounds = true;
		    BitmapFactory.decodeFile(uriFile.getPath(), bmOptions);
		    int photoW = bmOptions.outWidth;
		    int photoH = bmOptions.outHeight;

	    // Determine how much to scale down the image
		    int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

	    // Decode the image file into a Bitmap sized to fill the View
		    bmOptions.inJustDecodeBounds = false;
		    bmOptions.inSampleSize = scaleFactor;
		    bmOptions.inPurgeable = true;

	    Bitmap bitmap = BitmapFactory.decodeFile(uriFile.getPath(), bmOptions);
	    return(bitmap);
	}
}
