package nuvemapp.com.br.exemplomaterialswiperefreshlayout_snackbar;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.internal.view.ContextThemeWrapper;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import nuvemapp.com.br.exemplomaterialswiperefreshlayout_snackbar.domain.Car;
import nuvemapp.com.br.exemplomaterialswiperefreshlayout_snackbar.fragments.CarFragment;
import nuvemapp.com.br.exemplomaterialswiperefreshlayout_snackbar.fragments.LuxuryCarFragment;
import nuvemapp.com.br.exemplomaterialswiperefreshlayout_snackbar.fragments.OldCarFragment;
import nuvemapp.com.br.exemplomaterialswiperefreshlayout_snackbar.fragments.PopularCarFragment;
import nuvemapp.com.br.exemplomaterialswiperefreshlayout_snackbar.fragments.SportCarFragment;
import me.drakeet.materialdialog.MaterialDialog;


public class CarActivity extends ActionBarActivity {
    private Toolbar mToolbar;
    private Car car;
    private Drawer.Result navigationDrawerLeft;
    private MaterialDialog mMaterialDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        if(savedInstanceState != null){
            car = savedInstanceState.getParcelable("car");
        }
        else {
            if (getIntent() != null && getIntent().getExtras() != null && getIntent().getExtras().getParcelable("car") != null) {
                car = getIntent().getExtras().getParcelable("car");
            } else {
                Toast.makeText(this, "Fail!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }

        mToolbar = (Toolbar) findViewById(R.id.tb_main);
        mToolbar.setTitle(car.getModel());
        setSupportActionBar(mToolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);

        ImageView ivCar = (ImageView) findViewById(R.id.iv_car);
        TextView tvModel = (TextView) findViewById(R.id.tv_model);
        TextView tvBrand = (TextView) findViewById(R.id.tv_brand);
        TextView tvDescription = (TextView) findViewById(R.id.tv_description);
        Button btPhone = (Button) findViewById(R.id.bt_phone);

        btPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaterialDialog = new MaterialDialog(new ContextThemeWrapper(CarActivity.this, R.style.MyAlertDialog))
                        .setTitle("Telefone Empresa")
                        .setMessage(car.getTel())
                        .setPositiveButton("Ligar", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent it = new Intent(Intent.ACTION_CALL);
                                it.setData(Uri.parse("tel:" + car.getTel().trim()));
                                startActivity(it);
                            }
                        })
                        .setNegativeButton("Voltar", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mMaterialDialog.dismiss();
                            }
                        });
                mMaterialDialog.show();
            }
        });

        ivCar.setImageResource(car.getPhoto());
        tvModel.setText(car.getModel());
        tvBrand.setText(car.getBrand());
        tvDescription.setText( car.getDescription() );

        navigationDrawerLeft = new Drawer()
                .withActivity(this)
                .withToolbar(mToolbar)
                .withActionBarDrawerToggle(false)
                .withCloseOnClick(true)
                .withActionBarDrawerToggleAnimated(false)
                .withActionBarDrawerToggle(new ActionBarDrawerToggle(this, new DrawerLayout(this), R.string.drawer_open, R.string.drawer_close){
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        super.onDrawerSlide(drawerView, slideOffset);
                        navigationDrawerLeft.closeDrawer();
                        finish();
                    }
                })
                .build();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        return true;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("car", car);
    }
}
