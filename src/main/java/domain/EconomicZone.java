package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class EconomicZone extends AbstractNameAndNumberApiObject<EconomicZone>
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
		@Override
		public EconomicZone build()
		{
			return new EconomicZone(this);
		}
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -6758068504356335216L;

	public EconomicZone(final Init<?> init)
	{
		super(init);
	}

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
		JSONObject obj = new JSONObject();
		obj = appendJSON(obj);
		return obj;
	}

	public static EconomicZone fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
		{
			obj = obj.getJSONObject("result");
		}
		final EconomicZone economicZone = new EconomicZone.Builder().name(
			nullStringToNull(obj, "name"))
			.number(nullStringToNull(obj, "number"))
			.id(nullStringToNull(obj, "uuid"))
			.deleted(obj.getBoolean("deleted"))
			.revision(obj.getLong("revision"))
			.build();
		return economicZone;
	}
}
