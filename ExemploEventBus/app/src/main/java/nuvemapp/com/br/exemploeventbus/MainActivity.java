package nuvemapp.com.br.exemploeventbus;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


import de.greenrobot.event.EventBus;
import nuvemapp.com.br.exemploeventbus.eventbus.MessageEB;
import nuvemapp.com.br.exemploeventbus.fragment.FragmentBottom;
import nuvemapp.com.br.exemploeventbus.fragment.FragmentTop;
import nuvemapp.com.br.exemploeventbus.service.ServiceTest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EventBus register
        EventBus.getDefault().register(MainActivity.this);

        // Calling Service
        Intent intent = new Intent(MainActivity.this, ServiceTest.class);
        startService(intent);

        // Fragments
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentTop mFragmentTop = new FragmentTop();
        FragmentBottom mFragmentBottom = new FragmentBottom();

        mFragmentTransaction.replace(R.id.llContainerFragmentTop, mFragmentTop);
        mFragmentTransaction.replace(R.id.llContainerFragmentBottom, mFragmentBottom);
        mFragmentTransaction.commit();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

        // Destroying Service
        Intent intent = new Intent(MainActivity.this, ServiceTest.class);
        stopService(intent);

        // EventBus unregister
        EventBus.getDefault().unregister(MainActivity.this);
    }


    // Listeners
    public void askAboutPerson(View view){
        MessageEB m = new MessageEB();
        m.setClassTester(ServiceTest.class+"");

        EventBus.getDefault().post(m);
    }

    public void callSecondActivity(View view){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }


    public void onEventMainThread(MessageEB mMessageEB){
        if(!mMessageEB.getClassTester().equalsIgnoreCase(MainActivity.class+""))
            return;

        Log.i("LOG", "MainActivity.this.onEventMainThread()");

        if(mMessageEB.getList() != null){
            Toast.makeText(MainActivity.this,
                    "Name: "+mMessageEB.getList().get(0).getName()+"\nJob: "+mMessageEB.getList().get(0).getJob(),
                    Toast.LENGTH_SHORT).show();
        }
    }


    public void onEvent(MessageEB mMessageEB){
        if(!mMessageEB.getClassTester().equalsIgnoreCase(MainActivity.class+""))
            return;

        Log.i("LOG", "MainActivity.this.onEvent()");

        if(mMessageEB.getNumber() >= 0){
            Log.i("LOG", "MainActivity.this.onEvent().number: "+mMessageEB.getNumber());
        }

        if(mMessageEB.getText() != null){
            Log.i("LOG", "MainActivity.this.onEvent().text: "+mMessageEB.getText());
        }
    }
}
