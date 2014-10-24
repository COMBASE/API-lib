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

	/**
	 * 
	 */
	private static final long serialVersionUID = 928711587195250693L;
	private boolean included;
	private EconomicZone economicZone;
	private List<Rate> rateList;


	private Tax(final Init<?> init)
	{

		super(init);
		setIncluded(init.included);
		economicZone = init.economicZone;
		rateList = init.rateList;

	}

	public static abstract class Init<T extends Init<T>> extends
		AbstractNameAndNumberApiObject.Init<T>
	{

		private EconomicZone economicZone = null;

		private boolean included = false;
		private List<Rate> rateList = new ArrayList<Rate>();


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

		public T rateList(final Rate rate)
		{
			rateList.add(rate);
			return self();
		}

		public T rateList(final List<Rate> rates)
		{
			rateList = rates;
			return self();
		}

		@Override
		public Tax build()
		{
			return new Tax(this);
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

// public static Tax fromJSON(JSONObject obj) throws JSONException, ParseException
// {

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
// obj.put("deleted", deleted);
// obj.put("included", included);
// if (economicZone != null)
// {
// obj.put("economicZone", economicZone.getUuid());
// }
// if (!rateList.isEmpty())
// {
// final JSONArray array = new JSONArray();
// for (final Rate ratelem : rateList)
// {
// final JSONObject sub = ratelem.toJSON();
// array.put(sub);
// }
// obj.put("rates", array);
// }
// return obj;
// }
// catch (final JSONException e)
// {
// e.printStackTrace();
// return null;
// }
// }
//
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

	public List<Rate> getRateList()
	{
		return rateList;
	}

	public void setRateList(final List<Rate> rateList)
	{
		this.rateList = rateList;
	}

	public boolean isIncluded()
	{
		return included;
	}

	public void setIncluded(final boolean included)
	{
		this.included = included;
	}

	public EconomicZone getEconomicZone()
	{
		return economicZone;
	}

	public void setEconomicZone(final EconomicZone economicZone)
	{
		this.economicZone = economicZone;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
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

		result = prime * result + ((this.economicZone == null) ? 0 : this.economicZone.hashCode());

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


	public static Tax fromJSON(JSONObject obj) throws JSONException, ParseException
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
		economicZone.setId(obj.getString("economicZone"));

		final Tax tax = new Tax.Builder().name(obj.getString("name"))
			.economicZone(economicZone)
			.rateList(rates)
			.id(obj.getString("uuid"))
			.number(obj.getString("number"))
			.build();

		return tax;
	}
}
