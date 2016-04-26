package nuvemapp.com.br.exemplomediaplayer;

import java.io.File;
import java.io.IOException;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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
        //liberando recursos
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
						/*// RAW
							player = MediaPlayer.create(MainActivity.this, R.raw.music);
							player.start();*/

						/*// SDCARD
							File sdCard = Environment.getExternalStorageDirectory();
							File file = new File(sdCard, "Music/music.mp3");
							player = new MediaPlayer();
							player.setDataSource(file.getAbsolutePath().toString());
							player.prepareAsync();*/

                // URL
							/*player = new MediaPlayer();
							player.setAudioStreamType(AudioManager.STREAM_MUSIC);
							player.setDataSource("http://www.villopim.com.br/android/Music_02.mp3");
							player.prepareAsync();*/

                nextPlayer = new MediaPlayer();
                nextPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                nextPlayer.setDataSource("http://www.villopim.com.br/android/Music_01.mp3");
                nextPlayer.prepareAsync();

                // ASSETS FOLDER
                AssetFileDescriptor asset = getAssets().openFd("music.mp3");
                player = new MediaPlayer();
                player.setDataSource(asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength());
                player.prepareAsync();


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
        //mp.setNextMediaPlayer(nextPlayer);
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
}
