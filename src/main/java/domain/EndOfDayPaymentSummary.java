package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class EndOfDayPaymentSummary
{
	private PaymentMethods paymentMethods;
	private BigDecimal amount;

	public PaymentMethods getPaymentMethods()
	{
		return paymentMethods;
	}

	public void setPaymentMethods(final PaymentMethods paymentMethods)
	{
		this.paymentMethods = paymentMethods;
	}

	public BigDecimal getAmount()
	{
		return amount;
	}

	public void setAmount(final BigDecimal amount)
	{
		this.amount = amount;
	}

	public static EndOfDayPaymentSummary fromJSON(final JSONObject obj) throws JSONException
	{

		final EndOfDayPaymentSummary paymentSummary = new EndOfDayPaymentSummary();

		final PaymentMethods paymentMethods = new PaymentMethods.Builder().id(
			obj.getString("paymentMethod")).build();

		paymentSummary.setPaymentMethods(paymentMethods);
		paymentSummary.setAmount(new BigDecimal(String.valueOf(obj.getDouble("amount"))));

		return paymentSummary;
	}
}
