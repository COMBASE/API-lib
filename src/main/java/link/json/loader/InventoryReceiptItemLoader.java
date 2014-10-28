package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.InventoryReceiptItem;

public class InventoryReceiptItemLoader extends AbstractHasIdJsonLoader<InventoryReceiptItem>
{

	public InventoryReceiptItemLoader(final CloudLink cloudLink)
	{
		super(DataType.inventoryReceiptItem, cloudLink);
	}

	@Override
	public JSONObject toJSON(final InventoryReceiptItem value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

	@Override
	public InventoryReceiptItem fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final InventoryReceiptItem inventoryReceiptItem = InventoryReceiptItem.fromJSON(obj);
		return inventoryReceiptItem;
	}

}
