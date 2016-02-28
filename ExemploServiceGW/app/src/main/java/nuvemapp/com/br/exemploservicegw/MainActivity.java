package nuvemapp.com.br.exemploservicegw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view) {
        Intent it = new Intent("SERVICO_TEST");
        it.putExtra("aas", "sdvsd");
        startService(it);
    }

    public void stopService(View view) {
        Intent it = new Intent("SERVICO_TEST");
        stopService(it);
    }

}
