package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Inventory extends AbstractNumberApiObject<Inventory>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4473050181320272357L;

	private String user;

	private String description;

	private List<OrganizationalUnit> organizationalUnits;

	private Date createTime;

	private Date processTime;

	private final String inventoryProcedure;

	private Integer automaticBookingDays;

	private Integer maxArticlesPerList;

	private Boolean automaticBooking;

	private Boolean fridayInventory;

	private Boolean mondayInventory;

	private Boolean oneCommodityGroupPerList;

	private Boolean saturdayInventory;

	private Boolean sundayInventory;

	private Boolean thursdayInventory;

	private Boolean tuesdayInventory;

	private Boolean wednesdayInventory;

	protected static abstract class Init<T extends Init<T>> extends AbstractNumberApiObject.Init<T>
	{
		private String user = null;

		private String description = null;

		private List<OrganizationalUnit> organizationalUnits = null;

		private Date createTime = null;

		private Date processTime = null;

		private String inventoryProcedure = null;

		private Integer automaticBookingDays = null;

		private Integer maxArticlesPerList = null;

		private Boolean automaticBooking = null;

		private Boolean fridayInventory = null;

		private Boolean mondayInventory = null;

		private Boolean oneCommodityGroupPerList = null;

		private Boolean saturdayInventory = null;

		private Boolean sundayInventory = null;

		private Boolean thursdayInventory = null;

		private Boolean tuesdayInventory = null;

		private Boolean wednesdayInventory = null;


		public T user(final String value)
		{
			user = value;
			return self();
		}

		public T description(final String value)
		{
			description = value;
			return self();
		}

		public T organizationalUnits(final List<OrganizationalUnit> value)
		{
			organizationalUnits = value;
			return self();
		}

		public T createTime(final Date value)
		{
			createTime = value;
			return self();
		}

		public T processTime(final Date value)
		{
			processTime = value;
			return self();
		}

		public T inventoryProcedure(final String value)
		{
			inventoryProcedure = value;
			return self();
		}

		public T automaticBookingDays(final Integer value)
		{
			automaticBookingDays = value;
			return self();
		}

		public T maxArticlesPerList(final Integer value)
		{
			maxArticlesPerList = value;
			return self();
		}

		public T automaticBooking(final Boolean value)
		{
			automaticBooking = value;
			return self();
		}

		public T fridayInventory(final Boolean value)
		{
			fridayInventory = value;
			return self();
		}

		public T mondayInventory(final Boolean value)
		{
			mondayInventory = value;
			return self();
		}

		public T oneCommodityGroupPerList(final Boolean value)
		{
			oneCommodityGroupPerList = value;
			return self();
		}

		public T saturdayInventory(final Boolean value)
		{
			saturdayInventory = value;
			return self();
		}

		public T sundayInventory(final Boolean value)
		{
			sundayInventory = value;
			return self();
		}

		public T thursdayInventory(final Boolean value)
		{
			thursdayInventory = value;
			return self();
		}

		public T tuesdayInventory(final Boolean value)
		{
			tuesdayInventory = value;
			return self();
		}

		public T wednesdayInventory(final Boolean value)
		{
			wednesdayInventory = value;
			return self();
		}

		@Override
		public Inventory build()
		{
			return new Inventory(this);
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

	public Inventory(final Init<?> init)
	{
		super(init);

		this.user = init.user;

		this.description = init.description;

		this.organizationalUnits = init.organizationalUnits;

		this.createTime = init.createTime;

		this.processTime = init.processTime;

		this.inventoryProcedure = init.inventoryProcedure;

		this.automaticBookingDays = init.automaticBookingDays;

		this.maxArticlesPerList = init.maxArticlesPerList;

		this.automaticBooking = init.automaticBooking;

		this.fridayInventory = init.fridayInventory;

		this.mondayInventory = init.mondayInventory;

		this.oneCommodityGroupPerList = init.oneCommodityGroupPerList;

		this.saturdayInventory = init.saturdayInventory;

		this.sundayInventory = init.sundayInventory;

		this.thursdayInventory = init.thursdayInventory;

		this.tuesdayInventory = init.tuesdayInventory;

		this.wednesdayInventory = init.wednesdayInventory;
	}

// public static Inventory fromJSON(JSONObject jObj) throws JSONException, ParseException
// {
//
// if (jObj.has("result") && jObj.getString("result").equalsIgnoreCase("null"))
// jObj = jObj.getJSONObject("result");
//
// final List<OrganizationalUnit> organizationalUnits = new ArrayList<OrganizationalUnit>();
// jObj.getJSONArray("organizationalUnits");
//
// final Inventory inventory = new Inventory.Builder().deleted(jObj.getBoolean("deleted"))
// .revision(jObj.getLong("revision"))
// .uuid(jObj.getString("uuid"))
// .number(jObj.getString("number"))
// .user(jObj.getString("user"))
// .description(jObj.getString("description"))
// .organizationalUnits(organizationalUnits)
// .createTime(inputDf.parse(jObj.getString("createTime")))
// .processTime(inputDf.parse(jObj.getString("processTime")))
// .inventoryProcedure(jObj.getString("inventoryProcedure"))
// .build();
//
// return inventory;
// }


	public String getUser()
	{
		return user;
	}

	public void setUser(final String user)
	{
		this.user = user;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	public List<OrganizationalUnit> getOrganizationalUnits()
	{
		return organizationalUnits;
	}

	public void setOrganizationalUnits(final List<OrganizationalUnit> organizationalUnits)
	{
		this.organizationalUnits = organizationalUnits;
	}

	public void addOrganizationalUnit(final OrganizationalUnit value)
	{
		if (organizationalUnits == null)
			organizationalUnits = new ArrayList<OrganizationalUnit>();
		this.organizationalUnits.add(value);
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(final Date createTime)
	{
		this.createTime = createTime;
	}

	public Date getProcessTime()
	{
		return processTime;
	}

	public void setProcessTime(final Date processTime)
	{
		this.processTime = processTime;
	}

	public Integer getAutomaticBookingDays()
	{
		return automaticBookingDays;
	}

	public void setAutomaticBookingDays(final Integer automaticBookingDays)
	{
		this.automaticBookingDays = automaticBookingDays;
	}

	public Integer getMaxArticlesPerList()
	{
		return maxArticlesPerList;
	}

	public void setMaxArticlesPerList(final Integer maxArticlesPerList)
	{
		this.maxArticlesPerList = maxArticlesPerList;
	}

	public Boolean getAutomaticBooking()
	{
		return automaticBooking;
	}

	public void setAutomaticBooking(final Boolean automaticBooking)
	{
		this.automaticBooking = automaticBooking;
	}

	public Boolean getFridayInventory()
	{
		return fridayInventory;
	}

	public void setFridayInventory(final Boolean fridayInventory)
	{
		this.fridayInventory = fridayInventory;
	}

	public Boolean getMondayInventory()
	{
		return mondayInventory;
	}

	public void setMondayInventory(final Boolean mondayInventory)
	{
		this.mondayInventory = mondayInventory;
	}

	public Boolean getOneCommodityGroupPerList()
	{
		return oneCommodityGroupPerList;
	}

	public void setOneCommodityGroupPerList(final Boolean oneCommodityGroupPerList)
	{
		this.oneCommodityGroupPerList = oneCommodityGroupPerList;
	}

	public Boolean getSaturdayInventory()
	{
		return saturdayInventory;
	}

	public void setSaturdayInventory(final Boolean saturdayInventory)
	{
		this.saturdayInventory = saturdayInventory;
	}

	public Boolean getSundayInventory()
	{
		return sundayInventory;
	}

	public void setSundayInventory(final Boolean sundayInventory)
	{
		this.sundayInventory = sundayInventory;
	}

	public Boolean getThursdayInventory()
	{
		return thursdayInventory;
	}

	public void setThursdayInventory(final Boolean thursdayInventory)
	{
		this.thursdayInventory = thursdayInventory;
	}

	public Boolean getTuesdayInventory()
	{
		return tuesdayInventory;
	}

	public void setTuesdayInventory(final Boolean tuesdayInventory)
	{
		this.tuesdayInventory = tuesdayInventory;
	}

	public Boolean getWednesdayInventory()
	{
		return wednesdayInventory;
	}

	public void setWednesdayInventory(final Boolean wednesdayInventory)
	{
		this.wednesdayInventory = wednesdayInventory;
	}


// public JSONObject toJSON()
// {
// final JSONObject jObj = new JSONObject();
//
// try
// {
// jObj.put("deleted", deleted);
//
// jObj.put("number", number);
//
// if (revision != null)
// jObj.put("revision", revision);
//
// if (uuid != null)
// jObj.put("uuid", uuid);
//
// jObj.put("user", user);
//
// jObj.put("description", description);
//
//
// if (organizationalUnits != null && !organizationalUnits.isEmpty())
// {
// final JSONArray array = new JSONArray();
// for (final OrganizationalUnit organizationalUnit : organizationalUnits)
// {
// if (organizationalUnit != null)
// array.put(organizationalUnit.toJSON());
// }
// jObj.put("organizationalUnits", array);
// }
//
// jObj.put("createTime", createTime);
//
// jObj.put("processTime", processTime);
//
//
// jObj.put("inventoryProcedure", inventoryProcedure);
// }
// catch (final JSONException e)
// {
//
// e.printStackTrace();
// return null;
// }
//
//
// return jObj;
// }

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
		result = prime * result + ((this.user == null) ? 0 : this.user.hashCode());
		result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
		result = prime * result +
			((this.organizationalUnits == null) ? 0 : this.organizationalUnits.hashCode());
		result = prime * result + ((this.createTime == null) ? 0 : this.createTime.hashCode());
		result = prime * result + ((this.processTime == null) ? 0 : this.processTime.hashCode());
		result = prime * result +
			((this.inventoryProcedure == null) ? 0 : this.inventoryProcedure.hashCode());
		result = prime * result +
			((this.automaticBookingDays == null) ? 0 : this.automaticBookingDays.hashCode());
		result = prime * result +
			((this.maxArticlesPerList == null) ? 0 : this.maxArticlesPerList.hashCode());
		result = prime * result +
			((this.automaticBooking == null) ? 0 : this.automaticBooking.hashCode());
		result = prime * result + ((this.fridayInventory == null) ? 0 : this.user.hashCode());
		result = prime * result +
			((this.mondayInventory == null) ? 0 : this.mondayInventory.hashCode());
		result = prime * result +
			((this.tuesdayInventory == null) ? 0 : this.tuesdayInventory.hashCode());
		result = prime * result +
			((this.wednesdayInventory == null) ? 0 : this.wednesdayInventory.hashCode());
		result = prime * result +
			((this.thursdayInventory == null) ? 0 : this.thursdayInventory.hashCode());
		result = prime * result +
			((this.sundayInventory == null) ? 0 : this.sundayInventory.hashCode());
		result = prime * result +
			((this.saturdayInventory == null) ? 0 : this.saturdayInventory.hashCode());
		result = prime *
			result +
			((this.oneCommodityGroupPerList == null) ? 0 : this.oneCommodityGroupPerList.hashCode());

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
	public Inventory fromJSON(final JSONObject obj) throws JSONException
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
