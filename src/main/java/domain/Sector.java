package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import link.CloudLink;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Sector
{
	private String name;
	private int number;
	private List<Tax> taxlist;
	private String uuid = null;

	private Sector(Builder builder)
	{
		name = builder.name;
		number = builder.number;
		taxlist = builder.taxlist;
	}

	public static class Builder
	{
		private final String name;
		private int number = 0;
		private List<Tax> taxlist = new ArrayList<Tax>();

		public Builder(String name)
		{
			this.name = name;
		}

		public Builder number(int value)
		{
			number = value;
			return this;
		}

		public Builder taxlist(Tax t)
		{
			taxlist.add(t);
			return this;
		}

		public Sector build()
		{
			return new Sector(this);
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
			if (!taxlist.isEmpty())
			{
				if (taxlist.toArray().length > 1)
				{
					JSONArray array = new JSONArray();
					int i = 1;
					for (Tax tax : taxlist)
					{
						JSONObject sub = new JSONObject();
						sub.put("index", String.valueOf(i));
						sub.put("tax", tax.getUuid());
						array.put(sub);
						i++;
					}
					obj.put("items", array);
				}
				else
				{
					JSONObject sub = new JSONObject();
					sub.put("index", "1");
					sub.put("tax", taxlist.get(0).getUuid());
					obj.put("items", sub);
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
		if (taxlist != null)
		{
			for (Tax tax : taxlist)
			{
				if (tax.getUuid() == null)
					tax.post();
			}
		}
		boolean result = CloudLink.getConnector().postData(DataType.sector, this.toJSON());
		if (number != 0)
			uuid = CloudLink.getUUID(DataType.sector, String.valueOf(number));
		else
			uuid = CloudLink.getUUID(DataType.sector, name);
		return result;
	}

	public String getUuid()
	{
		return uuid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public List<Tax> getTaxlist()
	{
		return taxlist;
	}

	public void setTaxlist(List<Tax> taxlist)
	{
		this.taxlist = taxlist;
	}

	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}
}
