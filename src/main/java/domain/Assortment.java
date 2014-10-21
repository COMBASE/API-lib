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
	public Assortment fromJSON(final JSONObject obj) throws JSONException
	{
		readJSON(obj);
		return this;
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

	@Override
	public void readJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		super.readJSON(obj);

		setDescription(obj.getString("description"));
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		readJSON(obj);
		return obj;
	}

	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder();

		super.toString(builder);

		return builder.toString();
	}

	@Override
	public void writeJSON(final JSONObject obj) throws JSONException
	{
		super.writeJSON(obj);
		obj.put("description", getDescription());
	}

}
