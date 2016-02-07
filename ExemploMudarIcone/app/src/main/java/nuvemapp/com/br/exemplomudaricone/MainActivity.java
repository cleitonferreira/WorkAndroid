package nuvemapp.com.br.exemplomudaricone;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mudarIcone(View view) {
        Button bt = (Button) view;

        desativarAll();
        if (bt.getText().toString().equalsIgnoreCase("Ícone 1 Original")){
            getPackageManager().setComponentEnabledSetting(new ComponentName("nuvemapp.com.br.exemplomudaricone", "nuvemapp.com.br.exemplomudaricone.MainActivity-One"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
        } else if (bt.getText().toString().equalsIgnoreCase("Ícone 2")){
            getPackageManager().setComponentEnabledSetting(new ComponentName("nuvemapp.com.br.exemplomudaricone", "nuvemapp.com.br.exemplomudaricone.MainActivity-Two"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
        } else if (bt.getText().toString().equalsIgnoreCase("Ícone 3")){
            getPackageManager().setComponentEnabledSetting(new ComponentName("nuvemapp.com.br.exemplomudaricone", "nuvemapp.com.br.exemplomudaricone.MainActivity-Three"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
        }
    }

    public void desativarAll(){
        getPackageManager().setComponentEnabledSetting(new ComponentName("nuvemapp.com.br.exemplomudaricone", "nuvemapp.com.br.exemplomudaricone.MainActivity-One"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("nuvemapp.com.br.exemplomudaricone", "nuvemapp.com.br.exemplomudaricone.MainActivity-Two"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("nuvemapp.com.br.exemplomudaricone", "nuvemapp.com.br.exemplomudaricone.MainActivity-Three"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    }
}
