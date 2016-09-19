package net.tullco.addressbookapp.models;

import org.json.JSONObject;

public class PhoneNumber {

	private int id;
	private String number;
	private String type;
	private String country;
	private boolean preferred;
	private JSONObject json;
	public PhoneNumber(JSONObject json) {
		if(json.has("id"))
			this.id=json.getInt("id");
		if(json.has("number"))
			this.number=json.getString("number");
		if(json.has("country"))
			this.country=json.getString("country");
		if(json.has("preferred"))
			this.preferred=json.getBoolean("preferred");
		this.json=json;
	}
	
	public int getId(){
		return id;
	}
	public String getNumber(){
		return number;
	}
	public String getType(){
		return type;
	}
	public String getCountry(){
		return country;
	}
	public boolean getPreferred(){
		return preferred;
	}
	public JSONObject toJSON(){
		return json;
	}
}
