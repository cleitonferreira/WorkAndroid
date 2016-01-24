package nuvemapp.com.br.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Atividade1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade1);
    }

    public void voltar(View view){
        finish();
    }
}
