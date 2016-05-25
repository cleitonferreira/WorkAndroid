package nuvemapp.com.br.exemploandroidtextjustify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.hyphen.HyphenPattern;
import com.bluejamesbond.text.hyphen.Hyphenator;

public class TextPlainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_plain);

        DocumentView dvText = (DocumentView) findViewById(R.id.dvText);
        dvText.getDocumentLayoutParams().setHyphenator(new Hyphenator(HyphenPattern.PT));
        dvText.getDocumentLayoutParams().setHyphenated(true);
    }
}
