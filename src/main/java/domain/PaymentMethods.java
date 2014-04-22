package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class PaymentMethods {
	private boolean deleted;
	private String revision;
	private String uuid;
	private int number;
	private String name;
	
	//ctor of PaymentMethods
	public PaymentMethods(Builder builder){
		deleted=builder.deleted;
		revision=builder.revision;
		number=builder.number;
		name=builder.name;
	}
	
	public static class Builder{
		private boolean deleted=false;
		private String revision=null;
		private int number=0;
		private String name=null;
		
		public Builder(String name){
			this.name=name;
		}
		public Builder deleted(boolean value){
			deleted=value;
			return this;
		}
		public Builder revision(String value){
			revision=value;
			return this;
		}
		public Builder number(int value){
			number=value;
			return this;
		}
		public PaymentMethods build(){
			return new PaymentMethods(this);
		}
	}
	
	public static PaymentMethods fromJSON(JSONObject obj) throws JSONException {
		if(obj.has("result") && obj.getString("result")!=null)
			obj = obj.getJSONObject("result");
			
		PaymentMethods payMeth = new PaymentMethods.Builder(obj.getString("name")).
							deleted(obj.getBoolean("deleted")).
							number(obj.getInt("number"))
						.build();
		if (obj.has("number"))
			payMeth.setNumber(obj.getInt("number"));

		return payMeth;
	}

	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("name", name);
			if (number != 0)
				obj.put("number", number);
			obj.put("deleted", deleted);
			return obj;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean post() throws IOException {
		return CloudLink.getConnector().postData(DataType.paymentMethod,this.toJSON());
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}