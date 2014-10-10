package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Account
{

	private boolean deleted;
	private String uuid;
	private String revision;
	private String number;
	private String name;

	private String type;
	private boolean requiresSerialNumber;


	public Account(final Builder builder)
	{
		deleted = builder.deleted;
		number = builder.number;
		uuid = builder.uuid;
		name = builder.name;
		revision = builder.revision;
		type = builder.type;
		requiresSerialNumber = builder.requiresSerialNumber;
	}

	public static class Builder
	{
		private boolean deleted = false;
		private String uuid = null;
		private String revision = null;
		private String number = null;
		private String name = null;
		private String type = null;
		private boolean requiresSerialNumber = false;

		public Builder deleted(final boolean value)
		{
			deleted = value;
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

		public Builder uuid(final String value)
		{
			uuid = value;
			return this;
		}

		public Builder name(final String value)
		{
			name = value;
			return this;
		}

		public Builder type(final String value)
		{
			type = value;
			return this;
		}

		public Builder requiresSerialNumber(final boolean value)
		{
			requiresSerialNumber = value;
			return this;
		}

		public Account build()
		{
			return new Account(this);
		}
	}

	public static Account fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		final Account acc = new Account.Builder().deleted(obj.getBoolean("deleted"))
			.revision(obj.getString("revision"))
			.number(obj.getString("number"))
			.uuid(obj.getString("uuid"))
			.name(obj.getString("name"))
			.type(obj.getString("type"))
			.requiresSerialNumber(obj.getBoolean("requiresSerialNumber"))
			.build();
		return acc;
	}

	public boolean isDeleted()
	{
		return deleted;
	}

	public void setDeleted(final boolean deleted)
	{
		this.deleted = deleted;
	}

	public String getUuid()
	{
		return uuid;
	}

	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public String getRevision()
	{
		return revision;
	}

	public void setRevision(final String revision)
	{
		this.revision = revision;
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

	public String getType()
	{
		return type;
	}

	public void setType(final String type)
	{
		this.type = type;
	}

	public boolean isRequiresSerialNumber()
	{
		return requiresSerialNumber;
	}

	public void setRequiresSerialNumber(final boolean requiresSerialNumber)
	{
		this.requiresSerialNumber = requiresSerialNumber;
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
		result = prime * result + ((this.revision == null) ? 0 : this.revision.hashCode());
		result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());

		return result;
	}
}
