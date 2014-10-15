package domain;

import domain.interfaces.HasName;

public abstract class AbstractNameAndNumberApiObject extends AbstractNumberApiObject implements
	HasName
{
	private static final long serialVersionUID = 4379932372164338249L;

	private String name;

	public AbstractNameAndNumberApiObject(final ApiNameAndNumberObjectBuilder builder)
	{
		super(builder);
		this.name = builder.name;
	}

	public static abstract class ApiNameAndNumberObjectBuilder extends ApiNumberObjectBuilder
	{
		private String name;

		public ApiNameAndNumberObjectBuilder name(final String value)
		{
			name = value;
			return this;
		}
	}

	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public void setName(final String name)
	{
		this.name = name;
	}
}
