package nuvemapp.com.br.exemplosocialauth.adapter;

import java.util.List;

import org.brickred.socialauth.Feed;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import nuvemapp.com.br.exemplosocialauth.R;

public class FeedsAdapter extends BaseAdapter {
	private Context ctx;
	private List<Feed> list;
	private LayoutInflater inflater;
	
	public FeedsAdapter(Context ctx, List<Feed> list){
		this.ctx = ctx;
		this.list = list;
		this.inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
		Feed feed = list.get(position);
		ViewHolder holder;
		
		if(convertView == null){
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_feed, null);
			convertView.setTag(holder);
			
			holder.tvInfo = (TextView) convertView.findViewById(R.id.tvInfo);
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		// INFO
			String contentInfo = feed.getFrom() != null ? "<b>De:</b> "+feed.getFrom()+"<br />" : "";
			contentInfo += feed.getId() != null ? "<b>ID:</b> "+feed.getId()+"<br />" : "";
			contentInfo += feed.getMessage() != null ? "<b>Mensagem:</b> "+feed.getMessage()+"<br />" : "";
			contentInfo += feed.getScreenName() != null ? "<b>Nome em amostra:</b> "+feed.getScreenName()+"<br />" : "";
			contentInfo += feed.getCreatedAt() != null ? "<b>Data:</b> "+feed.getCreatedAt()+"<br />" : "";
			
			holder.tvInfo.setText(Html.fromHtml(contentInfo));
		
		return(convertView);
	}
	
	private class ViewHolder{
		TextView tvInfo;
	}
	
}
