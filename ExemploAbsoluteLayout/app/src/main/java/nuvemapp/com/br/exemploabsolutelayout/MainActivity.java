package nuvemapp.com.br.exemploabsolutelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        AbsoluteLayout al = new AbsoluteLayout(this);
        AbsoluteLayout.LayoutParams lp = new AbsoluteLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 0, 0);
        al.setLayoutParams(lp);

        TextView tv = new TextView(this);
        tv.setText("Usuário: ");
        lp = new AbsoluteLayout.LayoutParams(AbsoluteLayout.LayoutParams.WRAP_CONTENT, AbsoluteLayout.LayoutParams.WRAP_CONTENT, (int)getResources().getDimension(R.dimen.dezesseis_dp), (int)getResources().getDimension(R.dimen.vinte_dp));
        tv.setLayoutParams(lp);
        al.addView(tv);

        EditText et = new EditText(this);
        lp = new AbsoluteLayout.LayoutParams((int)getResources().getDimension(R.dimen.cem_dp), AbsoluteLayout.LayoutParams.WRAP_CONTENT, (int)getResources().getDimension(R.dimen.cem_dp), (int)getResources().getDimension(R.dimen.dez_dp));
        et.setLayoutParams(lp);
        al.addView(et);

        setContentView(al);

    }
}
