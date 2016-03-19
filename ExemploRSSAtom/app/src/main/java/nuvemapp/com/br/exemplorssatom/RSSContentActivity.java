package nuvemapp.com.br.exemplorssatom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class RSSContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsscontent);

        TextView tv = (TextView) findViewById(R.id.tv);
        //tv.setText(getIntent().getExtras().getString("rss"));

        String html = Html.fromHtml(getIntent().getExtras().getString("rss")).toString();
        tv.setText(html);
    }
}
