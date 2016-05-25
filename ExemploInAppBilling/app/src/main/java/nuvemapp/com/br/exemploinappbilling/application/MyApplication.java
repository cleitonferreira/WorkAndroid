package nuvemapp.com.br.exemploinappbilling.application;


import android.app.Application;

import nuvemapp.com.br.exemploinappbilling.util.IabHelper;

public class MyApplication extends Application {
	private IabHelper mHelper;
	
	@Override
	public void onCreate(){
		super.onCreate();
	}

	public IabHelper getmHelper() {
		return mHelper;
	}
	public void setmHelper(IabHelper mHelper) {
		this.mHelper = mHelper;
	}
}
