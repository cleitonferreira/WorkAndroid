package br.com.nuvemapp.exemloactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Tela1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        Intent intent = getIntent();
        if (intent != null){
            Bundle params = intent.getExtras();
            if (params != null){
                String nome = params.getString("nome");
                String email = params.getString("email");

                Log.v("Nome: ", nome);
                Log.v("Email: ", email);

                TextView nomeTV = (TextView) findViewById(R.id.nomeTela1);
                TextView emailTV = (TextView) findViewById(R.id.emailTela1);

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
