package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNumberJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.FullReceipt;

public class FullReceiptLoader extends AbstractHasNumberJsonLoader<FullReceipt>
{
	public FullReceiptLoader(final CloudLink cloudLink)
	{
		super(DataType.fullReceipt, cloudLink);
	}

	@Override
	public JSONObject toJSON(final FullReceipt value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return null;
	}

	@Override
	public FullReceipt fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final FullReceipt fullReceipt = FullReceipt.fromJSON(obj);
		return fullReceipt;
	}
}
