package nuvemapp.com.br.exemplomaterialdesignnavigationdrawer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.SwitchDrawerItem;
import com.mikepenz.materialdrawer.model.ToggleDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.OnCheckedChangeListener;


public class MainActivity extends AppCompatActivity {
    private static String TAG = "LOG";
    private Toolbar mToolbar;
    private Drawer.Result navigationDrawerLeft;
    private Drawer.Result navigationDrawerRight;
    private AccountHeader.Result headerNavigationLeft;
    private int mPositionClicked;

    private OnCheckedChangeListener mOnCheckedChangeListener = new OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(IDrawerItem iDrawerItem, CompoundButton compoundButton, boolean b) {
            Toast.makeText(MainActivity.this, "onCheckedChanged: "+( b ? "true" : "false" ), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // NAVIGATIOn DRAWER
        // END - RIGHT
        navigationDrawerRight = new Drawer()
                .withActivity(this)
                //.withToolbar(mToolbar)
                .addDrawerItems(
                        new SecondaryDrawerItem().withName("Carros Esportivos").withIcon(getResources().getDrawable(R.drawable.car_selected_1)),
                        new SecondaryDrawerItem().withName("Carros de Luxo").withIcon(getResources().getDrawable(R.drawable.car_selected_2)),
                        new SecondaryDrawerItem().withName("Carros para Colecionadores").withIcon(getResources().getDrawable(R.drawable.car_selected_3)),
                        new SecondaryDrawerItem().withName("Carros Populares").withIcon(getResources().getDrawable(R.drawable.car_selected_4))

                )
                .withDisplayBelowToolbar(true)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.END)
                .withSavedInstance(savedInstanceState)
                .withSelectedItem(-1)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        Toast.makeText(MainActivity.this, "onItemClick: " + i, Toast.LENGTH_SHORT).show();
                    }
                })
                .withOnDrawerItemLongClickListener(new Drawer.OnDrawerItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        Toast.makeText(MainActivity.this, "onItemLongClick: " + i, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                })
                .build();

                headerNavigationLeft = new AccountHeader()
                        .withActivity(this)
                        .withCompactStyle(false)
                        .withSavedInstance(savedInstanceState)
                        .withThreeSmallProfileImages(true)
                        .withHeaderBackground(R.drawable.ct6)
                        .addProfiles(
                                new ProfileDrawerItem().withName("Person One").withEmail("person1@gmail.com").withIcon(getResources().getDrawable(R.drawable.person_1)),
                                new ProfileDrawerItem().withName("Person Two").withEmail("person2@gmail.com").withIcon(getResources().getDrawable(R.drawable.person_2)),
                                new ProfileDrawerItem().withName("Person Three").withEmail("person3@gmail.com").withIcon(getResources().getDrawable(R.drawable.person_3)),
                                new ProfileDrawerItem().withName("Person Four").withEmail("person4@gmail.com").withIcon(getResources().getDrawable(R.drawable.person_4))
                        )
                        .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                            @Override
                            public boolean onProfileChanged(View view, IProfile iProfile, boolean b) {
                                Toast.makeText(MainActivity.this, "onProfileChanged: " + iProfile.getName(), Toast.LENGTH_SHORT).show();
                                headerNavigationLeft.setBackgroundRes(R.drawable.vyron);
                                return false;
                            }
                        })
                        .build();

                navigationDrawerLeft = new Drawer()
                        .withActivity(this)
                        .withToolbar(mToolbar)
                        .withDisplayBelowToolbar(false)
                        .withActionBarDrawerToggleAnimated(true)
                        .withDrawerGravity(Gravity.LEFT)
                        .withSavedInstance(savedInstanceState)
                        .withSelectedItem(0)
                        .withActionBarDrawerToggle(true)
                        .withAccountHeader(headerNavigationLeft)
                            /*.withOnDrawerNavigationListener(new Drawer.OnDrawerNavigationListener() {
                                @Override
                                public boolean onNavigationClickListener(View view) {
                                    return false;
                                }
                            })*/
                        .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                                for (int count = 0, tam = navigationDrawerLeft.getDrawerItems().size(); count < tam; count++) {
                                    if (count == mPositionClicked && mPositionClicked <= 3) {
                                        PrimaryDrawerItem aux = (PrimaryDrawerItem) navigationDrawerLeft.getDrawerItems().get(count);
                                        aux.setIcon(getResources().getDrawable( getCorretcDrawerIcon( count, false ) ));
                                        break;
                                    }
                                }

                                if(i <= 3){
                                    ((PrimaryDrawerItem) iDrawerItem).setIcon(getResources().getDrawable( getCorretcDrawerIcon( i, true ) ));
                                }

                                mPositionClicked = i;
                                navigationDrawerLeft.getAdapter().notifyDataSetChanged();
                            }
                        })
                        .withOnDrawerItemLongClickListener(new Drawer.OnDrawerItemLongClickListener() {
                            @Override
                            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                                Toast.makeText(MainActivity.this, "onItemLongClick: " + i, Toast.LENGTH_SHORT).show();
                                return false;
                            }
                        })
                        .build();

                navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Carros Esportivos").withIcon(getResources().getDrawable(R.drawable.car_selected_1)));
                navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Carros de Luxo").withIcon(getResources().getDrawable(R.drawable.car_2)));
                navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Carros para Colecionadores").withIcon(getResources().getDrawable(R.drawable.car_3)));
                navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Carros Populares").withIcon(getResources().getDrawable(R.drawable.car_4)));
                navigationDrawerLeft.addItem(new SectionDrawerItem().withName("Configurações"));
                navigationDrawerLeft.addItem(new SwitchDrawerItem().withName("Notificação").withChecked(true).withOnCheckedChangeListener(mOnCheckedChangeListener));
                navigationDrawerLeft.addItem(new ToggleDrawerItem().withName("News").withChecked(true).withOnCheckedChangeListener(mOnCheckedChangeListener));
    }

    private int getCorretcDrawerIcon(int position, boolean isSelecetd){
        switch(position){
            case 0:
                return( isSelecetd ? R.drawable.car_selected_1 : R.drawable.car_1 );
            case 1:
                return( isSelecetd ? R.drawable.car_selected_2 : R.drawable.car_2 );
            case 2:
                return( isSelecetd ? R.drawable.car_selected_3 : R.drawable.car_3 );
            case 3:
                return( isSelecetd ? R.drawable.car_selected_4 : R.drawable.car_4 );
        }
        return(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
