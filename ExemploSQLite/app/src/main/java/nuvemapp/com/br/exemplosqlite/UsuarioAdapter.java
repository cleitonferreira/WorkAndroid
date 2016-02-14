package nuvemapp.com.br.exemplosqlite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by XPredator on 14/02/2016.
 */
public class UsuarioAdapter extends BaseAdapter {

    private Context context;
    private List<Usuario> list;

    public UsuarioAdapter(Context context, List<Usuario> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int auxPosition = position;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.usuario, null);

        TextView tv = (TextView) layout.findViewById(R.id.nome);
        tv.setText(list.get(position).getNome());

        Button editarBt = (Button) layout.findViewById(R.id.editar);
        editarBt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewUserActivity.class);
                intent.putExtra("nome", list.get(auxPosition).getNome());
                intent.putExtra("email", list.get(auxPosition).getEmail());
                intent.putExtra("id", list.get(auxPosition).getId());
                context.startActivity(intent);
            }
        });

        Button deletarBt = (Button) layout.findViewById(R.id.deletar);
        deletarBt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                // deletar no BD SQLite
                BD bd = new BD(context);
                bd.deletar(list.get(auxPosition));

                layout.setVisibility(View.GONE);
            }
        });

        return layout;
    }
}
