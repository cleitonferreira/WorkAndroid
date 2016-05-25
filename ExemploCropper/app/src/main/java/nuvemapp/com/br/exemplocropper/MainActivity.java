package nuvemapp.com.br.exemplocropper;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.edmodo.cropper.CropImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView ivImage;
    private CropImageView mCropImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivImage = (ImageView) findViewById(R.id.ivImage);

        mCropImageView = (CropImageView) findViewById(R.id.mCropImageView);

    }

    // LISTENERS
    // Roatação
    public void rotate(View view) {
        if(view.getId() == R.id.bt0) {
            mCropImageView.setRotation(0f);
        } else if (view.getId() == R.id.bt90) {
            mCropImageView.setRotation(90f);
        } else if (view.getId() == R.id.bt180) {
            mCropImageView.setRotation(180f);
        } else if (view.getId() == R.id.bt270) {
            mCropImageView.setRotation(270f);
        }
    }

    public void statusCropImage(View view) {
        if (view.getId() == R.id.btGrid) {
            mCropImageView.setGuidelines(2); //sempre mostrar
        } else if (view.getId() == R.id.btNoGrid) {
            mCropImageView.setGuidelines(0); //nunca mostrar
        } else {
            Matrix matrix = new Matrix();
            matrix.setRotate(mCropImageView.getRotation());
            Bitmap auxBitmap = Bitmap.createScaledBitmap(mCropImageView.getCroppedImage(),
                    mCropImageView.getCroppedImage().getWidth(),
                    mCropImageView.getCroppedImage().getHeight(),
                    true);

            auxBitmap = Bitmap.createBitmap(auxBitmap, 0, 0, auxBitmap.getWidth(), auxBitmap.getHeight(), matrix, true);

            ivImage.setImageBitmap(auxBitmap);

        }
    }

}
