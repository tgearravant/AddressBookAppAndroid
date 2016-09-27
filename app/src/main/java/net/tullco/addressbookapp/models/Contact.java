package net.tullco.addressbookapp.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
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
			try {
				this.firstName=json.getString("first_name");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		if(json.has("middle_name"))
			try {
				this.middleName=json.getString("middle_name");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		if(json.has("last_name"))
			try {
				this.lastName=json.getString("last_name");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		if(json.has("birthdate"))
			try {
				this.birthdate=df.parse(json.getString("birthdate"));
			} catch (ParseException e) {} catch(JSONException e) {
				e.printStackTrace();
			}
		if(json.has("nickname"))
            try {
                this.nickname=json.getString("nickname");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        if(json.has("id"))
            try {
                this.id=json.getInt("id");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        try {
            JSONArray addressesJson = json.getJSONArray("addresses");
            for (int i=0; i < addressesJson.length(); i++) {
                JSONObject addressJson = addressesJson.getJSONObject(i);
                this.addresses.add(new Address(addressJson));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            JSONArray phoneNumbersJson = json.getJSONArray("phone_numbers");
            for (int i=0; i < phoneNumbersJson.length(); i++) {
                JSONObject phoneNumberJson = phoneNumbersJson.getJSONObject(i);
                this.phoneNumbers.add(new PhoneNumber(phoneNumberJson));
            }
        } catch (JSONException e) {
            e.printStackTrace();
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
