package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNumberJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.OrganizationalUnit;
import domain.User;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

public class UserLoader extends AbstractHasNumberJsonLoader<User>
{
	OrganizationalUnitLoader organizationalUnitLoader;

	public UserLoader(final CloudLink cloudLink)
	{
		super(DataType.user, cloudLink);
	}

	@Override
	public User fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final User user = User.fromJSON(obj);
		return user;
	}

	@Override
	public User postAndResolve(final User obj) throws JSONException, ParseException,
	KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		if (obj.getOrgs() != null && !obj.getOrgs().isEmpty())
		{
			for (final OrganizationalUnit organizationalUnit : obj.getOrgs())
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

		if (obj.getSelectedOrg() != null)
		{
			if (organizationalUnitLoader == null)
			{
				organizationalUnitLoader = new OrganizationalUnitLoader(cloudLink);
			}
			organizationalUnitLoader.postAndResolve(obj.getSelectedOrg());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No OrganizationalUnit to resolve and to pre-post");
		}

		return post(obj);

	}

	@Override
	public JSONObject toJSON(final User value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}


}
