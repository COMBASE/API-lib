package link.json.loader;

import java.text.ParseException;

import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.EndOfDayStatement;

public class EndOfDayStatementLoader extends AbstractHasIdJsonLoader<EndOfDayStatement>
{

	public EndOfDayStatementLoader(final DataType dataType, final String cloudUrl,
		final String token)
	{
		super(dataType, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final EndOfDayStatement value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public EndOfDayStatement fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final EndOfDayStatement endOfDayStatement = EndOfDayStatement.fromJSON(obj);
		return endOfDayStatement;
	}

}
