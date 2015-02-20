package link.json.loader;

import java.text.ParseException;
import java.util.List;

import link.CloudLink;
import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.Inventory;
import domain.InventoryReceipt;
import domain.InventoryReceiptItem;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.PostAllException;

public class InventoryReceiptItemLoader extends AbstractHasIdJsonLoader<InventoryReceiptItem>
{

	InventoryLoader inventoryLoader;

	InventoryReceiptLoader inventoryReceiptLoader;


	public InventoryReceiptItemLoader(final CloudLink cloudLink)
	{
		super(DataType.inventoryReceiptItem, cloudLink);
		inventoryLoader = new InventoryLoader(cloudLink);
		inventoryReceiptLoader = new InventoryReceiptLoader(cloudLink);
	}

	@Override
	public InventoryReceiptItem fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final InventoryReceiptItem inventoryReceiptItem = InventoryReceiptItem.fromJSON(obj);
		return inventoryReceiptItem;
	}

	/**
	 * Posting complete Inventory Report
	 *
	 * @param items
	 * @param receipts
	 * @param inventories
	 * @param limit
	 * @return updated list:List(InventoryReceipt)
	 * @throws JSONException
	 * @throws ParseException
	 * @throws ApiNotReachableException
	 * @throws PostAllException
	 * @throws InvalidTokenException
	 */
	public List<InventoryReceiptItem> postList(final List<InventoryReceiptItem> items,
		List<InventoryReceipt> receipts, List<Inventory> inventories, final int limit,
		final int threads) throws JSONException, ParseException, ApiNotReachableException,
		PostAllException, InvalidTokenException
	{

		inventories = inventoryLoader.postList(inventories, limit, threads);


		for (final InventoryReceipt receipt : receipts)
		{
			receipt.setInventory(inventoryLoader.getCachedObject(receipt.getInventory()));
		}

		receipts = inventoryReceiptLoader.postList(receipts, limit, threads);

		for (final InventoryReceiptItem item : items)
		{
			item.setReceipt(inventoryReceiptLoader.getCachedObject(item.getReceipt()));
		}

		return super.postList(items, limit, threads);

	}

	@Override
	public JSONObject toJSON(final InventoryReceiptItem value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

}
