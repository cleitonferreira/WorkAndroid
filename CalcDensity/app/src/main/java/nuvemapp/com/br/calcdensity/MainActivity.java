package nuvemapp.com.br.calcdensity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView etLdpi;
    private TextView etMdpi;
    private TextView etHdpi;
    private TextView etXhdpi;
    private TextView etXxhdpi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLdpi = (TextView) findViewById(R.id.ldpi);
        etMdpi = (TextView) findViewById(R.id.mdpi);
        etHdpi = (TextView) findViewById(R.id.hdpi);
        etXhdpi = (TextView) findViewById(R.id.xhdpi);
        etXxhdpi = (TextView) findViewById(R.id.xxhdpi);
    }

    public void calculateDp(View view) {
        EditText et = (EditText) findViewById(R.id.editText);
        int dp = Integer.parseInt(et.getText().toString());
        //final float scale = getResources().getDisplayMetrics().density;

        int ldpi = (int) (dp * 0.75 + 0.5f);
        int mdpi = (int) (dp * 1 + 0.5f);
        int hdpi = (int) (dp * 1.5 + 0.5f);
        int xhdpi = (int) (dp * 2 + 0.5f);
        int xxhdpi = (int) (dp * 3 + 0.5f);

        etLdpi.setText(Html.fromHtml("LDPI: <b>"+ldpi+"px</b>"));
        etMdpi.setText(Html.fromHtml("MDPI: <b>"+mdpi+"px</b>"));
        etHdpi.setText(Html.fromHtml("HDPI: <b>"+hdpi+"px</b>"));
        etXhdpi.setText(Html.fromHtml("X-HDPI: <b>"+xhdpi+"px</b>"));
        etXxhdpi.setText(Html.fromHtml("XX-HDPI: <b>"+xxhdpi+"px</b>"));
    }
}
