package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.Payment;

public class PaymentLoader extends AbstractHasIdJsonLoader<Payment>
{
	public PaymentLoader(final CloudLink cloudLink)
	{
		super(DataType.payment, cloudLink);
	}

	@Override
	public JSONObject toJSON(final Payment value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

	@Override
	public Payment fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Payment payment = Payment.fromJSON(obj);
		return payment;
	}
}
