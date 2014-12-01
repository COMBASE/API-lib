package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.POS;

public class POSLoader extends AbstractHasNameJsonLoader<POS>
{

	public POSLoader(final CloudLink cloudLink)
	{
		super(DataType.pos, cloudLink);
	}

	@Override
	public JSONObject toJSON(final POS value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

	@Override
	public POS fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final POS pos = POS.fromJSON(obj);
		return pos;
	}

}
