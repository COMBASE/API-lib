package domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Tax extends AbstractNameAndNumberApiObject<Tax>
{

	public static class Builder extends Init<Builder>
	{

		@Override
		protected Builder self()
		{
			return this;
		}


	}
	public static abstract class Init<T extends Init<T>> extends
		AbstractNameAndNumberApiObject.Init<T>
	{

		private EconomicZone economicZone = null;

		private Boolean included = null;
		private List<Rate> rateList = null;


		@Override
		public Tax build()
		{
			return new Tax(this);
		}

		public T economicZone(final EconomicZone value)
		{
			this.economicZone = value;
			return self();
		}

		public T included(final boolean value)
		{
			included = value;
			return self();
		}

		public T rateList(final List<Rate> rates)
		{
			rateList = rates;
			return self();
		}

		public T rateList(final Rate rate)
		{
			if (rateList == null) rateList = new ArrayList<Rate>(); 
			rateList.add(rate);
			return self();
		}
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 928711587195250693L;

	public static Tax fromJSON(JSONObject obj) throws JSONException, ParseException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");
		JSONArray jRates = null;

		if (!obj.isNull("rates"))
		{
			jRates = obj.getJSONArray("rates");
		}
		
		final List<Rate> rates = new ArrayList<Rate>();

		if (jRates != null)
		{
			for (int i = 0; i < jRates.length(); i++)
			{
				final JSONObject jRate = jRates.getJSONObject(i);
				final Rate rate = new Rate(new BigDecimal(jRate.getString("rate")),
					inputDf.parse(jRate.getString("validFrom")));
				rates.add(rate);
			}
		}
		final EconomicZone economicZone = new EconomicZone.Builder().build();
		economicZone.setId(obj.getString("economicZone"));

		final Tax tax = new Tax.Builder().name(obj.getString("name"))
			.economicZone(economicZone)
			.rateList(rates)
			.id(obj.getString("uuid"))
			.number(obj.getString("number"))
			.deleted(obj.getBoolean("deleted"))
			.build();

		return tax;
	}


	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	private Boolean included;

	private EconomicZone economicZone;

// public boolean post() throws IOException, ApiNotReachableException
// {
// if (economicZone != null && economicZone.getUuid() == null)
// {
// economicZone.post();
// }
// final boolean result = CloudLink.getConnector().postData(DataType.tax, this.toJSON());
// if (number != null)
// uuid = CloudLink.getUUIDByNumber(DataType.tax, number);
// else
// uuid = CloudLink.getUUIDByName(DataType.tax, name);
// return result;
// }

	private List<Rate> rateList;

	private Tax(final Init<?> init)
	{

		super(init);
		included = init.included;
		economicZone = init.economicZone;
		rateList = init.rateList;

	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public EconomicZone getEconomicZone()
	{
		return economicZone;
	}

	public List<Rate> getRateList()
	{
		return rateList;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = super.hashCode(result);

		result = prime * result + ((this.economicZone == null) ? 0 : this.economicZone.hashCode());

		return result;
	}

	public boolean isIncluded()
	{
		return included;
	}

	public void setEconomicZone(final EconomicZone economicZone)
	{
		this.economicZone = economicZone;
	}

	public void setIncluded(final boolean included)
	{
		this.included = included;
	}

	public void setRateList(final List<Rate> rateList)
	{
		this.rateList = rateList;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		appendJSON(obj);

		obj.put("included", included);
		if (economicZone != null)
		{
			obj.put("economicZone", economicZone.getId());
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
}
