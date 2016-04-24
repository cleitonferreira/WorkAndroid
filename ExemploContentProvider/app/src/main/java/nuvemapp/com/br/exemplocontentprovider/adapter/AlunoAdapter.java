package nuvemapp.com.br.exemplocontentprovider.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import nuvemapp.com.br.exemplocontentprovider.R;
import nuvemapp.com.br.exemplocontentprovider.domain.Aluno;

public class AlunoAdapter extends BaseAdapter {
	private List<Aluno> list;
	private LayoutInflater inflater;
	
	public AlunoAdapter(Context context, List<Aluno> list){
		this.list = list;
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		return(list.size());
	}

	@Override
	public Object getItem(int position) {
		return(list.get(position));
	}

	@Override
	public long getItemId(int position) {
		return(list.get(position).getId());
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		
		if(convertView == null){
			convertView = inflater.inflate(R.layout.aluno_item, null);
			holder = new ViewHolder();
			convertView.setTag(holder);
			
			holder.ivImg = (ImageView) convertView.findViewById(R.id.ivImg);
			holder.tvNome = (TextView) convertView.findViewById(R.id.tvNome);
			holder.tvMatricula = (TextView) convertView.findViewById(R.id.tvMatricula);
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		if(list.get(position).getBitmap() == null)
			holder.ivImg.setImageBitmap(BitmapFactory.decodeFile(list.get(position).getData()));
		else
			holder.ivImg.setImageBitmap(list.get(position).getBitmap());
			
		holder.tvNome.setText(list.get(position).getNome());
		holder.tvMatricula.setText(list.get(position).getMatricula());
		
		return(convertView);
	}
	
	public class ViewHolder{
		ImageView ivImg;
		TextView tvNome;
		TextView tvMatricula;
	}

}
