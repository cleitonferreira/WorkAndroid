package nuvemapp.com.br.exemployoutube;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final String API_KEY = "AIzaSyDWmnn0qFJYOV0JWd7pH-kAwEEFfuptIlM";
    private String ID_VIDEO = "OWsyrnOBsJs";
    private YouTubePlayerView youtube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youtube = (YouTubePlayerView) findViewById(R.id.youtube);
        youtube.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean loadAgain) {
        Log.i("Script", "RAIZ 1");
        if(!loadAgain) {
            Log.i("Script", "RAIZ 2");
            youTubePlayer.cueVideo(ID_VIDEO);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "onInitializationFailure()", Toast.LENGTH_SHORT);
    }

    public void callYouTube(View view){
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=OWsyrnOBsJs");
        uri = Uri.parse("vnd.youtube:"+uri.getQueryParameter("v"));

        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }

}
