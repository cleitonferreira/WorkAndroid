package nuvemapp.com.br.exemploonscrolllistener;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import nuvemapp.com.br.exemploonscrolllistener.adapter.CarAdapter;
import nuvemapp.com.br.exemploonscrolllistener.connection.Transaction;
import nuvemapp.com.br.exemploonscrolllistener.connection.VolleyConn;
import nuvemapp.com.br.exemploonscrolllistener.domain.Car;
import nuvemapp.com.br.exemploonscrolllistener.domain.RequestData;
public class MainActivity extends AppCompatActivity implements Transaction, AdapterView.OnItemClickListener, AbsListView.OnScrollListener {
    private ListView listView;
    private CarAdapter adapter;
    private ProgressBar progressBar;
    private Car car;
    private boolean isThereMore;
    private List<Car> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        car = new Car();
        list = new ArrayList<Car>();

        progressBar = (ProgressBar) findViewById(R.id.pbProxy);

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);

        (new VolleyConn(MainActivity.this, this)).execute();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent it = new Intent(MainActivity.this, DetailsActivity.class);
        it.putExtra("car", list.get(position));
        startActivity(it);
    }


    // CONN METHODS
    @Override
    public void doBefore() {
        progressBar.setVisibility(View.VISIBLE);
    }


    @Override
    public void doAfter(String answer) {
        try{
            JSONObject json = new JSONObject(answer);

            if(!json.isNull("cars")){
                isThereMore = json.getBoolean("isThereMore");
                JSONArray ja = json.getJSONArray("cars");

                for(int i = 0, tam = ja.length(); i < tam; i++){
                    JSONObject jCar = ja.getJSONObject(i);

                    Car car = new Car();
                    car.setId(jCar.getInt("id"));
                    car.setModel(jCar.getString("model"));
                    car.setBrand(jCar.getString("brand"));
                    car.setEngine(jCar.getString("engine"));
                    car.setYear(jCar.getInt("year"));
                    car.setPrice(jCar.getString("price"));
                    car.setImagePath(jCar.getString("imagePath"));
                    list.add(car);
                }

                if(adapter == null){
                    adapter = new CarAdapter(MainActivity.this, list);
                    listView.setAdapter(adapter);
                }
                else{
                    adapter.notifyDataSetChanged();
                }
            }
        }
        catch(JSONException e){
            e.printStackTrace();
        }
        finally {
            progressBar.setVisibility(View.GONE);
        }
    }


    @Override
    public RequestData getRequestData() {
        return( new RequestData(Car.CAR_URL, "an-get-car", car) );
    }


    // LISTENERS
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if(view.getId() == listView.getId() && isThereMore){
            if(listView.getLastVisiblePosition() + 1 == list.size()){
                car.setId(list.get(list.size() - 1).getId());
                isThereMore = false;
                (new VolleyConn(MainActivity.this, this)).execute();
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {}
}

