package nuvemapp.com.br.exemplojsonparser;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


/*
*
    HttpClient foi preterido no Nível API 22 e removido em API Nível 23.
    Você ainda pode usá-lo em API Nível 23 e seguintes, se for preciso,
    no entanto, é melhor para passar para métodos com suporte para lidar
    com HTTP. Então, se você está compilando com 23, adicione em sua build.gradle:

    android {
        useLibrary 'org.apache.http.legacy'
    }

*/
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void sendJson(View view){

        Carro carro = new Carro();
        carro.setMarca("Citroën");
        carro.setModelo("C4");
        carro.setPotencias(new ArrayList<Potencia>());
        carro.getPotencias().add(new Potencia(1.0f, 60));
        carro.getPotencias().add(new Potencia(1.5f, 80));
        carro.getPotencias().add(new Potencia(2.0f, 100));

        String json = generateJSON(carro);

        callServer("send-json", json);
    }


    public void getJson(View view){
        callServer("get-json", "");
    }


    private String generateJSON(Carro carro){
        JSONObject jo = new JSONObject();
        JSONArray ja = new JSONArray();

        try{
            jo.put("marca", carro.getMarca());
            jo.put("modelo", carro.getModelo());

            for(int i = 0, tam = carro.getPotencias().size(); i < tam; i++){
                JSONObject aux =  new JSONObject();
                aux.put("motor", carro.getPotencias().get(i).getMotor());
                aux.put("cavalos", carro.getPotencias().get(i).getCavalos());
                ja.put(aux);
            }

            jo.put("potencias", ja);
        }
        catch(JSONException e){ e.printStackTrace(); }

        return(jo.toString());
    }


    private Carro degenerateJSON(String data){
        Carro carro = new Carro();

        try{
            JSONObject jo = new JSONObject(data);
            JSONArray ja;

            carro.setMarca(jo.getString("marca"));
            carro.setModelo(jo.getString("modelo"));
            carro.setPotencias(new ArrayList<Potencia>());

            jo.put("marca", carro.getMarca());
            jo.put("modelo", carro.getModelo());

            ja = jo.getJSONArray("potencias");
            for(int i = 0, tam = ja.length(); i < tam; i++){

                Potencia p = new Potencia();
                p.setMotor(ja.getJSONObject(i).getDouble("motor"));
                p.setCavalos(ja.getJSONObject(i).getInt("cavalos"));

                carro.getPotencias().add(p);
            }

            // APRESENTAÇÃO
            Log.i("Script", "Marca: "+carro.getMarca());
            Log.i("Script", "Modelo: "+carro.getModelo());
            for(int i = 0, tam = carro.getPotencias().size(); i < tam; i++){
                Log.i("Script", "Motor: "+carro.getPotencias().get(i).getMotor());
                Log.i("Script", "Cavalos: "+carro.getPotencias().get(i).getCavalos());
            }

        }
        catch(JSONException e){ e.printStackTrace(); }

        return(carro);
    }



    @SuppressLint("NewApi")
    private void callServer(final String method, final String data){
        new Thread(){
            public void run(){
                String answer = HttpConnection.getSetDataWeb("http://www.villopim.com.br/android/json/process.php", method, data);

                Log.i("Script", "ANSWER: "+answer);

                if(data.isEmpty()){
                    degenerateJSON(answer);
                }
            }
        }.start();
    }

}
