package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNumberJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.PriceStandalone;

/**
 *
 * @author mas
 *
 */
public class PriceStandaloneLoader extends AbstractHasNumberJsonLoader<PriceStandalone>
{

	public PriceStandaloneLoader(final CloudLink cloudLink)
	{
		super(DataType.priceStandalone, cloudLink);
	}

	@Override
	public PriceStandalone fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		return null;
	}

	@Override
	public JSONObject toJSON(final PriceStandalone value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

}
