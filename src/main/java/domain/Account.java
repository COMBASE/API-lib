package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Account extends AbstractNameAndNumberApiObject<Account>
{
	public static class Builder extends Init<Builder>
	{

		@Override
		protected Builder self()
		{
			return this;
		}

	}

	protected static abstract class Init<T extends Init<T>> extends
	AbstractNameAndNumberApiObject.Init<T>
	{
		private String type = null;

		private Boolean requiresSerialNumber = null;

		private Boolean denominationInput = null;

		// private Producer producer;

		@Override
		public Account build()
		{
			return new Account(this);
		}

		public T denominationInput(final boolean value)
		{
			this.denominationInput = value;
			return self();
		}

		public T requiresSerialNumber(final boolean value)
		{
			this.requiresSerialNumber = value;
			return self();
		}

		public T type(final String value)
		{
			this.type = value;
			return self();
		}
	}

	private static final long serialVersionUID = 4756810592495231540L;

	private String type;

	// private Producer producer;

	private Boolean requiresSerialNumber;

	private Boolean denominationInput;

	public Account(final Init<?> init)
	{
		super(init);
		type = init.type;
		requiresSerialNumber = init.requiresSerialNumber;
		denominationInput = init.denominationInput;
	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public Boolean getDenominationInput()
	{
		return denominationInput;
	}

	public String getType()
	{
		return type;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = super.hashCode(result);

		result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
		result = prime * result +
			((this.requiresSerialNumber == null) ? 0 : this.requiresSerialNumber.hashCode());
		result = prime * result +
			((this.denominationInput == null) ? 0 : this.denominationInput.hashCode());

		return result;
	}

	public boolean isDenominationInput()
	{
		return denominationInput;
	}

	public boolean isRequiresSerialNumber()
	{
		return requiresSerialNumber;
	}

	public void setDenominationInput(final Boolean denominationInput)
	{
		this.denominationInput = denominationInput;
	}

	public void setRequiresSerialNumber(final boolean requiresSerialNumber)
	{
		this.requiresSerialNumber = requiresSerialNumber;
	}

	public void setType(final String type)
	{
		this.type = type;
	}


	@Override
	public JSONObject toJSON() throws JSONException
	{
		JSONObject obj = new JSONObject();
		obj = super.appendJSON(obj);
		obj.put("type", type);
		obj.put("requiresSerialNumber", requiresSerialNumber);
		obj.put("denominationInput", denominationInput);

		return obj;

	}

	public static Account fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
		{
			obj = obj.getJSONObject("result");
		}

		final Account acc = new Account.Builder().deleted(obj.getBoolean("deleted"))
			.revision(obj.getLong("revision"))
			.number(nullStringToNull(obj, "number"))
			.id(nullStringToNull(obj, "uuid"))
			.name(nullStringToNull(obj, "name"))
			.type(nullStringToNull(obj, "type"))
			.requiresSerialNumber(obj.getBoolean("requiresSerialNumber"))
			.denominationInput(obj.getBoolean("denominationInput"))
			.build();
		return acc;
	}
}
