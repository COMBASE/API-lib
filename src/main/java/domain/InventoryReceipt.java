package domain;

import java.text.ParseException;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class InventoryReceipt extends AbstractNumberApiObject<InventoryReceipt>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2039817144646051158L;

	private Date bookingTime;

	private Cashier cashier;

	private Date createTime;

	private String description;

	private Date finishTime;

	private Date modifiedTime;

	private POS pos;

	private OrganizationalUnit organizationalUnit;

	private String user;

	private Inventory inventory;

	protected static abstract class Init<T extends Init<T>> extends AbstractNumberApiObject.Init<T>
	{
		private Date bookingTime = null;

		private Cashier cashier = null;

		private Date createTime = null;

		private String description = null;

		private Date finishTime = null;

		private Date modifiedTime = null;

		private POS pos = null;

		private OrganizationalUnit organizationalUnit = null;

		private String user = null;

		private Inventory inventory = null;

		public T bookingTime(final Date value)
		{
			bookingTime = value;
			return self();
		}

		public T cashier(final Cashier value)
		{
			cashier = value;
			return self();
		}

		public T createTime(final Date value)
		{
			createTime = value;
			return self();
		}

		public T description(final String value)
		{
			description = value;
			return self();
		}

		public T finishTime(final Date value)
		{
			finishTime = value;
			return self();
		}

		public T modifiedTime(final Date value)
		{
			modifiedTime = value;
			return self();
		}

		public T pos(final POS value)
		{
			pos = value;
			return self();
		}

		public T organizationalUnit(final OrganizationalUnit value)
		{
			organizationalUnit = value;
			return self();
		}

		public T user(final String value)
		{
			user = value;
			return self();
		}

		public T inventory(final Inventory value)
		{
			inventory = value;
			return self();
		}

		@Override
		public InventoryReceipt build()
		{
			return new InventoryReceipt(this);
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

	public InventoryReceipt(final Init<?> init)
	{
		super(init);

		this.bookingTime = init.bookingTime;

		this.cashier = init.cashier;

		this.createTime = init.createTime;

		this.description = init.description;

		this.finishTime = init.finishTime;

		this.modifiedTime = init.modifiedTime;

		this.pos = init.pos;

		this.organizationalUnit = init.organizationalUnit;

		this.user = init.user;

		this.inventory = init.inventory;
	}

	public Date getBookingTime()
	{
		return bookingTime;
	}

	public void setBookingTime(final Date bookingTime)
	{
		this.bookingTime = bookingTime;
	}

	public Cashier getCashier()
	{
		return cashier;
	}

	public void setCashier(final Cashier cashier)
	{
		this.cashier = cashier;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(final Date createTime)
	{
		this.createTime = createTime;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	public Date getFinishTime()
	{
		return finishTime;
	}

	public void setFinishTime(final Date finishTime)
	{
		this.finishTime = finishTime;
	}

	public Date getModifiedTime()
	{
		return modifiedTime;
	}

	public void setModifiedTime(final Date modifiedTime)
	{
		this.modifiedTime = modifiedTime;
	}

	public POS getPos()
	{
		return pos;
	}

	public void setPos(final POS pos)
	{
		this.pos = pos;
	}

	public OrganizationalUnit getOrganizationalUnit()
	{
		return organizationalUnit;
	}

	public void setOrganizationalUnit(final OrganizationalUnit organizationalUnit)
	{
		this.organizationalUnit = organizationalUnit;
	}

	public String getUser()
	{
		return user;
	}

	public void setUser(final String user)
	{
		this.user = user;
	}

	public Inventory getInventory()
	{
		return inventory;
	}

	public void setInventory(final Inventory inventory)
	{
		this.inventory = inventory;
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
		result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
		result = prime * result + ((this.user == null) ? 0 : this.user.hashCode());
		result = prime * result + ((this.bookingTime == null) ? 0 : this.bookingTime.hashCode());
		result = prime * result + ((this.cashier == null) ? 0 : this.cashier.hashCode());
		result = prime * result + ((this.createTime == null) ? 0 : this.createTime.hashCode());
		result = prime * result + ((this.finishTime == null) ? 0 : this.finishTime.hashCode());
		result = prime * result + ((this.modifiedTime == null) ? 0 : this.modifiedTime.hashCode());
		result = prime * result + ((this.pos == null) ? 0 : this.pos.hashCode());
		result = prime * result +
			((this.organizationalUnit == null) ? 0 : this.organizationalUnit.hashCode());
		result = prime * result + ((this.inventory == null) ? 0 : this.inventory.hashCode());

		return result;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		appendJSON(obj);
		return obj;
	}

	public static InventoryReceipt fromJSON(final JSONObject obj) throws JSONException,
		ParseException
	{
		final Cashier cashier = new Cashier.Builder().id(obj.getString("cashier")).build();

		final OrganizationalUnit organizationalUnit = new OrganizationalUnit.Builder().id(
			obj.getString("organizationalUnit")).build();

		final Inventory inventory = new Inventory.Builder().id(obj.getString("inventory")).build();

		final InventoryReceipt inventoryReceipt = new InventoryReceipt.Builder().id(
			obj.getString("uuid"))
			.number(obj.getString("number"))
			.bookingTime(inputDf.parse(obj.getString("bookingTime")))
			.cashier(cashier)
			.createTime(inputDf.parse(obj.getString("createTime")))
			.description(obj.getString("description"))
			.finishTime(inputDf.parse(obj.getString("finishTime")))
			.organizationalUnit(organizationalUnit)
			.inventory(inventory)
			.build();


		return inventoryReceipt;
	}
}
