package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Tag extends AbstractNameAndNumberApiObject<Assortment>
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
		@Override
		public Tag build()
		{
			return new Tag(this);
		}

	}

	private static final long serialVersionUID = 5955525950261593638L;

	private Tag(final Init<?> init)
	{
		super(init);
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

		result = prime * result;

		result = super.hashCode(result);

		return result;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		JSONObject obj = new JSONObject();
		obj = super.appendJSON(obj);

		return obj;
	}

	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder();

		super.toString(builder);

		return builder.toString();
	}

	public static Tag fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
		{
			obj = obj.getJSONObject("result");
		}

		final Tag tag = new Tag.Builder().name(nullStringToNull(obj, "name"))
			.number(nullStringToNull(obj, "number"))
			.id(nullStringToNull(obj, "uuid"))
			.build();
		return tag;
	}
}
