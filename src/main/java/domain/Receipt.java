package domain;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Receipt
{

	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
	private boolean deleted;
	private String revision;
	private String uuid;
	private String number;
	private Cashier cashier;
	private Date creatTime;
	private String currency;
	private CustomerGroup customerGroup;
	private Date finishTime;
	private Date modifiedTime;
	private int orderNumber;
	private POS pos;
	private OrganizationalUnit organizationalUnit;
	private Pricelist priceGroup;
	private double grossTotalAmount;
	private double netTotalAmount;
	private double taxAmount;
	private double grossRevenueAmount;
	private double netRevenueAmount;
	private double receiptDiscountAmount;
	private double receiptDiscountGrossAmount;
	private double receiptDiscountNetAmount;
	private double zCount;
	private boolean voided;
	private Customer customer;

	private Receipt(final Builder builder)
	{
		deleted = builder.deleted;
		revision = builder.revision;
		number = builder.number;
		uuid = builder.uuid;
		cashier = builder.cashier;
		creatTime = builder.creatTime;
		currency = builder.currency;
		customerGroup = builder.customerGroup;
		finishTime = builder.finishTime;
		modifiedTime = builder.modifiedTime;
		orderNumber = builder.orderNumber;
		pos = builder.pos;
		organizationalUnit = builder.organizationalUnit;
		priceGroup = builder.priceGroup;
		grossTotalAmount = builder.grossTotalAmount;
		netTotalAmount = builder.netTotalAmount;
		taxAmount = builder.taxAmount;
		grossRevenueAmount = builder.grossRevenueAmount;
		netRevenueAmount = builder.netRevenueAmount;
		receiptDiscountAmount = builder.receiptDiscountAmount;
		receiptDiscountGrossAmount = builder.receiptDiscountGrossAmount;
		receiptDiscountNetAmount = builder.receiptDiscountNetAmount;
		zCount = builder.zCount;
		voided = builder.voided;
		customer = builder.customer;
	}

	public static class Builder
	{
		private boolean deleted = false;
		private String revision = null;
		private String number = null;
		private String uuid = null;
		private Cashier cashier = null;
		private Date creatTime = null;
		private String currency = null;
		private CustomerGroup customerGroup = null;
		private Date finishTime = null;
		private Date modifiedTime = null;
		private int orderNumber = 0;
		private POS pos = null;
		private OrganizationalUnit organizationalUnit = null;
		private final Pricelist priceGroup = null;
		private double grossTotalAmount = 0;
		private double netTotalAmount = 0;
		private double taxAmount = 0;
		private double grossRevenueAmount = 0;
		private double netRevenueAmount = 0;
		private double receiptDiscountAmount = 0;
		private double receiptDiscountGrossAmount = 0;
		private double receiptDiscountNetAmount = 0;
		private double zCount = 0;
		private boolean voided = false;
		private Customer customer = null;

		public Builder()
		{

		}

		public Builder deleted(final boolean value)
		{
			this.deleted = value;
			return this;
		}

		public Builder uuid(final String value)
		{
			this.uuid = value;
			return this;
		}

		public Builder revision(final String value)
		{
			this.revision = value;
			return this;
		}

		public Builder number(final String value)
		{
			this.number = value;
			return this;
		}

		public Builder cashier(final Cashier cash)
		{
			this.cashier = cash;
			return this;
		}

		public Builder creatTime(final Date value)
		{
			this.creatTime = value;
			return this;
		}

		public Builder currency(final String value)
		{
			this.currency = value;
			return this;
		}

		public Builder finishTime(final Date value)
		{
			this.finishTime = value;
			return this;
		}

		public Builder modifiedTime(final Date value)
		{
			this.modifiedTime = value;
			return this;
		}

		public Builder orderNumber(final int value)
		{
			this.orderNumber = value;
			return this;
		}

		public Builder grossTotalAmount(final double value)
		{
			this.grossTotalAmount = value;
			return this;
		}

		public Builder netTotalAmount(final double value)
		{
			this.netTotalAmount = value;
			return this;
		}

		public Builder taxAmount(final double value)
		{
			this.taxAmount = value;
			return this;
		}

		public Builder pos(final POS pos)
		{
			this.pos = pos;
			return this;
		}

		public Builder organizationalUnit(final OrganizationalUnit organizationalUnit)
		{
			this.organizationalUnit = organizationalUnit;
			return this;
		}

		public Builder grossRevenueAmount(final double value)
		{
			this.grossRevenueAmount = value;
			return this;
		}

		public Builder netRevenueAmount(final double value)
		{
			this.netRevenueAmount = value;
			return this;
		}

		public Builder receiptDiscountAmount(final double value)
		{
			this.receiptDiscountAmount = value;
			return this;
		}

		public Builder receiptDiscountGrossAmount(final double value)
		{
			this.receiptDiscountGrossAmount = value;
			return this;
		}

		public Builder receiptDiscountNetAmount(final double value)
		{
			this.receiptDiscountNetAmount = value;
			return this;
		}

		public Builder zCount(final double value)
		{
			this.zCount = value;
			return this;
		}

		public Builder voided(final boolean value)
		{
			this.voided = value;
			return this;
		}

		public Builder customerGroup(final CustomerGroup cGrp)
		{
			this.customerGroup = cGrp;
			return this;
		}

		public Builder customer(final Customer cust)
		{
			this.customer = cust;
			return this;
		}

		public Receipt build()
		{
			return new Receipt(this);
		}
	}

	public JSONObject toJSON()
	{
		final JSONObject obj = new JSONObject();
		try
		{
			obj.put("deleted", deleted);
			obj.put("revision", revision);
			obj.put("uuid", uuid);
			if (number != null)
				obj.put("number", number);

			return obj;
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static Receipt fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");


		final Cashier cash = new Cashier.Builder(null).build();
		cash.setUuid(obj.getString("cashier"));
		final CustomerGroup cGrp = new CustomerGroup.Builder(null).build();
		cGrp.setUuid(obj.getString("customerGroup"));
		final Customer cust = new Customer.Builder().build();
		cust.setUuid(obj.getString("customer"));
		Receipt rec = null;
		try
		{
			rec = new Receipt.Builder().number(obj.getString("number"))
				.deleted(obj.getBoolean("deleted"))
				.revision(obj.getString("revision"))
				.cashier(cash)
				.customerGroup(cGrp)
				.customer(cust)
				.receiptDiscountGrossAmount(obj.getDouble("receiptDiscountGrossAmount"))
				.voided(obj.getBoolean("voided"))
				.uuid(obj.getString("uuid"))
				.grossTotalAmount(obj.getDouble("grossTotalAmount"))
				.netTotalAmount(obj.getDouble("netTotalAmount"))
				.taxAmount(obj.getDouble("taxAmount"))
				.grossRevenueAmount(obj.getDouble("grossRevenueAmount"))
				.netRevenueAmount(obj.getDouble("netRevenueAmount"))
				.receiptDiscountAmount(obj.getDouble("receiptDiscountAmount"))
				.receiptDiscountGrossAmount(obj.getDouble("receiptDiscountGrossAmount"))
				.receiptDiscountNetAmount(obj.getDouble("receiptDiscountNetAmount"))
				.creatTime(inputDf.parse(obj.getString("createTime")))
				.modifiedTime(inputDf.parse(obj.getString("modifiedTime")))
				.finishTime(inputDf.parse(obj.getString("finishTime")))
				.build();
		}
		catch (final ParseException e)
		{
			e.printStackTrace();
		}
		return rec;
	}

	public boolean post() throws IOException
	{

		if (cashier != null && cashier.getUuid() == null)
			cashier.post();

		return CloudLink.getConnector().postData(DataType.receipt, this.toJSON());
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

	public Cashier getCashier()
	{
		return cashier;
	}

	public void setCashier(final Cashier cashier)
	{
		this.cashier = cashier;
	}

	public Date getCreatTime()
	{
		return creatTime;
	}

	public void setCreatTime(final Date creatTime)
	{
		this.creatTime = creatTime;
	}

	public String getCurrency()
	{
		return currency;
	}

	public void setCurrency(final String currency)
	{
		this.currency = currency;
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

	public int getOrderNumber()
	{
		return orderNumber;
	}

	public void setOrderNumber(final int orderNumber)
	{
		this.orderNumber = orderNumber;
	}

	public double getGrossTotalAmount()
	{
		return grossTotalAmount;
	}

	public void setGrossTotalAmount(final double grossTotalAmount)
	{
		this.grossTotalAmount = grossTotalAmount;
	}

	public double getNetTotalAmount()
	{
		return netTotalAmount;
	}

	public void setNetTotalAmount(final double netTotalAmount)
	{
		this.netTotalAmount = netTotalAmount;
	}

	public double getTaxAmount()
	{
		return taxAmount;
	}

	public void setTaxAmount(final double taxAmount)
	{
		this.taxAmount = taxAmount;
	}

	public double getGrossRevenueAmount()
	{
		return grossRevenueAmount;
	}

	public void setGrossRevenueAmount(final double grossRevenueAmount)
	{
		this.grossRevenueAmount = grossRevenueAmount;
	}

	public double getNetRevenueAmount()
	{
		return netRevenueAmount;
	}

	public void setNetRevenueAmount(final double netRevenueAmount)
	{
		this.netRevenueAmount = netRevenueAmount;
	}

	public double getReceiptDiscountAmount()
	{
		return receiptDiscountAmount;
	}

	public void setReceiptDiscountAmount(final double receiptDiscountAmount)
	{
		this.receiptDiscountAmount = receiptDiscountAmount;
	}

	public double getReceiptDiscountGrossAmount()
	{
		return receiptDiscountGrossAmount;
	}

	public void setReceiptDiscountGrossAmount(final double receiptDiscountGrossAmount)
	{
		this.receiptDiscountGrossAmount = receiptDiscountGrossAmount;
	}

	public double getReceiptDiscountNetAmount()
	{
		return receiptDiscountNetAmount;
	}

	public void setReceiptDiscountNetAmount(final double receiptDiscountNetAmount)
	{
		this.receiptDiscountNetAmount = receiptDiscountNetAmount;
	}

	public double getzCount()
	{
		return zCount;
	}

	public void setzCount(final double zCount)
	{
		this.zCount = zCount;
	}

	public boolean getVoided()
	{
		return voided;
	}

	public void setVoided(final boolean voided)
	{
		this.voided = voided;
	}

	public CustomerGroup getCustomerGroup()
	{
		return customerGroup;
	}

	public void setCustomerGroup(final CustomerGroup customerGroup)
	{
		this.customerGroup = customerGroup;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(final Customer customer)
	{
		this.customer = customer;
	}

	public Pricelist getPriceGroup()
	{
		return priceGroup;
	}

	public void setPriceGroup(final Pricelist priceGroup)
	{
		this.priceGroup = priceGroup;
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
		result = prime * result + ((this.currency == null) ? 0 : this.currency.hashCode());
		result = prime * result + ((this.cashier == null) ? 0 : this.cashier.hashCode());
		result = prime * result +
			((this.customerGroup == null) ? 0 : this.customerGroup.hashCode());
		result = prime * result + ((this.priceGroup == null) ? 0 : this.priceGroup.hashCode());


		return result;
	}


}
