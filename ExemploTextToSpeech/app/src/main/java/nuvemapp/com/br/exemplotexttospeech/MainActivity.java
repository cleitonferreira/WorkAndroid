package nuvemapp.com.br.exemplotexttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = (Button) findViewById(R.id.button);
        tts = new TextToSpeech(this, this);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            bt.setEnabled(true);
        }
    }

    public void falarMeuTexto(View view) {
        EditText et = (EditText) findViewById(R.id.editText);
        Log.i("Script", "Máximo: " + TextToSpeech.getMaxSpeechInputLength());

        int codigo = tts.isLanguageAvailable(new Locale("pt", "BR"));
        if (codigo == TextToSpeech.LANG_AVAILABLE){
            tts.setLanguage(new Locale("pt", "BR"));
        } else {
            Toast.makeText(this, "Código: "+codigo, Toast.LENGTH_SHORT).show();
        }

        /*tts.speak("Hello", tts.QUEUE_ADD, null);
        tts.speak("House", tts.QUEUE_ADD, null);
        tts.speak("Dog", tts.QUEUE_ADD, null);
        tts.speak("Cat", tts.QUEUE_FLUSH, null);*/
        tts.speak(et.getText().toString(), tts.QUEUE_FLUSH, null);

        File f = android.os.Environment.getExternalStorageDirectory();
        tts.synthesizeToFile(et.getText().toString(), null, f.getAbsolutePath()+"/meuTexto.wav");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        tts.shutdown();
    }
}
