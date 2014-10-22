package domain;

import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class TimeTracking extends AbstractApiObject<TimeTracking>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -740149629390934463L;
	private Cashier cashier;
	private String org;
	private Date start;
	private TimeTrackingEntities timeTrackingEntity;

	private TimeTracking(final Init<?> init)
	{
		super(init);
		cashier = init.cashier;
		org = init.org;
		start = init.start;
		timeTrackingEntity = init.timeTrackingEntity;

	}

	public static abstract class Init<T extends Init<T>> extends AbstractApiObject.Init<T>
	{
		private Cashier cashier = null;
		private String org;
		private Date start;
		private TimeTrackingEntities timeTrackingEntity;

		public T cashier(final Cashier cash)
		{
			cashier = cash;
			return self();
		}

		public T org(final String value)
		{
			org = value;
			return self();
		}

		public T start(final Date value)
		{
			start = value;
			return self();
		}

		public T timeTrackingentity(final TimeTrackingEntities entity)
		{
			timeTrackingEntity = entity;
			return self();
		}

		@Override
		public TimeTracking build()
		{
			return new TimeTracking(this);
		}
	}

	public static class Builder extends Init<Builder>
	{

		@Override
		protected Builder self()
		{
			return this;
		}

	}

// public static TimeTracking fromJSON(JSONObject obj) throws JSONException
// {
// if (obj.has("result") && obj.getString("result") != null)
// obj = obj.getJSONObject("result");
//
// // Date
// final String date = obj.getString("start");
// Date startTime = null;
// try
// {
// startTime = inputDf.parse(date);
// }
// catch (final ParseException e)
// {
// e.printStackTrace();
// }
//
// final TimeTrackingEntities ent = new TimeTrackingEntities.Builder(null).build();
// ent.setUuid(obj.getString("timeTrackingEntity"));
// final Cashier cash = new Cashier.Builder(null).build();
// cash.setUuid(obj.getString("cashier"));
// final TimeTracking tTrack = new TimeTracking.Builder().deleted(obj.getBoolean("deleted"))
// .start(startTime)
// .timeTrackingentity(ent)
// .cashier(cash)
// .revision(obj.getString("revision"))
// .build();
// return tTrack;
// }
//
// @Override
// public JSONObject toJSON()
// {
// final JSONObject obj = new JSONObject();
// try
// {
// obj.put("deleted", deleted);
// obj.put("uuid", uuid);
// obj.put("cashier", cashier);
// obj.put("org", org);
// obj.put("start", start);
// obj.put("timeTrackingEntity", timeTrackingEntity);
// return obj;
// }
// catch (final JSONException e)
// {
// e.printStackTrace();
// return null;
// }
// }
//
// public boolean post() throws IOException
// {
//
// if (cashier != null && cashier.getUuid() == null)
// cashier.post();
// if (timeTrackingEntity != null && timeTrackingEntity.getUuid() == null)
// timeTrackingEntity.post();
// return CloudLink.getConnector().postData(DataType.timeTracking, this.toJSON());
// }

	// ******************Setter and Getter**********************************************************
	public void setCashier(final Cashier cashier)
	{
		this.cashier = cashier;
	}

	public Cashier getCashier()
	{
		return this.cashier;
	}

	public void setOrg(final String org)
	{
		this.org = org;
	}

	public String getOrg()
	{
		return this.org;
	}

	public void setStart(final Date start)
	{
		this.start = start;
	}

	public Date getStart()
	{
		return this.start;
	}

	public void setTimeTrackingEntitiy(final TimeTrackingEntities timeTrackingEntity)
	{
		this.timeTrackingEntity = timeTrackingEntity;
	}

	public TimeTrackingEntities getTimeTrackingEntity()
	{
		return this.timeTrackingEntity;
	}


	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = prime * result + ((this.org == null) ? 0 : this.org.hashCode());


		result = prime * result + ((this.cashier == null) ? 0 : this.cashier.hashCode());
		result = prime * result + ((this.start == null) ? 0 : this.start.hashCode());
		result = prime * result +
			((this.timeTrackingEntity == null) ? 0 : this.timeTrackingEntity.hashCode());


		return result;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		writeJSON(obj);
		return obj;
	}

	@Override
	public void writeJSON(final JSONObject obj) throws JSONException
	{
		super.writeJSON(obj);

	}

	@Override
	public TimeTracking fromJSON(final JSONObject obj) throws JSONException
	{
		readJSON(obj);
		return this;
	}

	@Override
	public void readJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		super.readJSON(obj);


	}
}
