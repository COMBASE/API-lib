package domain;

import java.util.ArrayList;
import java.util.List;

public class Sector extends AbstractNameAndNumberApiObject
{

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

	protected static abstract class Init<T extends Init<T>> extends
		AbstractNameAndNumberApiObject.Init<T>
	{
		private List<Tax> taxlist = null;


		public T taxlist(final Tax t)
		{
			if (taxlist == null)
				taxlist = new ArrayList<Tax>();
			if (t != null)
				taxlist.add(t);
			return self();
		}

		public T taxlist(final List<Tax> taxes)
		{
			this.taxlist = taxes;
			return self();
		}

		@Override
		public Sector build()
		{
			return new Sector(this);
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

// public JSONObject toJSON()
// {
// final JSONObject obj = new JSONObject();
// try
// {
// obj.put("name", name);
// if (number != null)
// obj.put("number", number);
// obj.put("deleted", deleted);
// if (taxlist != null && !taxlist.isEmpty())
// {
// final JSONArray array = new JSONArray();
// int i = 1;
// for (final Tax tax : taxlist)
// {
// final JSONObject sub = new JSONObject();
// sub.put("index", String.valueOf(i));
// sub.put("tax", tax.getUuid());
// array.put(sub);
// i++;
// }
// obj.put("items", array);
// }
// return obj;
// }
// catch (final JSONException e)
// {
// e.printStackTrace();
// return null;
// }
// }
//
// public static Sector fromJSON(JSONObject obj) throws JSONException, ParseException
// {
// if (obj.has("result") && obj.getString("result") != null)
// obj = obj.getJSONObject("result");
//
// final JSONArray jTaxItems = obj.getJSONArray("items");
// Tax tax = null;
// if (jTaxItems.length() != 0)
// {
// final JSONObject jTaxItem = jTaxItems.getJSONObject(0);
//
// tax = new Tax.Builder(null, null).uuid(jTaxItem.getString("tax")).build();
// }
//
// final Sector sec = new Sector.Builder(obj.getString("name")).uuid(obj.getString("uuid"))
// .taxlist(tax)
// .build();
// if (obj.has("number"))
// sec.setNumber(obj.getString("number"));
//
//
// return sec;
// }
//
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

	public List<Tax> getTaxlist()
	{
		return taxlist;
	}

	public void setTaxlist(final List<Tax> taxlist)
	{
		this.taxlist = taxlist;
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
		result = super.hashCode(result);
		result = prime * result + ((this.taxlist == null) ? 0 : this.taxlist.hashCode());

		return result;
	}
}
