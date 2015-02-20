package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class TimeTrackingEntities extends AbstractNameAndNumberApiObject<TimeTrackingEntities>
{


	public static class Builder extends Init<Builder>
	{

		@Override
		protected Builder self()
		{
			return this;
		}

	}
	protected static abstract class Init<T extends Init<T>> extends
	AbstractNameAndNumberApiObject.Init<T>
	{
		private Boolean paidTime = null;

		@Override
		public TimeTrackingEntities build()
		{
			return new TimeTrackingEntities(this);
		}

		public T paidTime(final boolean value)
		{
			paidTime = value;
			return self();
		}
	}

	private static final long serialVersionUID = -1501561502510061367L;

	public static TimeTrackingEntities fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");
		final TimeTrackingEntities tTrackE = new TimeTrackingEntities.Builder().name(
			obj.getString("name"))
			.deleted(obj.getBoolean("deleted"))
			.id(obj.getString("uuid"))
			.number(obj.getString("number"))
			.paidTime(obj.getBoolean("paidTime"))
			.build();
		return tTrackE;
	}

	// originControlling
	private Boolean paidTime;

// public boolean post() throws IOException
// {
//
// return CloudLink.getConnector().postData(DataType.timeTrackingEntity, this.toJSON());
// }

	private TimeTrackingEntities(final Init<?> init)
	{
		super(init);
		paidTime = init.paidTime;
	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public boolean getPaidTime()
	{
		return this.paidTime;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = super.hashCode(result);
		result = prime * result + ((this.paidTime == false) ? 0 : 1);


		return result;
	}

	// ******************Setter and Getter**********************************************************
	public void setPaidTime(final boolean paidTime)
	{
		this.paidTime = paidTime;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		appendJSON(obj);

		obj.put("paidTime", paidTime);

		return obj;
	}

	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder();
		super.toString(builder);
		return builder.toString();
	}
}
