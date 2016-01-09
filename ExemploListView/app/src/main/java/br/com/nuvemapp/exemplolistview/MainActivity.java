package br.com.nuvemapp.exemplolistview;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<HashMap<String, String>> carros = new ArrayList<HashMap<String, String>>();

        for (int i=0; i < 10; i++){
            //carros[i] = "Carro "+ (i+1);

            HashMap<String, String> carro = new HashMap<String, String>();
            carro.put("carro", "Carro "+(i +1));
            carro.put("marca", "Marca "+(i +1));

            carros.add(carro);
        }

        String[] from = new String[]{"carro", "marca"};

        int layout = R.layout.carros;

        int[] to = new int[]{R.id.t1, R.id.t2};



        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new SimpleAdapter(this, carros, layout, from, to));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
