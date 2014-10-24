package link.json.loader;

import java.text.ParseException;

import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.Sector;

public class SectorLoader extends AbstractHasNameJsonLoader<Sector>
{

	public SectorLoader(final DataType dataType, final String cloudUrl, final String token)
	{
		super(dataType, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final Sector value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public Sector fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Sector sector = Sector.fromJSON(obj);
		return sector;
	}

}
