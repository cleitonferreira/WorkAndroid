package nuvemapp.com.br.exemploactionbartabs;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
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

        // TABS
        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        Tab tab1 = ab.newTab();
        tab1.setText("Tab 1");
        tab1.setIcon(R.drawable.ic_launcher);
        tab1.setTabListener(new NavegacaoTabs(new Fragment1()));
        ab.addTab(tab1, false);

        Tab tab2 = ab.newTab();
        tab2.setText("Tab 2");
        tab2.setTabListener(new NavegacaoTabs(new Fragment2()));
        ab.addTab(tab2, false);

        Tab tab3 = ab.newTab();
        tab3.setIcon(R.drawable.ic_launcher);
        tab3.setTabListener(new NavegacaoTabs(new Fragment3()));
        ab.addTab(tab3, false);

        if(savedInstanceState != null){
            int indiceTab = savedInstanceState.getInt("indiceTab");
            getActionBar().setSelectedNavigationItem(indiceTab);
        }
        else{
            getActionBar().setSelectedNavigationItem(0);
        }

    }


    private class NavegacaoTabs implements ActionBar.TabListener {
        private Fragment frag;

        public NavegacaoTabs(Fragment frag){
            this.frag = frag;
        }

        @Override
        public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
            Log.i("Script", "onTabReselected()");
        }

        @Override
        public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
            FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
            fts.replace(R.id.fragmentContainer, frag);
            fts.commit();
        }

        @Override
        public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
            FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
            fts.remove(frag);
            fts.commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);

		/*MenuItem m1 = menu.add(0, 0, 0, "Item 1");
		m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		MenuItem m2 = menu.add(0, 1, 1, "Item 2");
		m2.setIcon(R.drawable.ic_launcher);
		m2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

		MenuItem m3 = menu.add(0, 2, 2, "Item 3");
		m3.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);

		MenuItem m4 = menu.add(0, 3, 3, "Item 4");
		m4.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);*/
        getMenuInflater().inflate(R.menu.menu, menu);
        return(true);
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

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("indiceTab", getActionBar().getSelectedNavigationIndex());
    }
}
