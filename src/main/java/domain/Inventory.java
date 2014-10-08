package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Inventory
{
	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

	private boolean deleted;

	// needed to adress a certain Inventory object not touching any API relevent keywordfields
	private String qualifier = null;

	private String number;

	private Long revision;

	private String uuid;

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

	public Inventory(final Builder builder)
	{
		this.number = builder.number;

		this.uuid = builder.uuid;

		this.deleted = builder.deleted;

		this.revision = builder.revision;

		this.user = builder.user;

		this.description = builder.description;

		this.organizationalUnits = builder.organizationalUnits;

		this.createTime = builder.createTime;

		this.processTime = builder.processTime;

		this.inventoryProcedure = builder.inventoryProcedure;

		this.automaticBookingDays = builder.automaticBookingDays;

		this.maxArticlesPerList = builder.maxArticlesPerList;

		this.automaticBooking = builder.automaticBooking;

		this.fridayInventory = builder.fridayInventory;

		this.mondayInventory = builder.mondayInventory;

		this.oneCommodityGroupPerList = builder.oneCommodityGroupPerList;

		this.saturdayInventory = builder.saturdayInventory;

		this.sundayInventory = builder.sundayInventory;

		this.thursdayInventory = builder.thursdayInventory;

		this.tuesdayInventory = builder.tuesdayInventory;

		this.wednesdayInventory = builder.wednesdayInventory;
	}

	public static class Builder
	{
		private String number = null;

		private String uuid = null;

		private boolean deleted = false;

		private Long revision = null;

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


		public Builder number(final String value)
		{
			this.number = value;
			return this;
		}

		public Builder uuid(final String value)
		{
			this.uuid = value;
			return this;
		}

		public Builder user(final String value)
		{
			user = value;
			return this;
		}

		public Builder deleted(final boolean value)
		{
			deleted = value;
			return this;
		}

		public Builder revision(final Long value)
		{
			revision = value;
			return this;
		}

		public Builder description(final String value)
		{
			description = value;
			return this;
		}

		public Builder organizationalUnits(final List<OrganizationalUnit> value)
		{
			organizationalUnits = value;
			return this;
		}

		public Builder createTime(final Date value)
		{
			createTime = value;
			return this;
		}

		public Builder processTime(final Date value)
		{
			processTime = value;
			return this;
		}

		public Builder inventoryProcedure(final String value)
		{
			this.inventoryProcedure = value;
			return this;
		}

		public Builder automaticBookingDays(final Integer value)
		{
			automaticBookingDays = value;
			return this;
		}

		public Builder maxArticlesPerList(final Integer value)
		{
			maxArticlesPerList = value;
			return this;
		}

		public Builder automaticBooking(final Boolean value)
		{
			automaticBooking = value;
			return this;
		}

		public Builder fridayInventory(final Boolean value)
		{
			fridayInventory = value;
			return this;
		}

		public Builder mondayInventory(final Boolean value)
		{
			mondayInventory = value;
			return this;
		}

		public Builder oneCommodityGroupPerList(final Boolean value)
		{
			oneCommodityGroupPerList = value;
			return this;
		}

		public Builder saturdayInventory(final Boolean value)
		{
			saturdayInventory = value;
			return this;
		}

		public Builder sundayInventory(final Boolean value)
		{
			sundayInventory = value;
			return this;
		}

		public Builder thursdayInventory(final Boolean value)
		{
			thursdayInventory = value;
			return this;
		}

		public Builder tuesdayInventory(final Boolean value)
		{
			tuesdayInventory = value;
			return this;
		}

		public Builder wednesdayInventory(final Boolean value)
		{
			wednesdayInventory = value;
			return this;
		}

		public Inventory build()
		{
			return new Inventory(this);
		}
	}

	public static Inventory fromJSON(JSONObject jObj) throws JSONException, ParseException
	{

		if (jObj.has("result") && jObj.getString("result").equalsIgnoreCase("null"))
			jObj = jObj.getJSONObject("result");

		final List<OrganizationalUnit> organizationalUnits = new ArrayList<OrganizationalUnit>();
		jObj.getJSONArray("organizationalUnits");

		final Inventory inventory = new Inventory.Builder().deleted(jObj.getBoolean("deleted"))
			.revision(jObj.getLong("revision"))
			.uuid(jObj.getString("uuid"))
			.number(jObj.getString("number"))
			.user(jObj.getString("user"))
			.description(jObj.getString("description"))
			.organizationalUnits(organizationalUnits)
			.createTime(inputDf.parse(jObj.getString("createTime")))
			.processTime(inputDf.parse(jObj.getString("processTime")))
			.inventoryProcedure(jObj.getString("inventoryProcedure"))
			.build();

		return inventory;
	}


	public String getNumber()
	{
		return number;
	}

	public void setNumber(final String number)
	{
		this.number = number;
	}

	public Long getRevision()
	{
		return revision;
	}

	public void setRevision(final Long revision)
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

	public boolean isDeleted()
	{
		return deleted;
	}

	public void setDeleted(final boolean deleted)
	{
		this.deleted = deleted;
	}

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


	public JSONObject toJSON()
	{
		final JSONObject jObj = new JSONObject();

		try
		{
			jObj.put("deleted", deleted);

			jObj.put("number", number);

			if (revision != null)
				jObj.put("revision", revision);

			if (uuid != null)
				jObj.put("uuid", uuid);

			jObj.put("user", user);

			jObj.put("description", description);


			if (organizationalUnits != null && !organizationalUnits.isEmpty())
			{
				final JSONArray array = new JSONArray();
				for (final OrganizationalUnit organizationalUnit : organizationalUnits)
				{
					if (organizationalUnit != null)
						array.put(organizationalUnit.toJSON());
				}
				jObj.put("organizationalUnits", array);
			}

			jObj.put("createTime", createTime);

			jObj.put("processTime", processTime);


			jObj.put("inventoryProcedure", inventoryProcedure);
		}
		catch (final JSONException e)
		{

			e.printStackTrace();
			return null;
		}


		return jObj;
	}


	public String getQualifier()
	{
		return qualifier;
	}


	public void setQualifier(final String qualifier)
	{
		this.qualifier = qualifier;
	}
}
