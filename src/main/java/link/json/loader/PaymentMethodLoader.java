package link.json.loader;

import java.text.ParseException;

import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.PaymentMethod;

public class PaymentMethodLoader extends AbstractHasNameJsonLoader<PaymentMethod>
{

	public PaymentMethodLoader(final String cloudUrl, final String token)
	{
		super(DataType.paymentMethod, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final PaymentMethod value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public PaymentMethod fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final PaymentMethod paymentMethod = PaymentMethod.fromJSON(obj);
		return paymentMethod;
	}

}
