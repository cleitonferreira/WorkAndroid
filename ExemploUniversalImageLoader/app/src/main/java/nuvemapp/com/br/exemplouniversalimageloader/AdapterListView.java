package nuvemapp.com.br.exemplouniversalimageloader;

import java.util.List;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import nuvemapp.com.br.exemplouniversalimageloader.domain.Post;

public class AdapterListView extends BaseAdapter {
	private List<Post> list;
	private LayoutInflater inflater;
	private ImageLoader mImageLoader;
	
	
	public AdapterListView(Context context, List<Post> list, ImageLoader mImageLoader){
		this.list = list;
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.mImageLoader = mImageLoader;
	}
	
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return (Post) list.get(position);
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
			holder = new ViewHolder();
			convertView.setTag(holder);
			
			holder.ivPost = (ImageView) convertView.findViewById(R.id.ivPost);
			holder.tvPost = (TextView) convertView.findViewById(R.id.tvPost);
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.tvPost.setText(list.get(position).getTitle());
		
		// IMAGE LOADER
		mImageLoader.displayImage(list.get(position).getUrlImage(),
			holder.ivPost,
			null,
			new ImageLoadingListener(){

				@Override
				public void onLoadingCancelled(String uri, View view) {
					Log.i("Script", "onLoadingCancelled()");
				}
	
				@Override
				public void onLoadingComplete(String uri, View view, Bitmap bmp) {
					Log.i("Script", "onLoadingComplete()");
				}
	
				@Override
				public void onLoadingFailed(String uri, View view, FailReason fail) {
					Log.i("Script", "onLoadingFailed("+fail+")");
				}
	
				@Override
				public void onLoadingStarted(String uri, View view) {
					Log.i("Script", "onLoadingStarted()");
				}
				
			}, new ImageLoadingProgressListener(){
				@Override
				public void onProgressUpdate(String uri, View view, int current, int total) {
					Log.i("Script", "onProgressUpdate("+uri+" : "+total+" : "+current+")");
				}
			});
		
		return convertView;
	}

	
	private class ViewHolder{
		public ImageView ivPost;
		public TextView tvPost;
	}
}
