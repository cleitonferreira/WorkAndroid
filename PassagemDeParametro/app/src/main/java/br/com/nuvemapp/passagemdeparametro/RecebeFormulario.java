package br.com.nuvemapp.passagemdeparametro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class RecebeFormulario extends Activity {

    private static final String TAG = "RecebeFormulario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recebe_formulario);

        Intent intent = getIntent();

        if (intent != null){
            Bundle params = intent.getExtras();
            if (params != null ){
                String nome = params.getString("nome");
                String email = params.getString("email");

                Log.v(TAG, nome.toString());
                Log.v(TAG, email.toString());


                TextView nomeView = (TextView) findViewById(R.id.nomeTexto);
                TextView emailView = (TextView) findViewById(R.id.emailTexto);

                nomeView.setText(nome);
                emailView.setText(email);

            }
        }

    }

}
