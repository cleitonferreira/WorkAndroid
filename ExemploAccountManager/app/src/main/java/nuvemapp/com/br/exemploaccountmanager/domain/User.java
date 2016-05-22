package nuvemapp.com.br.exemploaccountmanager.domain;

public class User {
	private long id;
	private String name;
	private String email;
	private String image;
	private String password;
	private String newPassword;
	
	private String accountType;
	private String authTokenType;
	private String accountName;
	private String token;
	
	
	public User(){}
	public User(long id, String name, String email, String image, String password,
			String accountType, String authTokenType, String accountName, String token){
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.image = image;
		this.password = password;
		this.accountType = accountType;
		this.authTokenType = authTokenType;
		this.accountName = accountName;
		this.token = token;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	public String getAuthTokenType() {
		return authTokenType;
	}
	public void setAuthTokenType(String authTokenType) {
		this.authTokenType = authTokenType;
	}
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
}
