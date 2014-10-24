package link.json.loader;

import java.text.ParseException;

import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.TimeTracking;

public class TimeTrackingLoader extends AbstractHasIdJsonLoader<TimeTracking>
{

	public TimeTrackingLoader(final String cloudUrl, final String token)
	{
		super(DataType.timeTracking, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final TimeTracking value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public TimeTracking fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final TimeTracking timeTracking = TimeTracking.fromJSON(obj);
		return timeTracking;
	}

}
