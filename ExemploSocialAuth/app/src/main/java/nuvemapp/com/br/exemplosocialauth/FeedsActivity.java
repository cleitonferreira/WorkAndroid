package nuvemapp.com.br.exemplosocialauth;

import java.util.ArrayList;
import java.util.List;

import org.brickred.socialauth.Feed;
import org.brickred.socialauth.android.DialogListener;
import org.brickred.socialauth.android.SocialAuthAdapter;
import org.brickred.socialauth.android.SocialAuthAdapter.Provider;
import org.brickred.socialauth.android.SocialAuthError;
import org.brickred.socialauth.android.SocialAuthListener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import nuvemapp.com.br.exemplosocialauth.adapter.FeedsAdapter;

public class FeedsActivity extends Activity {
    private SocialAuthAdapter socialAuth;
    private ListView listView;
    private ProgressBar pbLoad;
    private List<Feed> listFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);

        socialAuth = new SocialAuthAdapter(new ResponseListener());
        socialAuth.authorize(FeedsActivity.this, Provider.LINKEDIN);

        listFeed = new ArrayList<Feed>();

        // VIEWS
        pbLoad = (ProgressBar) findViewById(R.id.pbLoad);
        listView = (ListView) findViewById(R.id.listView);
    }


    // SOCIAL AUTH CLASS
    public class ResponseListener implements DialogListener{
        @Override
        public void onComplete(Bundle values) {
            socialAuth.getFeedsAsync(new FeedDataListener());
        }

        @Override
        public void onBack() {}

        @Override
        public void onCancel() {}

        @Override
        public void onError(SocialAuthError error) {
            Log.i("Script", error.getMessage());
        }
    }


    public class FeedDataListener implements SocialAuthListener<List<Feed>> {
        @Override
        public void onExecute(String plataform, List<Feed> data) {
            if(data != null){

                for(Feed f : data){
                    listFeed.add(f);
                }

                pbLoad.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                listView.setAdapter(new FeedsAdapter(FeedsActivity.this, listFeed));
            }
        }

        @Override
        public void onError(SocialAuthError error) {
            Log.i("Script", error.getMessage());
        }
    }
}
