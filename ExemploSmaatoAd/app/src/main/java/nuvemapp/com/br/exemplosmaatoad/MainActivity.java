package nuvemapp.com.br.exemplosmaatoad;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.smaato.soma.AdDimension;
import com.smaato.soma.AdDownloaderInterface;
import com.smaato.soma.AdListenerInterface;
import com.smaato.soma.AdType;
import com.smaato.soma.AlertBanner;
import com.smaato.soma.AlertBannerStateListener;
import com.smaato.soma.BannerStateListener;
import com.smaato.soma.BannerView;
import com.smaato.soma.BaseView;
import com.smaato.soma.FullScreenBanner;
import com.smaato.soma.ReceivedBannerInterface;
import com.smaato.soma.bannerutilities.constant.BannerStatus;
import com.smaato.soma.exception.AdReceiveFailed;
import com.smaato.soma.exception.ClosingLandingPageFailed;
import com.smaato.soma.internal.requests.settings.UserSettings;
import com.smaato.soma.interstitial.Interstitial;
import com.smaato.soma.interstitial.InterstitialAdListener;

public class MainActivity extends AppCompatActivity {

    public static final int PUBLISHER_ID = 0; // 1100022499
    public static final int ADSPACE_ID = 0; // 0

    private LinearLayout linearLayout;
    private BannerView mBanner;
    private Interstitial mInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        float density = getResources().getDisplayMetrics().density;

        mBanner = new BannerView(MainActivity.this);
        mBanner.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int)(50 * density + 0.5f)));

        linearLayout.addView(mBanner, 3);

        // KEYS
        mBanner.getAdSettings().setPublisherId(PUBLISHER_ID);
        mBanner.getAdSettings().setAdspaceId(ADSPACE_ID);

        // TARGET
        // 1ª
        mBanner.setLocationUpdateEnabled(true);

        // 2ª
//        mBanner.getUserSettings().setLatitude(0);
//        mBanner.getUserSettings().setLongitude(0);
        mBanner.getUserSettings().setAge(24);
        mBanner.getUserSettings().setUserGender(UserSettings.Gender.MALE);
        mBanner.getUserSettings().setKeywordList("android, desenvolvimento web");
        mBanner.getUserSettings().setSearchQuery("JSON no android");

        // LISTENERS
        mBanner.addAdListener(new AdListenerInterface() {
            @Override
            public void onReceiveAd(AdDownloaderInterface adDownloaderInterface, ReceivedBannerInterface banner) throws AdReceiveFailed {
                if(banner.getStatus() == BannerStatus.ERROR) {
                    Log.i("Script", "onReceiveAd():FAIL");
                    mBanner.setVisibility(View.GONE);
                }
                else{
                    Log.i("Script", "onReceiveAd():SUCCESS");
                }
            }
        });

        mBanner.setBannerStateListener(new BannerStateListener() {
            @Override
            public void onWillOpenLandingPage(BaseView baseView) {
                Log.i("Script", "onWillOpenLandingPage()");
            }

            @Override
            public void onWillCloseLandingPage(BaseView baseView) throws ClosingLandingPageFailed {
                Log.i("Script", "onWillCloseLandingPage()");
            }
        });

        // CONFIG
        mBanner.setBackgroundColor(Color.RED);
        mBanner.setAutoReloadEnabled(true);
        mBanner.setAutoReloadFrequency(10);
        mBanner.getAdSettings().setAdType(AdType.ALL);
        mBanner.getAdSettings().setAdDimension(AdDimension.DEFAULT);

        mBanner.asyncLoadNewBanner();

    }

    // LISTENERS
    public void openFullScreenBanner(View view){
        FullScreenBanner mFullScreenBanner = new FullScreenBanner(MainActivity.this);
        mFullScreenBanner.setPublisherId(PUBLISHER_ID);
        mFullScreenBanner.setAdSpaceId(ADSPACE_ID);
        mFullScreenBanner.setAlertBannerStateListener(new AlertBannerStateListener() {
            @Override
            public void onWillLeaveActivity() {
                Log.i("Script", "onWillLeaveActivity()");
            }

            @Override
            public void onWillCancelAlert() {
                Log.i("Script", "onWillCancelAlert()");
            }

            @Override
            public void onWillShowBanner() {
                Log.i("Script", "onWillShowBanner()");
            }
        });

        mFullScreenBanner.asyncLoadNewBanner();

    }

    public void openAlertDialogBanner(View view){
        AlertBanner mAlertBanner = new AlertBanner(MainActivity.this);
        mAlertBanner.setPublisherId(PUBLISHER_ID);
        mAlertBanner.setAdSpaceId(ADSPACE_ID);
        mAlertBanner.setTitle("Test");
        mAlertBanner.setAlertBannerStateListener(new AlertBannerStateListener(){
            @Override
            public void onWillCancelAlert() {
                Log.i("Script", "onWillCancelAlert()");
            }

            @Override
            public void onWillLeaveActivity() {
                Log.i("Script", "onWillLeaveActivity()");
            }

            @Override
            public void onWillShowBanner() {
                Log.i("Script", "onWillShowBanner()");
            }
        });

        mAlertBanner.asyncLoadNewBanner();
    }

    public void openInterstitialBanner(View view){
        mInterstitial = new Interstitial(MainActivity.this);
        mInterstitial.getAdSettings().setPublisherId(PUBLISHER_ID);
        mInterstitial.getAdSettings().setAdspaceId(ADSPACE_ID);
        mInterstitial.setInterstitialAdListener(new InterstitialAdListener(){
            @Override
            public void onFailedToLoadAd() {
                Log.i("Script", "onFailedToLoadAd()");
            }

            @Override
            public void onReadyToShow() {
                Log.i("Script", "onReadyToShow()");
                mInterstitial.show();
            }

            @Override
            public void onWillClose() {
                Log.i("Script", "onWillClose()");
            }

            @Override
            public void onWillOpenLandingPage() {
                Log.i("Script", "onWillOpenLandingPage()");
            }

            @Override
            public void onWillShow() {
                Log.i("Script", "onWillShow()");
            }
        });
        mInterstitial.asyncLoadNewBanner();
    }

}
