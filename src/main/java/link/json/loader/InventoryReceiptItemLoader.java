package link.json.loader;

import java.text.ParseException;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Inventory;
import domain.InventoryReceipt;
import domain.InventoryReceiptItem;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import link.CloudLink;
import link.json.AbstractHasIdJsonLoader;



public class InventoryReceiptItemLoader extends AbstractHasIdJsonLoader<InventoryReceiptItem>
{
	private InventoryLoader inventoryLoader;

	private InventoryReceiptLoader inventoryReceiptLoader;

	private ProductLoader productLoader;


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


	@Override
	public InventoryReceiptItem postAndResolve(final InventoryReceiptItem obj) throws JSONException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		if (obj.getArticle() != null)
		{
			if (productLoader == null)
			{
				productLoader = new ProductLoader(cloudLink);
			}
			productLoader.postAndResolve(obj.getArticle());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No Article to resolve and to pre-post");
		}

		if (obj.getReceipt() != null)
		{
			if (inventoryReceiptLoader == null)
			{
				inventoryReceiptLoader = new InventoryReceiptLoader(cloudLink);
			}
			inventoryReceiptLoader.postAndResolve(obj.getReceipt());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No inventoryReceipt to resolve and to pre-post");
		}

		return post(obj);
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
	 * @throws KoronaCloudAPIErrorMessageException
	 * @throws InvalidTokenException
	 * @throws ArticleCodeMustBeUniqueException
	 */
	public List<InventoryReceiptItem> postList(final List<InventoryReceiptItem> items, List<InventoryReceipt> receipts, List<Inventory> inventories, final int limit, final int threads) throws JSONException, ParseException, ApiNotReachableException, KoronaCloudAPIErrorMessageException, InvalidTokenException
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
