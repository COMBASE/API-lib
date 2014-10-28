package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.EndOfDayStatement;

public class EndOfDayStatementLoader extends AbstractHasIdJsonLoader<EndOfDayStatement>
{

	public EndOfDayStatementLoader(final CloudLink cloudLink)
	{
		super(DataType.endOfDayStatement, cloudLink);
	}

	@Override
	public JSONObject toJSON(final EndOfDayStatement value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}

	@Override
	public EndOfDayStatement fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final EndOfDayStatement endOfDayStatement = EndOfDayStatement.fromJSON(obj);
		return endOfDayStatement;
	}

}
