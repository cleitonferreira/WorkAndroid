package br.exemploservicegw;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class ServicoConexao extends Service implements CountListener {
	private int count;
	private boolean active;
    private Thread thread;

	private Controller controller = new Controller();
	
	public class Controller extends Binder {
		public CountListener getCountListener(){
			return(ServicoConexao.this);
		}
	}
	
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return controller;
	}
	
	@Override
	public void onCreate(){
		super.onCreate();
		//setThread();
		Log.i("Script", "onCreate()");
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId){
		Log.i("Script", "onStartCommand()");
		setThread();
		return(super.onStartCommand(intent, flags, startId));
	}
	
	
	@Override
	public void onDestroy(){
		super.onDestroy();
        Log.i("LOG", "onDestroy()");
        thread.interrupt();
		active = false;
	}
	
	
	public void setThread(){
		count = 0;
		active = true;
		thread = new Thread(new Runnable() {
            public void run () {
                while (active && count < 100) {
                    SystemClock.sleep(1000);

                    count++;
                    Log.i("Script", " count: " + count);
                }
            }
        });
        thread.start();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}
}
