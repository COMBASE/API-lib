package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.POS;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

public class POSLoader extends AbstractHasNameJsonLoader<POS>
{
	CustomerGroupLoader customerGroupLoader;

	PaymentMethodLoader paymentMethodLoader;

	EconomicZoneLoader economicZoneLoader;

	OrganizationalUnitLoader organizationalUnitLoader;

	public POSLoader(final CloudLink cloudLink)
	{
		super(DataType.pos, cloudLink);
	}

	@Override
	public POS fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final POS pos = POS.fromJSON(obj);
		return pos;
	}

	@Override
	public POS postAndResolve(final POS obj) throws JSONException, ParseException,
	KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		if (obj.getDefaultCustomerGroup() != null)
		{
			if (customerGroupLoader == null)
			{
				customerGroupLoader = new CustomerGroupLoader(cloudLink);
			}
			customerGroupLoader.postAndResolve(obj.getDefaultCustomerGroup());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No CustomerGroup to resolve and to pre-post");
		}

		if (obj.getDefaultPaymentMethod() != null)
		{
			if (paymentMethodLoader == null)
			{
				paymentMethodLoader = new PaymentMethodLoader(cloudLink);
			}
			paymentMethodLoader.postAndResolve(obj.getDefaultPaymentMethod());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No PaymentMethod to resolve and to pre-post");
		}

		if (obj.getEconomicZone() != null)
		{
			if (economicZoneLoader == null)
			{
				economicZoneLoader = new EconomicZoneLoader(cloudLink);
			}
			economicZoneLoader.postAndResolve(obj.getEconomicZone());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No EconomicZone to resolve and to pre-post");
		}

		if (obj.getFriendsBonusCustomerGroup() != null)
		{
			if (customerGroupLoader == null)
			{
				customerGroupLoader = new CustomerGroupLoader(cloudLink);
			}
			customerGroupLoader.postAndResolve(obj.getFriendsBonusCustomerGroup());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No CustomerGroup to resolve and to pre-post");
		}

		if (obj.getOrganizationalUnit() != null)
		{
			if (organizationalUnitLoader == null)
			{
				organizationalUnitLoader = new OrganizationalUnitLoader(cloudLink);
			}
			organizationalUnitLoader.postAndResolve(obj.getOrganizationalUnit());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No OrganizationalUnit to resolve and to pre-post");
		}

		return post(obj);
	}

	@Override
	public JSONObject toJSON(final POS value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

}
