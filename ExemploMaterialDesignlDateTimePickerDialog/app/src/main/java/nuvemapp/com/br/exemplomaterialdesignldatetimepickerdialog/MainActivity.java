package nuvemapp.com.br.exemplomaterialdesignldatetimepickerdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener, DialogInterface.OnCancelListener {

    private TextView tvTestDrive;

    private int ano, mes, dia, hora, minuto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        tvTestDrive = (TextView) findViewById(R.id.tv_test_drive);
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

    public void testeAgenda(View view) {
        initDateTimeData();
        Calendar cDefault = Calendar.getInstance();
        cDefault.set(ano, mes, dia);

        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
                this,
                cDefault.get(Calendar.YEAR),
                cDefault.get(Calendar.MONTH),
                cDefault.get(Calendar.DAY_OF_MONTH)
        );

        Calendar cMin = Calendar.getInstance();
        Calendar cMax = Calendar.getInstance();
        cMax.set( cMax.get(Calendar.YEAR), 11, 31 );
        datePickerDialog.setMinDate(cMin);
        datePickerDialog.setMaxDate(cMax);

        List<Calendar> daysList = new LinkedList<>();
        Calendar[] daysArray;
        Calendar cAux = Calendar.getInstance();

        while( cAux.getTimeInMillis() <= cMax.getTimeInMillis() ){
            if( cAux.get( Calendar.DAY_OF_WEEK ) != 1 && cAux.get( Calendar.DAY_OF_WEEK ) != 7 ){
                Calendar c = Calendar.getInstance();
                c.setTimeInMillis( cAux.getTimeInMillis() );

                daysList.add( c );
            }
            cAux.setTimeInMillis( cAux.getTimeInMillis() + ( 24 * 60 * 60 * 1000 ) );
        }
        daysArray = new Calendar[ daysList.size() ];
        for( int i = 0; i < daysArray.length; i++ ){
            daysArray[i] = daysList.get(i);
        }

        datePickerDialog.setSelectableDays( daysArray );
        datePickerDialog.setOnCancelListener(this);
        datePickerDialog.show( getFragmentManager(), "DatePickerDialog" );
    }

    private void initDateTimeData(){
        if( ano == 0 ){
            Calendar c = Calendar.getInstance();
            ano = c.get(Calendar.YEAR);
            mes = c.get(Calendar.MONTH);
            dia = c.get(Calendar.DAY_OF_MONTH);
            hora = c.get(Calendar.HOUR_OF_DAY);
            minuto = c.get(Calendar.MINUTE);
        }
    }


    @Override
    public void onCancel(DialogInterface dialog) {
        ano = mes = dia = hora = minuto = 0;
        tvTestDrive.setText("");
    }

    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {
        Calendar tDefault = Calendar.getInstance();
        tDefault.set(ano, mes, dia, hora, minuto);

        ano = i;
        mes = i1;
        dia = i2;

        TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(
                this,
                tDefault.get(Calendar.HOUR_OF_DAY),
                tDefault.get(Calendar.MINUTE),
                true
        );
        timePickerDialog.setOnCancelListener(this);
        timePickerDialog.show(getFragmentManager(), "timePickerDialog");
        timePickerDialog.setTitle("Horário Test Drive");

        timePickerDialog.setThemeDark(true);
    }

//    @Override
//    public void onTimeSet(RadialPickerLayout radialPickerLayout, int i, int i1) {
//        if( i < 9 || i > 18 ){
//            onDateSet(null, year, month, day);
//            Toast.makeText(this, "Somente entre 9h e 18h", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        hour = i;
//        minute = i1;
//
//        tvTestDrive.setText( (day < 10 ? "0"+day : day)+"/"+
//                (month+1 < 10 ? "0"+(month+1) : month+1)+"/"+
//                year+" às "+
//                (hour < 10 ? "0"+hour : hour)+"h"+
//                (minute < 10 ? "0"+minute : minute));
//    }


    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        if( hourOfDay < 9 || hourOfDay > 18 ){
            onDateSet(null, ano, mes, dia);
            Toast.makeText(this, "Somente entre 9h e 18h", Toast.LENGTH_SHORT).show();
            return;
        }

        hora = hourOfDay;
        minuto = minute;

        tvTestDrive.setText( (dia < 10 ? "0"+dia : dia)+"/"+
                (mes+1 < 10 ? "0"+(mes+1) : mes+1)+"/"+
                ano+" às "+
                (hora < 10 ? "0"+hora : hora)+"h"+
                (minute < 10 ? "0"+minute : minute));
    }
}
