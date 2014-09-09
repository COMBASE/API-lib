package domain;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import link.CloudLink;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import error.ApiNotReachableException;

public class Tax
{
	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

	private final String name;
	private final String number;
	private final boolean deleted;
	private final boolean included;
	private final EconomicZone economicZone;
	private List<Rate> rateList;
	private String uuid;

	private Tax(final Builder builder)
	{
		name = builder.name;
		number = builder.number;
		deleted = builder.deleted;
		included = builder.included;
		economicZone = builder.economicZone;
		rateList = builder.rateList;
		uuid = builder.uuid;
	}

	public static class Builder
	{
		private final String name;
		private String number = null;
		private final EconomicZone economicZone;
		private boolean deleted = false;
		private boolean included = false;
		private List<Rate> rateList = new ArrayList<Rate>();
		private String uuid = null;

		public Builder(final String name, final EconomicZone zone)
		{
			this.name = name;
			this.economicZone = zone;
		}

		public Builder number(final String value)
		{
			number = value;
			return this;
		}

		public Builder deleted(final boolean value)
		{
			deleted = value;
			return this;
		}

		public Builder included(final boolean value)
		{
			included = value;
			return this;
		}

		public Builder rateList(final Rate rate)
		{
			rateList.add(rate);
			return this;
		}

		public Builder rateList(final List<Rate> rates)
		{
			rateList = rates;
			return this;
		}

		public Builder uuid(final String value)
		{
			uuid = value;
			return this;
		}

		public Tax build()
		{
			return new Tax(this);
		}
	}

	public static Tax fromJson(JSONObject obj) throws JSONException, ParseException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		final JSONArray jRates = obj.getJSONArray("rates");
		final List<Rate> rates = new ArrayList<Rate>();

		for (int i = 0; i < jRates.length(); i++)
		{
			final JSONObject jRate = jRates.getJSONObject(i);
			final Rate rate = new Rate(new BigDecimal(jRate.getString("rate")),
				inputDf.parse(jRate.getString("validFrom")));
			rates.add(rate);
		}
		final EconomicZone economicZone = new EconomicZone(null);
		economicZone.setUuid(obj.getString("economicZone"));

		final Tax tax = new Tax.Builder(obj.getString("name"), economicZone).rateList(rates)
			.uuid(obj.getString("uuid"))
			.number(obj.getString("number"))
			.build();

		return tax;
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
			obj.put("included", included);
			if (economicZone != null)
			{
				obj.put("economicZone", economicZone.getUuid());
			}
			if (!rateList.isEmpty())
			{
				final JSONArray array = new JSONArray();
				for (final Rate ratelem : rateList)
				{
					final JSONObject sub = ratelem.toJSON();
					array.put(sub);
				}
				obj.put("rates", array);
			}
			return obj;
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean post() throws IOException, ApiNotReachableException
	{
		if (economicZone != null && economicZone.getUuid() == null)
		{
			economicZone.post();
		}
		final boolean result = CloudLink.getConnector().postData(DataType.tax, this.toJSON());
		if (number != null)
			uuid = CloudLink.getUUIDByNumber(DataType.tax, number);
		else
			uuid = CloudLink.getUUIDByName(DataType.tax, name);
		return result;
	}

	public String getUuid()
	{
		return uuid;
	}

	public List<Rate> getRateList()
	{
		return rateList;
	}

	public void setRateList(final List<Rate> rateList)
	{
		this.rateList = rateList;
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

		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
		result = prime * result + ((this.economicZone == null) ? 0 : this.economicZone.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());


		return result;
	}
}
