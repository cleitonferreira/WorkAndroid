package nuvemapp.com.br.exemplosocialauth.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.brickred.socialauth.util.BirthDate;

public class User implements Serializable {
	private static final long serialVersionUID = -7639894856975329372L;
	private String providerId;
	private String validatedId;
	private String firstName;
	private String lastName;
	private String email;
	private String country;
	private String language;
	private String location;
	private String profileImageURL;
	private String gender;
	private String displayName;
	private String fullName;
	private Map<String, String> contactInfo;
	private BirthDate birthDate;
	private List<User> friends;
	
	
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	
	
	public String getValidatedId() {
		return validatedId;
	}
	public void setValidatedId(String validatedId) {
		this.validatedId = validatedId;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	public String getProfileImageURL() {
		return profileImageURL;
	}
	public void setProfileImageURL(String profileImageURL) {
		this.profileImageURL = profileImageURL;
	}
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
	public Map<String, String> getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(Map<String, String> contactInfo) {
		this.contactInfo = contactInfo;
	}
	
	
	public BirthDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(BirthDate birthDate) {
		this.birthDate = birthDate;
	}
	
	
	public List<User> getFriends() {
		return friends;
	}
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
}
