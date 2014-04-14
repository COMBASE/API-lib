package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class TimeTrackingEntities {
	private boolean deleted;
	private String name;
	//originControlling
	private String uuid;
	private int number;
	private boolean paidTime;
	
	private TimeTrackingEntities(Builder builder) {
		name = builder.name;
		deleted=builder.deleted;
		number=builder.number;
		paidTime=builder.paidTime;
		uuid=builder.uuid;
		
	}
	public static class Builder {
		private final String name;
		private int number = 0;
		private boolean deleted = false;
		private boolean paidTime;
		private String uuid;
		
		
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
		
		public Builder paidTime(boolean value){
			paidTime=value;
			return this;
		}
		public Builder uuid(String value){
			uuid=value;
			return this;
		}
				
		public TimeTrackingEntities build() {
			return new TimeTrackingEntities(this);
		}
	}
	
	public static TimeTrackingEntities fromJSON(JSONObject obj) throws JSONException {
		
		obj = obj.getJSONObject("result");
		TimeTrackingEntities tTrackE = new TimeTrackingEntities.Builder(obj.getString("name")).deleted(obj.getBoolean("deleted")).uuid(obj.getString("uuid")).number(obj.getInt("number")).paidTime(obj.getBoolean("paidTime"))
				.build();
		return tTrackE;
	}
	
	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("name", name);
			obj.put("deleted", deleted);
			obj.put("uuid", uuid);
			obj.put("number", number);
			obj.put("paidTime", paidTime);
			return obj;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean post() throws IOException {
		
		return CloudLink.getConnector().postData(DataType.timeTrackingEntity,
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
	
	public void setPaidTime(boolean paidTime){
		this.paidTime=paidTime;
	}
	
	public boolean getPaidTime(){
		return this.paidTime;
	}
	@Override
	public String toString() {
		return name;
	}
}
