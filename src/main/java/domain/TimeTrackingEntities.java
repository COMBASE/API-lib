package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class TimeTrackingEntities extends AbstractNameAndNumberApiObject<TimeTrackingEntities>
{


	private static final long serialVersionUID = -1501561502510061367L;
	// originControlling
	private boolean paidTime;

	protected static abstract class Init<T extends Init<T>> extends
		AbstractNameAndNumberApiObject.Init<T>
	{
		private boolean paidTime;

		public T paidTime(final boolean value)
		{
			paidTime = value;
			return self();
		}

		@Override
		public TimeTrackingEntities build()
		{
			return new TimeTrackingEntities(this);
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

	private TimeTrackingEntities(final Init<?> init)
	{
		super(init);
		paidTime = init.paidTime;
	}

// public static TimeTrackingEntities fromJSON(JSONObject obj) throws JSONException
// {
//

// }
//
// @Override
// public JSONObject toJSON()
// {
// final JSONObject obj = new JSONObject();
// try
// {
// obj.put("name", name);
// obj.put("deleted", deleted);
// obj.put("uuid", uuid);
// if (number != null)
// obj.put("number", number);
// obj.put("paidTime", paidTime);
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
// return CloudLink.getConnector().postData(DataType.timeTrackingEntity, this.toJSON());
// }

	// ******************Setter and Getter**********************************************************
	public void setPaidTime(final boolean paidTime)
	{
		this.paidTime = paidTime;
	}

	public boolean getPaidTime()
	{
		return this.paidTime;
	}

	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder();
		super.toString(builder);
		return builder.toString();
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

		result = super.hashCode(result);
		result = prime * result + ((this.paidTime == false) ? 0 : 1);


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
}
