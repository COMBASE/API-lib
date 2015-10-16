package link.json.loader;

import java.text.ParseException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.TimeTrackingEntities;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;



public class TimeTrackingEntitiesLoader extends AbstractHasNameJsonLoader<TimeTrackingEntities>
{
	public TimeTrackingEntitiesLoader(final CloudLink cloudLink)
	{
		super(DataType.timeTrackingEntity, cloudLink);
	}


	@Override
	public TimeTrackingEntities fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final TimeTrackingEntities timeTrackingEntities = TimeTrackingEntities.fromJSON(obj);
		return timeTrackingEntities;
	}


	@Override
	public TimeTrackingEntities postAndResolve(final TimeTrackingEntities obj) throws JSONException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		LOGGER.debug(super.getDataType() + ": Nothing to resolve and to pre-post");

		return post(obj);
	}


	@Override
	public JSONObject toJSON(final TimeTrackingEntities value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}
}
