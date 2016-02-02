package nuvemapp.com.br.exemplowebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ll = (LinearLayout) findViewById(R.id.LinearLayout);

       // WebView wv = (WebView) findViewById(R.id.webView);

        for (int i = 0; i < 3; i++) {
            WebView wv = new WebView(this);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            wv.setLayoutParams(lp);

            WebSettings ws = wv.getSettings();
            ws.setJavaScriptEnabled(true);
            ws.setSupportZoom(false);/*recomendado pelo google - zoom = false*/

            //wv.loadUrl("http://g1.globo.com/index.html");

            //wv.loadUrl("http://www.thiengo.com.br/img/system/logo/thiengo-80-80.png");

            String html = "<html>";
            html += "<body>";
            html += "<img src=\"http://www.thiengo.com.br/img/system/logo/thiengo-80-80.png\" style=\"float: left; display: block; margin-right: 10px;\" />";
            html += "<h3 id=\"h3\" style=\"float: left;\">Texto auxiliar "+(i+1)+"</h3>";
            html += "<script type=\"text/javascript\">";
            html += "document.getElementById('h3').style.color = '#ff0000';";
            html += "</script></body></html>";

            wv.loadData(html, "text/html", "UTF-8");

            ll.addView(wv);

        }
    }
}
