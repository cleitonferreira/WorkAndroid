package nuvemapp.com.br.exemplofontpersonalizada;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tv = (TextView) findViewById(R.id.textView);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Frijole.ttf");
        tv.setTypeface(font);

        Button bt = (Button) findViewById(R.id.button);
        bt.setTypeface(font);

        EditText et = (EditText) findViewById(R.id.editText);
        et.setTypeface(font);


    }
}
