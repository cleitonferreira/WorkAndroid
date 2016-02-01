package nuvemapp.com.br.exemplogridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] lista = new int[]{R.drawable.android_01,R.drawable.android_02, R.drawable.android_03,
                                R.drawable.android_01,R.drawable.android_02, R.drawable.android_03,
                                R.drawable.android_01,R.drawable.android_02, R.drawable.android_03,
                                R.drawable.android_01,R.drawable.android_02, R.drawable.android_03,
                                R.drawable.android_01,R.drawable.android_02, R.drawable.android_03,
                                R.drawable.android_01,R.drawable.android_02, R.drawable.android_03,
                                R.drawable.android_01,R.drawable.android_02, R.drawable.android_03,
                                R.drawable.android_01,R.drawable.android_02, R.drawable.android_03,
                                R.drawable.android_01,R.drawable.android_02, R.drawable.android_03,
                                R.drawable.android_01,R.drawable.android_02, R.drawable.android_03};


       /*
        GridView gv = (GridView) findViewById(R.id.gridView);
        gv.setAdapter(new Adaptador(this, lista));

        gv.setOnItemClickListener(new GridView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Imagem: "+(position+1), Toast.LENGTH_SHORT).show();
            }
        });
        */

        GridView gv = new GridView(this); //(GridView) findViewById(R.id.gridView1);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        gv.setLayoutParams(lp);
        gv.setNumColumns(GridView.AUTO_FIT);
        gv.setColumnWidth((int)getResources().getDimension(R.dimen.sessenta_dp));
        gv.setVerticalSpacing((int)getResources().getDimension(R.dimen.dez_dp));
        gv.setHorizontalSpacing((int)getResources().getDimension(R.dimen.dez_dp));

        gv.setAdapter(new Adaptador(this, lista));

        gv.setOnItemClickListener(new GridView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(getBaseContext(), "Imagem: " + (position + 1), Toast.LENGTH_SHORT).show();
            }

        });

        LinearLayout ll = (LinearLayout) findViewById(R.id.LinearLayout);
        ll.addView(gv);
    }

}
