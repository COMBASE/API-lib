package link.json.loader;

import java.text.ParseException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.CommodityGroup;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;



public class CommodityGroupLoader extends AbstractHasNameJsonLoader<CommodityGroup>
{

	CommodityGroupLoader commodityGroupLoader;


	public CommodityGroupLoader(final CloudLink cloudLink)
	{
		super(DataType.commodityGroup, cloudLink);
	}


	@Override
	public CommodityGroup fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final CommodityGroup commodityGroup = CommodityGroup.fromJSON(obj);
		return commodityGroup;
	}


	@Override
	public CommodityGroup postAndResolve(final CommodityGroup obj) throws JSONException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		if (obj.getParent() != null)
		{
			if (commodityGroupLoader == null)
			{
				commodityGroupLoader = new CommodityGroupLoader(cloudLink);
			}
			commodityGroupLoader.postAndResolve(obj.getParent());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No Commodity Group to resolve and to pre-post");
		}

		return post(obj);
	}


	@Override
	public JSONObject toJSON(final CommodityGroup value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}
}
