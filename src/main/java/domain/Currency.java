package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Assortment.Builder;

public class Currency
{
	private boolean deleted;
	private String name;
	private String number;
	private String uuid;
	private String revision;
	private String symbol;
	private String key;
	private String centName;

	protected static abstract class Init<T extends Init<T>> extends
		AbstractNameAndNumberApiObject.Init<T>
	{
		private String description;

		public T description(final String value)
		{
			this.description = value;
			return self();
		}

		@Override
		public Assortment build()
		{
			return new Assortment(this);
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

	private Currency(final Builder builder)
	{
		deleted = builder.deleted;
		name = builder.name;
		number = builder.number;
		uuid = builder.uuid;
		revision = builder.revision;
		symbol = builder.symbol;
		key = builder.key;
		centName = builder.centName;
	}

	public static class Builder
	{
		private boolean deleted = false;
		private String name = null;
		private String number = null;
		private String uuid = null;
		private String revision = null;
		private String symbol = null;
		private String key = null;
		private String centName = null;

		public Builder(final String name)
		{
			this.name = name;
		}

		public Builder deleted(final boolean value)
		{
			deleted = value;
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

		public Builder revision(final String value)
		{
			revision = value;
			return this;
		}

		public Builder symbol(final String value)
		{
			symbol = value;
			return this;
		}

		public Builder key(final String value)
		{
			key = value;
			return this;
		}

		public Builder centName(final String value)
		{
			centName = value;
			return this;
		}

		public Currency build()
		{
			return new Currency(this);
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
			obj.put("symbol", symbol);
			obj.put("key", key);
			obj.put("centName", centName);

			return obj;
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static Currency fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");
		final Currency cur = new Currency.Builder(obj.getString("name")).deleted(
			obj.getBoolean("deleted"))
			.revision(obj.getString("revision"))
			.uuid(obj.getString("uuid"))
			.number(obj.getString("number"))
			.symbol(obj.getString("symbol"))
			.key(obj.getString("key"))
			.centName(obj.getString("centName"))
			.build();
		return cur;
	}

	/**
	 * Currency upload nicht API-gestützt
	 * 
	 */
	/*
	 * public boolean post() throws IOException {
	 * 
	 * return CloudLink.getConnector().postData(DataType.currency, this.toJSON());
	 * 
	 * }
	 */

	public boolean isDeleted()
	{
		return deleted;
	}

	public void setDeleted(final boolean deleted)
	{
		this.deleted = deleted;
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

	public String getSymbol()
	{
		return symbol;
	}

	public void setSymbol(final String symbol)
	{
		this.symbol = symbol;
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(final String key)
	{
		this.key = key;
	}

	public String getCentName()
	{
		return centName;
	}

	public void setCentName(final String centName)
	{
		this.centName = centName;
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
		result = prime * result + ((this.key == null) ? 0 : this.key.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
		result = prime * result + ((this.symbol == null) ? 0 : this.symbol.hashCode());
		result = prime * result + ((this.centName == null) ? 0 : this.centName.hashCode());

		return result;
	}

}
