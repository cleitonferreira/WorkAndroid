package nuvemapp.com.br.exemplocountdowntimer;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by XPredator on 25/03/2016.
 */
public class MyCountDownTimer extends CountDownTimer {
    private Context context;
    private TextView tv;
    private long millisInFuture;
    private long countDownInterval;

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public MyCountDownTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    public MyCountDownTimer(Context context, TextView tv, long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.context = context;
        this.tv = tv;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        Log.i("Script", "Timer: "+millisUntilFinished);
        millisInFuture = millisUntilFinished;
        tv.setText(getCorrentcTimer(true, millisUntilFinished) + ":" + getCorrentcTimer(false, millisUntilFinished));
    }

    @Override
    public void onFinish() {
        millisInFuture -= 1000;
        tv.setText(getCorrentcTimer(true, millisInFuture) + ":" + getCorrentcTimer(false, millisInFuture));

        Toast.makeText(context, "FINISH!", Toast.LENGTH_SHORT).show();
    }

    private String getCorrentcTimer(boolean isMinute, long millisUntilFinished) {
        String aux;
        int constCalendar = isMinute ? Calendar.MINUTE : Calendar.SECOND;
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millisUntilFinished);

        aux = c.get(constCalendar) < 10 ? "0"+c.get(constCalendar) : ""+c.get(constCalendar);
        return aux;
    }
}
