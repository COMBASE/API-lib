package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.interfaces.HasId;
import domain.interfaces.HasNumber;

public abstract class AbstractNumberApiObject extends AbstractApiObject implements HasNumber
{

	public static abstract class ApiNumberObjectBuilder<T extends HasId & HasNumber> extends
		ApiObjectBuilder<T>
	{
		private String number = null;

		public ApiNumberObjectBuilder<T> number(final String value)
		{
			number = value;
			return this;
		}

		@Override
		public void writeJSON(final JSONObject obj, final T value) throws JSONException
		{
			obj.put("number", number);
			super.writeJSON(obj, value);
		}

		@Override
		public void readJSON(final JSONObject obj) throws JSONException
		{
			number(obj.getString("number"));
			super.readJSON(obj);
		}
	}

	private static final long serialVersionUID = -589391620327601920L;

	private String number;

	public AbstractNumberApiObject(final ApiNumberObjectBuilder<? extends HasNumber> builder)
	{
		super(builder);
		this.number = builder.number;
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
