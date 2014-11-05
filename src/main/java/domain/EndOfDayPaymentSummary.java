package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class EndOfDayPaymentSummary
{
	private PaymentMethod paymentMethods;
	private BigDecimal actualAmount;
	private BigDecimal expectedAmount;

	public PaymentMethod getPaymentMethods()
	{
		return paymentMethods;
	}

	public void setPaymentMethods(final PaymentMethod paymentMethods)
	{
		this.paymentMethods = paymentMethods;
	}

	public static EndOfDayPaymentSummary fromJSON(final JSONObject obj) throws JSONException
	{

		final EndOfDayPaymentSummary paymentSummary = new EndOfDayPaymentSummary();

		final PaymentMethod paymentMethods = new PaymentMethod.Builder().id(
			obj.getString("paymentMethod")).build();

		paymentSummary.setPaymentMethods(paymentMethods);
		paymentSummary.setActualAmount(new BigDecimal(String.valueOf(obj.getDouble("actualAmount"))));
		paymentSummary.setExpectedAmount(new BigDecimal(
			String.valueOf(obj.getDouble("expectedAmount"))));

		return paymentSummary;
	}

	public BigDecimal getActualAmount()
	{
		return actualAmount;
	}

	public void setActualAmount(final BigDecimal actualAmount)
	{
		this.actualAmount = actualAmount;
	}

	public BigDecimal getExpectedAmount()
	{
		return expectedAmount;
	}

	public void setExpectedAmount(final BigDecimal expectedAmount)
	{
		this.expectedAmount = expectedAmount;
	}
}
