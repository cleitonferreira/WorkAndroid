package nuvemapp.com.br.exemplointentfilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
    }

    public void voltarTela2(View view) {
        finish();
    }
}
