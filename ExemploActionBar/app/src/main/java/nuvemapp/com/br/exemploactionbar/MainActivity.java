package nuvemapp.com.br.exemploactionbar;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab = getActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);


        /*MenuItem m1 = menu.add(0, 0, 0, "Item 1");
        m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        MenuItem m2 = menu.add(0, 1, 1, "Item 2");
        m2.setIcon(R.mipmap.ic_launcher);
        m2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        MenuItem m3 = menu.add(0, 2, 2, "Item 3");
        m3.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);

        MenuItem m4 = menu.add(0, 3, 3, "Item 4");
        m4.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);*/

        // Não é recomendado via API Google e sim XML
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onMenuItemSelected(int panel, MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                Toast.makeText(this, "Logo botão", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item1:
                Toast.makeText(this, "Item "+(item.getItemId()+1), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "Item "+(item.getItemId()+1), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(this, "Item "+(item.getItemId()+1), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item4:
                Toast.makeText(this, "Item "+(item.getItemId()+1), Toast.LENGTH_SHORT).show();
                break;
        }

        return(true);
    }

}
