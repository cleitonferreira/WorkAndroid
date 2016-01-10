package br.com.nuvemapp.exemloactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        Intent intent = getIntent();
        if (intent != null){
            Bundle params = intent.getExtras();
            if (params != null){
                String nome = params.getString("nome");
                String email = params.getString("email");

                Log.v("Nome: ", nome);
                Log.v("Email: ", email);

                TextView nomeTV = (TextView) findViewById(R.id.nomeTela2);
                TextView emailTV = (TextView) findViewById(R.id.emailTela2);

                nomeTV.setText("Nome: "+nome);
                emailTV.setText("Email: "+email);
            }
        }

    }


    public void aceitou(View view){
        Intent intent = new Intent();
        intent.putExtra("msg", "Aceitou");

        setResult(1, intent);
        finish();
    }

    public void rejeitou(View view){
        Intent intent = new Intent();
        intent.putExtra("msg", "Rejeitou");

        setResult(2, intent);
        finish();
    }
}
