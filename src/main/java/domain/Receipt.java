package domain;

import java.math.BigDecimal;
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
	private BigDecimal grossTotalAmount;
	private BigDecimal netTotalAmount;
	private BigDecimal taxAmount;
	private BigDecimal grossRevenueAmount;
	private BigDecimal netRevenueAmount;
	private BigDecimal receiptDiscountAmount;
	private BigDecimal receiptDiscountGrossAmount;
	private BigDecimal receiptDiscountNetAmount;
	private BigDecimal zCount;
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
		private BigDecimal grossTotalAmount = null;
		private BigDecimal netTotalAmount = null;
		private BigDecimal taxAmount = null;
		private BigDecimal grossRevenueAmount = null;
		private BigDecimal netRevenueAmount = null;
		private BigDecimal receiptDiscountAmount = null;
		private BigDecimal receiptDiscountGrossAmount = null;
		private BigDecimal receiptDiscountNetAmount = null;
		private BigDecimal zCount = null;
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

		public T grossTotalAmount(final BigDecimal value)
		{
			this.grossTotalAmount = value;
			return self();
		}

		public T netTotalAmount(final BigDecimal value)
		{
			this.netTotalAmount = value;
			return self();
		}

		public T taxAmount(final BigDecimal value)
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

		public T grossRevenueAmount(final BigDecimal value)
		{
			this.grossRevenueAmount = value;
			return self();
		}

		public T netRevenueAmount(final BigDecimal value)
		{
			this.netRevenueAmount = value;
			return self();
		}

		public T receiptDiscountAmount(final BigDecimal value)
		{
			this.receiptDiscountAmount = value;
			return self();
		}

		public T receiptDiscountGrossAmount(final BigDecimal value)
		{
			this.receiptDiscountGrossAmount = value;
			return self();
		}

		public T receiptDiscountNetAmount(final BigDecimal value)
		{
			this.receiptDiscountNetAmount = value;
			return self();
		}

		public T zCount(final BigDecimal value)
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

	public BigDecimal getGrossTotalAmount()
	{
		return grossTotalAmount;
	}

	public void setGrossTotalAmount(final BigDecimal grossTotalAmount)
	{
		this.grossTotalAmount = grossTotalAmount;
	}

	public BigDecimal getNetTotalAmount()
	{
		return netTotalAmount;
	}

	public void setNetTotalAmount(final BigDecimal netTotalAmount)
	{
		this.netTotalAmount = netTotalAmount;
	}

	public BigDecimal getTaxAmount()
	{
		return taxAmount;
	}

	public void setTaxAmount(final BigDecimal taxAmount)
	{
		this.taxAmount = taxAmount;
	}

	public BigDecimal getGrossRevenueAmount()
	{
		return grossRevenueAmount;
	}

	public void setGrossRevenueAmount(final BigDecimal grossRevenueAmount)
	{
		this.grossRevenueAmount = grossRevenueAmount;
	}

	public BigDecimal getNetRevenueAmount()
	{
		return netRevenueAmount;
	}

	public void setNetRevenueAmount(final BigDecimal netRevenueAmount)
	{
		this.netRevenueAmount = netRevenueAmount;
	}

	public BigDecimal getReceiptDiscountAmount()
	{
		return receiptDiscountAmount;
	}

	public void setReceiptDiscountAmount(final BigDecimal receiptDiscountAmount)
	{
		this.receiptDiscountAmount = receiptDiscountAmount;
	}

	public BigDecimal getReceiptDiscountGrossAmount()
	{
		return receiptDiscountGrossAmount;
	}

	public void setReceiptDiscountGrossAmount(final BigDecimal receiptDiscountGrossAmount)
	{
		this.receiptDiscountGrossAmount = receiptDiscountGrossAmount;
	}

	public BigDecimal getReceiptDiscountNetAmount()
	{
		return receiptDiscountNetAmount;
	}

	public void setReceiptDiscountNetAmount(final BigDecimal receiptDiscountNetAmount)
	{
		this.receiptDiscountNetAmount = receiptDiscountNetAmount;
	}

	public BigDecimal getzCount()
	{
		return zCount;
	}

	public void setzCount(final BigDecimal zCount)
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
		appendJSON(obj);
		return obj;
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
			.receiptDiscountGrossAmount(prepareBigDecimal(obj, "receiptDiscountGrossAmount"))
			.voided(obj.getBoolean("voided"))
			.id(obj.getString("uuid"))
			.grossTotalAmount(prepareBigDecimal(obj, "grossTotalAmount"))
			.netTotalAmount(prepareBigDecimal(obj, "netTotalAmount"))
			.taxAmount(prepareBigDecimal(obj, "taxAmount"))
			.grossRevenueAmount(prepareBigDecimal(obj, "grossRevenueAmount"))
			.netRevenueAmount(prepareBigDecimal(obj, "netRevenueAmount"))
			.receiptDiscountAmount(prepareBigDecimal(obj, "receiptDiscountAmount"))
			.receiptDiscountGrossAmount(prepareBigDecimal(obj, "receiptDiscountGrossAmount"))
			.receiptDiscountNetAmount(prepareBigDecimal(obj, "receiptDiscountNetAmount"))
			.creatTime(inputDf.parse(obj.getString("createTime")))
			.modifiedTime(inputDf.parse(obj.getString("modifiedTime")))
			.finishTime(inputDf.parse(obj.getString("finishTime")))
			.build();

		return rec;
	}
}
