package domain;

import domain.interfaces.HasName;

public abstract class AbstractNameAndNumberApiObject extends AbstractNumberApiObject implements
	HasName
{

	private static final long serialVersionUID = 4379932372164338249L;

	private String name;

	protected static abstract class Init<T extends Init<T>> extends AbstractNumberApiObject.Init<T>
	{
		private String name;

		public T name(final String value)
		{
			name = value;
			return self();
		}

		@Override
		public abstract AbstractNameAndNumberApiObject build();
	}

	public static abstract class Builder extends Init<Builder>
	{

		@Override
		public abstract AbstractNameAndNumberApiObject build();

		@Override
		protected Builder self()
		{
			return this;
		}

	}

	public AbstractNameAndNumberApiObject(final Init<?> init)
	{
		super(init);
		this.name = init.name;
	}

// @Override
// public void readJSON(final JSONObject obj) throws JSONException
// {
// name(obj.getString("name"));
// super.readJSON(obj);
// }
//
// @Override
// public void writeJSON(final JSONObject obj, final T value) throws JSONException
// {
// super.writeJSON(obj, value);
// obj.put("name", value.getName());
//
// }


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

	@Override
	protected int hashCode(int result)
	{
		final int prime = 31;
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());

		super.hashCode(result);

		return result;
	}

	@Override
	protected StringBuilder toString(final StringBuilder builder)
	{
		builder.append("_");
		builder.append(this.name);

		super.toString(builder);

		return builder;
	}


}
