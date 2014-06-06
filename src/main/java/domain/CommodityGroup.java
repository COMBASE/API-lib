package domain;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import error.ApiNotReachableException;

public class CommodityGroup
{
	private String name;
	private String number;
	private boolean deleted;
	private boolean hasChildren;
	private String key;
	private String uuid;
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
		private String number = null;
		private boolean deleted = false;
		private boolean hasChildren = false;
		private String key = null;
		private CommodityGroup parent = null;

		public Builder(String name)
		{
			this.name = name;
		}

		public Builder number(String value)
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
			if (number!=null)
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
	
	public static CommodityGroup fromJSON(JSONObject obj) throws JSONException {
		if(obj.has("result") && obj.getString("result")!=null)
			obj = obj.getJSONObject("result");
		CommodityGroup grp = new CommodityGroup.Builder(obj.getString("name"))
						.build();
		if (obj.has("number"))
			grp.setNumber(obj.getString("number"));
		
		return grp;
			
		

		
	}
	
	public boolean post() throws ApiNotReachableException
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
		if (number!=null)
			uuid = CloudLink.getUUIDByNumber(DataType.commodityGroup, String.valueOf(number));
		else
			uuid = CloudLink.getUUIDByName(DataType.commodityGroup, name);
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

	public String getNumber()
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

	public void setNumber(String number)
	{
		this.number = number;
	}
	
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.key == null) ? 0 : this.key.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
		result = prime * result + ((this.parent == null) ? 0 : this.parent.hashCode());

		return result;
	}
}
