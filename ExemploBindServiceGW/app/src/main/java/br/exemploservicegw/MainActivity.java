package br.exemploservicegw;

import br.exemploservicegw.ServicoConexao.Controller;
import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity implements ServiceConnection {
	private CountListener cl;
	private ServiceConnection connection;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

    @Override
    protected void onDestroy(){
        super.onDestroy();
        stopService(new View(this));
    }
	
	public void startService(View view){
        if(connection == null) {
            connection = this;
            bindService(new Intent("SERVICO_CONEXAO"), connection, Context.BIND_AUTO_CREATE); // Context.BIND_AUTO_CREATE
            Intent it = new Intent("SERVICO_CONEXAO");
            startService(it);
        }
	}
	
	public void stopService(View view){
        if(connection != null) {
            unbindService(connection);
            connection = null;
            Intent it = new Intent("SERVICO_CONEXAO");
            stopService(it);
        }
	}
	
	public void getCount(View view){
		Toast.makeText(this, "COUNT: "+cl.getCount(), Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		// TODO Auto-generated method stub
		Controller c = (Controller) service;
		cl = c.getCountListener();
        Log.i("Script", "onServiceConnected()");
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
        Log.i("Script", "onServiceDisconnected()");
	}
}
