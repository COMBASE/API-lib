package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Cashier extends AbstractNameAndNumberApiObject<Cashier>
{
	private static final long serialVersionUID = -229595034107308709L;
	private final String firstName;
	private String surName;
	private int loginCode;

	protected static abstract class Init<T extends Init<T>> extends
		AbstractNameAndNumberApiObject.Init<T>
	{
		private String firstName;
		private String surName;
		private int loginCode;


		public T firstName(final String value)
		{
			firstName = value;
			return self();
		}

		public T surName(final String value)
		{
			surName = value;
			return self();
		}

		public T loginCode(final int value)
		{
			loginCode = value;
			return self();
		}

		@Override
		public Cashier build()
		{
			return new Cashier(this);
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


	private Cashier(final Init<?> init)
	{
		super(init);
		firstName = init.firstName;
		surName = init.surName;
		loginCode = init.loginCode;
	}

// public static Cashier fromJSON(JSONObject obj) throws JSONException
// {
//
// if (obj.has("result") && obj.getString("result") != null)
// obj = obj.getJSONObject("result");
//
//
// final Cashier cash = new Cashier.Builder(null).deleted(obj.getBoolean("deleted"))
// .number(obj.getString("number"))
// .firstName(obj.getString("firstname"))
// .surName(obj.getString("surname"))
// .uuid(obj.getString("uuid"))
// .loginCode(obj.getInt("loginCode"))
// .build();
// return cash;
//
//
// }
//
// public JSONObject toJSON()
// {
// final JSONObject obj = new JSONObject();
// try
// {

//
// return obj;
// }
// catch (final JSONException e)
// {
// e.printStackTrace();
// return null;
// }
// }
//
// public boolean post() throws IOException
// {
//
// return CloudLink.getConnector().postData(DataType.cashier, this.toJSON());
// }

	// ******************Setter and Getter**********************************************************
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
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = super.hashCode(result);
		result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
		result = prime * result + ((this.surName == null) ? 0 : this.surName.hashCode());
		result = prime * result + ((this.loginCode == 0) ? 0 : loginCode);

		return result;
	}

	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder();

		super.toString(builder);

		return builder.toString();
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		JSONObject obj = new JSONObject();
		obj = super.appendJSON(obj);
		obj.put("firstName", firstName);
		obj.put("surName", surName);
		return obj;
	}

	public static Cashier fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");


		final Cashier cash = new Cashier.Builder().deleted(obj.getBoolean("deleted"))
			.number(obj.getString("number"))
			.firstName(obj.getString("firstname"))
			.surName(obj.getString("surname"))
			.id(obj.getString("uuid"))
			.loginCode(obj.getInt("loginCode"))
			.build();
		return cash;
	}
}