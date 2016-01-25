package nuvemapp.com.br.exemplociclovida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String CATEGORIA = "Script";

    //CICLO DE VIDA
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(CATEGORIA, getClassName() + ".onCreate");
    }

    public void onStart(){
        super.onStart();
        Log.i(CATEGORIA, getClassName()+".onStart");
    }

    public void onRestart(){
        super.onRestart();
        Log.i(CATEGORIA, getClassName()+".onRestart");
    }

    public void onResume(){
        super.onResume();
        Log.i(CATEGORIA, getClassName()+".onResume");
    }

    public void onPause(){
        super.onPause();
        Log.i(CATEGORIA, getClassName()+".onPause");
    }

    public void onStop(){
        super.onStop();
        Log.i(CATEGORIA, getClassName()+".onStop");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.i(CATEGORIA, getClassName()+".onDestroy");
    }

    public String getClassName() {
        String aux = getClass().getName();
        return (aux.substring(aux.lastIndexOf(".") + 1));
    }

    public void acessarAtividadeFinal(View view) {
        Intent intent = new Intent(this, Final.class);
        startActivity(intent);
    }

}
