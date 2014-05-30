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
	private String number;
	private boolean paidTime;
	
	private TimeTrackingEntities(Builder builder) {
		name = builder.name;
		deleted=builder.deleted;
		number=builder.number;
		paidTime=builder.paidTime;
		uuid=builder.uuid;
		
	}
	public static class Builder {
		private String name;
		private String number = null;
		private boolean deleted = false;
		private boolean paidTime;
		private String uuid;
		
		
		//ctor
		public Builder(String name) {
			this.name = name;
		}
		
		public Builder number(String value) {
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
		
		if(obj.has("result") && obj.getString("result")!=null)
			obj=obj.getJSONObject("result"); 
		TimeTrackingEntities tTrackE = new TimeTrackingEntities.
							Builder(obj.getString("name")).
							deleted(obj.getBoolean("deleted")).
							uuid(obj.getString("uuid")).
							number(obj.getString("number")).
							paidTime(obj.getBoolean("paidTime"))
				.build();
		return tTrackE;
	}
	
	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("name", name);
			obj.put("deleted", deleted);
			obj.put("uuid", uuid);
			if (number!=null)
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
	
	public void setNumber(String number){
		this.number=number;
	}
	
	public String getNumber(){
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
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		
		
		

		return result;
	}
}
