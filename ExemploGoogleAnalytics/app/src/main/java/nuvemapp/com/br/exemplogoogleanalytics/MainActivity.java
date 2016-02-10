package nuvemapp.com.br.exemplogoogleanalytics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chamarTela(View view) {
        Button bt = (Button) view;

        Intent intent;

        if (bt.getText().toString().equals("Tela 1")){
            EasyTracker.getInstance(this).send(MapBuilder.createEvent("botao", "click", "Abrir Tela 1", 1L).build());
            intent = new Intent(this, Tela1.class);
        } else {
            EasyTracker.getInstance(this).send(MapBuilder.createEvent("botao", "click", "Abrir Tela 2", 2L).build());
            intent = new Intent(this, Tela2.class);
        }

        startActivity(intent);

    }


    @Override
    public void onStart(){
        super.onStart();
        EasyTracker.getInstance(this).activityStart(this);
    }

    @Override
    public void onStop(){
        super.onStop();
        EasyTracker.getInstance(this).activityStop(this);
    }
}
