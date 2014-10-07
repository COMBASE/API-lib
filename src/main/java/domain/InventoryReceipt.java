package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class InventoryReceipt
{
	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

	private String uuid;

	private final String number;

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

	public InventoryReceipt(final Builder builder)
	{
		this.uuid = builder.uuid;

		this.number = builder.number;

		this.bookingTime = builder.bookingTime;

		this.cashier = builder.cashier;

		this.createTime = builder.createTime;

		this.description = builder.description;

		this.finishTime = builder.finishTime;

		this.modifiedTime = builder.modifiedTime;

		this.pos = builder.pos;

		this.organizationalUnit = builder.organizationalUnit;

		this.user = builder.user;

		this.inventory = builder.inventory;
	}

	public static class Builder
	{
		private String uuid = null;

		private String number = null;

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

		public Builder bookingTime(final Date value)
		{
			bookingTime = value;
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

		public Builder cashier(final Cashier value)
		{
			cashier = value;
			return this;
		}

		public Builder createTime(final Date value)
		{
			createTime = value;
			return this;
		}

		public Builder description(final String value)
		{
			description = value;
			return this;
		}

		public Builder finishTime(final Date value)
		{
			finishTime = value;
			return this;
		}

		public Builder modifiedTime(final Date value)
		{
			modifiedTime = value;
			return this;
		}

		public Builder pos(final POS value)
		{
			pos = value;
			return this;
		}

		public Builder organizationalUnit(final OrganizationalUnit value)
		{
			organizationalUnit = value;
			return this;
		}

		public Builder user(final String value)
		{
			user = value;
			return this;
		}

		public Builder inventory(final Inventory value)
		{
			inventory = value;
			return this;
		}

		public InventoryReceipt build()
		{
			return new InventoryReceipt(this);
		}
	}

	public static InventoryReceipt fromJSON(final JSONObject object) throws JSONException,
		ParseException
	{
		final Cashier cashier = new Cashier.Builder(null).uuid(object.getString("cashier")).build();

		final OrganizationalUnit organizationalUnit = new OrganizationalUnit.Builder(null).uuid(
			object.getString("organizationalUnit")).build();

		final Inventory inventory = new Inventory.Builder().uuid(object.getString("inventory"))
			.build();

		final InventoryReceipt inventoryReceipt = new InventoryReceipt.Builder().uuid(
			object.getString("uuid"))
			.number(object.getString("number"))
			.bookingTime(inputDf.parse(object.getString("bookingTime")))
			.cashier(cashier)
			.createTime(inputDf.parse(object.getString("createTime")))
			.description(object.getString("description"))
			.finishTime(inputDf.parse(object.getString("finishTime")))
			.organizationalUnit(organizationalUnit)
			.inventory(inventory)
			.build();


		return inventoryReceipt;
	}

	public JSONObject toJSON()
	{
		return null;
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

	public String getUuid()
	{
		return uuid;
	}

	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}
}
