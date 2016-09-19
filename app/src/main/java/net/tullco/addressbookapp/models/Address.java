package net.tullco.addressbookapp.models;

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
			this.id=json.getInt("id");
		if(json.has("street"))
			this.street=json.getString("street");
		if(json.has("apartment"))
			this.apartment=json.getString("apartment");
		if(json.has("city"))
			this.city=json.getString("city");
		if(json.has("state"))
			this.state=json.getString("state");
		if(json.has("country"))
			this.country=json.getString("country");
		if(json.has("active"))
			this.active=json.getBoolean("active");
		if(json.has("zip_code"))
			this.zipCode=json.getString("zip_code");
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
