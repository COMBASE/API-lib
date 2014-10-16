package domain;


public class Account extends AbstractNameAndNumberApiObject
{

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
}
