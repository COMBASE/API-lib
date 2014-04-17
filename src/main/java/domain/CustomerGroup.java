package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class CustomerGroup {
	private boolean deleted;
	private int revision;
	private String uuid;
	private int number;
	private Pricelist priceGroup;
	private String name;
	
	private CustomerGroup(Builder builder) {
		name = builder.name;
		deleted=builder.deleted;
		revision=builder.revision;
		number=builder.number;
		priceGroup=builder.priceGroup;
	}
	
	public static class Builder{
		private String name=null;
		private boolean deleted=false;
		private int revision=0;
		private int number=0;
		private Pricelist priceGroup=null;
		
		public Builder(String name) {
			this.name = name;
		}
		public Builder deleted(boolean value){
			deleted=value;
			return this;
		}
		public Builder revision(int value){
			revision=value;
			return this;
		}
		public Builder number(int value){
			number=value;
			return this;
		}
		public Builder priceGroup(Pricelist list){
			priceGroup=list;
			return this;
		}
		public CustomerGroup build() {
			return new CustomerGroup(this);
		}
	}
	
	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("deleted", deleted);
			obj.put("revision", revision);
			obj.put("uuid", uuid);
			obj.put("name", name);
						
			return obj;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static CustomerGroup fromJSON(JSONObject obj) throws JSONException {
		
			
		if(obj.has("result") && obj.getString("result")!=null)
			obj=obj.getJSONObject("result"); 
		
		CustomerGroup custGrp = new CustomerGroup.Builder(obj.getString("name"))
				.build();
		return custGrp;
	}
	
	public boolean post() throws IOException {
		return CloudLink.getConnector().postData(DataType.customergroup,this.toJSON());
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public int getRevision() {
		return revision;
	}
	public void setRevision(int revision) {
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
	public Pricelist getPriceGroup() {
		return priceGroup;
	}
	public void setPriceGroup(Pricelist priceGroup) {
		this.priceGroup = priceGroup;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
