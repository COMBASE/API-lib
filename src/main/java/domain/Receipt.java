package domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Receipt extends AbstractNumberApiObject<Receipt>
{
	public static class Builder extends Init<Builder>
	{

		@Override
		protected Builder self()
		{
			return this;
		}

	}
	protected static abstract class Init<T extends Init<T>> extends AbstractNumberApiObject.Init<T>
	{
		private Cashier cashier = null;
		private Date creatTime = null;
		private String currency = null;
		private CustomerGroup customerGroup = null;
		private Date finishTime = null;
		private Date modifiedTime = null;
		private Integer orderNumber = null;
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
		private Boolean voided = null;
		private Customer customer = null;

		private String costCenter = null;

		@Override
		public Receipt build()
		{
			return new Receipt(this);
		}

		public T cashier(final Cashier cash)
		{
			this.cashier = cash;
			return self();
		}

		public T costCenter(final String value)
		{
			this.costCenter = value;
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

		public T customer(final Customer cust)
		{
			this.customer = cust;
			return self();
		}

		public T customerGroup(final CustomerGroup cGrp)
		{
			this.customerGroup = cGrp;
			return self();
		}

		public T finishTime(final Date value)
		{
			this.finishTime = value;
			return self();
		}

		public T grossRevenueAmount(final BigDecimal value)
		{
			this.grossRevenueAmount = value;
			return self();
		}

		public T grossTotalAmount(final BigDecimal value)
		{
			this.grossTotalAmount = value;
			return self();
		}

		public T modifiedTime(final Date value)
		{
			this.modifiedTime = value;
			return self();
		}

		public T netRevenueAmount(final BigDecimal value)
		{
			this.netRevenueAmount = value;
			return self();
		}

		public T netTotalAmount(final BigDecimal value)
		{
			this.netTotalAmount = value;
			return self();
		}

		public T orderNumber(final int value)
		{
			this.orderNumber = value;
			return self();
		}

		public T organizationalUnit(final OrganizationalUnit organizationalUnit)
		{
			this.organizationalUnit = organizationalUnit;
			return self();
		}

		public T pos(final POS pos)
		{
			this.pos = pos;
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

		public T taxAmount(final BigDecimal value)
		{
			this.taxAmount = value;
			return self();
		}

		public T voided(final boolean value)
		{
			this.voided = value;
			return self();
		}

		public T zCount(final BigDecimal value)
		{
			this.zCount = value;
			return self();
		}
	}

	private static final long serialVersionUID = 889206414092644647L;

	private Cashier cashier;

	private Date creatTime;
	private String currency;
	private CustomerGroup customerGroup;
	private Date finishTime;
	private Date modifiedTime;
	private Integer orderNumber;
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
	private String contraAccount;

	private String costCenter;

	private Boolean voided;

	private Customer customer;

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
		costCenter = init.costCenter;
	}


// public boolean post() throws IOException
// {
//
// if (cashier != null && cashier.getUuid() == null)
// cashier.post();
//
// return CloudLink.getConnector().postData(DataType.receipt, this.toJSON());
// }

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public Cashier getCashier()
	{
		return cashier;
	}

	public String getContraAccount()
	{
		return contraAccount;
	}

	public String getCostCenter()
	{
		return costCenter;
	}

	public Date getCreatTime()
	{
		return creatTime;
	}

	public String getCurrency()
	{
		return currency;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public CustomerGroup getCustomerGroup()
	{
		return customerGroup;
	}

	public Date getFinishTime()
	{
		return finishTime;
	}

	public BigDecimal getGrossRevenueAmount()
	{
		return grossRevenueAmount;
	}

	public BigDecimal getGrossTotalAmount()
	{
		return grossTotalAmount;
	}

	public Date getModifiedTime()
	{
		return modifiedTime;
	}

	public BigDecimal getNetRevenueAmount()
	{
		return netRevenueAmount;
	}

	public BigDecimal getNetTotalAmount()
	{
		return netTotalAmount;
	}

	public int getOrderNumber()
	{
		return orderNumber;
	}

	public OrganizationalUnit getOrganizationalUnit()
	{
		return organizationalUnit;
	}

	public POS getPos()
	{
		return pos;
	}

	public Pricelist getPriceGroup()
	{
		return priceGroup;
	}

	public BigDecimal getReceiptDiscountAmount()
	{
		return receiptDiscountAmount;
	}

	public BigDecimal getReceiptDiscountGrossAmount()
	{
		return receiptDiscountGrossAmount;
	}

	public BigDecimal getReceiptDiscountNetAmount()
	{
		return receiptDiscountNetAmount;
	}

	public BigDecimal getTaxAmount()
	{
		return taxAmount;
	}

	public Boolean getVoided()
	{
		return voided;
	}

	public BigDecimal getzCount()
	{
		return zCount;
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

	public void setCashier(final Cashier cashier)
	{
		this.cashier = cashier;
	}

	public void setContraAccount(final String contraAccount)
	{
		this.contraAccount = contraAccount;
	}

	public void setCostCenter(final String costCenter)
	{
		this.costCenter = costCenter;
	}

	public void setCreatTime(final Date creatTime)
	{
		this.creatTime = creatTime;
	}

	public void setCurrency(final String currency)
	{
		this.currency = currency;
	}

	public void setCustomer(final Customer customer)
	{
		this.customer = customer;
	}

	public void setCustomerGroup(final CustomerGroup customerGroup)
	{
		this.customerGroup = customerGroup;
	}

	public void setFinishTime(final Date finishTime)
	{
		this.finishTime = finishTime;
	}

	public void setGrossRevenueAmount(final BigDecimal grossRevenueAmount)
	{
		this.grossRevenueAmount = grossRevenueAmount;
	}

	public void setGrossTotalAmount(final BigDecimal grossTotalAmount)
	{
		this.grossTotalAmount = grossTotalAmount;
	}

	public void setModifiedTime(final Date modifiedTime)
	{
		this.modifiedTime = modifiedTime;
	}

	public void setNetRevenueAmount(final BigDecimal netRevenueAmount)
	{
		this.netRevenueAmount = netRevenueAmount;
	}

	public void setNetTotalAmount(final BigDecimal netTotalAmount)
	{
		this.netTotalAmount = netTotalAmount;
	}

	public void setOrderNumber(final int orderNumber)
	{
		this.orderNumber = orderNumber;
	}

	public void setOrganizationalUnit(final OrganizationalUnit organizationalUnit)
	{
		this.organizationalUnit = organizationalUnit;
	}

	public void setPos(final POS pos)
	{
		this.pos = pos;
	}

	public void setPriceGroup(final Pricelist priceGroup)
	{
		this.priceGroup = priceGroup;
	}

	public void setReceiptDiscountAmount(final BigDecimal receiptDiscountAmount)
	{
		this.receiptDiscountAmount = receiptDiscountAmount;
	}

	public void setReceiptDiscountGrossAmount(final BigDecimal receiptDiscountGrossAmount)
	{
		this.receiptDiscountGrossAmount = receiptDiscountGrossAmount;
	}

	public void setReceiptDiscountNetAmount(final BigDecimal receiptDiscountNetAmount)
	{
		this.receiptDiscountNetAmount = receiptDiscountNetAmount;
	}

	public void setTaxAmount(final BigDecimal taxAmount)
	{
		this.taxAmount = taxAmount;
	}


	public void setVoided(final boolean voided)
	{
		this.voided = voided;
	}


	public void setzCount(final BigDecimal zCount)
	{
		this.zCount = zCount;
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
		{
			obj = obj.getJSONObject("result");
		}


		final Cashier cash = new Cashier.Builder().build();
		cash.setId(obj.getString("cashier"));

		final CustomerGroup cGrp = new CustomerGroup.Builder().build();
		cGrp.setId(obj.getString("customerGroup"));

		Customer cust = null;
		if (!obj.isNull("customer"))
		{
			cust = new Customer.Builder().build();
			cust.setId(obj.getString("customer"));
			cust.setNumber(obj.getString("customerNr"));
			cust.setZipCode((obj.getString("customerZip").equalsIgnoreCase("null") ? null
				: obj.getString("customerZip")));
		}

		final Receipt rec = new Receipt.Builder().number(obj.getString("number"))
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
			.creatTime(prepareDate(obj, "createTime"))
			.modifiedTime(prepareDate(obj, "modifiedTime"))
			.finishTime(prepareDate(obj, "finishTime"))
			.costCenter(obj.getString("costCenter"))
			.build();

		return rec;
	}
}
