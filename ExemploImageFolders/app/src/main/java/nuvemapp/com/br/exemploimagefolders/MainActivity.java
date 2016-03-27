package nuvemapp.com.br.exemploimagefolders;

import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private List<Line> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list = new ArrayList<Line>();
        list.add(new Line(R.drawable.amazon_web_service, "Amazon Web Service"));
        list.add(new Line(R.drawable.android, "Android"));
        list.add(new Line(R.drawable.apple, "Apple"));
        list.add(new Line(R.drawable.behance, "Behance"));
        list.add(new Line(R.drawable.delicious, "Delicious"));
        list.add(new Line(R.drawable.deviantart, "Deviantart"));
        list.add(new Line(R.drawable.drupal, "Drupal"));
        list.add(new Line(R.drawable.facebook, "Facebook"));
        list.add(new Line(R.drawable.git, "Git"));
        list.add(new Line(R.drawable.reddit, "Reddit"));
        list.add(new Line(R.drawable.windows, "Windows"));
        list.add(new Line(R.drawable.you_tube, "You Tube"));


        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new ListAdapter(this, list));
        lv.setOnItemClickListener(new ListView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, list.get(position).getLabel(), Toast.LENGTH_SHORT).show();
            }
        });


        // CÁLCULO DPI
        float scale = getResources().getDisplayMetrics().density;
        int value = (int) (1 * scale + 0.5f);
        Log.i("Script", "DP: "+value);
    }
}



