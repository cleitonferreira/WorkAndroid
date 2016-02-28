package nuvemapp.com.br.exemplohaptico;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText email;
    private EditText senha;
    private Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (EditText) findViewById(R.id.nome);
        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.senha);
        bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                // código de processamento
                Toast.makeText(MainActivity.this, "Resposta servidor", Toast.LENGTH_LONG).show();
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(100);
            }
        });

        // PERSONALIZADO
        nome.setOnTouchListener(new HapticoPersonalizado());
        email.setOnTouchListener(new HapticoPersonalizado());
        senha.setOnTouchListener(new HapticoPersonalizado());



        // CUSTOMIZADO
        /*nome.setOnTouchListener(new HapticoNativo());
        email.setOnTouchListener(new HapticoNativo());
        senha.setOnTouchListener(new HapticoNativo());*/

    }

    public class HapticoPersonalizado implements View.OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent event) {

            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);

            view.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, 0);

            return true;
        }
    }

    public class HapticoNativo implements View.OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent event) {

            view.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP);

            view.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, 0);

            return true;
        }
    }
}

