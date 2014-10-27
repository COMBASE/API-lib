package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNumberJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.Receipt;

public class ReceiptLoader extends AbstractHasNumberJsonLoader<Receipt>
{

	public ReceiptLoader(final CloudLink cloudLink)
	{
		super(DataType.receipt, cloudLink);
	}

	@Override
	public JSONObject toJSON(final Receipt value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public Receipt fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Receipt receipt = Receipt.fromJSON(obj);
		return receipt;
	}

}
