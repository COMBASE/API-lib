package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class CustomerGroup {
	private boolean deleted;
	private String revision;
	private String uuid;
	private String number;
	private Pricelist priceGroup;
	private String name;
	
	private CustomerGroup(Builder builder) {
		name = builder.name;
		deleted=builder.deleted;
		uuid=builder.uuid;
		revision=builder.revision;
		number=builder.number;
		priceGroup=builder.priceGroup;
	}
	
	public static class Builder{
		private String name=null;
		private boolean deleted=false;
		private String revision=null;
		private String uuid=null;
		private String number=null;
		private Pricelist priceGroup=null;
		
		public Builder(String name) {
			this.name = name;
		}
		public Builder deleted(boolean value){
			deleted=value;
			return this;
		}
		public Builder uuid(String value){
			uuid=value;
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
			if (number!=null)
				obj.put("number", number);
						
			return obj;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static CustomerGroup fromJSON(JSONObject obj) throws JSONException {
		
			
		if(obj.has("result") && obj.getString("result")!=null)
			obj=obj.getJSONObject("result"); 
		
		CustomerGroup custGrp = new CustomerGroup.Builder(obj.getString("name")).
				uuid(obj.getString("uuid"))
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
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
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
		result = prime * result + ((this.revision == null) ? 0 : this.revision.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.priceGroup == null) ? 0 : this.priceGroup.hashCode());
		
		
		

		return result;
	}
	
}
