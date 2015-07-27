package domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Sector extends AbstractNameAndNumberApiObject<Sector>
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
		private List<Tax> taxlist = null;


		@Override
		public Sector build()
		{
			return new Sector(this);
		}

		public T taxlist(final List<Tax> taxes)
		{
			this.taxlist = taxes;
			return self();
		}

		public T taxlist(final Tax t)
		{
			if (taxlist == null)
			{
				taxlist = new ArrayList<Tax>();
			}
			if (t != null)
			{
				taxlist.add(t);
			}
			return self();
		}
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -2798024033200003781L;

	private List<Tax> taxlist;

	private Sector(final Init<?> init)
	{
		super(init);
		taxlist = init.taxlist;
	}

// public boolean post() throws ApiNotReachableException, IOException
// {
// if (taxlist != null)
// {
// for (final Tax tax : taxlist)
// {
// if (tax.getUuid() == null)
// tax.post();
// }
// }
// final boolean result = CloudLink.getConnector().postData(DataType.sector, this.toJSON());
// if (number != null)
// uuid = CloudLink.getUUIDByNumber(DataType.sector, number);
// else
// uuid = CloudLink.getUUIDByName(DataType.sector, name);
// return result;
// }

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public List<Tax> getTaxlist()
	{
		return taxlist;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = super.hashCode(result);
		result = prime * result + ((this.taxlist == null) ? 0 : this.taxlist.hashCode());

		return result;
	}

	public void setTaxlist(final List<Tax> taxlist)
	{
		this.taxlist = taxlist;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		appendJSON(obj);

		if (taxlist != null && !taxlist.isEmpty())
		{
			final JSONArray array = new JSONArray();
			int i = 1;
			for (final Tax tax : taxlist)
			{
				final JSONObject sub = new JSONObject();
				sub.put("index", String.valueOf(i));
				sub.put("tax", tax.getId());
				array.put(sub);
				i++;
			}
			obj.put("items", array);
		}

		return obj;
	}

	public static Sector fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
		{
			obj = obj.getJSONObject("result");
		}

		JSONArray jTaxItems = null;

		if (!obj.isNull("items"))
		{
			jTaxItems = obj.getJSONArray("items");
		}
		Tax tax = null;

		if (jTaxItems != null && jTaxItems.length() != 0)
		{
			final JSONObject jTaxItem = jTaxItems.getJSONObject(0);

			tax = new Tax.Builder().id(jTaxItem.getString("tax")).build();
		}

		final Sector sec = new Sector.Builder().name(nullStringToNull(obj, "name"))
			.id(nullStringToNull(obj, "uuid"))
			.taxlist(tax)
			.deleted(obj.getBoolean("deleted"))
			.build();
		if (obj.has("number"))
		{
			sec.setNumber(nullStringToNull(obj, "number"));
		}


		return sec;
	}
}
