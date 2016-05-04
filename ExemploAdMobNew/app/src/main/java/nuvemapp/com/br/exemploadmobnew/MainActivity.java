package nuvemapp.com.br.exemploadmobnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private AdView adView_1;
    private AdView adView_2;
    private InterstitialAd interstitial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        adView_1 = new AdView(this);
        adView_1.setAdUnitId("ca-app-pub-2538596252160048/1329783818");
        adView_1.setAdSize(AdSize.BANNER);
        linearLayout.addView(adView_1);

        adView_2 = new AdView(this);
        adView_2.setAdUnitId("ca-app-pub-2538596252160048/1329783818");
        adView_2.setAdSize(AdSize.MEDIUM_RECTANGLE);
        linearLayout.addView(adView_2);

        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId("ca-app-pub-2538596252160048/1329783818");

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("AF8CDE91144F6A31C28629FD2573AB82")
                .build();

        adView_1.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded(){
                Log.i("Script", "onAdLoaded()");
            }
            @Override
            public void onAdFailedToLoad(int error){
                Log.i("Script", "onAdFailedToLoad("+error+")");
            }
            @Override
            public void onAdOpened(){
                Log.i("Script", "onAdOpened()");
            }
            @Override
            public void onAdClosed(){
                Log.i("Script", "onAdClosed()");
            }
            @Override
            public void onAdLeftApplication(){
                Log.i("Script", "onAdLeftApplication()");
            }
        });

        adView_1.loadAd(adRequest);
        adView_2.loadAd(adRequest);
        interstitial.loadAd(adRequest);

    }

    public void segundaTela(View view) {
        Intent intent = new Intent(this, AdMobTest.class);
        startActivity(intent);
    }



    @Override
    public void onResume() {
        super.onResume();
        adView_1.resume();
        adView_2.resume();
    }

    @Override
    public void onStop() {
        super.onStop();
        adView_1.pause();
        adView_2.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        adView_1.destroy();
        adView_2.destroy();
    }

    //LISTENER
    public void showInterstitial(View view) {
        interstitial.show();
    }

}
