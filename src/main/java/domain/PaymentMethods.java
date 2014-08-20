package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class PaymentMethods
{
	private boolean deleted;
	private String revision;
	private String uuid;
	private String number;
	private String name;
	private Currency currency;

	// ctor of PaymentMethods
	public PaymentMethods(final Builder builder)
	{
		this.deleted = builder.deleted;
		this.revision = builder.revision;
		this.uuid = builder.uuid;
		this.number = builder.number;
		this.name = builder.name;
		this.currency = builder.currency;
	}

	public static class Builder
	{
		private boolean deleted = false;
		private String revision = null;
		private String uuid = null;
		private String number = null;
		private String name = null;
		private Currency currency = null;

		public Builder(final String name)
		{
			this.name = name;
		}

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

		public Builder uuid(final String value)
		{
			uuid = value;
			return this;
		}

		public Builder number(final String value)
		{
			number = value;
			return this;
		}

		public Builder currency(final Currency currency)
		{
			this.currency = currency;
			return this;
		}

		public PaymentMethods build()
		{
			return new PaymentMethods(this);
		}
	}

	public static PaymentMethods fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		final Currency currency = new Currency.Builder(null).uuid(obj.getString("currency"))
			.build();

		final PaymentMethods payMeth = new PaymentMethods.Builder(obj.getString("name")).deleted(
			obj.getBoolean("deleted"))
			.number(obj.getString("number"))
			.uuid(obj.getString("uuid"))
			.currency(currency)
			.build();
		if (obj.has("number"))
			payMeth.setNumber(obj.getString("number"));

		return payMeth;
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
			return obj;
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean post() throws IOException
	{
		return CloudLink.getConnector().postData(DataType.paymentMethod, this.toJSON());
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

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public Currency getCurrency()
	{
		return currency;
	}

	public void setCurrency(final Currency currency)
	{
		this.currency = currency;
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


		return result;
	}

}
