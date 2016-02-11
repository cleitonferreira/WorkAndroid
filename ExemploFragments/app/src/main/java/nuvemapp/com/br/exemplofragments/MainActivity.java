package nuvemapp.com.br.exemplofragments;


import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
    FragmentManager fm = getSupportFragmentManager();
    int lastPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(savedInstanceState == null){
            Fragment1 frag1 = new Fragment1();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.layoutDireito, frag1, "frag1");
            ft.commit();
        }


        String[] lista = new String[]{"Fragment 1",
                "Altera Texto Fragment 1",
                "Fragment 2",
                "Fragment 3"};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);

        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> lv, View view, int position, long id) {

                /*if (position == 1) {
                    Fragment1 frag1 = (Fragment1)fm.findFragmentById(R.id.fragment1);
                    frag1.alteraTextView("Fragment 1 - TextView Alterado");
                }*/

                FragmentTransaction ft = fm.beginTransaction();

                if(position == 0){
                    Fragment1 frag1 = (Fragment1)fm.findFragmentByTag("frag1");

                    if(frag1 == null) {
                        frag1 = new Fragment1();
                    }
                    ft.replace(R.id.layoutDireito, frag1, "frag1");
                }
                else if(position == 1){
                    Fragment1 frag1 = (Fragment1)fm.findFragmentByTag("frag1");
                    ft.replace(R.id.layoutDireito, frag1, "frag1");

                    if(frag1 != null && (lastPosition == 0 || lastPosition == 1)){
                        frag1.alteraTextView("Fragment 1 - TextView Alterado");
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Fragment 1 foi para o topo somente nessa tentativa, na próxima tentativa o texto será alterado.", Toast.LENGTH_LONG).show();
                    }
                }
                else if(position == 2){
                    Fragment2 frag2 = (Fragment2)fm.findFragmentByTag("frag2");

                    if(frag2 == null) {
                        frag2 = new Fragment2();
                    }
                    ft.replace(R.id.layoutDireito, frag2, "frag2");
                }
                else if(position == 3){
                    Fragment3 frag3 = (Fragment3)fm.findFragmentByTag("frag3");

                    if(frag3 == null) {
                        frag3 = new Fragment3();
                    }
                    ft.replace(R.id.layoutDireito, frag3, "frag3");
                }

                ft.addToBackStack("pilha");
                ft.commit();
                lastPosition = position;
            }

        });
    }

}
