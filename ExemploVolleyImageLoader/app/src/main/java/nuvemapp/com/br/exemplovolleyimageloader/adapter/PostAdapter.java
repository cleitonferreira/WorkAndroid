package nuvemapp.com.br.exemplovolleyimageloader.adapter;

import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import nuvemapp.com.br.exemplovolleyimageloader.R;
import nuvemapp.com.br.exemplovolleyimageloader.cdp.Post;

public class PostAdapter extends BaseAdapter {
	private Context context;
	private List<Post> list;
	private ImageLoader il;
	private LayoutInflater inflater;
	
	
	public PostAdapter(Context context, List<Post> list, ImageLoader il){
		this.context = context;
		this.list = list;
		this.il = il;
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
	public View getView(int position, View view, ViewGroup parent) {
		ViewHolder holder;
		
		if(view == null){
			view = inflater.inflate(R.layout.item, null);
			holder = new ViewHolder();
			view.setTag(holder);
			
			holder.nivImg = (NetworkImageView) view.findViewById(R.id.nivImg);
			holder.ivImg = (ImageView) view.findViewById(R.id.ivImg);
			holder.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
		}
		else{
			holder = (ViewHolder) view.getTag();
		}
		
		// NETWORK IMAGE VIEW
			/*holder.nivImg.setVisibility(View.VISIBLE);
			holder.nivImg.setImageUrl(list.get(position).getUrlImage(), il);
			holder.nivImg.setDefaultImageResId(R.drawable.load);
			holder.nivImg.setErrorImageResId(R.drawable.error);*/
			
		// IMAGE VIEW
			holder.ivImg.setVisibility(View.VISIBLE);
			il.get(list.get(position).getUrlImage(), il.getImageListener(holder.ivImg, R.drawable.load, R.drawable.error));
			
		holder.tvTitle.setText(list.get(position).getTitle());
		
		return view;
	}
	
	
	public static class ViewHolder{
		public NetworkImageView nivImg;
		public ImageView ivImg;
		public TextView tvTitle;
	}
}
