package nuvemapp.com.br.exemploautocompletetextview;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import nuvemapp.com.br.exemploautocompletetextview.adapter.AutoCompleteAdapter;
import nuvemapp.com.br.exemploautocompletetextview.domain.State;


public class MainActivity extends Activity implements OnItemSelectedListener {
    private Spinner spCountry;
    private AutoCompleteTextView actvState;
    public static int id = 0;

    // STATES
    private List<State> listStatesBrazil = Arrays.asList(new State[]{new State("Acre (AC)", R.drawable.acre),
            new State("Alagoas (AL)", R.drawable.alagoas),
            new State("Amapá (AP)", R.drawable.amapa),
            new State("Amazonas (AM)", R.drawable.amazonas),
            new State("Bahia (BA)", R.drawable.bahia),
            new State("Ceará (CE)", R.drawable.ceara),
            new State("Distrito Federal (DF)", R.drawable.distrito_federal),
            new State("Espírito Santo (ES)", R.drawable.espirito_santo),
            new State("Goiás (GO)", R.drawable.goias),
            new State("Maranhão (MA)", R.drawable.maranhao),
            new State("Mato Grosso (MT)", R.drawable.mato_grosso),
            new State("Mato Grosso do Sul (MS)", R.drawable.mato_grosso_do_sul),
            new State("Minas Gerais (MG)", R.drawable.minas_gerais),
            new State("Pará (PA)", R.drawable.para),
            new State("Paraíba (PB)", R.drawable.paraiba),
            new State("Paraná (PR)", R.drawable.parana),
            new State("Pernambuco (PE)", R.drawable.pernambuco),
            new State("Piauí (PI)", R.drawable.piaui),
            new State("Rio de Janeiro (RJ)", R.drawable.rio_de_janeiro),
            new State("Rio Grande do Norte (RN)", R.drawable.rio_grande_do_norte),
            new State("Rio Grande do Sul (RS)", R.drawable.rio_grande_do_sul),
            new State("Rondônia (RO)", R.drawable.rondonia),
            new State("Roraima (RR)", R.drawable.roraima),
            new State("Santa Catarina (SC)", R.drawable.santa_catarina),
            new State("São Paulo (SP)", R.drawable.sao_paulo),
            new State("Sergipe (SE)", R.drawable.sergipe),
            new State("Tocantins (TO)", R.drawable.tocantins)
    });

    private List<State> listStatesCanada = Arrays.asList(new State[]{new State("Ontario (ON)", R.drawable.ontario),
            new State("Quebec (QC)", R.drawable.quebec),
            new State("Nova Scotia (NS)", R.drawable.nova_scotia),
            new State("New Brunswick (NB)", R.drawable.new_brunswick),
            new State("Manitoba (MB)", R.drawable.manitoba),
            new State("British Columbia (BC)", R.drawable.british_columbia),
            new State("Prince Edward Island (PE)", R.drawable.prince_edward_island),
            new State("Saskatchewan (SK)", R.drawable.saskatchewan),
            new State("Alberta (AB)", R.drawable.alberta),
            new State("Newfoundland and Labrador (NL)", R.drawable.newfoundland_and_labrador)
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> arrayAdapterCountries = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.countries));
        spCountry = (Spinner) findViewById(R.id.spCountry);
        spCountry.setAdapter(arrayAdapterCountries);
        spCountry.setOnItemSelectedListener(this);

        LinearLayout llAddress = (LinearLayout) findViewById(R.id.llAddress);

        // AUTO COMPLETE TEXT VIEW
        actvState = new AutoCompleteTextView(MainActivity.this);
        actvState.setThreshold(1);
        actvState.setLayoutParams(new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, 1));
        actvState.setHint("Estado / Provincia");
        //actvState = (AutoCompleteTextView) findViewById(R.id.actvState);
        actvState.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i("Script", "beforeTextChanged("+s+")");
                MainActivity.id = 0;
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("Script", "onTextChanged("+s+")");
            }
            @Override
            public void afterTextChanged(Editable s) {
                Log.i("Script", "afterTextChanged("+s+")");
            }
        });
        llAddress.addView(actvState);
			/*float scale = getResources().getDisplayMetrics().density;
			actvState.setDropDownHorizontalOffset((int)(50 * scale + 0.5f));
			actvState.setDropDownVerticalOffset((int)(50 * scale + 0.5f));*/
    }



    // LISTENERS
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			/*String[] aux = getResources().getStringArray(position == 0 ? R.array.statesBrazil : R.array.statesCanada);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, aux);
			actvState.setAdapter(adapter);*/

        List<State> aux = position == 0 ? listStatesBrazil : listStatesCanada;
        //actvState.setAdapter(new AutoCompleteAdapter2(MainActivity.this, R.layout.auto_complete_item, R.id.tvState, aux));
        actvState.setAdapter(new AutoCompleteAdapter(MainActivity.this, position+1, aux));
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}
