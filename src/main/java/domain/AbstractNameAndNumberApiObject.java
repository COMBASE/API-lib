package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.interfaces.HasId;
import domain.interfaces.HasName;
import domain.interfaces.HasNumber;

public abstract class AbstractNameAndNumberApiObject<T extends HasName & HasNumber & HasId> extends
	AbstractNumberApiObject<T> implements HasName
{

	public static abstract class Builder extends Init<Builder>
	{

		@Override
		public abstract AbstractNameAndNumberApiObject<?> build();

		@Override
		protected Builder self()
		{
			return this;
		}

	}

	protected static abstract class Init<T extends Init<T>> extends AbstractNumberApiObject.Init<T>
	{
		private String name;

		@Override
		public abstract AbstractNameAndNumberApiObject<?> build();

		public T name(final String value)
		{
			name = value;
			return self();
		}
	}

	private static final long serialVersionUID = 4379932372164338249L;

	private String name;

	public AbstractNameAndNumberApiObject(final Init<?> init)
	{
		super(init);
		this.name = init.name;
	}

	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	protected int hashCode(int result)
	{
		super.hashCode(result);

		final int prime = 31;
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());

		return result;
	}


	@Override
	public void readJSON(final JSONObject obj) throws JSONException
	{
		super.readJSON(obj);
		if (obj.has("name") && !obj.get("name").equals(null))
			setName(obj.getString("name"));
	}

	@Override
	public void setName(final String name)
	{
		this.name = name;
	}

	@Override
	protected StringBuilder toString(final StringBuilder builder)
	{
		super.toString(builder);

		if (name != null)
		{
			builder.append("_name=");
			builder.append(this.name);
		}
		return builder;
	}

	@Override
	public void writeJSON(final JSONObject obj) throws JSONException
	{
		super.writeJSON(obj);
		obj.put("name", getName());
	}
}
