package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNumberJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Customer;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

public class CustomerLoader extends AbstractHasNumberJsonLoader<Customer>
{
	CustomerGroupLoader customerGroupLoader;

	public CustomerLoader(final CloudLink cloudLink)
	{
		super(DataType.customer, cloudLink);
	}

	@Override
	public Customer fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Customer customer = Customer.fromJSON(obj);
		return customer;
	}

	@Override
	public Customer postAndResolve(final Customer obj) throws JSONException, ParseException,
	KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		if (obj.getCustomerGroup() != null)
		{
			if (customerGroupLoader == null)
			{
				customerGroupLoader = new CustomerGroupLoader(cloudLink);
			}
			customerGroupLoader.postAndResolve(obj.getCustomerGroup());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No Customer Group to resolve and to pre-post");
		}

		return post(obj);
	}

	@Override
	public JSONObject toJSON(final Customer value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}

}
