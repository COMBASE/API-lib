package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class OrganizationalUnit
{
	private boolean deleted;
	private String revision;
	private String uuid;
	private String number;
	private String name;
	private String parent;
	// private AssortmentValidities assortmentValidities;
	// private AdressInformation adressInformation;
	private Pricelist priceGroup;
	// private OrderingSources orderingSources;
	private String storageSpace;
	private String salesArea;
	private boolean mondayOpen;
	private boolean tuesdayOpen;
	private boolean wednesdayOpen;
	private boolean thursdayOpen;
	private boolean fridayOpen;
	private boolean saturdayOpen;
	private boolean sundayOpen;
	private boolean hasChildren;

	// usw...

	private OrganizationalUnit(final Builder builder)
	{
		deleted = builder.deleted;
		revision = builder.revision;
		number = builder.number;
		uuid = builder.uuid;
		name = builder.name;
		parent = builder.parent;
	}

	/**
	 * Pre-Builder Ctor
	 * 
	 * @param preBuilder
	 */
	private OrganizationalUnit(final PreBuilder preBuilder)
	{
		uuid = preBuilder.uuid;
	}

	/**
	 * Pre-initialized object when UUID is exclusively known and other fields aren't necessary. I.e.
	 * you've downloaded an object to enrich certain fields and you want to uploaded the updated
	 * one. In this scenario you don't have to resolve all its sub objects.
	 * 
	 * @author mas
	 * 
	 */
	public static class PreBuilder
	{
		private final String uuid;

		public PreBuilder(final String uuid)
		{
			this.uuid = uuid;
		}

		public OrganizationalUnit build()
		{
			return new OrganizationalUnit(this);
		}
	}

	public static class Builder
	{
		private boolean deleted = false;
		private final String revision = null;
		private String uuid = null;
		private String number = null;
		private String name = null;
		private final String parent = null;

		// private AssortmentValidities assortmentValidities;
		// private AdressInformation adressInformation;
// private final Pricelist priceGroup = null;
// private OrderingSources orderingSources;
// private final String storageSpace = null;
// private final String salesArea = null;
// private final boolean mondayOpen = false;
// private final boolean tuesdayOpen = false;
// private final boolean wednesdayOpen = false;
// private final boolean thursdayOpen = false;
// private final boolean fridayOpen = false;
// private final boolean saturdayOpen = false;
// private final boolean sundayOpen = false;
// private final boolean hasChildren = false;

		// usw...

		public Builder(final String name)
		{
			this.name = name;
		}

		public Builder(final String uuid, final int test)
		{
			this.uuid = uuid;
		}

		public Builder deleted(final boolean value)
		{
			deleted = value;
			return this;
		}

		public Builder uuid(final String value)
		{
			uuid = value;
			return this;
		}

		public Builder number(final String value)
		{
			number = value;
			return this;
		}

		public OrganizationalUnit build()
		{
			return new OrganizationalUnit(this);
		}
	}

	public JSONObject toJSON()
	{
		final JSONObject obj = new JSONObject();
		try
		{
			obj.put("name", name);
			obj.put("deleted", deleted);
			obj.put("revision", revision);
			obj.put("uuid", uuid);
			if (number != null)
				obj.put("number", number);

			// Dependencies to existence of other objects

			return obj;
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static OrganizationalUnit fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");
		final OrganizationalUnit orgUnit = new OrganizationalUnit.Builder(obj.getString("name")).deleted(
			obj.getBoolean("deleted"))
			.number(obj.getString("number"))
			.uuid(obj.getString("uuid"))
			.build();
		return orgUnit;
	}

	public boolean post() throws IOException
	{

		// dependencies
		return CloudLink.getConnector().postData(DataType.organizationalUnit, this.toJSON());
	}

	public boolean isDeleted()
	{
		return deleted;
	}

	public void setDeleted(final boolean deleted)
	{
		this.deleted = deleted;
	}

	public String getRevision()
	{
		return revision;
	}

	public void setRevision(final String revision)
	{
		this.revision = revision;
	}

	public String getUuid()
	{
		return uuid;
	}

	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(final String number)
	{
		this.number = number;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getParent()
	{
		return parent;
	}

	public void setParent(final String parent)
	{
		this.parent = parent;
	}

	public Pricelist getPriceGroup()
	{
		return priceGroup;
	}

	public void setPriceGroup(final Pricelist priceGroup)
	{
		this.priceGroup = priceGroup;
	}

	public String getStorageSpace()
	{
		return storageSpace;
	}

	public void setStorageSpace(final String storageSpace)
	{
		this.storageSpace = storageSpace;
	}

	public String getSalesArea()
	{
		return salesArea;
	}

	public void setSalesArea(final String salesArea)
	{
		this.salesArea = salesArea;
	}

	public boolean isMondayOpen()
	{
		return mondayOpen;
	}

	public void setMondayOpen(final boolean mondayOpen)
	{
		this.mondayOpen = mondayOpen;
	}

	public boolean isTuesdayOpen()
	{
		return tuesdayOpen;
	}

	public void setTuesdayOpen(final boolean tuesdayOpen)
	{
		this.tuesdayOpen = tuesdayOpen;
	}

	public boolean isWednesdayOpen()
	{
		return wednesdayOpen;
	}

	public void setWednesdayOpen(final boolean wednesdayOpen)
	{
		this.wednesdayOpen = wednesdayOpen;
	}

	public boolean isThursdayOpen()
	{
		return thursdayOpen;
	}

	public void setThursdayOpen(final boolean thursdayOpen)
	{
		this.thursdayOpen = thursdayOpen;
	}

	public boolean isFridayOpen()
	{
		return fridayOpen;
	}

	public void setFridayOpen(final boolean fridayOpen)
	{
		this.fridayOpen = fridayOpen;
	}

	public boolean isSaturdayOpen()
	{
		return saturdayOpen;
	}

	public void setSaturdayOpen(final boolean saturdayOpen)
	{
		this.saturdayOpen = saturdayOpen;
	}

	public boolean isSundayOpen()
	{
		return sundayOpen;
	}

	public void setSundayOpen(final boolean sundayOpen)
	{
		this.sundayOpen = sundayOpen;
	}

	public boolean isHasChildren()
	{
		return hasChildren;
	}

	public void setHasChildren(final boolean hasChildren)
	{
		this.hasChildren = hasChildren;
	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
		result = prime * result + ((this.revision == null) ? 0 : this.revision.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.parent == null) ? 0 : this.parent.hashCode());
		result = prime * result + ((this.salesArea == null) ? 0 : this.salesArea.hashCode());
		result = prime * result + ((this.storageSpace == null) ? 0 : this.storageSpace.hashCode());
		result = prime * result + ((this.priceGroup == null) ? 0 : this.priceGroup.hashCode());


		return result;
	}


}
