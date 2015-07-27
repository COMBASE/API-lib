package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class PaymentMethod extends AbstractNameAndNumberApiObject<PaymentMethod>
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
		private Currency currency = null;

		@Override
		public PaymentMethod build()
		{
			return new PaymentMethod(this);
		}

		public T currency(final Currency currency)
		{
			this.currency = currency;
			return self();
		}
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -456220004107764453L;

	private Currency currency;

	// ctor of PaymentMethods
	public PaymentMethod(final Init<?> init)
	{
		super(init);
		this.currency = init.currency;
	}

// public boolean post() throws IOException
// {
// return CloudLink.getConnector().postData(DataType.paymentMethod, this.toJSON());
// }

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public Currency getCurrency()
	{
		return currency;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = super.hashCode(result);
		result = prime * result + ((this.currency == null) ? 0 : this.currency.hashCode());


		return result;
	}

	public void setCurrency(final Currency currency)
	{
		this.currency = currency;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		appendJSON(obj);
		return obj;
	}

	public static PaymentMethod fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
		{
			obj = obj.getJSONObject("result");
		}

		final Currency currency = new Currency.Builder().id(nullStringToNull(obj, "currency"))
			.build();

		final PaymentMethod payMeth = new PaymentMethod.Builder().name(
			nullStringToNull(obj, "name"))
			.deleted(obj.getBoolean("deleted"))
			.number(nullStringToNull(obj, "number"))
			.id(nullStringToNull(obj, "uuid"))
			.currency(currency)
			.build();
		if (obj.has("number"))
		{
			payMeth.setNumber(nullStringToNull(obj, "number"));
		}

		return payMeth;
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
// return obj;
// }
// catch (final JSONException e)
// {
// e.printStackTrace();
// return null;
// }
// }
}
