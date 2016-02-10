package nuvemapp.com.br.exemploadmob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView ads = new AdView(this, AdSize.BANNER, "ca-app-pub-2538596252160048/7428219818");

        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);
        ll.addView(ads);

        AdRequest request = new AdRequest();
        request.addTestDevice(AdRequest.TEST_EMULATOR);
        ads.loadAd(request);

    }
}
