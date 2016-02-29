package nuvemapp.com.br.exemplolinkify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t1 = (TextView) findViewById(R.id.t1);
        Linkify.addLinks(t1, Linkify.ALL);

        TextView t2 = (TextView) findViewById(R.id.t2);
        Linkify.addLinks(t2, Linkify.EMAIL_ADDRESSES);

        TextView t3 = (TextView) findViewById(R.id.t3);
        Linkify.addLinks(t3, Linkify.MAP_ADDRESSES);

        TextView t4 = (TextView) findViewById(R.id.t4);
        Linkify.addLinks(t4, Linkify.PHONE_NUMBERS);

        TextView t5 = (TextView) findViewById(R.id.t5);
        Linkify.addLinks(t5, Linkify.WEB_URLS);

        Pattern p1 = Pattern.compile("(clicar aqui funciona)");
        TextView t6 = (TextView) findViewById(R.id.t6);
        Linkify.addLinks(t6, p1, "http://g1.globo.com/");


        Linkify.TransformFilter tf = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher match, String url) {
                return ("futebol/times/vasco/");
            }
        };

        Linkify.MatchFilter mf = new Linkify.MatchFilter() {
            @Override
            public boolean acceptMatch(CharSequence s, int start, int end) {
                if (start > 1000) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        TextView t7 = (TextView) findViewById(R.id.t7);
        Linkify.addLinks(t7, p1, "http://globoesporte.globo.com/", mf, tf);

    }
}
