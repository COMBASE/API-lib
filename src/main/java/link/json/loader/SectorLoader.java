package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Sector;
import domain.enums.DataType;

public class SectorLoader extends AbstractHasNameJsonLoader<Sector>
{

	public SectorLoader(final CloudLink cloudLink)
	{
		super(DataType.sector, cloudLink);
	}

	@Override
	public JSONObject toJSON(final Sector value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

	@Override
	public Sector fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Sector sector = Sector.fromJSON(obj);
		return sector;
	}

}
