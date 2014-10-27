package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNumberJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.InventoryReceipt;

public class InventoryReceiptLoader extends AbstractHasNumberJsonLoader<InventoryReceipt>
{

	public InventoryReceiptLoader(final CloudLink cloudLink)
	{
		super(DataType.inventoryReceipt, cloudLink);
	}

	@Override
	public JSONObject toJSON(final InventoryReceipt value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public InventoryReceipt fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final InventoryReceipt inventoryReceipt = InventoryReceipt.fromJSON(obj);
		return inventoryReceipt;
	}

}
