package nuvemapp.com.br.exemplocrouton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import nuvemapp.com.br.exemplocrouton.adapter.ContactsAdapter;
import nuvemapp.com.br.exemplocrouton.domain.Contact;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvContacts;
    private ContactsAdapter adapter;
    private List<Contact> list;
    private Random rand;
    private Crouton crouton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rand = new Random();

        // Adapter
        list = new ArrayList<Contact>();
        list.add(new Contact("Contact 1", R.drawable.contact1, 1 + rand.nextInt(10)));
        list.add(new Contact("Contact 2", R.drawable.contact2, 1 + rand.nextInt(10)));
        list.add(new Contact("Contact 3", R.drawable.contact3, 1 + rand.nextInt(10)));
        list.add(new Contact("Contact 4", R.drawable.contact4, 1 + rand.nextInt(10)));
        list.add(new Contact("Contact 5", R.drawable.contact5, 1 + rand.nextInt(10)));
        list.add(new Contact("Contact 6", R.drawable.contact6, 1 + rand.nextInt(10)));
        list.add(new Contact("Contact 7", R.drawable.contact7, 1 + rand.nextInt(10)));
        list.add(new Contact("Contact 8", R.drawable.contact8, 1 + rand.nextInt(10)));
        list.add(new Contact("Contact 9", R.drawable.contact9, 1 + rand.nextInt(10)));
        list.add(new Contact("Contact 10", R.drawable.contact10, 1 + rand.nextInt(10)));

        adapter = new ContactsAdapter(MainActivity.this, list);

        lvContacts = (ListView) findViewById(R.id.lvContacts);
        lvContacts.setAdapter(adapter);
        lvContacts.setOnItemClickListener(MainActivity.this);
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        Crouton.cancelAllCroutons();
    }


    // LISTENER
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(crouton != null){
            crouton.hide();
        }


            /*Toast.makeText(MainActivity.this, "Contato \""+list.get(position).getName()+"\" bloqueado temporariamente.", Toast.LENGTH_SHORT)
                    .show();*/

        Style style = new Style.Builder()
                .setBackgroundColorValue(Color.BLACK)
                .setConfiguration(new Configuration.Builder().setDuration(Configuration.DURATION_INFINITE).build())
                .build();

        crouton = Crouton.makeText(MainActivity.this, "Contato \""+list.get(position).getName()+"\" bloqueado temporariamente.", Style.INFO)
                .setConfiguration(new Configuration.Builder().setDuration(1000).build());
            /*crouton = Crouton.makeText(MainActivity.this, R.string.big_text, style);*/
        crouton.show();
    }

}
