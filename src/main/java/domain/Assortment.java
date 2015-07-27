package domain;

import java.text.ParseException;
import java.util.Date;

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
		private Date lastCleanUp = null;
		private String costCenter = null;


		@Override
		public Assortment build()
		{
			return new Assortment(this);
		}

		public T costCenter(final String value)
		{
			this.costCenter = value;
			return self();
		}

		public T description(final String value)
		{
			this.description = value;
			return self();
		}

		public T lastCleanUp(final Date value)
		{
			this.lastCleanUp = value;
			return self();
		}
	}

	private static final long serialVersionUID = 4119884542878721366L;

	private Date lastCleanUp;
	private String costCenter;
	private String description;

	private Assortment(final Init<?> init)
	{
		super(init);
		description = init.description;
		costCenter = init.costCenter;
		lastCleanUp = init.lastCleanUp;
	}

	@Override
	public boolean equals(final Object obj)
	{
		return obj.hashCode() == this.hashCode();
	}

	public String getCostCenter()
	{
		return costCenter;
	}

	/**
	 * {@inheritDoc}
	 */


	public String getDescription()
	{
		return description;
	}

	public Date getLastCleanUp()
	{
		return lastCleanUp;
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

	public void setCostCenter(final String costCenter)
	{
		this.costCenter = costCenter;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	public void setLastCleanUp(final Date lastCleanUp)
	{
		this.lastCleanUp = lastCleanUp;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		JSONObject obj = new JSONObject();
		obj = super.appendJSON(obj);

		obj.put("description", description);
		obj.put("costCenter", costCenter);
		obj.put("lastCleanUp", lastCleanUp);

		return obj;
	}

	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder();

		super.toString(builder);

		return builder.toString();
	}

	public static Assortment fromJSON(JSONObject obj) throws JSONException, ParseException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
		{
			obj = obj.getJSONObject("result");
		}

		final Assortment assortment = new Assortment.Builder().name(nullStringToNull(obj, "name"))
			.deleted(obj.getBoolean("deleted"))
			.number(nullStringToNull(obj, "number"))
			.id(nullStringToNull(obj, "uuid"))
			.revision(obj.getLong("revision"))
			.description(nullStringToNull(obj, "description"))
			.costCenter(nullStringToNull(obj, "costCenter"))
			.lastCleanUp(prepareDate(obj, "lastCleanUp"))
			.build();

		return assortment;
	}
}
