package link.json.loader;

import java.text.ParseException;

import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.CommodityGroup;
import domain.DataType;

public class CommodityGroupLoader extends AbstractHasNameJsonLoader<CommodityGroup>
{

	public CommodityGroupLoader(final String cloudUrl, final String token)
	{
		super(DataType.commodityGroup, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final CommodityGroup value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public CommodityGroup fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final CommodityGroup commodityGroup = CommodityGroup.fromJSON(obj);
		return commodityGroup;
	}

}
