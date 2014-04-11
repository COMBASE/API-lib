package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Assortment
{
	private int number;
	private String name;
	private String description;
	private boolean deleted;
	private String uuid = null;

	private Assortment(Builder builder)
	{
		number = builder.number;
		name = builder.name;
		description = builder.description;
		deleted = builder.deleted;
	}

	public static class Builder
	{
		private final String name;
		private int number = 0;
		private String description;
		private boolean deleted;

		public Builder(String name)
		{
			this.name = name;
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

		public Builder description(String desc)
		{
			description = desc;
			return this;
		}

		public Assortment build()
		{
			return new Assortment(this);
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
			obj.put("description", description);
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
		boolean result = CloudLink.getConnector().postData(DataType.assortment, this.toJSON());
		if (number != 0)
			uuid = CloudLink.getUUIDByNumber(DataType.assortment, String.valueOf(number));
		else
			uuid = CloudLink.getUUIDByName(DataType.assortment, name);
		return result;
	}

	public String getUuid()
	{
		return uuid;
	}
}
