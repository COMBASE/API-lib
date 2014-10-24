package link.json.loader;

import java.text.ParseException;

import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.TimeTrackingEntities;

public class TimeTrackingEntitiesLoader extends AbstractHasNameJsonLoader<TimeTrackingEntities>
{

	public TimeTrackingEntitiesLoader(final String cloudUrl, final String token)
	{
		super(DataType.timeTrackingEntity, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final TimeTrackingEntities value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public TimeTrackingEntities fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final TimeTrackingEntities timeTrackingEntities = TimeTrackingEntities.fromJSON(obj);
		return timeTrackingEntities;
	}

}
