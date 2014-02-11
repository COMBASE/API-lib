package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class CommodityGroup
{
	private String name;
	private int number;
	private boolean deleted;
	private boolean hasChildren;
	private String key;
	private String uuid = null;
	private CommodityGroup parent;

	private CommodityGroup(Builder builder)
	{
		name = builder.name;
		number = builder.number;
		deleted = builder.deleted;
		hasChildren = builder.hasChildren;
		key = builder.key;
		parent = builder.parent;
	}

	public static class Builder
	{
		private final String name;
		private int number = 0;
		private boolean deleted = false;
		private boolean hasChildren = false;
		private String key = null;
		private CommodityGroup parent = null;

		public Builder(String name)
		{
			this.name = name;
		}

		public Builder number(int value)
		{
			number = value;
			return this;
		}

		public Builder deleted(boolean value)
		{
			deleted = value;
			return this;
		}

		public Builder hasChildren(boolean value)
		{
			hasChildren = value;
			return this;
		}

		public Builder key(String s)
		{
			key = s;
			return this;
		}

		public Builder parent(CommodityGroup group)
		{
			parent = group;
			return this;
		}

		public CommodityGroup build()
		{
			return new CommodityGroup(this);
		}
	}

	public JSONObject toJSON()
	{
		JSONObject obj = new JSONObject();
		try
		{
			obj.put("name", name);
			if (number != 0)
				obj.put("number", number);
			obj.put("deleted", deleted);
			obj.put("hasChildren", hasChildren);
			if (key != null)
				obj.put("key", key);
			if (parent != null)
				obj.put("parentCommodityGroup", parent.getUuid());
			return obj;
		}
		catch (JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean post() throws IOException
	{
		if (parent != null)
		{
			parent.hasChildren = true;
			if (parent.getUuid() == null)
			{
				parent.post();
			}
		}
		boolean result = CloudLink.getConnector().postData(DataType.commodityGroup, this.toJSON());
		if (number != 0)
			uuid = CloudLink.getUUID(DataType.commodityGroup, String.valueOf(number));
		else
			uuid = CloudLink.getUUID(DataType.commodityGroup, name);
		return result;
	}

	public String getUuid()
	{
		return uuid;
	}

	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}

	public int getNumber()
	{
		return number;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isDeleted()
	{
		return deleted;
	}

	public void setDeleted(boolean deleted)
	{
		this.deleted = deleted;
	}

	public boolean isHasChildren()
	{
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren)
	{
		this.hasChildren = hasChildren;
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public CommodityGroup getParent()
	{
		return parent;
	}

	public void setParent(CommodityGroup parent)
	{
		this.parent = parent;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}
}
