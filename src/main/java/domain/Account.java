package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Account {
	
	private boolean deleted;
	private String uuid;
	private String revision;
	private String number;
	
	public Account(Builder builder){
		deleted=builder.deleted;
		number=builder.number;
		uuid=builder.uuid;
	}
	
	public static class Builder{
		private boolean deleted=false;
		private String uuid=null;
		private String revision=null;
		private String number=null;
		
		public Builder deleted(boolean value){
			deleted=value;
			return this;
		}
		public Builder revision(String value){
			revision=value;
			return this;
		}
		public Builder number(String value){
			number=value;
			return this;
		}
		public Builder uuid(String value){
			uuid=value;
			return this;
		}
		public Account build(){
			return new Account(this);
		}
	}
	
	public static Account fromJSON(JSONObject obj) throws JSONException {
		if(obj.has("result") && obj.getString("result")!=null)
			obj=obj.getJSONObject("result"); 
		
		Account acc = new Account.Builder().
					deleted(obj.getBoolean("deleted")).
					revision(obj.getString("revision")).
					number(obj.getString("number")).
					uuid(obj.getString("uuid"))
					
				.build();
		return acc;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
