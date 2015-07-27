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

	// originControlling
	private Boolean paidTime;

	private TimeTrackingEntities(final Init<?> init)
	{
		super(init);
		paidTime = init.paidTime;
	}

// public boolean post() throws IOException
// {
//
// return CloudLink.getConnector().postData(DataType.timeTrackingEntity, this.toJSON());
// }

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
		result = prime * result + ((this.paidTime == null) ? 0 : this.paidTime.hashCode());


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

	public static TimeTrackingEntities fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
		{
			obj = obj.getJSONObject("result");
		}
		final TimeTrackingEntities tTrackE = new TimeTrackingEntities.Builder().name(
			nullStringToNull(obj, "name"))
			.deleted(obj.getBoolean("deleted"))
			.id(nullStringToNull(obj, "uuid"))
			.number(nullStringToNull(obj, "number"))
			.paidTime(obj.getBoolean("paidTime"))
			.build();
		return tTrackE;
	}
}
