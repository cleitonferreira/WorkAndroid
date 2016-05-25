package nuvemapp.com.br.exemplobutterknife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


import butterknife.ButterKnife;
import butterknife.InjectView;
import nuvemapp.com.br.exemplobutterknife.R;
import nuvemapp.com.br.exemplobutterknife.domain.Product;


public class ProductAdapter extends BaseAdapter {
    private Context context;
    private List<Product> list;
    private LayoutInflater inflater;


    public ProductAdapter(Context context, List<Product> list){
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

            /*holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            holder.tvCategory = (TextView) convertView.findViewById(R.id.tvCategory);
            holder.tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);*/
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }


        holder.tvName.setText(list.get(position).getName());
        holder.tvCategory.setText(list.get(position).getCategory());
        holder.tvPrice.setText("R$ "+list.get(position).getPriceFormatted());

        return convertView;
    }


    static class ViewHolder{
        @InjectView(R.id.tvName) public TextView tvName;
        @InjectView(R.id.tvCategory) public TextView tvCategory;
        @InjectView(R.id.tvPrice) public TextView tvPrice;

        public ViewHolder(View view){
            ButterKnife.inject(ViewHolder.this, view);
        }
    }

}
