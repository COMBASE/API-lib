package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Assortment extends AbstractNameAndNumberApiObject
{
	private static final long serialVersionUID = 4119884542878721366L;
	private String description;


	private Assortment(final Builder builder)
	{
		super(builder);
		description = builder.description;
	}

	public static class Builder extends ApiNameAndNumberObjectBuilder<Assortment>
	{
		private String description;

		public Builder description(final String desc)
		{
			description = desc;
			return this;
		}

		@Override
		public void readJSON(JSONObject obj) throws JSONException
		{
			if (obj.has("result") && obj.getString("result") != null)
				obj = obj.getJSONObject("result");

			description(obj.getString("description"));

			super.readJSON(obj);
		}

		@Override
		public void writeJSON(final JSONObject obj, final Assortment value) throws JSONException
		{
			obj.put("description", value.getDescription());
			super.writeJSON(obj, value);
		}

		@Override
		public Assortment build()
		{
			return new Assortment(this);
		}
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

		super.hashCode(result);

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
