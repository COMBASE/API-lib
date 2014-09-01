package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class CustomerGroup
{
	private boolean deleted;
	private String revision;
	private String uuid;
	private String number;
	private Pricelist priceGroup;
	private String name;

	private CustomerGroup(final Builder builder)
	{
		name = builder.name;
		deleted = builder.deleted;
		uuid = builder.uuid;
		revision = builder.revision;
		number = builder.number;
		priceGroup = builder.priceGroup;
	}

	public static class Builder
	{
		private String name = null;
		private boolean deleted = false;
		private String revision = null;
		private String uuid = null;
		private String number = null;
		private Pricelist priceGroup = null;

		public Builder(final String name)
		{
			this.name = name;
		}

		public Builder deleted(final boolean value)
		{
			deleted = value;
			return this;
		}

		public Builder uuid(final String value)
		{
			uuid = value;
			return this;
		}

		public Builder revision(final String value)
		{
			revision = value;
			return this;
		}

		public Builder number(final String value)
		{
			number = value;
			return this;
		}

		public Builder priceGroup(final Pricelist list)
		{
			priceGroup = list;
			return this;
		}

		public CustomerGroup build()
		{
			return new CustomerGroup(this);
		}
	}

	public JSONObject toJSON()
	{
		final JSONObject obj = new JSONObject();
		try
		{
			obj.put("deleted", deleted);
			obj.put("revision", revision);
			obj.put("uuid", uuid);
			obj.put("name", name);
			if (number != null)
				obj.put("number", number);

			return obj;
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static CustomerGroup fromJSON(JSONObject obj) throws JSONException
	{

		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		final CustomerGroup custGrp = new CustomerGroup.Builder(obj.getString("name")).uuid(
			obj.getString("uuid"))
			.number(obj.getString("number"))
			.build();
		return custGrp;
	}

	public boolean post() throws IOException
	{
		return CloudLink.getConnector().postData(DataType.customergroup, this.toJSON());
	}

	public boolean isDeleted()
	{
		return deleted;
	}

	public void setDeleted(final boolean deleted)
	{
		this.deleted = deleted;
	}

	public String getRevision()
	{
		return revision;
	}

	public void setRevision(final String revision)
	{
		this.revision = revision;
	}

	public String getUuid()
	{
		return uuid;
	}

	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(final String number)
	{
		this.number = number;
	}

	public Pricelist getPriceGroup()
	{
		return priceGroup;
	}

	public void setPriceGroup(final Pricelist priceGroup)
	{
		this.priceGroup = priceGroup;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
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
		result = prime * result + ((this.revision == null) ? 0 : this.revision.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.priceGroup == null) ? 0 : this.priceGroup.hashCode());

		return result;
	}

}
