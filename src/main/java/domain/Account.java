package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Account extends AbstractNameAndNumberApiObject<Account>
{
	private static final long serialVersionUID = 4756810592495231540L;

	private String type;

	private boolean requiresSerialNumber;

	protected static abstract class Init<T extends Init<T>> extends
		AbstractNameAndNumberApiObject.Init<T>
	{
		private String type;

		private boolean requiresSerialNumber;

		public T type(final String value)
		{
			this.type = value;
			return self();
		}

		public T requiresSerialNumber(final boolean value)
		{
			this.requiresSerialNumber = value;
			return self();
		}

		@Override
		public Account build()
		{
			return new Account(this);
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

	public Account(final Init<?> init)
	{
		super(init);
		type = init.type;
		requiresSerialNumber = init.requiresSerialNumber;
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

	@Override
	public JSONObject toJSON() throws JSONException
	{
		JSONObject obj = new JSONObject();
		obj = super.appendJSON(obj);

		return obj;

	}


	public static Account fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		final Account acc = new Account.Builder().deleted(obj.getBoolean("deleted"))
			.revision(obj.getLong("revision"))
			.number(obj.getString("number"))
			.id(obj.getString("uuid"))
			.name(obj.getString("name"))
			.type(obj.getString("type"))
			.requiresSerialNumber(obj.getBoolean("requiresSerialNumber"))
			.build();
		return acc;
	}
}
