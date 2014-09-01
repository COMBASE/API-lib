package domain;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import error.ApiNotReachableException;

public class Assortment
{
	private boolean deleted;
	private String uuid;
	private final String revision;
	private String number;
	private String name;

	private String description;


	private Assortment(final Builder builder)
	{
		number = builder.number;
		name = builder.name;
		description = builder.description;
		deleted = builder.deleted;
		uuid = builder.uuid;
		revision = builder.revision;
	}

	public static class Builder
	{
		private final String name;
		private String uuid = null;
		private String number = null;
		private String description;
		private boolean deleted;
		private String revision;

		public Builder(final String name)
		{
			this.name = name;
		}

		public Builder revision(final String value)
		{
			this.revision = value;
			return this;
		}

		public Builder number(final String value)
		{
			number = value;
			return this;
		}

		public Builder uuid(final String value)
		{
			uuid = value;
			return this;
		}

		public Builder deleted(final boolean value)
		{
			deleted = value;
			return this;
		}

		public Builder description(final String desc)
		{
			description = desc;
			return this;
		}

		public Assortment build()
		{
			return new Assortment(this);
		}
	}

	public static Assortment fromJSON(JSONObject obj) throws JSONException
	{

		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");


		final Assortment assortment = new Assortment.Builder(obj.getString("name")).deleted(
			obj.getBoolean("deleted"))
			.number(obj.getString("number"))
			.uuid(obj.getString("uuid"))
			.build();
		return assortment;


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
			obj.put("description", description);
			return obj;
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean post() throws ApiNotReachableException
	{
		final boolean result = CloudLink.getConnector()
			.postData(DataType.assortment, this.toJSON());
		if (number != null)
			uuid = CloudLink.getUUIDByNumber(DataType.assortment, number);
		else
			uuid = CloudLink.getUUIDByName(DataType.assortment, name);
		return result;
	}

	public String getUuid()
	{
		return uuid;
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(final String number)
	{
		this.number = number;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	public boolean isDeleted()
	{
		return deleted;
	}

	public void setDeleted(final boolean deleted)
	{
		this.deleted = deleted;
	}

	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public String getRevision()
	{
		return revision;
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
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());

		return result;
	}
}
