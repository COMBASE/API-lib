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
	private PaymentMethod paymentMethod;
	private double actualItemTotal;
	private double expectedItemTotal;
	private double absoluteDifference;

	public ItemSummary(final Builder builder)
	{
		this.paymentMethod = builder.paymentMethod;
		this.actualItemTotal = builder.actualItemTotal;
		this.expectedItemTotal = builder.expectedItemTotal;
		this.absoluteDifference = builder.absoluteDifference;
	}

	public static class Builder
	{
		private PaymentMethod paymentMethod = null;
		private double actualItemTotal = 0;
		private double expectedItemTotal = 0;
		private double absoluteDifference = 0;

		public Builder paymentMethod(final PaymentMethod value)
		{
			this.paymentMethod = value;
			return this;
		}

		public Builder actualItemTotal(final double value)
		{
			this.actualItemTotal = value;
			return this;
		}

		public Builder expectedItemTotal(final double value)
		{
			this.expectedItemTotal = value;
			return this;
		}

		public Builder absoluteDifference(final double value)
		{
			this.absoluteDifference = value;
			return this;
		}

		public ItemSummary build()
		{
			return new ItemSummary(this);
		}

	}

	public static ItemSummary fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		final PaymentMethod paymentMethods = new PaymentMethod.Builder().name(
			obj.getString("paymentMethodName"))
			// .revision(33l)
			.id(obj.getString("paymentMethod"))
			.number(obj.getString("paymentMethodNr"))
			.build();

		final ItemSummary itemSummary = new ItemSummary.Builder().absoluteDifference(
			obj.getDouble("absoluteDifference"))
			.actualItemTotal(obj.getDouble("actualItemTotal"))
			.expectedItemTotal(obj.getDouble("expectedItemTotal"))
			.paymentMethod(paymentMethods)
			.build();
		return itemSummary;


	}

	public PaymentMethod getPaymentMethod()
	{
		return paymentMethod;
	}

	public void setPaymentMethod(final PaymentMethod paymentMethod)
	{
		this.paymentMethod = paymentMethod;
	}

	public double getActualItemTotal()
	{
		return actualItemTotal;
	}

	public void setActualItemTotal(final double actualItemTotal)
	{
		this.actualItemTotal = actualItemTotal;
	}

	public double getExpectedItemTotal()
	{
		return expectedItemTotal;
	}

	public void setExpectedItemTotal(final double expectedItemTotal)
	{
		this.expectedItemTotal = expectedItemTotal;
	}

	public double getAbsoluteDifference()
	{
		return absoluteDifference;
	}

	public void setAbsoluteDifference(final double absoluteDifference)
	{
		this.absoluteDifference = absoluteDifference;
	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}
}
