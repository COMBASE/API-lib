package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.OrganizationalUnit;

public class OrganizationalUnitLoader extends AbstractHasNameJsonLoader<OrganizationalUnit>
{

	public OrganizationalUnitLoader(final CloudLink cloudLink)
	{
		super(DataType.organizationalUnit, cloudLink);
	}

	@Override
	public JSONObject toJSON(final OrganizationalUnit value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public OrganizationalUnit fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final OrganizationalUnit organizationalUnit = OrganizationalUnit.fromJSON(obj);
		return organizationalUnit;
	}

}
