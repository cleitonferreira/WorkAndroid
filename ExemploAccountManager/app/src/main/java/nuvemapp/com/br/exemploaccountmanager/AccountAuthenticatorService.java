package nuvemapp.com.br.exemploaccountmanager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class AccountAuthenticatorService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		Log.i("Script", "AccountAuthenticatorService.onBind()");
		AccountAuthenticator mAccountAuthenticator = new AccountAuthenticator(AccountAuthenticatorService.this);
		return(mAccountAuthenticator.getIBinder());
	}

}
