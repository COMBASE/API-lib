package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Cashier
{
	private boolean deleted;
	private String name;
	private String uuid;
	private String number;
	private String firstName;
	private String surName;
	private int loginCode;

	private Cashier(final Builder builder)
	{
		name = builder.name;
		deleted = builder.deleted;
		uuid = builder.uuid;
		number = builder.number;
		firstName = builder.firstName;
		surName = builder.surName;
		loginCode = builder.loginCode;
	}

	public static class Builder
	{
		private final String name;
		private String number = null;
		private boolean deleted = false;
		private String firstName = null;
		private String surName = null;
		private int loginCode = 1; // default login code
		private String uuid = null;


		// ctor
		public Builder(final String name)
		{
			this.name = name;
		}

		public Builder number(final String value)
		{
			number = value;
			return this;
		}

		public Builder deleted(final boolean value)
		{
			deleted = value;
			return this;
		}

		public Builder firstName(final String value)
		{
			firstName = value;
			return this;
		}

		public Builder surName(final String value)
		{
			surName = value;
			return this;
		}

		public Builder loginCode(final int value)
		{
			loginCode = value;
			return this;
		}

		public Builder uuid(final String value)
		{
			uuid = value;
			return this;
		}

		public Cashier build()
		{
			return new Cashier(this);
		}
	}

	public static Cashier fromJSON(JSONObject obj) throws JSONException
	{

		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");


		final Cashier cash = new Cashier.Builder(null).deleted(obj.getBoolean("deleted"))
			.number(obj.getString("number"))
			.firstName(obj.getString("firstname"))
			.surName(obj.getString("surname"))
			.uuid(obj.getString("uuid"))
			.loginCode(obj.getInt("loginCode"))
			.build();
		return cash;


	}

	public JSONObject toJSON()
	{
		final JSONObject obj = new JSONObject();
		try
		{
			obj.put("name", name);
			obj.put("deleted", deleted);
			obj.put("uuid", uuid);
			if (number != null)
				obj.put("number", number);
			obj.put("firstName", firstName);
			obj.put("surName", surName);

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

		return CloudLink.getConnector().postData(DataType.cashier, this.toJSON());
	}

	// ******************Setter and Getter**********************************************************
	public void setDeleted(final boolean del)
	{
		this.deleted = del;
	}

	public boolean getDeleted()
	{
		return this.deleted;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public String getUuid()
	{
		return this.uuid;
	}

	public void setNumber(final String number)
	{
		this.number = number;
	}

	public String getNumber()
	{
		return this.number;
	}

	public void setFirstName(final String name)
	{
		this.firstName = name;
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public void setSurName(final String surName)
	{
		this.surName = surName;
	}

	public String getSurName()
	{
		return this.surName;
	}

	public void setLoginCode(final int loginCode)
	{
		this.loginCode = loginCode;
	}

	public int getLoginCode()
	{
		return this.loginCode;
	}

	@Override
	public String toString()
	{
		return name;
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
		result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
		result = prime * result + ((this.surName == null) ? 0 : this.surName.hashCode());

		return result;
	}


}