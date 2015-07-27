package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * used by domain.PosBalance
 *
 * @author mas
 *
 */
public class ItemSummary
{
	public static class Builder
	{
		private PaymentMethod paymentMethod = null;
		private Double actualItemTotal = null;
		private Double expectedItemTotal = null;
		private Double absoluteDifference = null;

		public Builder absoluteDifference(final double value)
		{
			this.absoluteDifference = value;
			return this;
		}

		public Builder actualItemTotal(final double value)
		{
			this.actualItemTotal = value;
			return this;
		}

		public ItemSummary build()
		{
			return new ItemSummary(this);
		}

		public Builder expectedItemTotal(final double value)
		{
			this.expectedItemTotal = value;
			return this;
		}

		public Builder paymentMethod(final PaymentMethod value)
		{
			this.paymentMethod = value;
			return this;
		}

	}

	private PaymentMethod paymentMethod;

	private Double actualItemTotal;
	private Double expectedItemTotal;

	private Double absoluteDifference;

	public ItemSummary(final Builder builder)
	{
		this.paymentMethod = builder.paymentMethod;
		this.actualItemTotal = builder.actualItemTotal;
		this.expectedItemTotal = builder.expectedItemTotal;
		this.absoluteDifference = builder.absoluteDifference;
	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public double getAbsoluteDifference()
	{
		return absoluteDifference;
	}

	public double getActualItemTotal()
	{
		return actualItemTotal;
	}

	public double getExpectedItemTotal()
	{
		return expectedItemTotal;
	}

	public PaymentMethod getPaymentMethod()
	{
		return paymentMethod;
	}

	public void setAbsoluteDifference(final double absoluteDifference)
	{
		this.absoluteDifference = absoluteDifference;
	}

	public void setActualItemTotal(final double actualItemTotal)
	{
		this.actualItemTotal = actualItemTotal;
	}

	public void setExpectedItemTotal(final double expectedItemTotal)
	{
		this.expectedItemTotal = expectedItemTotal;
	}

	public void setPaymentMethod(final PaymentMethod paymentMethod)
	{
		this.paymentMethod = paymentMethod;
	}

	public static ItemSummary fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
		{
			obj = obj.getJSONObject("result");
		}

		final PaymentMethod paymentMethods = new PaymentMethod.Builder().name(
			nullStringToNull(obj, "paymentMethodName"))
			// .revision(33l)
			.id(nullStringToNull(obj, "paymentMethod"))
			.number(nullStringToNull(obj, "paymentMethodNr"))
			.build();

		final ItemSummary itemSummary = new ItemSummary.Builder().absoluteDifference(
			obj.getDouble("absoluteDifference"))
			.actualItemTotal(obj.getDouble("actualItemTotal"))
			.expectedItemTotal(obj.getDouble("expectedItemTotal"))
			.paymentMethod(paymentMethods)
			.build();
		return itemSummary;


	}

	/**
	 *
	 * @param obj
	 * @param value
	 * @return
	 * @throws JSONException
	 */
	protected static String nullStringToNull(final JSONObject obj, final String value)
		throws JSONException
	{
		if (obj.getString(value).equalsIgnoreCase("null"))
			return null;
		return obj.getString(value);
	}
}
