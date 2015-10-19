package link.json.loader;

import java.text.ParseException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Sector;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;



public class SectorLoader extends AbstractHasNameJsonLoader<Sector>
{
	public SectorLoader(final CloudLink cloudLink)
	{
		super(DataType.sector, cloudLink);
	}


	@Override
	public Sector fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Sector sector = Sector.fromJSON(obj);
		return sector;
	}


	@Override
	public Sector postAndResolve(final Sector obj) throws JSONException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		LOGGER.debug(super.getDataType() + ": Nothing to resolve and to pre-post");

		return post(obj);
	}


	@Override
	public JSONObject toJSON(final Sector value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}
}
