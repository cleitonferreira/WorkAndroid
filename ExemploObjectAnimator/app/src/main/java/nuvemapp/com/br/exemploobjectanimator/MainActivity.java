package nuvemapp.com.br.exemploobjectanimator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void efeitoAPI(View view) {
        ImageView img = (ImageView) findViewById(R.id.imageView);

        PropertyValuesHolder animacao1 = PropertyValuesHolder.ofFloat("alpha", 1f, 0f);
        PropertyValuesHolder animacao2 = PropertyValuesHolder.ofFloat("x", 0f, 30f);
        PropertyValuesHolder animacao3 = PropertyValuesHolder.ofFloat("y", 0f, 30f);

        ObjectAnimator anim = ObjectAnimator.ofPropertyValuesHolder(img, animacao1, animacao2, animacao3);
        anim.setDuration(6000);

/*
        ObjectAnimator anim = ObjectAnimator.ofFloat(img, "alpha", 1f, 0f);
        anim.setDuration(2000);
        anim.setRepeatCount(2);
        anim.setRepeatMode(ObjectAnimator.INFINITE);
*/
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation){
                Log.i("Script", "onAnimationEnd()");
            }
            @Override
            public void onAnimationStart(Animator animation){
                Log.i("Script", "onAnimationStart()");
            }
            @Override
            public void onAnimationRepeat(Animator animation){
                Log.i("Script", "onAnimationRepeat()");
            }
        });


        if (flag) {
            anim.start();
        } else {
            anim.reverse();
        }

        flag = !flag;


    }
}
