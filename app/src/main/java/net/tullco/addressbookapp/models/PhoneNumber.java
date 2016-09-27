package net.tullco.addressbookapp.models;

import org.json.JSONException;
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
			try {
				this.id=json.getInt("id");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		if(json.has("number"))
			try {
				this.number=json.getString("number");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		if(json.has("country"))
			try {
				this.country=json.getString("country");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		if(json.has("preferred"))
			try {
				this.preferred=json.getBoolean("preferred");
			} catch (JSONException e) {
				e.printStackTrace();
			}
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
