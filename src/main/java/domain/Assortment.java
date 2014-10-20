package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Assortment extends AbstractNameAndNumberApiObject<Assortment>
{
	public static class Builder extends Init<Builder>
	{

		@Override
		protected Builder self()
		{

			return this;
		}

	}
	protected static abstract class Init<T extends Init<T>> extends
		AbstractNameAndNumberApiObject.Init<T>
	{
		private String description;

		@Override
		public Assortment build()
		{
			return new Assortment(this);
		}

		public T description(final String value)
		{
			this.description = value;
			return self();
		}
	}

	private static final long serialVersionUID = 4119884542878721366L;

	private String description;

// @Override
// public void readJSON(JSONObject obj) throws JSONException
// {
// if (obj.has("result") && obj.getString("result") != null)
// obj = obj.getJSONObject("result");
//
// description(obj.getString("description"));
//
// super.readJSON(obj);
// }
//
// @Override
// public void writeJSON(final JSONObject obj, final Assortment value) throws JSONException
// {
// super.writeJSON(obj, value);
// obj.put("description", value.getDescription());


	private Assortment(final Init<?> init)
	{
		super(init);
		description = init.description;
	}

	@Override
	public boolean equals(final Object obj)
	{
		return obj.hashCode() == this.hashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractNumberApiObject<AbstractNameAndNumberApiObject<Assortment>> fromJSON(
		final JSONObject obj) throws JSONException
	{
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescription()
	{
		return description;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());

		result = super.hashCode(result);

		return result;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JSONObject toJSON(
		AbstractNumberApiObject<AbstractNameAndNumberApiObject<Assortment>> value)
		throws JSONException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder();

		super.toString(builder);

		return builder.toString();
	}

}
