package nuvemapp.com.br.exemplosocialauth.adapter;

import java.util.List;

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
import nuvemapp.com.br.exemplosocialauth.domain.Image;
import nuvemapp.com.br.exemplosocialauth.domain.User;

public class FriendsAdapter extends BaseAdapter {
	private Context ctx;
	private List<User> list;
	private LayoutInflater inflater;

	public FriendsAdapter(Context ctx, List<User> list){
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
		User user = list.get(position);
		ViewHolder holder;

		if(convertView == null){
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item, null);
			convertView.setTag(holder);

			holder.ivProfile = (ImageView) convertView.findViewById(R.id.ivProfile);
			holder.pbLoad = (ProgressBar) convertView.findViewById(R.id.pbLoad);
			holder.tvInfo = (TextView) convertView.findViewById(R.id.tvInfo);
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}

		holder.pbLoad.setVisibility(View.VISIBLE);
		holder.ivProfile.setVisibility(View.GONE);
		if(user.getProfileImageURL() != null){
			Image.loadImg(ctx, user.getProfileImageURL(), holder.ivProfile, holder.pbLoad);
		}
		else{
			holder.pbLoad.setVisibility(View.GONE);
			holder.ivProfile.setVisibility(View.VISIBLE);
			holder.ivProfile.setImageResource(R.drawable.profile_photo);
		}

		// INFO
		String contentInfo = user.getValidatedId() != null ? "<b>ID:</b> "+user.getValidatedId()+"<br />" : "";
		contentInfo += user.getFirstName() != null ? "<b>Primeiro nome:</b> "+user.getFirstName()+"<br />" : "";
		contentInfo += user.getLastName() != null ? "<b>Último nome:</b> "+user.getLastName()+"<br />" : "";
		contentInfo += user.getEmail() != null ? "<b>Email:</b> "+user.getEmail()+"<br />" : "";
		contentInfo += user.getDisplayName() != null ? "<b>Nome em amostra:</b> "+user.getDisplayName()+"<br />" : "";
		contentInfo += user.getDisplayName() != null ? "<b>Outros emails:</b> "+user.getOtherEmails().length+"<br />" : "";

		holder.tvInfo.setText(Html.fromHtml(contentInfo));

		return(convertView);
	}

	private class ViewHolder{
		ImageView ivProfile;
		ProgressBar pbLoad;
		TextView tvInfo;
	}

}
