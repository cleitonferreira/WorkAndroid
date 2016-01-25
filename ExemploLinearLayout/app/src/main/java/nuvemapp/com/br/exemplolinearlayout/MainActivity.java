package nuvemapp.com.br.exemplolinearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);

        TextView tv1 = new TextView(this);
        tv1.setText("Texto 21");
        ll.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText("Texto 22");
        ll.addView(tv2);

        setContentView(ll);
        */
    }
}
