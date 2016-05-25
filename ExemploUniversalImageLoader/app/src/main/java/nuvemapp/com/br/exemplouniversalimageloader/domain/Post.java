package nuvemapp.com.br.exemplouniversalimageloader.domain;

public class Post {
	private String title;
	private String urlImage;
	
	
	public Post(){}
	public Post(String title, String urlImage){
		this.title = title;
		this.urlImage = urlImage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
}
