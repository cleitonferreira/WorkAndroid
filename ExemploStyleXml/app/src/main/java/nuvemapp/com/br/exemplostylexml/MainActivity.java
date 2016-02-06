package nuvemapp.com.br.exemplostylexml;

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

        TextView tv = (TextView) findViewById(R.id.txt2);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(25, 25, 25, 25);
        tv.setLayoutParams(lp);
        tv.setTextAppearance(this, R.style.textView2_css);
        tv.setBackgroundResource(R.color.amarelo);
        tv.setPadding(20, 20, 20, 20);
    }
}
