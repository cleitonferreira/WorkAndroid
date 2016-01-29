package nuvemapp.com.br.exemplotablelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        TableLayout tl = new TableLayout(this);
        TableLayout.LayoutParams lp = new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tl.setLayoutParams(lp);

        TableRow tr = new TableRow(this);
        tl.addView(tr);

        TextView tv = new TextView(this);
        tv.setText("Teste 1");
        tr.addView(tv);

        setContentView(tl);

    }
}
