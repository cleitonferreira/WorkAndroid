package nuvemapp.com.br.exemplobutterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity { //implements View.OnClickListener {
    @InjectView(R.id.tvMainTitle) protected TextView tvMainTitle;
    @InjectView(R.id.btCallFragmentTest) protected Button btCallFragmentTest;
    @InjectView(R.id.btCallListTest) protected Button btCallListTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(MainActivity.this);
        tvMainTitle.setText("Example ButterKnife lib");

        /*tvMainTitle = (TextView) findViewById(R.id.tvMainTitle);
        tvMainTitle.setText("Example ButterKnife lib");

        btCallFragmentTest = (Button) findViewById(R.id.btCallFragmentTest);
        btCallListTest = (Button) findViewById(R.id.btCallListTest);

        btCallFragmentTest.setOnClickListener(MainActivity.this);
        btCallListTest.setOnClickListener(MainActivity.this);*/
    }



    @OnClick({R.id.btCallFragmentTest, R.id.btCallListTest})
    public void callOtherEntities(Button v){
        Intent intent;

        if(v.getId() == R.id.btCallFragmentTest){
            intent = new Intent(MainActivity.this, FragmentActivityTest.class);
        }
        else{
            intent = new Intent(MainActivity.this, ListActivityTest.class);
        }
        startActivity(intent);
    }

    /*@Override
    public void onClick(View v) {
        Intent intent;

        if(v.getId() == R.id.btCallFragmentTest){
            intent = new Intent(MainActivity.this, FragmentActivityTest.class);
        }
        else{
            intent = new Intent(MainActivity.this, ListActivityTest.class);
        }
        startActivity(intent);
    }*/
}
