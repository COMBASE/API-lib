package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import link.CloudLink;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import error.ApiNotReachableException;

public class Tax
{
	private String name;
	private String number;
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
		private String number = null;
		private final EconomicZone economicZone;
		private boolean deleted = false;
		private boolean included = false;
		private List<Rate> rateList = new ArrayList<Rate>();

		public Builder(String name, EconomicZone zone)
		{
			this.name = name;
			this.economicZone = zone;
		}

		public Builder number(String value)
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
			if (number!=null)
				obj.put("number", number);
			obj.put("deleted", deleted);
			obj.put("included", included);
			if (economicZone != null)
			{
				obj.put("economicZone", economicZone.getUuid());
			}
			if (!rateList.isEmpty())
			{
				JSONArray array = new JSONArray();
				for (Rate ratelem : rateList)
				{
					JSONObject sub = ratelem.toJSON();
					array.put(sub);
				}
				obj.put("rates", array);
			}
			return obj;
		}
		catch (JSONException e)
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
		boolean result = CloudLink.getConnector().postData(DataType.tax, this.toJSON());
		if (number!=null)
			uuid = CloudLink.getUUIDByNumber(DataType.tax, number);
		else
			uuid = CloudLink.getUUIDByName(DataType.tax, name);
		return result;
	}

	public String getUuid()
	{
		return uuid;
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
