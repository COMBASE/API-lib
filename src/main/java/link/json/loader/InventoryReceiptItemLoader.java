package link.json.loader;

import java.text.ParseException;

import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.InventoryReceiptItem;

public class InventoryReceiptItemLoader extends AbstractHasIdJsonLoader<InventoryReceiptItem>
{

	public InventoryReceiptItemLoader(final String cloudUrl, final String token)
	{
		super(DataType.inventoryReceiptItem, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final InventoryReceiptItem value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public InventoryReceiptItem fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final InventoryReceiptItem inventoryReceiptItem = InventoryReceiptItem.fromJSON(obj);
		return inventoryReceiptItem;
	}

}
