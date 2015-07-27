package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Pricelist extends AbstractNameAndNumberApiObject<Pricelist>
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
		private String uuidOfCurrency = null;
		private Boolean netPrices = null;


		@Override
		public Pricelist build()
		{
			return new Pricelist(this);
		}

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
	}

	private static final long serialVersionUID = 563916800781375676L;


	private Boolean netPrices;

	private String uuidOfCurrency;

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

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

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
		result = prime * result + ((this.netPrices == null) ? 0 : this.netPrices.hashCode());

		return result;
	}

	public boolean isNetPrices()
	{
		return netPrices;
	}

	public void setNetPrices(final boolean netPrices)
	{
		this.netPrices = netPrices;
	}

	public void setUuidOfCurrency(final String uuidOfCurrency)
	{
		this.uuidOfCurrency = uuidOfCurrency;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		appendJSON(obj);

		obj.put("netPrices", netPrices);
		obj.put("currency", uuidOfCurrency);

		return obj;
	}

	@Override
	public String toString()
	{

		final StringBuilder ret = new StringBuilder();

		ret.append(this.getName());

		return ret.toString();
	}

	public static Pricelist fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
		{
			obj = obj.getJSONObject("result");
		}

		final Pricelist priceList = new Pricelist.Builder().name(nullStringToNull(obj, "name"))
			.uuidOfCurrency(nullStringToNull(obj, "currency"))
			.deleted(obj.getBoolean("deleted"))
			.id(nullStringToNull(obj, "uuid"))
			.build();
		if (obj.has("number"))
		{
			priceList.setNumber(nullStringToNull(obj, "number"));
		}

		return priceList;
	}
}
