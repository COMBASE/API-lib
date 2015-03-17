package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class CommodityGroup extends AbstractNameAndNumberApiObject<CommodityGroup>
{
	public static class Builder extends Init<Builder>
	{
		@Override
		protected Builder self()
		{
			return this;
		}
	}

	protected static abstract class Init<T extends Init<T>> extends
			AbstractNameAndNumberApiObject.Init<T>
	{
		private Boolean hasChildren = null;
		private String key = null;
		private CommodityGroup parent = null;

		@Override
		public CommodityGroup build()
		{
			return new CommodityGroup(this);
		}

		public T hasChildren(final boolean value)
		{
			hasChildren = value;
			return self();
		}

		public T key(final String s)
		{
			key = s;
			return self();
		}

		public T parent(final CommodityGroup group)
		{
			parent = group;
			return self();
		}
	}

	private static final long serialVersionUID = -1157923369749796851L;

	public static CommodityGroup fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");
		final CommodityGroup grp = new CommodityGroup.Builder().name(obj.getString("name"))
				.revision(obj.getLong("revision")).deleted(obj.getBoolean("deleted")).build();
		if (obj.has("number"))
			grp.setNumber(obj.getString("number"));
		if (obj.has("uuid"))
			grp.setId(obj.getString("uuid"));

		return grp;
	}

	private Boolean hasChildren;

	private String key;

	private CommodityGroup parent;

	// public JSONObject toJSON()
	// {
	// final JSONObject obj = new JSONObject();
	// try
	// {

	// return obj;
	// }
	// catch (final JSONException e)
	// {
	// e.printStackTrace();
	// return null;
	// }
	// }

	// public static CommodityGroup fromJSON(JSONObject obj) throws
	// JSONException
	// {
	//
	//
	//
	// }

	// public boolean post() throws ApiNotReachableException
	// {
	// if (parent != null)
	// {
	// parent.hasChildren = true;
	// if (parent.getUuid() == null)
	// {
	// parent.post();
	// }
	// }
	// final boolean result =
	// CloudLink.getConnector().postData(DataType.commodityGroup,
	// this.toJSON());
	// if (number != null)
	// uuid = CloudLink.getUUIDByNumber(DataType.commodityGroup, number);
	// else
	// uuid = CloudLink.getUUIDByName(DataType.commodityGroup, name);
	// return result;
	// }

	private CommodityGroup(final Init<?> init)
	{
		super(init);
		hasChildren = init.hasChildren;
		key = init.key;
		parent = init.parent;

	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public String getKey()
	{
		return key;
	}

	public CommodityGroup getParent()
	{
		return parent;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = super.hashCode(result);

		result = prime * result + ((this.key == null) ? 0 : this.key.hashCode());
		result = prime * result + ((this.parent == null) ? 0 : this.parent.hashCode());
		result = prime * result + ((this.hasChildren == null) ? 0 : this.hasChildren.hashCode());

		return result;
	}

	public boolean isHasChildren()
	{
		return hasChildren;
	}

	public void setHasChildren(final boolean hasChildren)
	{
		this.hasChildren = hasChildren;
	}

	public void setKey(final String key)
	{
		this.key = key;
	}

	public void setParent(final CommodityGroup parent)
	{
		this.parent = parent;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		JSONObject obj = new JSONObject();
		obj = super.appendJSON(obj);

		obj.put("hasChildren", hasChildren);
		obj.put("key", key);
		if (parent != null)
			obj.put("parentCommodityGroup", parent.getId());

		return obj;
	}
}
