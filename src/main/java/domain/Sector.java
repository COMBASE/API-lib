package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import link.CloudLink;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import error.ApiNotReachableException;

public class Sector
{
	private String name;
	private String number;
	private List<Tax> taxlist;
	private final boolean deleted;
	private String uuid = null;

	private Sector(final Builder builder)
	{
		name = builder.name;
		number = builder.number;
		taxlist = builder.taxlist;
		deleted = builder.deleted;
		uuid = builder.uuid;
	}

	public static class Builder
	{
		private final String name;
		private String number = null;
		private boolean deleted = false;
		private String uuid = null;
		private List<Tax> taxlist = null;

		public Builder(final String name)
		{
			this.name = name;
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

		public Builder deleted(final boolean value)
		{
			deleted = value;
			return this;
		}

		public Builder taxlist(final Tax t)
		{
			if (taxlist == null)
				taxlist = new ArrayList<Tax>();
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
		final JSONObject obj = new JSONObject();
		try
		{
			obj.put("name", name);
			if (number != null)
				obj.put("number", number);
			obj.put("deleted", deleted);
			if (taxlist != null && !taxlist.isEmpty())
			{
				final JSONArray array = new JSONArray();
				int i = 1;
				for (final Tax tax : taxlist)
				{
					final JSONObject sub = new JSONObject();
					sub.put("index", String.valueOf(i));
					sub.put("tax", tax.getUuid());
					array.put(sub);
					i++;
				}
				obj.put("items", array);
			}
			return obj;
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static Sector fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		final Sector sec = new Sector.Builder(obj.getString("name")).uuid(obj.getString("uuid"))
			.build();
		if (obj.has("number"))
			sec.setNumber(obj.getString("number"));

		return sec;
	}

	public boolean post() throws ApiNotReachableException, IOException
	{
		if (taxlist != null)
		{
			for (final Tax tax : taxlist)
			{
				if (tax.getUuid() == null)
					tax.post();
			}
		}
		final boolean result = CloudLink.getConnector().postData(DataType.sector, this.toJSON());
		if (number != null)
			uuid = CloudLink.getUUIDByNumber(DataType.sector, number);
		else
			uuid = CloudLink.getUUIDByName(DataType.sector, name);
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

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(final String number)
	{
		this.number = number;
	}

	public List<Tax> getTaxlist()
	{
		return taxlist;
	}

	public void setTaxlist(final List<Tax> taxlist)
	{
		this.taxlist = taxlist;
	}

	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
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
		result = prime * result + ((this.taxlist == null) ? 0 : this.taxlist.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());

		return result;
	}
}
