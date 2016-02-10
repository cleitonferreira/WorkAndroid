package nuvemapp.com.br.exemploviewpersonalizada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EmailText et;
    private Quadrado quadrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*et = new EmailText(this);
        et.setHint("Coloque um email aqui");

        quadrado = new Quadrado(this);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        quadrado.setLayoutParams(lp);

        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);
        ll.addView(et);
        ll.addView(quadrado); */

    }

    public void verificarEmail(View view) {

        et = (EmailText) findViewById(R.id.email);

        if (et.isEmail()) {
            Toast.makeText(this, "Sim", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Não", Toast.LENGTH_SHORT).show();
        }


    }

}
