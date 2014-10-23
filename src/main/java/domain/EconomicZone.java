package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class EconomicZone extends AbstractNameAndNumberApiObject<EconomicZone>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6758068504356335216L;

	protected static abstract class Init<T extends Init<T>> extends
		AbstractNameAndNumberApiObject.Init<T>
	{
		@Override
		public EconomicZone build()
		{
			return new EconomicZone(this);
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

	public EconomicZone(final Init<?> init)
	{
		super(init);
	}

// public static EconomicZone fromJson(JSONObject obj) throws JSONException
// {
//
// }
//
// public JSONObject toJSON()
// {
// final JSONObject obj = new JSONObject();
// try
// {
// obj.put("name", name);
// if (number != null)
// obj.put("number", number);
// return obj;
// }
// catch (final JSONException e)
// {
// e.printStackTrace();
// return null;
// }
// }
//
// public boolean post() throws ApiNotReachableException
// {
// final boolean result = CloudLink.getConnector().postData(DataType.economicZone,
// this.toJSON());
// if (number != null)
// uuid = CloudLink.getUUIDByNumber(DataType.economicZone, number);
// else
// uuid = CloudLink.getUUIDByName(DataType.economicZone, name);
// return result;
// }

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	@Override
	public int hashCode()
	{
		// final int prime = 31;
		int result = 1;

		result = super.hashCode(result);


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

	public static EconomicZone fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");
		final EconomicZone economicZone = new EconomicZone.Builder().name(obj.getString("name"))
			.number(obj.getString("number"))
			.id(obj.getString("uuid"))
			.build();
		return economicZone;
	}
}
