package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Cashier {
	private boolean deleted;
	private String name;
	private String uuid;
	private int number;
	private String firstName;
	private String surName;
	private int loginCode;
	
	private Cashier(Builder builder) {
		name = builder.name;
		deleted=builder.deleted;
		number=builder.number;
		firstName=builder.firstName;
		surName=builder.surName;
		loginCode=builder.loginCode;
	}
	public static class Builder {
		private final String name;
		private int number = 0;
		private boolean deleted = false;
		private String firstName=null;
		private String surName=null;
		private int loginCode=1; //default login code
		
		
		//ctor
		public Builder(String name) {
			this.name = name;
		}
		
		public Builder number(int value) {
			number = value;
			return this;
		}
		
		public Builder deleted(boolean value) {
			deleted = value;
			return this;
		}
		
		public Builder firstName(String value){
			firstName=value;
			return this;
		}
		
		public Builder surName(String value){
			surName=value;
			return this;
		}
		public Builder loginCode(int value){
			loginCode=value;
			return this;
		}
		
		public Cashier build() {
			return new Cashier(this);
		}
	}
	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("name", name);
			obj.put("deleted", deleted);
			obj.put("uuid", uuid);
			obj.put("number", number);
			obj.put("firstName", firstName);
			obj.put("surName", surName);
			return obj;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean post() throws IOException {
		
		return CloudLink.getConnector().postData(DataType.cashier,
				this.toJSON());
	}

	//******************Setter and Getter**********************************************************
	public void setDeleted(boolean del){
		this.deleted=del;
	}
	
	public boolean getDeleted(){
		return this.deleted;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setUuid(String uuid){
		this.uuid=uuid;
	}
	
	public String getUuid(){
		return this.uuid;
	}
	
	public void setNumber(int number){
		this.number=number;
	}
	
	public int getNumber(){
		return this.number;
	}
	
	public void setFirstName(String name){
		this.firstName=name;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public void setSurName(String surName){
		this.surName=surName;
	}
	
	public String getSurName(){
		return this.surName;
	}
	
	public void setLoginCode(int loginCode){
		this.loginCode=loginCode;
	}
	public int getLoginCode(){
		return this.loginCode;
	}
}