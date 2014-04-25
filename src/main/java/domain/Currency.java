package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Currency {
	private boolean deleted;
	private static String name;
	private int number;
	private String uuid;
	private String revision;
	private String symbol;
	private String key;
	private String centName;

	private Currency(Builder builder){
		deleted=builder.deleted;
		name=builder.name;
		number=builder.number;
		uuid=builder.uuid;
		revision=builder.revision;
		symbol=builder.symbol;
		key=builder.key;
		centName=builder.centName;
	}

	public static class Builder {
		private boolean deleted = false;
		private String name = null;
		private int number = 0;
		private String uuid = null;
		private String revision = null;
		private String symbol = null;
		private String key = null;
		private String centName = null;
		
		public Builder(String name){
			this.name=name;
		}
		public Builder deleted(boolean value) {
			deleted = value;
			return this;
		}
		public Builder number(int value) {
			number = value;
			return this;
		}
		public Builder uuid(String value) {
			uuid = value;
			return this;
		}
		public Builder revision(String value) {
			revision = value;
			return this;
		}
		public Builder symbol(String value) {
			symbol = value;
			return this;
		}
		public Builder key(String value) {
			key = value;
			return this;
		}
		public Builder centName(String value) {
			 centName = value;
			return this;
		}
		public Currency build(){
			return new Currency(this);
		}
	}
	
	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("deleted", deleted);
			obj.put("revision", revision);
			obj.put("uuid", uuid);
			obj.put("name",name);
			obj.put("number",number);
			obj.put("symbol",symbol);
			obj.put("key",key);
			obj.put("centName",centName);
			
			return obj;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Currency fromJSON(JSONObject obj) throws JSONException {
		if(obj.has("result") && obj.getString("result")!=null)
			obj=obj.getJSONObject("result"); 
		Currency cur = new Currency.Builder(obj.getString("name")).
					deleted(obj.getBoolean("deleted")).
					revision(obj.getString("revision")).
					uuid(obj.getString("uuid")).
					number(obj.getInt("number")).
					symbol(obj.getString("symbol")).
					key(obj.getString("key")).
					centName(obj.getString("centName"))
				.build();
		return cur;
	}
	
	public boolean post() throws IOException {
		
		return CloudLink.getConnector().postData(DataType.currency,
				this.toJSON());
		
	}
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCentName() {
		return centName;
	}

	public void setCentName(String centName) {
		this.centName = centName;
	}

}
