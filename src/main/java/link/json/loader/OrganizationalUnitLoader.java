package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.OrganizationalUnit;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

public class OrganizationalUnitLoader extends AbstractHasNameJsonLoader<OrganizationalUnit>
{
	EconomicZoneLoader economicZoneLoader;
	OrganizationalUnitLoader organizationalUnitLoader;

	public OrganizationalUnitLoader(final CloudLink cloudLink)
	{
		super(DataType.organizationalUnit, cloudLink);
	}

	@Override
	public OrganizationalUnit fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final OrganizationalUnit organizationalUnit = OrganizationalUnit.fromJSON(obj);
		return organizationalUnit;
	}

	@Override
	public OrganizationalUnit postAndResolve(final OrganizationalUnit obj) throws JSONException,
		ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException,
		ApiNotReachableException
	{
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

		if (obj.getOrderingSources() != null && !obj.getOrderingSources().isEmpty())
		{
			for (final OrganizationalUnit organizationalUnit : obj.getOrderingSources())
			{
				if (organizationalUnit != null)
				{
					if (organizationalUnitLoader == null)
					{
						organizationalUnitLoader = new OrganizationalUnitLoader(cloudLink);
					}
					organizationalUnitLoader.postAndResolve(organizationalUnit);
				}
			}
		}
		else
		{
			LOGGER.debug(super.getDataType() +
				": No Account Transaction to resolve and to pre-post");
		}

		return post(obj);
	}

	@Override
	public JSONObject toJSON(final OrganizationalUnit value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}

}
