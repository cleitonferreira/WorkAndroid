package nuvemapp.com.br.exemplospinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] carrosNome = new String[]{"Bugatti Veyron", "Ferrari Laferrari", "Lamborghini Veneno",
            "Maserati Gran Turismo", "Mclaren", "Pagani Zonda", "Porsche 911"};

    private int[] carrosImgs = {R.drawable.bugatti_veyron, R.drawable.ferrari_laferrari, R.drawable.lamborghini_veneno,
            R.drawable.maserati_gran_turismo, R.drawable.mclaren, R.drawable.pagani_zonda,
            R.drawable.porsche_911};

    private Spinner sp;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1ª opção para implementar
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, carrosNome);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //3ª opção para implementar
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.carros, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        iv = (ImageView) findViewById(R.id.imageView);

        //sp = (Spinner) findViewById(R.id.spinner);
        sp = new Spinner(this);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        sp.setLayoutParams(lp);

        sp.setAdapter(adapter);
        //sp.setAdapter(new AdapterCarro(this, carrosNome));

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                iv.setImageResource(carrosImgs[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);
        ll.addView(sp, 1); // 1 - é a posição do elementos do layout

    }

    public void showElemento(View view) {
        String nome = (String) sp.getSelectedItem();
        long id = sp.getSelectedItemId();
        int posicao = sp.getSelectedItemPosition();

        Toast.makeText(this, "Carro: "+ nome +" -> Id: "+ id + " -> Posição: " + posicao, Toast.LENGTH_SHORT).show();
    }
}
