package nuvemapp.com.br.exemplospinner;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by XPredator on 07/02/2016.
 */
public class AdapterCarro extends BaseAdapter {

    private Context ctx;
    private String[] lista;

    public AdapterCarro(Context ctx, String[] lista){
        this.ctx = ctx;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.length;
    }

    @Override
    public Object getItem(int position) {
        return lista[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView tv = new TextView(ctx);
        tv.setText(lista[position]);
        tv.setTextColor(Color.RED);

        return tv;
    }
}
