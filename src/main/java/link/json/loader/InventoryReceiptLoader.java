package link.json.loader;

import java.text.ParseException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.InventoryReceipt;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import link.CloudLink;
import link.json.AbstractHasNumberJsonLoader;



public class InventoryReceiptLoader extends AbstractHasNumberJsonLoader<InventoryReceipt>
{
	private InventoryLoader inventoryLoader;

	private OrganizationalUnitLoader organizationalUnitLoader;

	private POSLoader posLoader;


	public InventoryReceiptLoader(final CloudLink cloudLink)
	{
		super(DataType.inventoryReceipt, cloudLink);
	}


	@Override
	public InventoryReceipt fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final InventoryReceipt inventoryReceipt = InventoryReceipt.fromJSON(obj);
		return inventoryReceipt;
	}


	@Override
	public InventoryReceipt postAndResolve(final InventoryReceipt obj) throws JSONException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		if (obj.getInventory() != null)
		{
			if (inventoryLoader == null)
			{
				inventoryLoader = new InventoryLoader(cloudLink);
			}
			inventoryLoader.postAndResolve(obj.getInventory());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No Inventory to resolve and to pre-post");
		}

		if (obj.getOrganizationalUnit() != null)
		{
			if (organizationalUnitLoader == null)
			{
				organizationalUnitLoader = new OrganizationalUnitLoader(cloudLink);
			}
			organizationalUnitLoader.postAndResolve(obj.getOrganizationalUnit());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No OrganizationalUnit to resolve and to pre-post");
		}

		if (obj.getPos() != null)
		{
			if (posLoader == null)
			{
				posLoader = new POSLoader(cloudLink);
			}
			posLoader.postAndResolve(obj.getPos());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No POS to resolve and to pre-post");
		}

		return post(obj);
	}


	@Override
	public JSONObject toJSON(final InventoryReceipt value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}
}
