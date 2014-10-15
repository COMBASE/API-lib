package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Account extends AbstractNameAndNumberApiObject
{

	private String type;
	private boolean requiresSerialNumber;


	public Account(final Builder builder)
	{
		super(builder);
		type = builder.type;
		requiresSerialNumber = builder.requiresSerialNumber;
	}

	public static class Builder extends ApiNameAndNumberObjectBuilder<Account>
	{
		private String type = null;
		private boolean requiresSerialNumber = false;

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

		@Override
		public void readJSON(JSONObject obj) throws JSONException
		{
			if (obj.has("result") && obj.getString("result") != null)
				obj = obj.getJSONObject("result");

			type(obj.getString("type"));
			requiresSerialNumber(obj.getBoolean("requiresSerialNumber"));

			super.readJSON(obj);
		}

		@Override
		public void writeJSON(final JSONObject obj, final Account value) throws JSONException
		{
			super.writeJSON(obj, value);
		}

		@Override
		public Account build()
		{
			return new Account(this);
		}
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
		result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());

		result = super.hashCode(result);

		return result;
	}
}
