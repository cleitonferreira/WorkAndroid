package nuvemapp.com.br.exemplowebview_monitoramentoinicioefim;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar pb = new ProgressBar(this);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        pb.setLayoutParams(lp);

        final FrameLayout fl = (FrameLayout) findViewById(R.id.frameLayout);

        final WebView wv = (WebView) findViewById(R.id.webView);
        wv.loadUrl("http://www.thiengo.com.br/doc/projects/monitoramento-inicio-e-finalizacao-de-carregamento-de-pagina-no-webview/index.php");


        wv.setWebViewClient(new WebViewClient(){
            //este método é chamado no momento do início/carregamento da página
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){

               /* ProgressBar pb = (ProgressBar) findViewById(R.id.progress);
                pb.setVisibility(View.VISIBLE);
                */

                fl.addView(pb);

            }
            //este método é chamado no momento do fim/carregamento da página
            @Override
            public void onPageFinished(WebView view, String url){

                /*ProgressBar pb = (ProgressBar) findViewById(R.id.progress);
                pb.setVisibility(View.INVISIBLE);
                */

                //remove o ProgressBar
                fl.removeView(pb);

                wv.setVisibility(View.VISIBLE);

            }
        });

    }
}
