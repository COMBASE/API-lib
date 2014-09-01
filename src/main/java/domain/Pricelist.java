package domain;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import error.ApiNotReachableException;


public class Pricelist
{
	private String number;
	private String name;
	private boolean netPrices;
	private boolean deleted;
	private String uuidOfCurrency;
	private String uuid;

	/**
	 * standard Ctor
	 * 
	 * @param builder
	 */
	private Pricelist(final Builder builder)
	{
		name = builder.name;
		number = builder.number;
		uuid = builder.uuid;
		uuidOfCurrency = builder.uuidOfCurrency;
		deleted = builder.deleted;
		netPrices = builder.netPrices;
	}

	/**
	 * Pre-Builder Ctor
	 * 
	 * @param preBuilder
	 */
	private Pricelist(final PreBuilder preBuilder)
	{
		uuid = preBuilder.uuid;
	}

	/**
	 * Pre-initialized object when UUID is exclusively known and other fields aren't necessary. I.e.
	 * you've downloaded an object to enrich certain fields and you want to uploaded the updated
	 * one. In this scenario you don't have to resolve all its sub objects.
	 * 
	 * @author mas
	 * 
	 */
	public static class PreBuilder
	{
		private final String uuid;

		public PreBuilder(final String uuid)
		{
			this.uuid = uuid;
		}

		public Pricelist build()
		{
			return new Pricelist(this);
		}
	}

	/**
	 * standard builder pattern
	 * 
	 * @author gob
	 * 
	 */
	public static class Builder
	{
		private final String name;
		private String number = null;
		private String uuid = null;
		private final String uuidOfCurrency;
		private boolean deleted = false;
		private boolean netPrices = false;

		public Builder(final String name, final String uuidOfCurrency)
		{
			this.name = name;
			this.uuidOfCurrency = uuidOfCurrency;
		}

		public Pricelist build()
		{
			return new Pricelist(this);
		}

		public Builder deleted(final boolean value)
		{
			deleted = value;
			return this;
		}

		public Builder netPrices(final boolean value)
		{
			netPrices = value;
			return this;
		}

		public Builder number(final String value)
		{
			number = value;
			return this;
		}

		public Builder uuid(final String value)
		{
			this.uuid = value;
			return this;
		}
	}

	public static Pricelist fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		final Pricelist priceList = new Pricelist.Builder(obj.getString("name"),
			obj.getString("currency")).deleted(obj.getBoolean("deleted"))
			.uuid(obj.getString("uuid"))
			.build();
		if (obj.has("number"))
			priceList.setNumber(obj.getString("number"));

		return priceList;
	}

	public String getName()
	{
		return name;
	}

	public String getNumber()
	{
		return number;
	}

	public String getUuid()
	{
		return uuid;
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
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
		result = prime * result +
			((this.uuidOfCurrency == null) ? 0 : this.uuidOfCurrency.hashCode());

		return result;
	}

	public boolean isDeleted()
	{
		return deleted;
	}

	public boolean isNetPrices()
	{
		return netPrices;
	}

	public boolean post() throws ApiNotReachableException
	{
		boolean result = false;
		if (uuid == null)
		{
			result = CloudLink.getConnector().postData(DataType.priceList, this.toJSON());
			if (number != null)
				uuid = CloudLink.getUUIDByNumber(DataType.priceList, number);
			else
				uuid = CloudLink.getUUIDByName(DataType.priceList, name);
		}
		return result;

	}

	public void setDeleted(final boolean deleted)
	{
		this.deleted = deleted;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public void setNetPrices(final boolean netPrices)
	{
		this.netPrices = netPrices;
	}

	public void setNumber(final String number)
	{
		this.number = number;
	}

	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public void setUuidOfCurrency(final String uuidOfCurrency)
	{
		this.uuidOfCurrency = uuidOfCurrency;
	}

	public JSONObject toJSON()
	{
		final JSONObject obj = new JSONObject();
		try
		{
			obj.put("name", name);
			if (number != null)
				obj.put("number", number);
			obj.put("deleted", deleted);
			obj.put("netPrices", netPrices);
			obj.put("currency", uuidOfCurrency);
			return obj;
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}
}
