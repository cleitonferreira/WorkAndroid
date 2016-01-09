package br.com.nuvemapp.passagemdeparametro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void enviarFormulario(View view){
        EditText nome = (EditText) findViewById(R.id.txtNome);
        EditText email = (EditText) findViewById(R.id.txtEmail);

        Bundle params = new Bundle();
        params.putString("nome", nome.getText().toString());
        params.putString("email", email.getText().toString());

        Intent intent = new Intent(this, RecebeFormulario.class);
        intent.putExtras(params);

        startActivity(intent);
    }



}
