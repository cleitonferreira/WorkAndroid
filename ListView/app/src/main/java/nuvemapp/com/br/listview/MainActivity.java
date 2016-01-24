package nuvemapp.com.br.listview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] atividades = new String[]{"Atividade 1", "Atividade 2"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, atividades);

        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(chamaAtividades());
    }

    public AdapterView.OnItemClickListener chamaAtividades() {
        return (new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View view, int position, long id) {
                Intent intent;
                switch (position){
                    case 0:
                        intent = new Intent(getBaseContext(), Atividade1.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getBaseContext(), Atividade2.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    /*public void acessarAtividade1(View view) {
        Intent intent = new Intent(this, Atividade1.class);
        startActivity(intent);
    }

    public void acessarAtividade2(View view) {
        Intent intent = new Intent(this, Atividade2.class);
        startActivity(intent);
    }*/

    public void sair(View view){
        finish();
    }
}
