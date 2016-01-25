package nuvemapp.com.br.exemplobaseadapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by XPredator on 25/01/2016.
 */
public class CarroAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Carro> lista;

    public CarroAdapter(Context context, ArrayList<Carro> lista) {
        this.context = context;
        this.lista = lista;
    }

    //tamanho da lista
    @Override
    public int getCount() {
        return lista.size();
    }

    //tamanho da posição
    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Carro carro = lista.get(position);
        View layout;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = inflater.inflate(R.layout.carros, null);
        }else {
            layout = convertView;
        }

        TextView modelo = (TextView) layout.findViewById(R.id.t1);
        modelo.setText(carro.getModelo());

        TextView marca = (TextView) layout.findViewById(R.id.t2);
        marca.setText(carro.getMarca());

        //setar a imagem
        ImageView iv = (ImageView) layout.findViewById(R.id.iv);
        iv.setImageResource(carro.getCarroImagem(position));

        if (position % 2 == 0){
            layout.setBackgroundColor(Color.WHITE);
        }

        return layout;
    }
}
