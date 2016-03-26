package nuvemapp.com.br.exemplocountdowntimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MyCountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onResume() {
        super.onResume();

        TextView tv = (TextView) findViewById(R.id.tvCountDownTimer);
        timer = new MyCountDownTimer(this, tv, 5*60*1000, 1000);
        timer.start();
    }

    public void onDestroy() {
        super.onDestroy();

        if (timer != null) {
            timer.cancel();
        }
    }
}
