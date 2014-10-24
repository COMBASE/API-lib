package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.interfaces.HasId;
import domain.interfaces.HasNumber;

public abstract class AbstractNumberApiObject<T extends HasNumber & HasId> extends
	AbstractIDApiObject<T> implements HasNumber
{

	public static abstract class Builder extends Init<Builder>
	{

		@Override
		public abstract AbstractNumberApiObject<?> build();

		@Override
		protected Builder self()
		{
			return this;
		}

	}

	protected static abstract class Init<T extends Init<T>> extends AbstractIDApiObject.Init<T>
	{
		private String number;

		@Override
		public abstract AbstractNumberApiObject<?> build();

		public T number(final String value)
		{
			number = value;
			return self();
		}

	}

	private static final long serialVersionUID = -589391620327601920L;

	private String number;

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
	protected int hashCode(int result)
	{
		super.hashCode(result);

		final int prime = 31;
		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());

		return result;
	}

	@Override
	public void setNumber(final String number)
	{
		this.number = number;
	}

	@Override
	protected StringBuilder toString(final StringBuilder builder)
	{
		super.toString(builder);
		if (number != null)
		{
			builder.append("_nr=");
			builder.append(this.number);
		}
		return builder;
	}

	@Override
	public void writeJSON(final JSONObject obj) throws JSONException
	{
		super.writeJSON(obj);
		obj.put("number", getNumber());
	}
}
