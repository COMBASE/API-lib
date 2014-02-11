package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import link.CloudLink;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Tax
{
	private String name;
	private int number;
	private boolean deleted;
	private boolean included;
	private EconomicZone economicZone;
	private List<Rate> rateList;
	private String uuid = null;

	private Tax(Builder builder)
	{
		name = builder.name;
		number = builder.number;
		deleted = builder.deleted;
		included = builder.included;
		economicZone = builder.economicZone;
		rateList = builder.rateList;
	}

	public static class Builder
	{
		private final String name;
		private int number = 0;
		private final EconomicZone economicZone;
		private boolean deleted = false;
		private boolean included = false;
		private List<Rate> rateList = new ArrayList<Rate>();

		public Builder(String name, EconomicZone zone)
		{
			this.name = name;
			this.economicZone = zone;
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

		public Builder included(boolean value)
		{
			included = value;
			return this;
		}

		public Builder rateList(Rate rate)
		{
			rateList.add(rate);
			return this;
		}

		public Tax build()
		{
			return new Tax(this);
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
			obj.put("included", included);
			if (economicZone != null)
			{
				obj.put("economicZone", economicZone.getUuid());
			}
			if (!rateList.isEmpty())
			{
				if (rateList.toArray().length > 1)
				{
					JSONArray array = new JSONArray();
					for (Rate ratelem : rateList)
					{
						JSONObject sub = ratelem.toJSON();
						array.put(sub);
					}
					obj.put("rates", array);
				}
				else
				{
					obj.put("rates", rateList.get(0).toJSON());
				}
			}
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
		if (economicZone != null && economicZone.getUuid() == null)
		{
			economicZone.post();
		}
		boolean result = CloudLink.getConnector().postData(DataType.tax, this.toJSON());
		if (number != 0)
			uuid = CloudLink.getUUID(DataType.tax, String.valueOf(number));
		else
			uuid = CloudLink.getUUID(DataType.tax, name);
		return result;
	}

	public String getUuid()
	{
		return uuid;
	}
}
