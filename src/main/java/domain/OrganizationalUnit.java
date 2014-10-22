package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class OrganizationalUnit extends AbstractNameAndNumberApiObject<OrganizationalUnit>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5837677863056916822L;
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

	protected static abstract class Init<T extends Init<T>> extends
		AbstractNameAndNumberApiObject.Init<T>
	{
		private final String parent = null;

		@Override
		public OrganizationalUnit build()
		{
			return new OrganizationalUnit(this);
		}
	}

	public static class Builder extends Init<Builder>
	{

		@Override
		protected Builder self()
		{
			return this;
		}

	}

	private OrganizationalUnit(final Init<?> init)
	{
		super(init);
		parent = init.parent;
	}

// public JSONObject toJSON()
// {
// final JSONObject obj = new JSONObject();
// try
// {
// obj.put("name", name);
// obj.put("deleted", deleted);
// obj.put("revision", revision);
// obj.put("uuid", uuid);
// if (number != null)
// obj.put("number", number);
//
// // Dependencies to existence of other objects
//
// return obj;
// }
// catch (final JSONException e)
// {
// e.printStackTrace();
// return null;
// }
// }
//
// public static OrganizationalUnit fromJSON(JSONObject obj) throws JSONException
// {
// if (obj.has("result") && obj.getString("result") != null)
// obj = obj.getJSONObject("result");
// final OrganizationalUnit orgUnit = new OrganizationalUnit.Builder(obj.getString("name")).deleted(
// obj.getBoolean("deleted"))
// .number(obj.getString("number"))
// .uuid(obj.getString("uuid"))
// .build();
// return orgUnit;
// }
//
// public boolean post() throws IOException
// {
//
// // dependencies
// return CloudLink.getConnector().postData(DataType.organizationalUnit, this.toJSON());
// }

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

		result = super.hashCode(result);

		result = prime * result + ((this.parent == null) ? 0 : this.parent.hashCode());
		result = prime * result + ((this.salesArea == null) ? 0 : this.salesArea.hashCode());
		result = prime * result + ((this.storageSpace == null) ? 0 : this.storageSpace.hashCode());
		result = prime * result + ((this.priceGroup == null) ? 0 : this.priceGroup.hashCode());


		return result;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		writeJSON(obj);
		return obj;
	}

	@Override
	public void writeJSON(final JSONObject obj) throws JSONException
	{
		super.writeJSON(obj);

	}

	@Override
	public OrganizationalUnit fromJSON(final JSONObject obj) throws JSONException
	{
		readJSON(obj);
		return this;
	}

	@Override
	public void readJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		super.readJSON(obj);


	}
}
