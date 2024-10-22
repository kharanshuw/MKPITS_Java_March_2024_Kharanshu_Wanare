package com.MVC_1.entity;

import java.util.List;

public class Student {

	private String firstnameString;

	private String lastnameString;

	private String country;

	private String favoriteLanguage;

	private List<String> fevoritesystem;

	public List<String> getFevoritesystem() {
		return fevoritesystem;
	}

	public void setFevoritesystem(List<String> fevoritesystem) {
		this.fevoritesystem = fevoritesystem;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstnameString() {
		return firstnameString;
	}

	public void setFirstnameString(String firstnameString) {
		this.firstnameString = firstnameString;
	}

	public String getLastnameString() {
		return lastnameString;
	}

	public void setLastnameString(String lastnameString) {
		this.lastnameString = lastnameString;
	}

	@Override
	public String toString() {
		return "Student [firstnameString=" + firstnameString + ", lastnameString=" + lastnameString + ", country="
				+ country + ", favoriteLanguage=" + favoriteLanguage + "]";
	}

}
