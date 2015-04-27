package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.CommodityGroup;
import domain.enums.DataType;

public class CommodityGroupLoader extends AbstractHasNameJsonLoader<CommodityGroup>
{

	public CommodityGroupLoader(final CloudLink cloudLink)
	{
		super(DataType.commodityGroup, cloudLink);
	}

	@Override
	public JSONObject toJSON(final CommodityGroup value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}

	@Override
	public CommodityGroup fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final CommodityGroup commodityGroup = CommodityGroup.fromJSON(obj);
		return commodityGroup;
	}

}
