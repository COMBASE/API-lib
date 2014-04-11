package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Pricelist
{
	private int number;
	private String name;
	private boolean netPrices;
	private boolean deleted;
	private String uuidOfCurrency;
	private String uuid = null;

	private Pricelist(Builder builder)
	{
		name = builder.name;
		number = builder.number;
		uuidOfCurrency = builder.uuidOfCurrency;
		deleted = builder.deleted;
		netPrices = builder.netPrices;
	}

	public static class Builder
	{
		private final String name;
		private int number = 0;
		private final String uuidOfCurrency;
		private boolean deleted = false;
		private boolean netPrices = false;

		public Builder(String name, String uuidOfCurrency)
		{
			this.name = name;
			this.uuidOfCurrency = uuidOfCurrency;
		}

		public Builder number(int value)
		{
			number = value;
			return this;
		}

		public Builder deleted(boolean value)
		{
			deleted = value;
			return this;
		}

		public Builder netPrices(boolean value)
		{
			netPrices = value;
			return this;
		}

		public Pricelist build()
		{
			return new Pricelist(this);
		}
	}

	public JSONObject toJSON()
	{
		JSONObject obj = new JSONObject();
		try
		{
			obj.put("name", name);
			if (number != 0)
				obj.put("number", number);
			obj.put("deleted", deleted);
			obj.put("netPrices", netPrices);
			obj.put("currency", uuidOfCurrency);
			return obj;
		}
		catch (JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean post() throws IOException
	{
		boolean result = CloudLink.getConnector().postData(DataType.price, this.toJSON());
		if (number != 0)
			uuid = CloudLink.getUUIDByNumber(DataType.price, String.valueOf(number));
		else
			uuid = CloudLink.getUUIDByName(DataType.price, name);
		return result;
	}

	public String getUuid()
	{
		return uuid;
	}
}
