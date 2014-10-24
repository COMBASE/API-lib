package link.json.loader;

import java.text.ParseException;

import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.Payment;

public class PaymentLoader extends AbstractHasIdJsonLoader<Payment>
{
	public PaymentLoader(final String cloudUrl, final String token)
	{
		super(DataType.payment, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final Payment value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public Payment fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Payment payment = Payment.fromJSON(obj);
		return payment;
	}
}
