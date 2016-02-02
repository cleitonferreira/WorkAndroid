package nuvemapp.com.br.exemplogallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] carros = {R.drawable.ferrari_laferrari, R.drawable.bugatti_veyron, R.drawable.lamborghini_veneno,
                        R.drawable.maserati_gran_turismo, R.drawable.mclaren, R.drawable.pagani_zonda, R.drawable.porsche_911};

        //Gallery ga = (Gallery) findViewById(R.id.gallery);

        Gallery ga = new Gallery(this);
        Gallery.LayoutParams lp = new Gallery.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ga.setLayoutParams(lp);
        ga.setAdapter(new AdapterImgs(this, carros));

        ga.setOnItemClickListener(new Gallery.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Widget "+(position + 1), Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);
        ll.addView(ga);



    }
}
