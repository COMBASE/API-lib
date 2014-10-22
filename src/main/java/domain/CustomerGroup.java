package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class CustomerGroup extends AbstractNameAndNumberApiObject<CustomerGroup>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 633716651892752195L;
	private Pricelist priceGroup;

	protected static abstract class Init<T extends Init<T>> extends
		AbstractNameAndNumberApiObject.Init<T>
	{
		private Pricelist priceGroup = null;

		public T priceGroup(final Pricelist list)
		{
			priceGroup = list;
			return self();
		}

		@Override
		public CustomerGroup build()
		{
			return new CustomerGroup(this);
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


	private CustomerGroup(final Init<?> init)
	{
		super(init);
		priceGroup = init.priceGroup;
	}

// public JSONObject toJSON()
// {
// final JSONObject obj = new JSONObject();
// try
// {
// obj.put("deleted", deleted);
// obj.put("revision", revision);
// obj.put("uuid", uuid);
// obj.put("name", name);
// if (number != null)
// obj.put("number", number);
//
// return obj;
// }
// catch (final JSONException e)
// {
// e.printStackTrace();
// return null;
// }
// }
//
// public static CustomerGroup fromJSON(JSONObject obj) throws JSONException
// {
//
// if (obj.has("result") && obj.getString("result") != null)
// obj = obj.getJSONObject("result");
//
// final CustomerGroup custGrp = new CustomerGroup.Builder(obj.getString("name")).uuid(
// obj.getString("uuid"))
// .number(obj.getString("number"))
// .build();
// return custGrp;
// }
//
// public boolean post() throws IOException
// {
// return CloudLink.getConnector().postData(DataType.customergroup, this.toJSON());
// }


	public Pricelist getPriceGroup()
	{
		return priceGroup;
	}

	public void setPriceGroup(final Pricelist priceGroup)
	{
		this.priceGroup = priceGroup;
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
		result = prime * result + ((this.priceGroup == null) ? 0 : this.priceGroup.hashCode());

		return result;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		writeJSON(obj);
		return obj;
	}

	@Override
	public void writeJSON(final JSONObject obj) throws JSONException
	{
		super.writeJSON(obj);

	}

	@Override
	public CustomerGroup fromJSON(final JSONObject obj) throws JSONException
	{
		readJSON(obj);
		return this;
	}

	@Override
	public void readJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		super.readJSON(obj);


	}
}
