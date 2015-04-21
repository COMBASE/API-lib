package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.PaymentMethod;
import domain.enums.DataType;

public class PaymentMethodLoader extends AbstractHasNameJsonLoader<PaymentMethod>
{

	public PaymentMethodLoader(final CloudLink cloudLink)
	{
		super(DataType.paymentMethod, cloudLink);
	}

	@Override
	public JSONObject toJSON(final PaymentMethod value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

	@Override
	public PaymentMethod fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final PaymentMethod paymentMethod = PaymentMethod.fromJSON(obj);
		return paymentMethod;
	}

}
