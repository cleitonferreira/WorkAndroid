package nuvemapp.com.br.exemploaccountmanager.conf;

public class Constant {
	// SERVER
	//public static final String SERVER_URL = "http://www.villopim.com.br/android/accountmanager/ctrl/CtrlAccountManager.php";

	//Teste LocalHost -> Verificar o IP da máquina
	//colocar os arquivos na pasta www e depois criar o banco mysql
	public static final String SERVER_URL = "http://192.168.1.4/android/accountManager/ctrl/CtrlAccountManager.php";

	// ACCOUNT MANAGER
		public static final String ACCOUNT_TYPE = "nuvemapp.com.br.exemploaccountmanager";
		public static final String ACCOUNT_TOKEN_TYPE = "full";
		
		public static final String ARG_ACCOUNT_TYPE = "ACCOUNT_TYPE";
		public static final String ARG_AUTH_TYPE = "AUTH_TYPE";
		public static final String ARG_ACCOUNT_NAME = "ACCOUNT_NAME";
}
