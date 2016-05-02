package nuvemapp.com.br.exemplodialogfragment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDialogFragment(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        CustomDialogFragment cdf = new CustomDialogFragment(1, 2);
//        CustomDialogFragment cdf = new CustomDialogFragment(2, 1);
//        CustomDialogFragment cdf = new CustomDialogFragment(3, 3);
        CustomDialogFragment cdf = new CustomDialogFragment(3, 2);
        cdf.show(ft, "dialog");
    }

    public void turnOffDialogFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        CustomDialogFragment cdf = (CustomDialogFragment) getSupportFragmentManager().findFragmentByTag("dialog");
        if (cdf != null) {
            cdf.dismiss();
            ft.remove(cdf);
        }
    }

}
