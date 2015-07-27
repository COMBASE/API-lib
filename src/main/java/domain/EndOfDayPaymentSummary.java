package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class EndOfDayPaymentSummary
{
	private PaymentMethod paymentMethods;
	private BigDecimal actualAmount;
	private BigDecimal expectedAmount;

	public BigDecimal getActualAmount()
	{
		return actualAmount;
	}

	public BigDecimal getExpectedAmount()
	{
		return expectedAmount;
	}

	public PaymentMethod getPaymentMethods()
	{
		return paymentMethods;
	}

	public void setActualAmount(final BigDecimal actualAmount)
	{
		this.actualAmount = actualAmount;
	}

	public void setExpectedAmount(final BigDecimal expectedAmount)
	{
		this.expectedAmount = expectedAmount;
	}

	public void setPaymentMethods(final PaymentMethod paymentMethods)
	{
		this.paymentMethods = paymentMethods;
	}

	public static EndOfDayPaymentSummary fromJSON(final JSONObject obj) throws JSONException
	{

		final EndOfDayPaymentSummary paymentSummary = new EndOfDayPaymentSummary();

		final PaymentMethod paymentMethods = new PaymentMethod.Builder().id(
			nullStringToNull(obj, "paymentMethod")).build();

		paymentSummary.setPaymentMethods(paymentMethods);
		// paymentSummary.setActualAmount(new
// BigDecimal(String.valueOf(obj.getDouble("actualAmount"))));
		paymentSummary.setExpectedAmount(new BigDecimal(
			String.valueOf(obj.getDouble("expectedAmount"))));

		return paymentSummary;
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
