package domain;

import domain.interfaces.HasNumber;

public abstract class AbstractNumberApiObject extends AbstractApiObject implements HasNumber
{

	private static final long serialVersionUID = -589391620327601920L;

	private String number;

	protected static abstract class Init<T extends Init<T>> extends AbstractApiObject.Init<T>
	{
		private String number;

		public T number(final String value)
		{
			number = value;
			return self();
		}

		@Override
		public abstract AbstractNumberApiObject build();

	}

	public static abstract class Builder extends Init<Builder>
	{

		@Override
		public abstract AbstractNumberApiObject build();

		@Override
		protected Builder self()
		{
			return this;
		}

	}

// @Override
// public void writeJSON(final JSONObject obj, final T value) throws JSONException
// {
// super.writeJSON(obj, value);
// obj.put("number", number);
//
// }
//
// @Override
// public void readJSON(final JSONObject obj) throws JSONException
// {
// number(obj.getString("number"));
// super.readJSON(obj);
// }


	public AbstractNumberApiObject(final Init<?> init)
	{
		super(init);
		this.number = init.number;
	}

	@Override
	public String getNumber()
	{
		return this.number;
	}

	@Override
	public void setNumber(final String number)
	{
		this.number = number;
	}

	@Override
	protected int hashCode(int result)
	{
		final int prime = 31;
		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());

		super.hashCode(result);

		return result;
	}

	@Override
	protected StringBuilder toString(final StringBuilder builder)
	{
		builder.append("_");
		builder.append(this.number);

		super.toString(builder);

		return builder;
	}


}
