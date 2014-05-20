package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class OrganizationalUnit {
	private boolean deleted;
	private String revision;
	private String uuid;
	private String number;
	private String name;
	private String parent;
	//private AssortmentValidities assortmentValidities;
	//private AdressInformation adressInformation;
	private Pricelist priceGroup;
	//private OrderingSources orderingSources;
	private String storageSpace;
	private String salesArea;
	private boolean mondayOpen;
	private boolean tuesdayOpen;
	private boolean wednesdayOpen;
	private boolean thursdayOpen;
	private boolean fridayOpen;
	private boolean saturdayOpen;
	private boolean sundayOpen;
	private boolean hasChildren;
	//usw...
	
	private OrganizationalUnit(Builder builder) {
		deleted=builder.deleted;
		revision=builder.revision;
		number=builder.number;
		uuid=builder.uuid;
		name=builder.name;
		parent=builder.parent;
	}
	
	public static class Builder {
		private boolean deleted=false;
		private String revision=null;
		private String uuid=null;
		private String number=null;
		private String name=null;
		private String parent=null;
		//private AssortmentValidities assortmentValidities;
		//private AdressInformation adressInformation;
		private Pricelist priceGroup=null;
		//private OrderingSources orderingSources;
		private String storageSpace=null;
		private String salesArea=null;
		private boolean mondayOpen=false;
		private boolean tuesdayOpen=false;
		private boolean wednesdayOpen=false;
		private boolean thursdayOpen=false;
		private boolean fridayOpen=false;
		private boolean saturdayOpen=false;
		private boolean sundayOpen=false;
		private boolean hasChildren=false;
		//usw...
		
		public Builder(String name) {
			this.name=name;
		}
		
		public Builder deleted(boolean value){
			deleted=value;
			return this;
		} 
		
		public Builder uuid(String value){
			uuid=value;
			return this;
		}
		
		public Builder number(String value){
			number=value;
			return this;
		}
		
		public OrganizationalUnit build(){
			return new OrganizationalUnit(this);
		}
	}
	
	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("name", name);
			obj.put("deleted", deleted);
			obj.put("revision", revision);
			obj.put("uuid", uuid);
			obj.put("number", number);
			
			//Dependencies to existence of other objects
			
			return obj;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static OrganizationalUnit fromJSON(JSONObject obj) throws JSONException {
		if(obj.has("result") && obj.getString("result")!=null)
			obj=obj.getJSONObject("result"); 
		OrganizationalUnit orgUnit = new OrganizationalUnit.Builder(null).
					deleted(obj.getBoolean("deleted")).
					number(obj.getString("number")).
					uuid(obj.getString("uuid"))
				.build();
		return orgUnit;
	}
	
	public boolean post() throws IOException {
		
		//dependencies
		return CloudLink.getConnector().postData(DataType.organizationalUnit,
				this.toJSON());
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public Pricelist getPriceGroup() {
		return priceGroup;
	}
	public void setPriceGroup(Pricelist priceGroup) {
		this.priceGroup = priceGroup;
	}
	public String getStorageSpace() {
		return storageSpace;
	}
	public void setStorageSpace(String storageSpace) {
		this.storageSpace = storageSpace;
	}
	public String getSalesArea() {
		return salesArea;
	}
	public void setSalesArea(String salesArea) {
		this.salesArea = salesArea;
	}
	public boolean isMondayOpen() {
		return mondayOpen;
	}
	public void setMondayOpen(boolean mondayOpen) {
		this.mondayOpen = mondayOpen;
	}
	public boolean isTuesdayOpen() {
		return tuesdayOpen;
	}
	public void setTuesdayOpen(boolean tuesdayOpen) {
		this.tuesdayOpen = tuesdayOpen;
	}
	public boolean isWednesdayOpen() {
		return wednesdayOpen;
	}
	public void setWednesdayOpen(boolean wednesdayOpen) {
		this.wednesdayOpen = wednesdayOpen;
	}
	public boolean isThursdayOpen() {
		return thursdayOpen;
	}
	public void setThursdayOpen(boolean thursdayOpen) {
		this.thursdayOpen = thursdayOpen;
	}
	public boolean isFridayOpen() {
		return fridayOpen;
	}
	public void setFridayOpen(boolean fridayOpen) {
		this.fridayOpen = fridayOpen;
	}
	public boolean isSaturdayOpen() {
		return saturdayOpen;
	}
	public void setSaturdayOpen(boolean saturdayOpen) {
		this.saturdayOpen = saturdayOpen;
	}
	public boolean isSundayOpen() {
		return sundayOpen;
	}
	public void setSundayOpen(boolean sundayOpen) {
		this.sundayOpen = sundayOpen;
	}
	public boolean isHasChildren() {
		return hasChildren;
	}
	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
	
	
	
	
}
