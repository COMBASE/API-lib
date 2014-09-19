package domain;

import java.util.Date;

public class InventoryReceipt
{
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
}
