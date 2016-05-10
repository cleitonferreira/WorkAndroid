package nuvemapp.com.br.exemplopopupwindow.util;


import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import nuvemapp.com.br.exemplopopupwindow.R;

public class Popup {
	public static void showPopupWindow(View view, String title, String info, String btLabel){

		final PopupWindow popupWindow = new PopupWindow(view.getContext());
		
		LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.popup_window, null);
		
		TextView tv = (TextView) linearLayout.findViewById(R.id.tvTitle);
		tv.setText(title);
		
		tv = (TextView) linearLayout.findViewById(R.id.tvInfo);
		tv.setText(info);
		
		Button bt = (Button) linearLayout.findViewById(R.id.btOk);
		bt.setText(btLabel);
		bt.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				popupWindow.dismiss();
			}
		});
		
		popupWindow.setContentView(linearLayout);
		popupWindow.setWidth(LayoutParams.MATCH_PARENT);
		popupWindow.setHeight(LayoutParams.WRAP_CONTENT);
		popupWindow.setOutsideTouchable(true);
		popupWindow.setAnimationStyle(R.style.PopupWindow);
		popupWindow.setBackgroundDrawable(view.getContext().getResources().getDrawable(android.R.color.transparent));
		//popupWindow.showAsDropDown(view, 0, 0);
		popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
	}
}
