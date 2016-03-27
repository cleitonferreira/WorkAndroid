package nuvemapp.com.br.exemploimagefolders;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
	private List<Line> list;
	private LayoutInflater inflater;
	
	public ListAdapter(Context context, List<Line> list){
		this.list = list;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
		view = inflater.inflate(R.layout.line, null);
		
		ImageView iv = (ImageView) view.findViewById(R.id.imageView);
		iv.setImageResource(list.get(position).getIdImage());
		
		TextView tv = (TextView) view.findViewById(R.id.textView);
		tv.setText(list.get(position).getLabel());
		
		return view;
	}

}
