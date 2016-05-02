package nuvemapp.com.br.exemploexpandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> listGroup;
    private HashMap<String, List<String>> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildList();

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListView.setAdapter(new ExpandableAdapter(MainActivity.this, listGroup, listData));


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Toast.makeText(MainActivity.this, "Grupo: "+groupPosition+"| Item: "+childPosition, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(MainActivity.this, "Grupo (Expand): "+groupPosition, Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(MainActivity.this, "Grupo (Collapse): "+groupPosition, Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setGroupIndicator(getResources().getDrawable(R.drawable.icon_group));
    }

    public void buildList() {
        listGroup = new ArrayList<String>();
        listData = new HashMap<String, List<String>>();

        //GROUP
        listGroup.add("Grupo 1");
        listGroup.add("Grupo 2");
        listGroup.add("Grupo 3");
        listGroup.add("Grupo 4");

        //CHILDREN
        List<String> auxList = new ArrayList<String>();
        auxList.add("Item 1");
        auxList.add("Item 2");
        auxList.add("Item 3");
        auxList.add("Item 4");
        listData.put(listGroup.get(0), auxList);

        auxList = new ArrayList<String>();
        auxList.add("Item 5");
        auxList.add("Item 6");
        auxList.add("Item 7");
        auxList.add("Item 8");
        listData.put(listGroup.get(1), auxList);

        auxList = new ArrayList<String>();
        auxList.add("Item 9");
        auxList.add("Item 10");
        auxList.add("Item 11");
        auxList.add("Item 12");
        listData.put(listGroup.get(2), auxList);

        auxList = new ArrayList<String>();
        auxList.add("Item 13");
        auxList.add("Item 14");
        auxList.add("Item 15");
        auxList.add("Item 16");
        listData.put(listGroup.get(3), auxList);
    }

}
