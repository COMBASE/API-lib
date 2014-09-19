package domain;

import java.util.Date;
import java.util.List;

public class Inventory
{
	private String user;

	private String description;

	private List<OrganizationalUnit> organizationalUnits;

	private Date createTime;

	private Date processTime;

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
		this.user = builder.user;

		this.description = builder.description;

		this.organizationalUnits = builder.organizationalUnits;

		this.createTime = builder.createTime;

		this.processTime = builder.processTime;

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
		private String user = null;

		private String description = null;

		private List<OrganizationalUnit> organizationalUnits = null;

		private Date createTime = null;

		private Date processTime = null;

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


		public Builder user(final String value)
		{
			user = value;
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
}
