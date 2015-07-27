package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Cashier extends AbstractNameAndNumberApiObject<Cashier>
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
		private String firstName = null;
		private String surName = null;
		private String loginCode = null;


		@Override
		public Cashier build()
		{
			return new Cashier(this);
		}

		public T firstName(final String value)
		{
			firstName = value;
			return self();
		}

		public T loginCode(final String value)
		{
			loginCode = value;
			return self();
		}

		public T surName(final String value)
		{
			surName = value;
			return self();
		}
	}

	private static final long serialVersionUID = -229595034107308709L;

	private final String firstName;

	private String surName;

	private String loginCode;


	private Cashier(final Init<?> init)
	{
		super(init);
		firstName = init.firstName;
		surName = init.surName;
		loginCode = init.loginCode;
	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public String getLoginCode()
	{
		return this.loginCode;
	}

	public String getSurName()
	{
		return this.surName;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = super.hashCode(result);
		result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
		result = prime * result + ((this.surName == null) ? 0 : this.surName.hashCode());
		result = prime * result + ((this.loginCode == null) ? 0 : loginCode.hashCode());

		return result;
	}

	public void setLoginCode(final String loginCode)
	{
		this.loginCode = loginCode;
	}

	public void setSurName(final String surName)
	{
		this.surName = surName;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		JSONObject obj = new JSONObject();
		obj = super.appendJSON(obj);
		obj.put("firstName", firstName);
		obj.put("surName", surName);
		obj.put("loginCode", loginCode);
		return obj;
	}

	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder();

		super.toString(builder);

		return builder.toString();
	}

	public static Cashier fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
		{
			obj = obj.getJSONObject("result");
		}


		final Cashier cash = new Cashier.Builder().deleted(obj.getBoolean("deleted"))
			.number(nullStringToNull(obj, "number"))
			.revision(obj.getLong("revision"))
			.firstName(nullStringToNull(obj, "firstname"))
			.surName(nullStringToNull(obj, "surname"))
			.id(nullStringToNull(obj, "uuid"))
			.loginCode(nullStringToNull(obj, "loginCode"))
			.build();
		return cash;
	}
}