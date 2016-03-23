package nuvemapp.com.br.exemploparcelabledata.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import nuvemapp.com.br.exemploparcelabledata.R;
import nuvemapp.com.br.exemploparcelabledata.domain.Student;

public class ClassAdapter extends BaseAdapter {
	private Context context;
	private List<Student> list;
	private LayoutInflater inflater;
	
	public ClassAdapter(Context context, List<Student> list){
		this.context = context;
		this.list = list;
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout view = (LinearLayout) inflater.inflate(R.layout.student, null);
		Student st = list.get(position);
		
		ImageView iv = (ImageView) view.findViewById(R.id.imageView);
		iv.setImageBitmap(st.getImage());
		
		TextView tv = (TextView) view.findViewById(R.id.name);
		tv.setText(st.getName());
		
		tv = (TextView) view.findViewById(R.id.age);
		tv.setText(st.getAge()+"");
		
		tv = (TextView) view.findViewById(R.id.team);
		tv.setText(st.getTeam().getName());
		
		tv = (TextView) view.findViewById(R.id.disciplines);
		tv.setText(st.getDisciplinesAsString()+"");
		
		return view;
	}

}
