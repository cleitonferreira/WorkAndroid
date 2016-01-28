package nuvemapp.com.br.exemploframelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        FrameLayout fl = new FrameLayout(this);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        fl.setLayoutParams(lp);

        TextView tv = new TextView(this);
        tv.setText("Apenas um teste com FrameLayout");
        fl.addView(tv);

        setContentView(fl);

    }

    /*public void enviarFormulario(View view) {
        FrameLayout fl = (FrameLayout) findViewById(R.id.fl2);
        fl.setVisibility(View.VISIBLE);
    }
    */
}
