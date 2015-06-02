package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.CustomerGroup;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

public class CustomerGroupLoader extends AbstractHasNameJsonLoader<CustomerGroup>
{
	PricelistLoader pricelistLoader;

	public CustomerGroupLoader(final CloudLink cloudLink)
	{
		super(DataType.customergroup, cloudLink);
	}

	@Override
	public CustomerGroup fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final CustomerGroup customerGroup = CustomerGroup.fromJSON(obj);
		return customerGroup;
	}

	@Override
	public CustomerGroup postAndResolve(final CustomerGroup obj) throws JSONException,
	ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException,
	ApiNotReachableException
	{

		if (obj.getPriceGroup() != null)
		{
			if (pricelistLoader == null)
			{
				pricelistLoader = new PricelistLoader(cloudLink);
			}
			pricelistLoader.postAndResolve(obj.getPriceGroup());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No Price Group to resolve and to pre-post");
		}

		return post(obj);

	}

	@Override
	public JSONObject toJSON(final CustomerGroup value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		obj.put("deleted", value.isDeleted());
		obj.put("revision", value.getRevision());
		obj.put("uuid", value.getId());
		obj.put("name", value.getName());
		obj.put("number", value.getNumber());

		return obj;
	}

}
