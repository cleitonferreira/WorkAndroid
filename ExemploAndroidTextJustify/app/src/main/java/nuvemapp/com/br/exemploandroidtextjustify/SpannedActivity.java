package nuvemapp.com.br.exemploandroidtextjustify;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.hyphen.HyphenPattern;
import com.bluejamesbond.text.hyphen.Hyphenator;
import com.bluejamesbond.text.style.TextAlignment;

public class SpannedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spanned);

        LinearLayout llContainer = (LinearLayout) findViewById(R.id.llContainer);
        double sp = getResources().getDisplayMetrics().density * 18 + 0.5f;


        Spannable span = new SpannableStringBuilder("Nesse vídeo apresento a lib TextJustify https://github.com/bluejamesbond/TextJustify-Android que nos permite justificar textos no Android, caracteristica que a principio o Android não nos fornece de forma nativa. A lib é simples de utilizar, trabalhamos no vídeo, no caso, com a view DocumentView que aparenemente herda de TextView, porém não, pois quando utilizamos o Linkify, por exemplo, a instancia de DocumentView não é aceita, se tentarmos o cast (TextView) também não é aceito. A lib pode ser util em casos como resumos de itens do ListView, para texto completo recomendo com o alinhamento a esquerda, pois é mais confortável na leitura. No vídeo é mostrado também que a Lib TextJustify tem uma limitação que pode atrapalhar seu uso, se quisermos colocar textos linkados (facimente conseguido com TextView / Spannable e Linkify) aparenemente não é possível com o uso da lib, mesmo se criarmos os links via SpannableString. Agora é esperar uma atualizava corrigida ou ampliada se essa for mesmo uma limitação da lib. Outra coisa que é possível notar é não funcionamento dos métodos de Hyphen (setHyphenator() e setHyphenated()) se estiver sendo utilizando algum Spannable, provavelmente outra limitação da lib. Então é isso, acredito que para resumos a lib é uma boa escolha, mais por questão de designer mesmo, para texto completo onde provavelmente terá links e emails não recomendo o uso dela.");
        span.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 10, 100, 0);
        span.setSpan(new ForegroundColorSpan(Color.RED), 140, 200, 0);
        span.setSpan(new URLSpan("https://github.com/bluejamesbond/TextJustify-Android"), 0, 4, 0);
        span.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(SpannedActivity.this, "Test", Toast.LENGTH_SHORT).show();
            }
        }, 6, 11, 0);


        Linkify.addLinks(span, Linkify.WEB_URLS);


        DocumentView dvText = new DocumentView(SpannedActivity.this, DocumentView.FORMATTED_TEXT);
        dvText.setText(span);
        dvText.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        dvText.setTextSize((int)sp);

        dvText.getDocumentLayoutParams().setHyphenator(new Hyphenator(HyphenPattern.PT));
        dvText.getDocumentLayoutParams().setHyphenated(true);


        llContainer.addView(dvText);
    }
}
