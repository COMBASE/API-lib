package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.interfaces.HasId;
import domain.interfaces.HasName;
import domain.interfaces.HasNumber;

public abstract class AbstractNameAndNumberApiObject extends AbstractNumberApiObject implements
	HasName
{

	public static abstract class ApiNameAndNumberObjectBuilder<T extends HasId & HasNumber & HasName>
		extends ApiNumberObjectBuilder<T>
	{
		private String name = null;

		public ApiNameAndNumberObjectBuilder<T> name(final String value)
		{
			name = value;
			return this;
		}

		@Override
		public void readJSON(final JSONObject obj) throws JSONException
		{
			name(obj.getString("name"));
			super.readJSON(obj);
		}

		@Override
		public void writeJSON(final JSONObject obj, final T value) throws JSONException
		{
			super.writeJSON(obj, value);
			obj.put("name", value.getName());

		}
	}

	private static final long serialVersionUID = 4379932372164338249L;

	private String name;

	public AbstractNameAndNumberApiObject(
		final ApiNameAndNumberObjectBuilder<? extends HasName> builder)
	{
		super(builder);
		this.name = builder.name;
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
