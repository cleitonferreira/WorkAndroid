package nuvemapp.com.br.exemplowebviewcomjavascript;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.JavascriptInterface;

public class MainActivity extends AppCompatActivity {

    private String url = "http://www.thiengo.com.br/doc/projects/integrando-webview-do-android-com-javascript-web/index.php?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView wv = (WebView) findViewById(R.id.webView);

        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);

        wv.addJavascriptInterface(this, "ExemploWebView");

        wv.loadUrl(url+"apelido=Calopsita");

    }

    @JavascriptInterface
    public void getForm(String nome, String email, String senha){
        Log.i("Script", "Nome: " + nome);
        Log.i("Script", "Email: " + email);
        Log.i("Script", "Senha: " + senha);
    }

}
