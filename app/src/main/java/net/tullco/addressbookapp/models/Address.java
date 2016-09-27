package net.tullco.addressbookapp.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Address {

	private int id;
	private String street;
	private String apartment;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private boolean active;
	private JSONObject json;
	
	public Address(JSONObject json) {
		if(json.has("id"))
			try {
				this.id=json.getInt("id");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		if(json.has("street"))
			try {
				this.street=json.getString("street");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		if(json.has("apartment"))
			try {
				this.apartment=json.getString("apartment");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		if(json.has("city"))
			try {
				this.city=json.getString("city");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		if(json.has("state"))
			try {
				this.state=json.getString("state");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		if(json.has("country"))
			try {
				this.country=json.getString("country");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		if(json.has("active"))
			try {
				this.active=json.getBoolean("active");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		if(json.has("zip_code"))
			try {
				this.zipCode=json.getString("zip_code");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		this.json=json;
	}
	
	public int getId(){
		return id;
	}
	public String getStreet(){
		return street;
	}
	public String getApartment(){
		return apartment;
	}
	public String getCity(){
		return city;
	}
	public String getZipCode(){
		return zipCode;
	}
	public String getCountry(){
		return country;
	}
	public String getState(){
		return state;
	}
	public boolean active(){
		return active;
	}
	public JSONObject toJSON(){
		return json;
	}

}
