package nuvemapp.com.br.exemplointentservicegw;

import nuvemapp.com.br.exemplointentservicegw.ServicoIntent.Controller;
import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
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

        connection = this;

        bindService(new Intent("SERVICO_INTENT"), connection, Context.BIND_AUTO_CREATE); // Context.BIND_AUTO_CREATE
    }

    public void startService(View view){
        Intent it = new Intent("SERVICO_INTENT");
        startService(it);

    }

    public void stopService(View view){
        Intent it = new Intent("SERVICO_INTENT");
        it.putExtra("desligar", 1);
        startService(it);
        //stopService(it);
        //unbindService(connection);
    }

    public void getCount(View view){
        Toast.makeText(this, "COUNT: "+cl.getCount(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        // TODO Auto-generated method stub
        Controller c = (Controller) service;
        cl = c.getCountListener();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        // TODO Auto-generated method stub

    }
}
