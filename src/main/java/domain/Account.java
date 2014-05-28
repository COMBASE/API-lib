package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Account {
	
	private boolean deleted;
	private String uuid;
	private String revision;
	private String number;
	private String name;
	
	private String type;
	private boolean requiresSerialNumber;
	
	
	
	
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
		private String name=null;
		private String type=null;
		private boolean requiresSerialNumber=false;
		
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
		public Builder name(String value){
			name=value;
			return this;
		}
		public Builder type(String value){
			type=value;
			return this;
		}
		public Builder requiresSerialNumber(boolean value){
			requiresSerialNumber=value;
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
					uuid(obj.getString("uuid")).
					name(obj.getString("name")).
					type(obj.getString("type")).
					requiresSerialNumber(obj.getBoolean("requiresSerialNumber"))
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isRequiresSerialNumber() {
		return requiresSerialNumber;
	}

	public void setRequiresSerialNumber(boolean requiresSerialNumber) {
		this.requiresSerialNumber = requiresSerialNumber;
	}
}
