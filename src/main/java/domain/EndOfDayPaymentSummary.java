package domain;

import java.math.BigDecimal;

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

	public static EndOfDayPaymentSummary fromJSON(final JSONObject jEndOfDayPaymentSummary)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
