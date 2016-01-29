package nuvemapp.com.br.exemploscrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //ScrollView sv = new ScrollView(this);
        HorizontalScrollView sv = new HorizontalScrollView(this);
        FrameLayout.LayoutParams lpsv = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        sv.setLayoutParams(lpsv);

        LinearLayout ll = new LinearLayout(this);
        //ll.setOrientation(LinearLayout.VERTICAL);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams lpll = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lpll);
        sv.addView(ll);

        for(int i = 0; i < 50; i++){
            TextView tv = new TextView(this);
            tv.setText("Texto Exemplo"+(i+1)+" - ");
            ll.addView(tv);
        }

        setContentView(sv);

    }
}
