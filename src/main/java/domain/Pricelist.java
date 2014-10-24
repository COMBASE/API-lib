package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Pricelist extends AbstractNameAndNumberApiObject<Pricelist>
{
	private static final long serialVersionUID = 563916800781375676L;
	private boolean netPrices;
	private String uuidOfCurrency;


	protected static abstract class Init<T extends Init<T>> extends
		AbstractNameAndNumberApiObject.Init<T>
	{
		private String uuidOfCurrency = null;
		private boolean netPrices = false;


		public T netPrices(final boolean value)
		{
			netPrices = value;
			return self();
		}

		public T uuidOfCurrency(final String value)
		{
			this.uuidOfCurrency = value;
			return self();
		}

		@Override
		public Pricelist build()
		{
			return new Pricelist(this);
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

	public Pricelist(final Init<?> init)
	{
		super(init);
		this.netPrices = init.netPrices;
		this.uuidOfCurrency = init.uuidOfCurrency;
	}

// public static Pricelist fromJSON(JSONObject obj) throws JSONException
// {
//
// }

	public String getUuidOfCurrency()
	{
		return uuidOfCurrency;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = super.hashCode(result);
		result = prime * result +
			((this.uuidOfCurrency == null) ? 0 : this.uuidOfCurrency.hashCode());
		result = prime * result + ((this.netPrices == false) ? 0 : 1);

		return result;
	}

	public boolean isNetPrices()
	{
		return netPrices;
	}

// public boolean post() throws ApiNotReachableException
// {
// boolean result = false;
// if (uuid == null)
// {
// result = CloudLink.getConnector().postData(DataType.priceList, this.toJSON());
// if (number != null)
// uuid = CloudLink.getUUIDByNumber(DataType.priceList, number);
// else
// uuid = CloudLink.getUUIDByName(DataType.priceList, name);
// }
// return result;
//
// }

	public void setNetPrices(final boolean netPrices)
	{
		this.netPrices = netPrices;
	}

	public void setUuidOfCurrency(final String uuidOfCurrency)
	{
		this.uuidOfCurrency = uuidOfCurrency;
	}

// public JSONObject toJSON()
// {
// final JSONObject obj = new JSONObject();
// try
// {
// obj.put("name", name);
// if (number != null)
// obj.put("number", number);
// obj.put("deleted", deleted);
// obj.put("netPrices", netPrices);
// obj.put("currency", uuidOfCurrency);
// return obj;
// }
// catch (final JSONException e)
// {
// e.printStackTrace();
// return null;
// }
// }

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
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

	public static Pricelist fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		final Pricelist priceList = new Pricelist.Builder().name(obj.getString("name"))
			.uuidOfCurrency(obj.getString("currency"))
			.deleted(obj.getBoolean("deleted"))
			.id(obj.getString("uuid"))
			.build();
		if (obj.has("number"))
			priceList.setNumber(obj.getString("number"));

		return priceList;
	}
}
