package nuvemapp.com.br.exemplologcat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String CATEGORIA = "Script";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("Script", "Verbose - Preto");
        Log.d("Script", "Debug - Azul");
        Log.i("Script", "Informação - Verde");
        Log.w("Script", "Alerta - Laranja");
        Log.e("Script", "Erro - Vermelho");

        //Erro
       // int i = 2 / 0;

        Log.e(CATEGORIA, "Teste");

    }
}
