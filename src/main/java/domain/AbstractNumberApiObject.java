package domain;

import domain.interfaces.HasNumber;

public abstract class AbstractNumberApiObject extends AbstractApiObject implements HasNumber
{
	private static final long serialVersionUID = -589391620327601920L;

	private String number;

	public AbstractNumberApiObject(final ApiNumberObjectBuilder builder)
	{
		super(builder);
		this.number = builder.number;
	}

	public static abstract class ApiNumberObjectBuilder extends ApiObjectBuilder
	{
		private String number;

		public ApiNumberObjectBuilder number(final String value)
		{
			number = value;
			return this;
		}
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
}
