package nuvemapp.com.br.exemplobutterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nuvemapp.com.br.exemplobutterknife.adapter.ProductAdapter;
import nuvemapp.com.br.exemplobutterknife.domain.Product;

public class ListActivityTest extends AppCompatActivity {

    @InjectView(R.id.lvProducts) protected ListView lvProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity_test);

        Random randoPrice = new Random();

        List<Product> list = new ArrayList<Product>();
        list.add(new Product("Product 1", "Produtos de limpeza", 5 + randoPrice.nextInt(100)));
        list.add(new Product("Product 2", "Produtos de limpeza", 5 + randoPrice.nextInt(100)));
        list.add(new Product("Product 3", "Produtos de limpeza", 5 + randoPrice.nextInt(100)));
        list.add(new Product("Product 4", "Produtos de limpeza", 5 + randoPrice.nextInt(100)));
        list.add(new Product("Product 5", "Produtos de limpeza", 5 + randoPrice.nextInt(100)));
        list.add(new Product("Product 6", "Produtos de limpeza", 5 + randoPrice.nextInt(100)));
        list.add(new Product("Product 7", "Produtos de limpeza", 5 + randoPrice.nextInt(100)));
        list.add(new Product("Product 8", "Produtos de limpeza", 5 + randoPrice.nextInt(100)));
        list.add(new Product("Product 9", "Produtos de limpeza", 5 + randoPrice.nextInt(100)));
        list.add(new Product("Product 10", "Produtos de limpeza", 5 + randoPrice.nextInt(100)));

        //lvProducts = (ListView) findViewById(R.id.lvProducts);
        ButterKnife.inject(ListActivityTest.this);
        lvProducts.setAdapter(new ProductAdapter(ListActivityTest.this, list));
    }
}
