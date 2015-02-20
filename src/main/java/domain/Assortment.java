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
		private String description = null;

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

	public static Assortment fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");


		final Assortment assortment = new Assortment.Builder().name(obj.getString("name"))
			.deleted(obj.getBoolean("deleted"))
			.number(obj.getString("number"))
			.id(obj.getString("uuid"))
			.revision(obj.getLong("revision"))
			.build();
		return assortment;
	}

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

	@Override
	public JSONObject toJSON() throws JSONException
	{
		JSONObject obj = new JSONObject();
		obj = super.appendJSON(obj);

		obj.put("description", description);

		return obj;
	}

	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder();

		super.toString(builder);

		return builder.toString();
	}
}
