package net.tullco.addressbookapp.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class Contact {
	
	private static SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String nickname;
	private Date birthdate;
	
	private JSONObject json;
	private ArrayList<Address> addresses;
	private ArrayList<PhoneNumber> phoneNumbers;
	
	public Contact(JSONObject json){
		this.addresses = new ArrayList<Address>();
		this.phoneNumbers = new ArrayList<PhoneNumber>();
		this.json=json;
		if(json.has("first_name"))
			this.firstName=json.getString("first_name");
		if(json.has("middle_name"))
			this.middleName=json.getString("middle_name");
		if(json.has("last_name"))
			this.lastName=json.getString("last_name");
		if(json.has("birthdate"))
			try {
				this.birthdate=df.parse(json.getString("birthdate"));
			} catch (ParseException e) {}
		if(json.has("nickname"))
			this.nickname=json.getString("nickname");
		if(json.has("id"))
			this.id=json.getInt("id");
		JSONArray addressesJson = json.getJSONArray("addresses");
		for(Object o: addressesJson){
			JSONObject addressJson = (JSONObject) o;
			this.addresses.add(new Address(addressJson));
		}
		JSONArray phoneNumbersJson = json.getJSONArray("phone_numbers");
		for(Object o: phoneNumbersJson){
			JSONObject phoneNumberJson = (JSONObject) o;
			this.phoneNumbers.add(new PhoneNumber(phoneNumberJson));
		}
	}
	
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getNickname() {
		return nickname;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public JSONObject toJSON(){
		return json;
	}
}
