package nuvemapp.com.br.exemplodropboxdownloadupload;

import java.util.List;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dropbox.client2.DropboxAPI.Entry;

public class AdapterDropbox extends BaseAdapter {
    private Context ctx;
    private LayoutInflater inflater;
    private List<Entry> list;


    public AdapterDropbox(Context ctx, List<Entry> list){
        this.ctx = ctx;
        this.list = list;
        this.inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        String html = "";

        if(view == null){
            view = inflater.inflate(R.layout.item, null);
            holder = new ViewHolder();
            view.setTag(holder);

            holder.tvDropbox = (TextView) view.findViewById(R.id.tvDropbox);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        html = "<b>Path:</b> "+list.get(position).path+"<br />";
        html += "<b>Size:</b> "+list.get(position).size+"<br />";
        html += "<b>File name:</b> "+list.get(position).fileName();

        holder.tvDropbox.setText(Html.fromHtml(html));

        return view;
    }

    private class ViewHolder{
        public TextView tvDropbox;
    }
}
