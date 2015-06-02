package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Inventory;
import domain.OrganizationalUnit;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

public class InventoryLoader extends AbstractHasNameJsonLoader<Inventory>
{
	OrganizationalUnitLoader organizationalUnitLoader;

	UserLoader userLoader;

	public InventoryLoader(final CloudLink cloudLink)
	{
		super(DataType.inventory, cloudLink);
	}

	@Override
	public Inventory fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Inventory inventory = Inventory.fromJSON(obj);
		return inventory;
	}

	@Override
	public Inventory postAndResolve(final Inventory obj) throws JSONException, ParseException,
	KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		if (obj.getOrganizationalUnits() != null && !obj.getOrganizationalUnits().isEmpty())
		{
			for (final OrganizationalUnit organizationalUnit : obj.getOrganizationalUnits())
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
			LOGGER.debug(super.getDataType() + ": No Payment to resolve and to pre-post");
		}

		if (obj.getUser() != null)
		{
			if (userLoader == null)
			{
				userLoader = new UserLoader(cloudLink);
			}
			userLoader.postAndResolve(obj.getUser());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No User to resolve and to pre-post");
		}

		return post(obj);

	}

	@Override
	public JSONObject toJSON(final Inventory value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}

}
