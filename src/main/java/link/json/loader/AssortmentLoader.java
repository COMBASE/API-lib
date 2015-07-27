package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Assortment;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

/**
 *
 * @author mas
 *
 */
public class AssortmentLoader extends AbstractHasNameJsonLoader<Assortment>
{
	public AssortmentLoader(final CloudLink cloudLink)
	{
		super(DataType.assortment, cloudLink);
	}

	@Override
	public Assortment fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Assortment assortment = Assortment.fromJSON(obj);

		return assortment;
	}

	@Override
	public Assortment postAndResolve(final Assortment obj) throws JSONException, ParseException,
	KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		LOGGER.debug(super.getDataType() + ": Nothing to resolve and to pre-post");

		return post(obj);
	}

	@Override
	public JSONObject toJSON(final Assortment value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}
}
