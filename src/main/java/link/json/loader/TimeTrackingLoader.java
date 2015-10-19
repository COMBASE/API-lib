package link.json.loader;

import java.text.ParseException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.TimeTracking;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import link.CloudLink;
import link.json.AbstractHasIdJsonLoader;



public class TimeTrackingLoader extends AbstractHasIdJsonLoader<TimeTracking>
{
	private CashierLoader cashierLoader;

	private TimeTrackingEntitiesLoader timeTrackingEntityLoader;


	public TimeTrackingLoader(final CloudLink cloudLink)
	{
		super(DataType.timeTracking, cloudLink);
	}


	@Override
	public TimeTracking fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final TimeTracking timeTracking = TimeTracking.fromJSON(obj);
		return timeTracking;
	}


	@Override
	public TimeTracking postAndResolve(final TimeTracking obj) throws JSONException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		if (obj.getCashier() != null)
		{
			if (cashierLoader == null)
			{
				cashierLoader = new CashierLoader(cloudLink);
			}
			cashierLoader.postAndResolve(obj.getCashier());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No Cashier to resolve and to pre-post");
		}

		if (obj.getTimeTrackingEntity() != null)
		{
			if (timeTrackingEntityLoader == null)
			{
				timeTrackingEntityLoader = new TimeTrackingEntitiesLoader(cloudLink);
			}
			timeTrackingEntityLoader.postAndResolve(obj.getTimeTrackingEntity());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No TimeTrackingEntity to resolve and to pre-post");
		}

		return null;
	}


	@Override
	public JSONObject toJSON(final TimeTracking value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}
}
