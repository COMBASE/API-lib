package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class CustomerGroup extends AbstractNameAndNumberApiObject<CustomerGroup>
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
		private Pricelist priceGroup = null;

		@Override
		public CustomerGroup build()
		{
			return new CustomerGroup(this);
		}

		public T priceGroup(final Pricelist list)
		{
			priceGroup = list;
			return self();
		}
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 633716651892752195L;

	private Pricelist priceGroup;


	private CustomerGroup(final Init<?> init)
	{
		super(init);
		priceGroup = init.priceGroup;
	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public Pricelist getPriceGroup()
	{
		return priceGroup;
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

	public void setPriceGroup(final Pricelist priceGroup)
	{
		this.priceGroup = priceGroup;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		JSONObject obj = new JSONObject();
		obj = appendJSON(obj);

		obj.put("priceGroup", priceGroup);

		return obj;
	}

	public static CustomerGroup fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
		{
			obj = obj.getJSONObject("result");
		}

		final Pricelist pricelist = new Pricelist.Builder().id(nullStringToNull(obj, "priceGroup"))
			.build();

		final CustomerGroup custGrp = new CustomerGroup.Builder().name(
			nullStringToNull(obj, "name"))
			.id(nullStringToNull(obj, "uuid"))
			.number(nullStringToNull(obj, "number"))
			.deleted(obj.getBoolean("deleted"))
			.revision(obj.getLong("revision"))
			.priceGroup(pricelist)
			.build();

		return custGrp;

	}

}
