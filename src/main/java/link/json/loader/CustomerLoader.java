package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNumberJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Customer;
import domain.DataType;

public class CustomerLoader extends AbstractHasNumberJsonLoader<Customer>
{

	public CustomerLoader(final CloudLink cloudLink)
	{
		super(DataType.customer, cloudLink);
	}

	@Override
	public JSONObject toJSON(final Customer value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public Customer fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Customer customer = Customer.fromJSON(obj);
		return customer;
	}

}
