package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.TimeTracking;
import domain.enums.DataType;

public class TimeTrackingLoader extends AbstractHasIdJsonLoader<TimeTracking>
{

	public TimeTrackingLoader(final CloudLink cloudLink)
	{
		super(DataType.timeTracking, cloudLink);
	}

	@Override
	public JSONObject toJSON(final TimeTracking value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

	@Override
	public TimeTracking fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final TimeTracking timeTracking = TimeTracking.fromJSON(obj);
		return timeTracking;
	}

}
