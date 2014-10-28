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
		JSONObject obj = new JSONObject();
		obj = appendJSON(obj);

		return obj;
	}

	public static CustomerGroup fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		final CustomerGroup custGrp = new CustomerGroup.Builder().name(obj.getString("name"))
			.id(obj.getString("uuid"))
			.number(obj.getString("number"))
			.build();
		return custGrp;
	}

// public boolean post() throws IOException
// {
// return CloudLink.getConnector().postData(DataType.customergroup, this.toJSON());
// }
}
