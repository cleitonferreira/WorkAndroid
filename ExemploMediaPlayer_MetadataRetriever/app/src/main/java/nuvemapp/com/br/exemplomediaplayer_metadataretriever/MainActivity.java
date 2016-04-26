package nuvemapp.com.br.exemplomediaplayer_metadataretriever;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends Activity implements OnPreparedListener, OnSeekCompleteListener, OnCompletionListener, OnBufferingUpdateListener, OnErrorListener {
    private MediaPlayer player;
    private MediaPlayer nextPlayer;
    private TextView tvTime;
    private long currentTime;
    private long duration;
    private boolean isPlaying;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTime = (TextView) findViewById(R.id.tvTime);

        if(savedInstanceState != null){
            duration = savedInstanceState.getLong("duration");
            currentTime = savedInstanceState.getLong("currentTime");
            isPlaying = savedInstanceState.getBoolean("isPlaying");

            if(isPlaying){
                playMusic(null);
            }
        }
    }


    @Override
    public void onSaveInstanceState(Bundle output){
        super.onSaveInstanceState(output);

        output.putLong("duration", duration);
        output.putLong("currentTime", currentTime);
        output.putBoolean("isPlaying", isPlaying);
    }


    @Override
    public void onPause(){
        super.onPause();
        if(player != null){
            duration = player.getDuration();
            currentTime = player.getCurrentPosition();
        }
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        if(player != null){
            player.stop();
            player.release();
            player = null;
        }
    }


    // ONCLICK LISTENERS
    public void playMusic(View view){
        if(player == null){
            try {
                // RAW
							/*player = MediaPlayer.create(MainActivity.this, R.raw.music);
							player.start();

							Uri uriRaw = Uri.parse("android.resource://"+getPackageName()+"/raw/music");
							Log.i("Script", "PACKAGE: android.resource://"+getPackageName()+"/raw/music");
							accessMetadata(uriRaw);*/

						/*// SDCARD
							File sdCard = Environment.getExternalStorageDirectory();
							File file = new File(sdCard, "Music/music.mp3");
							player = new MediaPlayer();
							player.setDataSource(file.getAbsolutePath().toString());
							player.prepareAsync();

							accessMetadata(file);*/

                // URL
							/*player = new MediaPlayer();
							player.setAudioStreamType(AudioManager.STREAM_MUSIC);
							player.setDataSource("http://www.villopim.com.br/android/Music_02.mp3");
							player.prepareAsync();

							accessMetadata("http://www.villopim.com.br/android/Music_02.mp3");*/

                // ASSETS FOLDER
                AssetFileDescriptor asset = getAssets().openFd("music.mp3");
                player = new MediaPlayer();
                player.setDataSource(asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength());
                player.prepareAsync();




                // NEXT PLAY
                nextPlayer = new MediaPlayer();
                nextPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                nextPlayer.setDataSource("http://www.villopim.com.br/android/Music_01.mp3");
                nextPlayer.prepareAsync();

                // VIDEO VIEW
                VideoView vvVideo = (VideoView) findViewById(R.id.vvVideo);
                vvVideo.setVideoURI(Uri.parse("http://www.villopim.com.br/android/video.3gp"));
                vvVideo.setMediaController(new MediaController(MainActivity.this));
                accessMetadata("http://www.villopim.com.br/android/video.3gp");

                player.setOnBufferingUpdateListener(this);
                player.setOnCompletionListener(this);
                player.setOnErrorListener(this);
                player.setOnPreparedListener(this);
                player.setOnSeekCompleteListener(this);
            }
            catch (IllegalArgumentException e) { e.printStackTrace(); }
            catch (SecurityException e) { e.printStackTrace(); }
            catch (IllegalStateException e) { e.printStackTrace(); }
            catch (IOException e) { e.printStackTrace(); }
        }
        else{
            player.start();
            isPlaying = true;
            updateTimeMusicThread(player, tvTime);
        }
    }


    public void pauseMusic(View view){
        isPlaying = false;
        if(player != null){
            player.pause();
        }
    }


    public void stopMusic(View view){
        isPlaying = false;
        if(player != null){
            player.stop();
            player.release();
            player = null;
            currentTime = 0;
            tvTime.setText("");
        }
    }


    public void updateTimeMusic(final long duration, final long currentTime, final TextView view){
        runOnUiThread(new Runnable(){
            public void run(){
                long aux;
                int minute, second;

                // DURATION
                aux = duration / 1000;
                minute = (int) (aux / 60);
                second = (int) (aux % 60);
                String sDuration = minute < 10 ? "0"+minute : minute+"";
                sDuration += ":"+(second < 10 ? "0"+second : second);

                // CURRENTTIME
                aux = currentTime / 1000;
                minute = (int) (aux / 60);
                second = (int) (aux % 60);
                String sCurrentTime = minute < 10 ? "0"+minute : minute+"";
                sCurrentTime += ":"+(second < 10 ? "0"+second : second);

                view.setText(sDuration +" / "+sCurrentTime);
            }
        });
    }


    public void updateTimeMusicThread(final MediaPlayer mp, final TextView view){
        new Thread(){
            public void run(){
                while(isPlaying){
                    try{
                        updateTimeMusic(mp.getDuration(), mp.getCurrentPosition(), view);
                        Thread.sleep(1000);
                    }
                    catch(IllegalStateException e){ e.printStackTrace(); }
                    catch (InterruptedException e) { e.printStackTrace(); }
                }
            }
        }.start();
    }


    // LISTENERS
    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        //Log.i("Script", "onBufferingUpdate()");
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onPrepared(MediaPlayer mp) {
        Log.i("Script", "onPrepared()");

        isPlaying = true;

        mp.start();
        //mp.setLooping(true);
        mp.setNextMediaPlayer(nextPlayer);
        mp.setVolume(1, 1);
        mp.seekTo((int)currentTime);

        updateTimeMusicThread(mp, tvTime);
    }


    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        Log.i("Script", "onError()");
        return false;
    }


    @Override
    public void onCompletion(MediaPlayer mp) {
        Log.i("Script", "onCompletion()");
    }


    @Override
    public void onSeekComplete(MediaPlayer mp) {
        Log.i("Script", "onSeekComplete()");
    }


    // METADATA
    public void accessMetadata(String link){
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();

        if(Build.VERSION.SDK_INT >= 14){
            retriever.setDataSource(link, new HashMap<String, String>());
        }
        else{
            retriever.setDataSource(link);
        }

        showMetadata(retriever);
    }


    public void accessMetadata(Uri uriRaw){
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();

        retriever.setDataSource(MainActivity.this, uriRaw);

        showMetadata(retriever);
    }


    public void accessMetadata(AssetFileDescriptor asset){
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();

        retriever.setDataSource(asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength());

        showMetadata(retriever);
    }


    public void accessMetadata(File file){
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();

        retriever.setDataSource(file.getAbsolutePath());

        showMetadata(retriever);
    }


    public void showMetadata(MediaMetadataRetriever retriever){
        if(retriever != null){
            Log.i("Script", "METADATA_KEY_ALBUM: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM));
            Log.i("Script", "METADATA_KEY_ALBUMARTIST: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUMARTIST));
            Log.i("Script", "METADATA_KEY_ARTIST: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
            Log.i("Script", "METADATA_KEY_AUTHOR: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_AUTHOR));
            Log.i("Script", "METADATA_KEY_BITRATE: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_BITRATE));
            Log.i("Script", "METADATA_KEY_CD_TRACK_NUMBER: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_CD_TRACK_NUMBER));
            Log.i("Script", "METADATA_KEY_COMPILATION: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_COMPILATION));
            Log.i("Script", "METADATA_KEY_COMPOSER: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_COMPOSER));
            Log.i("Script", "METADATA_KEY_DATE: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DATE));
            Log.i("Script", "METADATA_KEY_DISC_NUMBER: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DISC_NUMBER));
            Log.i("Script", "METADATA_KEY_DISC_NUMBER: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DISC_NUMBER));
            Log.i("Script", "METADATA_KEY_DURATION: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
            Log.i("Script", "METADATA_KEY_GENRE: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE));
            Log.i("Script", "METADATA_KEY_HAS_AUDIO: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_HAS_AUDIO));
            Log.i("Script", "METADATA_KEY_HAS_VIDEO: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_HAS_VIDEO));
            Log.i("Script", "METADATA_KEY_LOCATION: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_LOCATION));
            Log.i("Script", "METADATA_KEY_MIMETYPE: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_MIMETYPE));
            Log.i("Script", "METADATA_KEY_NUM_TRACKS: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_NUM_TRACKS));
            Log.i("Script", "METADATA_KEY_TITLE: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
            Log.i("Script", "METADATA_KEY_YEAR: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_YEAR));
            Log.i("Script", "METADATA_KEY_VIDEO_HEIGHT: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT));
            Log.i("Script", "METADATA_KEY_VIDEO_ROTATION: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION));
            Log.i("Script", "METADATA_KEY_VIDEO_WIDTH: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH));
            Log.i("Script", "METADATA_KEY_WRITER: "+retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_WRITER));


            byte[] imgBytes = retriever.getEmbeddedPicture();
            Bitmap bitmap;
            if(imgBytes != null){
                bitmap = BitmapFactory.decodeByteArray(imgBytes, 0, imgBytes.length);

                ImageView ivImage = (ImageView) findViewById(R.id.ivImage);
                ivImage.setImageBitmap(bitmap);
            }

            //pegar o frame
            bitmap = retriever.getFrameAtTime(14000, MediaMetadataRetriever.OPTION_CLOSEST);
            if(bitmap != null){
                ImageView ivFrame= (ImageView) findViewById(R.id.ivFrame);
                ivFrame.setImageBitmap(bitmap);
            }
        }
    }
}
