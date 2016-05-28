package nuvemapp.com.br.exemploonscrolllistener;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import nuvemapp.com.br.exemploonscrolllistener.application.CustomApplication;
import nuvemapp.com.br.exemploonscrolllistener.domain.Car;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if(getIntent() != null && getIntent().getParcelableExtra("car") != null){
            Car car = (Car) getIntent().getParcelableExtra("car");
            ImageLoader imageLoader = ((CustomApplication) getApplication()).getImageLoader();
            ImageView ivImg = (ImageView) findViewById(R.id.ivImg);
            TextView tvDescription = (TextView) findViewById(R.id.tvDescription);

            imageLoader.displayImage(car.getImagePath(), ivImg);
            tvDescription.setText(Html.fromHtml(car.toString()));
        }
        else{
            Toast.makeText(this, "Fail! Try again", Toast.LENGTH_SHORT).show();
        }
    }
}
