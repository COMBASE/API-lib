package domain;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;




public class TimeTracking {
	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
	private boolean deleted;
	private String revision;
	private String uuid;
	private Cashier cashier;
	private String org;
	private Date start;
	private TimeTrackingEntities timeTrackingEntity;
	
	private TimeTracking(Builder builder) {
		deleted=builder.deleted;
		revision=builder.revision;
		cashier=builder.cashier;
		org=builder.org;
		start=builder.start;
		timeTrackingEntity=builder.timeTrackingEntity;
		
	}
	public static class Builder {
		private String revision=null;
		private boolean deleted = true;
		private Cashier cashier=null;
		private String org;
		private Date start;
		private TimeTrackingEntities timeTrackingEntity;
		
		
		//ctor
		public Builder() {

		}
		
		public Builder deleted(boolean value) {
			deleted = value;
			return this;
		}
		
		public Builder revision(String value){
			revision=value;
			return this;
		}
		
		public Builder cashier(Cashier cash){
			cashier=cash;
			return this;
		}
		
		public Builder org(String value){
			org=value;
			return this;
		}
		
		public Builder start(Date value){
			start=value;
			return this;
		}
		
		public Builder timeTrackingentity(TimeTrackingEntities entity){
			timeTrackingEntity=entity;
			return this;
		}
		
		public TimeTracking build() {
			return new TimeTracking(this);
		}
	}
	
	public static TimeTracking fromJSON(JSONObject obj) throws JSONException {
		if(obj.has("result") && obj.getString("result")!=null)
			obj=obj.getJSONObject("result"); 
		
		//Date
		String date=obj.getString("start");
		Date startTime=null;
		try {
			startTime = inputDf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		TimeTrackingEntities ent=new TimeTrackingEntities.Builder(null).build();
		ent.setUuid(obj.getString("timeTrackingEntity"));
		Cashier cash=new Cashier.Builder(null).build();
		cash.setUuid(obj.getString("cashier"));
		TimeTracking tTrack = new TimeTracking.Builder().
				deleted(obj.getBoolean("deleted")).
				start(startTime).
				timeTrackingentity(ent).
				cashier(cash).
				revision(obj.getString("revision"))
						.build();
		return tTrack;
	}
	
	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("deleted", deleted);
			obj.put("uuid", uuid);
			obj.put("cashier", cashier);
			obj.put("org", org);
			obj.put("start", start);
			obj.put("timeTrackingEntity", timeTrackingEntity);
			return obj;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean post() throws IOException {
		
		if (cashier != null && cashier.getUuid() == null)
			cashier.post();
		if (timeTrackingEntity != null && timeTrackingEntity.getUuid() == null)
			timeTrackingEntity.post();
		return CloudLink.getConnector().postData(DataType.timeTracking,
				this.toJSON());
	}
	
	//******************Setter and Getter**********************************************************
	public void setDeleted(boolean del){
		this.deleted=del;
	}
	
	public boolean isDeleted(){
		return this.deleted;
	}
	
	public void setUuid(String uuid){
		this.uuid=uuid;
	}
	
	public String getUuid(){
		return this.uuid;
	}
	
	public void setCashier(Cashier cashier){
		this.cashier=cashier;
	}
	
	public Cashier getCashier(){
		return this.cashier;
	}
	
	public void setOrg(String org){
		this.org=org;
	}
	
	public String getOrg(){
		return this.org;
	}
	
	public void setStart(Date start){
		this.start=start;
	}
	
	public Date getStart(){
		return this.start;
	}
	
	public void setTimeTrackingEntitiy(TimeTrackingEntities timeTrackingEntity){
		this.timeTrackingEntity=timeTrackingEntity;
	}
	
	public TimeTrackingEntities getTimeTrackingEntity(){
		return this.timeTrackingEntity;
	}
	public String getRevision() {
		return revision;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((this.org == null) ? 0 : this.org.hashCode());
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
		result = prime * result + ((this.revision == null) ? 0 : this.revision.hashCode());
		result = prime * result + ((this.cashier == null) ? 0 : this.cashier.hashCode());
		result = prime * result + ((this.start == null) ? 0 : this.start.hashCode());
		result = prime * result + ((this.timeTrackingEntity == null) ? 0 : this.timeTrackingEntity.hashCode());
		
		
		
		

		return result;
	}
}
