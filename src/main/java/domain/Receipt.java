package domain;

import java.text.ParseException;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Receipt extends AbstractNumberApiObject<Receipt>
{
	private static final long serialVersionUID = 889206414092644647L;
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

	protected static abstract class Init<T extends Init<T>> extends AbstractNumberApiObject.Init<T>
	{
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

		public T cashier(final Cashier cash)
		{
			this.cashier = cash;
			return self();
		}

		public T creatTime(final Date value)
		{
			this.creatTime = value;
			return self();
		}

		public T currency(final String value)
		{
			this.currency = value;
			return self();
		}

		public T finishTime(final Date value)
		{
			this.finishTime = value;
			return self();
		}

		public T modifiedTime(final Date value)
		{
			this.modifiedTime = value;
			return self();
		}

		public T orderNumber(final int value)
		{
			this.orderNumber = value;
			return self();
		}

		public T grossTotalAmount(final double value)
		{
			this.grossTotalAmount = value;
			return self();
		}

		public T netTotalAmount(final double value)
		{
			this.netTotalAmount = value;
			return self();
		}

		public T taxAmount(final double value)
		{
			this.taxAmount = value;
			return self();
		}

		public T pos(final POS pos)
		{
			this.pos = pos;
			return self();
		}

		public T organizationalUnit(final OrganizationalUnit organizationalUnit)
		{
			this.organizationalUnit = organizationalUnit;
			return self();
		}

		public T grossRevenueAmount(final double value)
		{
			this.grossRevenueAmount = value;
			return self();
		}

		public T netRevenueAmount(final double value)
		{
			this.netRevenueAmount = value;
			return self();
		}

		public T receiptDiscountAmount(final double value)
		{
			this.receiptDiscountAmount = value;
			return self();
		}

		public T receiptDiscountGrossAmount(final double value)
		{
			this.receiptDiscountGrossAmount = value;
			return self();
		}

		public T receiptDiscountNetAmount(final double value)
		{
			this.receiptDiscountNetAmount = value;
			return self();
		}

		public T zCount(final double value)
		{
			this.zCount = value;
			return self();
		}

		public T voided(final boolean value)
		{
			this.voided = value;
			return self();
		}

		public T customerGroup(final CustomerGroup cGrp)
		{
			this.customerGroup = cGrp;
			return self();
		}

		public T customer(final Customer cust)
		{
			this.customer = cust;
			return self();
		}

		@Override
		public Receipt build()
		{
			return new Receipt(this);
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

	public Receipt(final Init<?> init)
	{
		super(init);
		cashier = init.cashier;
		creatTime = init.creatTime;
		currency = init.currency;
		customerGroup = init.customerGroup;
		finishTime = init.finishTime;
		modifiedTime = init.modifiedTime;
		orderNumber = init.orderNumber;
		pos = init.pos;
		organizationalUnit = init.organizationalUnit;
		priceGroup = init.priceGroup;
		grossTotalAmount = init.grossTotalAmount;
		netTotalAmount = init.netTotalAmount;
		taxAmount = init.taxAmount;
		grossRevenueAmount = init.grossRevenueAmount;
		netRevenueAmount = init.netRevenueAmount;
		receiptDiscountAmount = init.receiptDiscountAmount;
		receiptDiscountGrossAmount = init.receiptDiscountGrossAmount;
		receiptDiscountNetAmount = init.receiptDiscountNetAmount;
		zCount = init.zCount;
		voided = init.voided;
		customer = init.customer;

	}


// public JSONObject toJSON()
// {
// final JSONObject obj = new JSONObject();
// try
// {
// obj.put("deleted", deleted);
// obj.put("revision", revision);
// obj.put("uuid", uuid);
// if (number != null)
// obj.put("number", number);
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
// public static Receipt fromJSON(JSONObject obj) throws JSONException
// {

// }
// catch (final ParseException e)
// {
// e.printStackTrace();
// }
// return rec;
// }
//
// public boolean post() throws IOException
// {
//
// if (cashier != null && cashier.getUuid() == null)
// cashier.post();
//
// return CloudLink.getConnector().postData(DataType.receipt, this.toJSON());
// }

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

		result = super.hashCode(result);
		result = prime * result + ((this.currency == null) ? 0 : this.currency.hashCode());
		result = prime * result + ((this.cashier == null) ? 0 : this.cashier.hashCode());
		result = prime * result +
			((this.customerGroup == null) ? 0 : this.customerGroup.hashCode());
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

	public static Receipt fromJSON(JSONObject obj) throws JSONException, ParseException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");


		final Cashier cash = new Cashier.Builder().build();
		cash.setId(obj.getString("cashier"));
		final CustomerGroup cGrp = new CustomerGroup.Builder().build();
		cGrp.setId(obj.getString("customerGroup"));
		final Customer cust = new Customer.Builder().build();
		cust.setId(obj.getString("customer"));
		Receipt rec = null;
		rec = new Receipt.Builder().number(obj.getString("number"))
			.deleted(obj.getBoolean("deleted"))
			.revision(obj.getLong("revision"))
			.cashier(cash)
			.customerGroup(cGrp)
			.customer(cust)
			.receiptDiscountGrossAmount(obj.getDouble("receiptDiscountGrossAmount"))
			.voided(obj.getBoolean("voided"))
			.id(obj.getString("uuid"))
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

		return rec;
	}
}
