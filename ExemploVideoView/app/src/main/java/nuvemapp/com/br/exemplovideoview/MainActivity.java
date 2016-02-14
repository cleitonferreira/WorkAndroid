package nuvemapp.com.br.exemplovideoview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File sdcard = android.os.Environment.getExternalStorageDirectory();
        //String path = sdcard.toString();
        //Log.i("Script", path);
        File file = new File(sdcard, "video.mp4");

        VideoView video = new VideoView(this);

        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);
        ll.addView(video);

        //String src = file.getAbsolutePath();
        //video.setVideoPath(src);

        Uri src = Uri.parse("http://www.villopim.com.br/android/video.3gp");
        video.setVideoURI(src);

        video.setMediaController(new MediaController(this));


    }
}
