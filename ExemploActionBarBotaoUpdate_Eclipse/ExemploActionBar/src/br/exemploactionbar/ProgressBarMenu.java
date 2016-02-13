package br.exemploactionbar;

import com.actionbarsherlock.view.MenuItem;

import android.app.Activity;

public class ProgressBarMenu {
	public static void atualizar(final Activity activity, final MenuItem mi){
		mi.setActionView(R.layout.progress_bar_menu);
		
		new Thread(){
			public void run(){
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				activity.runOnUiThread(new Runnable(){
					public void run(){
						mi.setActionView(null);
						mi.setIcon(android.R.drawable.ic_menu_rotate);
					}
				});
			}
		}.start();
	}
}
