package link.json.loader;

import java.text.ParseException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.EndOfDayStatement;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import link.CloudLink;
import link.json.AbstractHasIdJsonLoader;



public class EndOfDayStatementLoader extends AbstractHasIdJsonLoader<EndOfDayStatement>
{
	POSLoader posLoader;


	public EndOfDayStatementLoader(final CloudLink cloudLink)
	{
		super(DataType.endOfDayStatement, cloudLink);
	}


	@Override
	public EndOfDayStatement fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final EndOfDayStatement endOfDayStatement = EndOfDayStatement.fromJSON(obj);
		return endOfDayStatement;
	}


	@Override
	public EndOfDayStatement postAndResolve(final EndOfDayStatement obj) throws JSONException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		if (obj.getPos() != null)
		{
			if (posLoader == null)
			{
				posLoader = new POSLoader(cloudLink);
			}
			posLoader.postAndResolve(obj.getPos());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No Receipt to resolve and to pre-post");
		}

		return post(obj);
	}


	@Override
	public JSONObject toJSON(final EndOfDayStatement value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}
}
