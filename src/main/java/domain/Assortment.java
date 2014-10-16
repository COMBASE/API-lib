package domain;


public class Assortment extends AbstractNameAndNumberApiObject
{
	private static final long serialVersionUID = 4119884542878721366L;
	private String description;

	protected static abstract class Init<T extends Init<T>> extends
		AbstractNameAndNumberApiObject.Init<T>
	{
		private String description;

		public T description(final String value)
		{
			this.description = value;
			return self();
		}

		@Override
		public Assortment build()
		{
			return new Assortment(this);
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
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

		result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());

		result = super.hashCode(result);

		return result;
	}

	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder();

		super.toString(builder);

		return builder.toString();
	}

}
