package nuvemapp.com.br.exemplogoogleanalytics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.Fields;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.Tracker;

public class Tela2 extends AppCompatActivity {

    private GoogleAnalytics instance;
    private Tracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        instance = GoogleAnalytics.getInstance(this);
        tracker = instance.getTracker("UA-73612512-1");
        tracker.set(Fields.SCREEN_NAME, "Tela 2 - Personalizado");
    }

    public void voltarMain(View view) {
        finish();
    }

    @Override
    public void onStart(){
        super.onStart();
        tracker.send(MapBuilder.createAppView().build());
    }
}
