package nuvemapp.com.br.exemplocrouton.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import nuvemapp.com.br.exemplocrouton.R;
import nuvemapp.com.br.exemplocrouton.domain.Contact;


public class ContactsAdapter extends BaseAdapter {
    private List<Contact> list;
    private LayoutInflater inflater;


    public ContactsAdapter(Context c, List<Contact> l){
        list = l;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;

        if(view == null){
            view = inflater.inflate(R.layout.item, null);
            holder = new ViewHolder();
            view.setTag(holder);

            holder.rivImg = (RoundedImageView) view.findViewById(R.id.rivImg);
            holder.tvName = (TextView) view.findViewById(R.id.tvName);
            holder.tvQtdMessages = (TextView) view.findViewById(R.id.tvQtdMessages);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        holder.rivImg.setImageResource(list.get(position).getImage());
        holder.tvName.setText(list.get(position).getName());
        holder.tvQtdMessages.setText(Integer.toString(list.get(position).getQtdMessages()));

        return view;
    }


    // INNER CLASS
    private static class ViewHolder{
        RoundedImageView rivImg;
        TextView tvName;
        TextView tvQtdMessages;
    }
}
