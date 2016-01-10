package nuvemapp.com.br.exemplointentfilter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dispararAcaoTela(View view){

        Intent intent = new Intent("ACAO_TELA");
        startActivity(intent);

    }

    public void dispararAcaoTelaCategoriaTela(View view){

        Intent intent = new Intent("ACAO_TELA");
        intent.addCategory("CATEGORIA_TELA");
        startActivity(intent);

    }

    public void abrirNavegador(View view) {

        Uri uri = Uri.parse("https://www.google.com.br/");

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        startActivity(intent);
    }


}
