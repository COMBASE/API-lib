package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class OrganizationalUnit extends AbstractNameAndNumberApiObject<OrganizationalUnit>
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
		private OrganizationalUnit parent = null;

		private EconomicZone economicZone = null;

		private List<AssortmentValidity> assortmentValidities = null;

		// private SupplierCaseEntityInformationReadable addressInformation=null;

		private Pricelist priceGroup = null;

		private List<OrganizationalUnit> orderingSources = null;

		private BigDecimal storageSpace = null;

		private BigDecimal salesArea = null;

		private Boolean mondayOpen = null;

		private Boolean tuesdayOpen = null;

		private Boolean wednesdayOpen = null;

		private Boolean thursdayOpen = null;

		private Boolean fridayOpen = null;

		private Boolean saturdayOpen = null;

		private Boolean sundayOpen = null;

		private Boolean hasChildren = null;

		private Date mondayFrom = null;

		private Date tuesdayFrom = null;

		private Date wednesdayFrom = null;

		private Date thursdayFrom = null;

		private Date fridayFrom = null;

		private Date saturdayFrom = null;

		private Date sundayFrom = null;

		private Date mondayTo = null;

		private Date tuesdayTo = null;

		private Date wednesdayTo = null;

		private Date thursdayTo = null;

		private Date fridayTo = null;

		private Date saturdayTo = null;

		private Date sundayTo = null;

		private Integer centralityIndex = null;// Zentralitätsindex (integer)

		private Long ehNumber = null;

		private BigDecimal monthlyOperatingCostsRent = null;// monatliche Kosten
		// Betrieb/Miete

		private BigDecimal monthlyStaffCosts = null;// monatliche Kosten Personal

		private BigDecimal stretchZone = null;

		private BigDecimal viewingZone = null;

		private BigDecimal gripZone = null;

		private BigDecimal bendZone = null;

		private Boolean warehouse = null;

		public T assortmentValidities(final List<AssortmentValidity> value)
		{
			assortmentValidities = value;
			return self();
		}

		public T bendZone(final BigDecimal value)
		{
			bendZone = value;
			return self();
		}

		@Override
		public OrganizationalUnit build()
		{
			return new OrganizationalUnit(this);
		}

		// private SupplierCaseEntityInformationReadable addressInformation=null;

		public T centralityIndex(final int value)
		{
			centralityIndex = value;
			return self();
		}// Zentralitätsindex (integer)

		public T economicZone(final EconomicZone value)
		{
			economicZone = value;
			return self();
		}

		public T ehNumber(final Long value)
		{
			ehNumber = value;
			return self();
		}

		public T fridayFrom(final Date value)
		{
			fridayFrom = value;
			return self();
		}

		public T fridayOpen(final Boolean value)
		{
			fridayOpen = value;
			return self();
		}

		public T fridayTo(final Date value)
		{
			fridayTo = value;
			return self();
		}

		public T gripZone(final BigDecimal value)
		{
			gripZone = value;
			return self();
		}

		public T hasChildren(final Boolean value)
		{
			hasChildren = value;
			return self();
		}

		public T mondayFrom(final Date value)
		{
			mondayFrom = value;
			return self();
		}

		public T mondayOpen(final Boolean value)
		{
			mondayOpen = value;
			return self();
		}

		public T mondayTo(final Date value)
		{
			mondayTo = value;
			return self();
		}

		public T monthlyOperatingCostsRent(final BigDecimal value)
		{
			monthlyOperatingCostsRent = value;
			return self();
		}// monatliche Kosten

		public T monthlyStaffCosts(final BigDecimal value)
		{
			monthlyStaffCosts = value;
			return self();
		}// monatliche Kosten Personal

		public T orderingSources(final List<OrganizationalUnit> value)
		{
			orderingSources = value;
			return self();
		}

		public T parent(final OrganizationalUnit value)
		{
			parent = value;
			return self();
		}

		public T priceGroup(final Pricelist value)
		{
			priceGroup = value;
			return self();
		}

		public T salesArea(final BigDecimal value)
		{
			salesArea = value;
			return self();
		}

		public T saturdayFrom(final Date value)
		{
			saturdayFrom = value;
			return self();
		}

		public T saturdayOpen(final Boolean value)
		{
			saturdayOpen = value;
			return self();
		}

		public T saturdayTo(final Date value)
		{
			saturdayTo = value;
			return self();
		}

		public T storageSpace(final BigDecimal value)
		{
			storageSpace = value;
			return self();
		}

		public T stretchZone(final BigDecimal value)
		{
			stretchZone = value;
			return self();
		}

		public T sundayFrom(final Date value)
		{
			sundayFrom = value;
			return self();
		}

		public T sundayOpen(final Boolean value)
		{
			sundayOpen = value;
			return self();
		}

		public T sundayTo(final Date value)
		{
			sundayTo = value;
			return self();
		}

		public T thursdayFrom(final Date value)
		{
			thursdayFrom = value;
			return self();
		}

		public T thursdayOpen(final Boolean value)
		{
			thursdayOpen = value;
			return self();
		}

		public T thursdayTo(final Date value)
		{
			thursdayTo = value;
			return self();
		}

		public T tuesdayFrom(final Date value)
		{
			tuesdayFrom = value;
			return self();
		}

		// Betrieb/Miete

		public T tuesdayOpen(final Boolean value)
		{
			tuesdayOpen = value;
			return self();
		}

		public T tuesdayTo(final Date value)
		{
			tuesdayTo = value;
			return self();
		}

		public T viewingZone(final BigDecimal value)
		{
			viewingZone = value;
			return self();
		}

		public T warehouse(final Boolean value)
		{
			warehouse = value;
			return self();
		}

		public T wednesdayFrom(final Date value)
		{
			wednesdayFrom = value;
			return self();
		}

		public T wednesdayOpen(final Boolean value)
		{
			wednesdayOpen = value;
			return self();
		}


		public T wednesdayTo(final Date value)
		{
			wednesdayTo = value;
			return self();
		}
	}

	private static final long serialVersionUID = -5837677863056916822L;

	public static OrganizationalUnit fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");
		final OrganizationalUnit orgUnit = new OrganizationalUnit.Builder().name(
			obj.getString("name"))
			.deleted(obj.getBoolean("deleted"))
			.number(obj.getString("number"))
			.id(obj.getString("uuid"))
			.revision(obj.getLong("revision"))
			.build();
		return orgUnit;
	}

	// private SupplierCaseEntityInformationReadable addressInformation;

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	private OrganizationalUnit parent;

	private EconomicZone economicZone;

	private List<AssortmentValidity> assortmentValidities = new ArrayList<AssortmentValidity>();

	private Pricelist priceGroup;

	private List<OrganizationalUnit> orderingSources = new ArrayList<OrganizationalUnit>();

	private BigDecimal storageSpace;

	private BigDecimal salesArea;

	private Boolean mondayOpen;

	private Boolean tuesdayOpen;

	private Boolean wednesdayOpen;

	private Boolean thursdayOpen;

	private Boolean fridayOpen;

	private Boolean saturdayOpen;

	private Boolean sundayOpen;

	private Boolean hasChildren;

	private Date mondayFrom;

	private Date tuesdayFrom;

	private Date wednesdayFrom;

	private Date thursdayFrom;

	private Date fridayFrom;

	private Date saturdayFrom;

	private Date sundayFrom;

	private Date mondayTo;

	private Date tuesdayTo;

	private Date wednesdayTo;

	private Date thursdayTo;

	private Date fridayTo;

	private Date saturdayTo;

	private Date sundayTo;

	private Integer centralityIndex;// Zentralitätsindex (integer)

	private Long ehNumber;

	private BigDecimal monthlyOperatingCostsRent;// monatliche Kosten
	// Betrieb/Miete

	private BigDecimal monthlyStaffCosts;// monatliche Kosten Personal

	private BigDecimal stretchZone;

	private BigDecimal viewingZone;

	private BigDecimal gripZone;

	private BigDecimal bendZone;

	private Boolean warehouse;

	private OrganizationalUnit(final Init<?> init)
	{
		super(init);

		parent = init.parent;

		economicZone = init.economicZone;

		assortmentValidities = init.assortmentValidities;

		// private SupplierCaseEntityInformationReadable addressInformation=init.blubb;

		priceGroup = init.priceGroup;

		orderingSources = init.orderingSources;

		storageSpace = init.storageSpace;

		salesArea = init.salesArea;

		mondayOpen = init.mondayOpen;

		tuesdayOpen = init.tuesdayOpen;

		wednesdayOpen = init.wednesdayOpen;

		thursdayOpen = init.thursdayOpen;

		fridayOpen = init.fridayOpen;

		saturdayOpen = init.saturdayOpen;

		sundayOpen = init.sundayOpen;

		hasChildren = init.hasChildren;

		mondayFrom = init.mondayFrom;

		tuesdayFrom = init.tuesdayFrom;

		wednesdayFrom = init.wednesdayFrom;

		thursdayFrom = init.thursdayFrom;

		fridayFrom = init.fridayFrom;

		saturdayFrom = init.saturdayFrom;

		sundayFrom = init.sundayFrom;

		mondayTo = init.mondayTo;

		tuesdayTo = init.tuesdayTo;

		wednesdayTo = init.wednesdayTo;

		thursdayTo = init.thursdayTo;

		fridayTo = init.fridayTo;

		saturdayTo = init.saturdayTo;

		sundayTo = init.sundayTo;

		centralityIndex = init.centralityIndex;// Zentralitätsindex (integer)

		ehNumber = init.ehNumber;

		monthlyOperatingCostsRent = init.monthlyOperatingCostsRent;// monatliche Kosten
		// Betrieb/Miete

		monthlyStaffCosts = init.monthlyStaffCosts;// monatliche Kosten Personal

		stretchZone = init.stretchZone;

		viewingZone = init.viewingZone;

		gripZone = init.gripZone;

		bendZone = init.bendZone;

		warehouse = init.warehouse;
	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public List<AssortmentValidity> getAssortmentValidities()
	{
		return assortmentValidities;
	}

	public BigDecimal getBendZone()
	{
		return bendZone;
	}

	public Integer getCentralityIndex()
	{
		return centralityIndex;
	}

	public EconomicZone getEconomicZone()
	{
		return economicZone;
	}

	public Long getEhNumber()
	{
		return ehNumber;
	}

	public Date getFridayFrom()
	{
		return fridayFrom;
	}

	public Date getFridayTo()
	{
		return fridayTo;
	}

	public BigDecimal getGripZone()
	{
		return gripZone;
	}

	public Date getMondayFrom()
	{
		return mondayFrom;
	}

	public Date getMondayTo()
	{
		return mondayTo;
	}

	public BigDecimal getMonthlyOperatingCostsRent()
	{
		return monthlyOperatingCostsRent;
	}

	public BigDecimal getMonthlyStaffCosts()
	{
		return monthlyStaffCosts;
	}

	public List<OrganizationalUnit> getOrderingSources()
	{
		return orderingSources;
	}

	public Pricelist getPriceGroup()
	{
		return priceGroup;
	}

	public Date getSaturdayFrom()
	{
		return saturdayFrom;
	}

	public Date getSaturdayTo()
	{
		return saturdayTo;
	}

	public BigDecimal getStretchZone()
	{
		return stretchZone;
	}

	public Date getSundayFrom()
	{
		return sundayFrom;
	}

	public Date getSundayTo()
	{
		return sundayTo;
	}

	public Date getThursdayFrom()
	{
		return thursdayFrom;
	}

	public Date getThursdayTo()
	{
		return thursdayTo;
	}

	public Date getTuesdayFrom()
	{
		return tuesdayFrom;
	}

	public Date getTuesdayTo()
	{
		return tuesdayTo;
	}

	public BigDecimal getViewingZone()
	{
		return viewingZone;
	}

	public Date getWednesdayFrom()
	{
		return wednesdayFrom;
	}

	public Date getWednesdayTo()
	{
		return wednesdayTo;
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
		result = prime * result +
			((this.assortmentValidities == null) ? 0 : this.assortmentValidities.hashCode());
		result = prime * result + ((this.bendZone == null) ? 0 : this.bendZone.hashCode());
		result = prime * result + ((this.economicZone == null) ? 0 : this.economicZone.hashCode());
		result = prime * result + ((this.fridayFrom == null) ? 0 : this.fridayFrom.hashCode());
		result = prime * result + ((this.fridayOpen == null) ? 0 : this.fridayOpen.hashCode());
		result = prime * result + ((this.fridayTo == null) ? 0 : this.fridayTo.hashCode());
		result = prime * result + ((this.gripZone == null) ? 0 : this.gripZone.hashCode());
		result = prime * result + ((this.hasChildren == null) ? 0 : this.hasChildren.hashCode());
		result = prime * result + ((this.mondayFrom == null) ? 0 : this.mondayFrom.hashCode());
		result = prime * result + ((this.mondayOpen == null) ? 0 : this.mondayOpen.hashCode());
		result = prime * result + ((this.mondayTo == null) ? 0 : this.mondayTo.hashCode());
		result = prime *
			result +
			((this.monthlyOperatingCostsRent == null) ? 0
				: this.monthlyOperatingCostsRent.hashCode());
		result = prime * result +
			((this.monthlyStaffCosts == null) ? 0 : this.monthlyStaffCosts.hashCode());
		result = prime * result +
			((this.orderingSources == null) ? 0 : this.orderingSources.hashCode());
		result = prime * result + ((this.parent == null) ? 0 : this.parent.hashCode());
		result = prime * result + ((this.priceGroup == null) ? 0 : this.priceGroup.hashCode());
		result = prime * result + ((this.salesArea == null) ? 0 : this.salesArea.hashCode());
		result = prime * result + ((this.saturdayFrom == null) ? 0 : this.saturdayFrom.hashCode());
		result = prime * result + ((this.saturdayOpen == null) ? 0 : this.saturdayOpen.hashCode());
		result = prime * result + ((this.saturdayTo == null) ? 0 : this.saturdayTo.hashCode());
		result = prime * result + ((this.storageSpace == null) ? 0 : this.storageSpace.hashCode());
		result = prime * result + ((this.stretchZone == null) ? 0 : this.stretchZone.hashCode());
		result = prime * result + ((this.sundayFrom == null) ? 0 : this.sundayFrom.hashCode());


		return result;
	}

	public Boolean isFridayOpen()
	{
		return fridayOpen;
	}

	public Boolean isHasChildren()
	{
		return hasChildren;
	}

	public Boolean isMondayOpen()
	{
		return mondayOpen;
	}

	public Boolean isSaturdayOpen()
	{
		return saturdayOpen;
	}

	public Boolean isSundayOpen()
	{
		return sundayOpen;
	}

	public Boolean isThursdayOpen()
	{
		return thursdayOpen;
	}

	public Boolean isTuesdayOpen()
	{
		return tuesdayOpen;
	}

	public Boolean isWarehouse()
	{
		return warehouse;
	}

	public Boolean isWednesdayOpen()
	{
		return wednesdayOpen;
	}

	public void setAssortmentValidities(final List<AssortmentValidity> assortmentValidities)
	{
		this.assortmentValidities = assortmentValidities;
	}

	public void setBendZone(final BigDecimal bendZone)
	{
		this.bendZone = bendZone;
	}

	public void setCentralityIndex(final Integer centralityIndex)
	{
		this.centralityIndex = centralityIndex;
	}

	public void setEconomicZone(final EconomicZone economicZone)
	{
		this.economicZone = economicZone;
	}

	public void setEhNumber(final Long ehNumber)
	{
		this.ehNumber = ehNumber;
	}

	public void setFridayFrom(final Date fridayFrom)
	{
		this.fridayFrom = fridayFrom;
	}

	public void setFridayOpen(final Boolean fridayOpen)
	{
		this.fridayOpen = fridayOpen;
	}

	public void setFridayTo(final Date fridayTo)
	{
		this.fridayTo = fridayTo;
	}

	public void setGripZone(final BigDecimal gripZone)
	{
		this.gripZone = gripZone;
	}

	public void setHasChildren(final Boolean hasChildren)
	{
		this.hasChildren = hasChildren;
	}

	public void setMondayFrom(final Date mondayFrom)
	{
		this.mondayFrom = mondayFrom;
	}

	public void setMondayOpen(final Boolean mondayOpen)
	{
		this.mondayOpen = mondayOpen;
	}

	public void setMondayTo(final Date mondayTo)
	{
		this.mondayTo = mondayTo;
	}

	public void setMonthlyOperatingCostsRent(final BigDecimal monthlyOperatingCostsRent)
	{
		this.monthlyOperatingCostsRent = monthlyOperatingCostsRent;
	}

	public void setMonthlyStaffCosts(final BigDecimal monthlyStaffCosts)
	{
		this.monthlyStaffCosts = monthlyStaffCosts;
	}

	public void setOrderingSources(final List<OrganizationalUnit> orderingSources)
	{
		this.orderingSources = orderingSources;
	}

	public void setParent(final OrganizationalUnit parent)
	{
		this.parent = parent;
	}

	public void setPriceGroup(final Pricelist priceGroup)
	{
		this.priceGroup = priceGroup;
	}

	public void setSalesArea(final BigDecimal salesArea)
	{
		this.salesArea = salesArea;
	}

	public void setSaturdayFrom(final Date saturdayFrom)
	{
		this.saturdayFrom = saturdayFrom;
	}

	public void setSaturdayOpen(final Boolean saturdayOpen)
	{
		this.saturdayOpen = saturdayOpen;
	}

	public void setSaturdayTo(final Date saturdayTo)
	{
		this.saturdayTo = saturdayTo;
	}

	public void setStorageSpace(final BigDecimal storageSpace)
	{
		this.storageSpace = storageSpace;
	}

	public void setStretchZone(final BigDecimal stretchZone)
	{
		this.stretchZone = stretchZone;
	}

	public void setSundayFrom(final Date sundayFrom)
	{
		this.sundayFrom = sundayFrom;
	}

	public void setSundayOpen(final Boolean sundayOpen)
	{
		this.sundayOpen = sundayOpen;
	}

	public void setSundayTo(final Date sundayTo)
	{
		this.sundayTo = sundayTo;
	}

	public void setThursdayFrom(final Date thursdayFrom)
	{
		this.thursdayFrom = thursdayFrom;
	}

	public void setThursdayOpen(final Boolean thursdayOpen)
	{
		this.thursdayOpen = thursdayOpen;
	}

	public void setThursdayTo(final Date thursdayTo)
	{
		this.thursdayTo = thursdayTo;
	}

	public void setTuesdayFrom(final Date tuesdayFrom)
	{
		this.tuesdayFrom = tuesdayFrom;
	}

	public void setTuesdayOpen(final Boolean tuesdayOpen)
	{
		this.tuesdayOpen = tuesdayOpen;
	}

	public void setTuesdayTo(final Date tuesdayTo)
	{
		this.tuesdayTo = tuesdayTo;
	}

	public void setViewingZone(final BigDecimal viewingZone)
	{
		this.viewingZone = viewingZone;
	}

	public void setWarehouse(final Boolean warehouse)
	{
		this.warehouse = warehouse;
	}

	public void setWednesdayFrom(final Date wednesdayFrom)
	{
		this.wednesdayFrom = wednesdayFrom;
	}

	public void setWednesdayOpen(final Boolean wednesdayOpen)
	{
		this.wednesdayOpen = wednesdayOpen;
	}

	public void setWednesdayTo(final Date wednesdayTo)
	{
		this.wednesdayTo = wednesdayTo;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		appendJSON(obj);

		obj.put("parent", parent);

		if (!assortmentValidities.isEmpty())
		{
			final JSONArray array = new JSONArray();
			for (final AssortmentValidity assortmentValidity : assortmentValidities)
			{
				array.put(assortmentValidity.toJSON());
			}
			obj.put("assortmentValidities", array);
		}

		if (priceGroup != null)
			obj.put("priceGroup", priceGroup.getId());

		if (economicZone != null)
			obj.put("economicZone", economicZone.getId());

		if (!orderingSources.isEmpty())
		{
			final JSONArray array = new JSONArray();
			for (final OrganizationalUnit organizationalUnit : orderingSources)
			{
				array.put(organizationalUnit.toJSON());
			}
			obj.put("orderingSources", array);
		}

		obj.put("storageSpace", storageSpace);
		obj.put("salesArea", salesArea);
		obj.put("mondayOpen", mondayOpen);
		obj.put("tuesdayOpen", tuesdayOpen);
		obj.put("wednesdayOpen", wednesdayOpen);
		obj.put("thursdayOpen", thursdayOpen);
		obj.put("fridayOpen", fridayOpen);
		obj.put("saturdayOpen", saturdayOpen);
		obj.put("sundayOpen", sundayOpen);
		obj.put("hasChildren", hasChildren);
		obj.put("mondayFrom", mondayFrom);
		obj.put("tuesdayFrom", tuesdayFrom);
		obj.put("wednesdayFrom", wednesdayFrom);
		obj.put("thursdayFrom", thursdayFrom);
		obj.put("fridayFrom", fridayFrom);
		obj.put("saturdayFrom", saturdayFrom);
		obj.put("sundayFrom", sundayFrom);
		obj.put("mondayTo", mondayTo);
		obj.put("tuesdayTo", tuesdayTo);
		obj.put("wednesdayTo", wednesdayTo);
		obj.put("thursdayTo", thursdayTo);
		obj.put("fridayTo", fridayTo);
		obj.put("saturdayTo", saturdayTo);
		obj.put("sundayTo", sundayTo);
		obj.put("centralityIndex", centralityIndex);
		obj.put("ehNumber", ehNumber);
		obj.put("monthlyOperatingCostsRent", monthlyOperatingCostsRent);
		obj.put("monthlyStaffCosts", monthlyStaffCosts);
		obj.put("stretchZone", stretchZone);
		obj.put("viewingZone", viewingZone);
		obj.put("gripZone", gripZone);
		obj.put("bendZone", bendZone);
		obj.put("warehouse", warehouse);

		return obj;
	}
}
