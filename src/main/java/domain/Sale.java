package domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Sale extends AbstractApiObject<Sale>
{
	public static class Builder extends Init<Builder>
	{

		@Override
		protected Builder self()
		{
			return this;
		}

	}
	protected static abstract class Init<T extends Init<T>> extends AbstractApiObject.Init<T>
	{
		private Product article = null;
		private Cashier cashier = null;
		private CommodityGroup commodityGroup = null;
		private Date bookingTime = null;
		private String description = null;
		private String infoTexts = null;
		private Sector sector = null;
		private String receiptNumber = null;
		private Integer receiptIndex = null;
		private BigDecimal quantity = null;
		private Receipt receipt = null;
		private BigDecimal manualPrice = null;
		private BigDecimal itemPrice = null;
		private BigDecimal grossItemPrice = null;
		private BigDecimal netItemPrice = null;
		private BigDecimal baseItemPrice = null;
		private String serialNumber = null;
		private POS pos = null;
		private final List<TaxPayments> taxPayments = null;
		private String revenueAccount = null;
		private String costCenter = null;

		public T article(final Product prod)
		{
			article = prod;
			return self();
		}

		public T baseItemPrice(final BigDecimal value)
		{
			baseItemPrice = value;
			return self();
		}

		public T bookingTime(final Date time)
		{
			bookingTime = time;
			return self();
		}

		@Override
		public Sale build()
		{
			return new Sale(this);
		}

		public T cashier(final Cashier cash)
		{
			cashier = cash;
			return self();
		}

		public T commodityGroup(final CommodityGroup grp)
		{
			commodityGroup = grp;
			return self();
		}

		public T costCenter(final String value)
		{
			setCostCenter(value);
			return self();
		}

		public T description(final String txt)
		{
			description = txt;
			return self();
		}

		public String getCostCenter()
		{
			return costCenter;
		}

		public T grossItemPrice(final BigDecimal value)
		{
			grossItemPrice = value;
			return self();
		}

		public T infoTexts(final String txt)
		{
			infoTexts = txt;
			return self();
		}

		public T itemPrice(final BigDecimal value)
		{
			itemPrice = value;
			return self();
		}

		public T manualPrice(final BigDecimal value)
		{
			manualPrice = value;
			return self();
		}

		public T netItemPrice(final BigDecimal value)
		{
			netItemPrice = value;
			return self();
		}

		public T pos(final POS posy)
		{
			pos = posy;
			return self();
		}

		public T quantity(final BigDecimal value)
		{
			quantity = value;
			return self();
		}

		public T receipt(final Receipt rec)
		{
			this.receipt = rec;
			return self();
		}

		public T receiptIndex(final int value)
		{
			receiptIndex = value;
			return self();
		}

		public T receiptNumber(final String value)
		{
			receiptNumber = value;
			return self();
		}

		public T revenueAccount(final String value)
		{
			revenueAccount = value;
			return self();
		}

		public T sector(final Sector sec)
		{
			sector = sec;
			return self();
		}

		public T serialNumber(final String value)
		{
			serialNumber = value;
			return self();
		}

		public void setCostCenter(final String costCenter)
		{
			this.costCenter = costCenter;
		}

		public T taxPayments(final Collection<TaxPayments> coll)
		{
			for (final TaxPayments taxPay : coll)
			{
				taxPayments.add(taxPay);
			}
			return self();
		}

		public T taxPayments(final TaxPayments taxPayment)
		{
			taxPayments.add(taxPayment);
			return self();
		}
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -3645926143364056863L;

	private Product article;

	private Cashier cashier;
	private CommodityGroup commodityGroup;
	private Date bookingTime;
	private String description;
	private String infoTexts;
	private Sector sector;
	private String receiptNumber;
	private Integer receiptIndex;
	private BigDecimal quantity;
	private POS pos;
	private Receipt receipt;
	private BigDecimal manualPrice;
	private BigDecimal itemPrice;
	private BigDecimal grossItemPrice;
	private BigDecimal netItemPrice;
	private BigDecimal baseItemPrice;
	private String costCenter;

	private String serialNumber;

	private List<TaxPayments> taxPayments;

	private String revenueAccount;

	private Sale(final Init<?> init)
	{
		super(init);
		article = init.article;
		cashier = init.cashier;
		commodityGroup = init.commodityGroup;
		bookingTime = init.bookingTime;
		description = init.description;
		infoTexts = init.infoTexts;
		sector = init.sector;
		receiptNumber = init.receiptNumber;
		receiptIndex = init.receiptIndex;
		quantity = init.quantity;
		receipt = init.receipt;
		manualPrice = init.manualPrice;
		itemPrice = init.itemPrice;
		grossItemPrice = init.grossItemPrice;
		netItemPrice = init.netItemPrice;
		baseItemPrice = init.baseItemPrice;
		serialNumber = init.serialNumber;
		pos = init.pos;
		taxPayments = init.taxPayments;
		revenueAccount = init.revenueAccount;
		costCenter = init.costCenter;
	}

// public boolean post() throws ApiNotReachableException, IOException
// {
//
// if (commodityGroup != null && commodityGroup.getUuid() == null)
// commodityGroup.post();
// if (sector != null && sector.getUuid() == null)
// sector.post();
// if (cashier != null && cashier.getUuid() == null)
// cashier.post();
// if (article != null && article.getUuid() == null)
// article.post();
// return CloudLink.getConnector().postData(DataType.sale, this.toJSON());
// }

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public Product getArticle()
	{
		return this.article;
	}

	public BigDecimal getBaseItemPrice()
	{
		return baseItemPrice;
	}

	public Date getBookingTime()
	{
		return this.bookingTime;
	}

	public Cashier getCashier()
	{
		return this.cashier;
	}

	public CommodityGroup getCommodityGroup()
	{
		return this.commodityGroup;
	}

	public String getCostCenter()
	{
		return costCenter;
	}

	public String getDescription()
	{
		return this.description;
	}

	public BigDecimal getGrossItemPrice()
	{
		return grossItemPrice;
	}

	public String getInfoTexts()
	{
		return this.infoTexts;
	}

	public BigDecimal getItemPrice()
	{
		return itemPrice;
	}

	public BigDecimal getManualPrice()
	{
		return manualPrice;
	}

	public BigDecimal getNetItemPrice()
	{
		return netItemPrice;
	}

	public POS getPos()
	{
		return pos;
	}

	public BigDecimal getQuantity()
	{
		return this.quantity;
	}

	public Receipt getReceipt()
	{
		return receipt;
	}

	public int getReceiptIndex()
	{
		return this.receiptIndex;
	}

	public String getReceiptNumber()
	{
		return this.receiptNumber;
	}

	public String getRevenueAccount()
	{
		return revenueAccount;
	}

	public Sector getSector()
	{
		return this.sector;
	}

	public String getSerialNumber()
	{
		return serialNumber;
	}

	public List<TaxPayments> getTaxPayments()
	{
		return taxPayments;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = super.hashCode(result);
		result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
		result = prime * result + ((this.infoTexts == null) ? 0 : this.infoTexts.hashCode());
		result = prime * result +
			((this.receiptNumber == null) ? 0 : this.receiptNumber.hashCode());
		result = prime * result + ((this.serialNumber == null) ? 0 : this.serialNumber.hashCode());
		result = prime * result + ((this.article == null) ? 0 : this.article.hashCode());
		result = prime * result + ((this.cashier == null) ? 0 : this.cashier.hashCode());
		result = prime * result +
			((this.commodityGroup == null) ? 0 : this.commodityGroup.hashCode());
		result = prime * result + ((this.pos == null) ? 0 : this.pos.hashCode());
		result = prime * result + ((this.receipt == null) ? 0 : this.receipt.hashCode());
		result = prime * result + ((this.sector == null) ? 0 : this.sector.hashCode());


		return result;
	}

	public void setArticle(final Product article)
	{
		this.article = article;
	}

	public void setBaseItemPrice(final BigDecimal baseItemPrice)
	{
		this.baseItemPrice = baseItemPrice;
	}

	public void setBookingTime(final Date bookingTime)
	{
		this.bookingTime = bookingTime;
	}

	public void setCashier(final Cashier cashier)
	{
		this.cashier = cashier;
	}

	public void setCommodityGroup(final CommodityGroup grp)
	{
		this.commodityGroup = grp;
	}

	public void setCostCenter(final String costCenter)
	{
		this.costCenter = costCenter;
	}

	public void setDescription(final String txt)
	{
		this.description = txt;
	}

	public void setGrossItemPrice(final BigDecimal grossItemPrice)
	{
		this.grossItemPrice = grossItemPrice;
	}

	public void setInfoTexts(final String infoTexts)
	{
		this.infoTexts = infoTexts;
	}

	public void setItemPrice(final BigDecimal itemPrice)
	{
		this.itemPrice = itemPrice;
	}

	public void setManualPrice(final BigDecimal manualPrice)
	{
		this.manualPrice = manualPrice;
	}

	public void setNetItemPrice(final BigDecimal netItemPrice)
	{
		this.netItemPrice = netItemPrice;
	}

	public void setPos(final POS pos)
	{
		this.pos = pos;
	}

	public void setQuantity(final BigDecimal quant)
	{
		this.quantity = quant;
	}

	public void setReceipt(final Receipt receipt)
	{
		this.receipt = receipt;
	}

	public void setReceiptIndex(final int index)
	{
		this.receiptIndex = index;
	}

	public void setReceiptNumber(final String number)
	{
		this.receiptNumber = number;
	}

	public void setRevenueAccount(final String revenueAccount)
	{
		this.revenueAccount = revenueAccount;
	}

	public void setSector(final Sector sec)
	{
		this.sector = sec;
	}

	public void setSerialNumber(final String serialNumber)
	{
		this.serialNumber = serialNumber;
	}

	public void setTaxPayments(final List<TaxPayments> taxPayments)
	{
		this.taxPayments = taxPayments;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		appendJSON(obj);

		obj.put("bookingTime", bookingTime);
		obj.put("description", description);
		obj.put("infoTexts", infoTexts);
		obj.put("sector", sector);
		obj.put("receiptNumber", receiptNumber);
		obj.put("receiptIndex", receiptIndex);
		obj.put("quantity", quantity);

		if (cashier != null)
		{
			obj.put("cashier", cashier.getId());
		}
		if (article != null)
		{
			obj.put("article", article.getId());
		}
		if (commodityGroup != null)
		{
			obj.put("commodityGroup", commodityGroup.getId());
		}
		if (sector != null)
		{
			obj.put("sector", sector.getId());
		}

		return obj;
	}

	public static Sale fromJSON(JSONObject obj) throws JSONException, ParseException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
		{
			obj = obj.getJSONObject("result");
		}


		final Product prod = new Product.Builder().build();
		prod.setId(nullStringToNull(obj, "article"));

		final Cashier cash = new Cashier.Builder().build();
		cash.setId(nullStringToNull(obj, "cashier"));

		final CommodityGroup grp = new CommodityGroup.Builder().build();
		grp.setId(nullStringToNull(obj, "commodityGroup"));

		final Sector sec = new Sector.Builder().build();
		sec.setId(nullStringToNull(obj, "sector"));

		final Receipt rec = new Receipt.Builder().build();
		rec.setId(nullStringToNull(obj, "receipt"));

		final POS pos = new POS.Builder().build();
		pos.setId(nullStringToNull(obj, "pos"));

		final Sale sale = new Sale.Builder().deleted(obj.getBoolean("deleted"))
			.revision(obj.getLong("revision"))
			.id(nullStringToNull(obj, "uuid"))
			.article(prod)
			.cashier(cash)
			.commodityGroup(grp)
			.bookingTime(prepareDate(obj, "bookingTime"))
			.description(nullStringToNull(obj, "description"))
			.infoTexts(nullStringToNull(obj, "infoTexts"))
			.sector(sec)
			.receiptNumber(nullStringToNull(obj, "receiptNumber"))
			.receiptIndex(obj.getInt("receiptIndex"))
			.quantity(prepareBigDecimal(obj, "quantity"))
			.receipt(rec)
			.itemPrice(prepareBigDecimal(obj, "itemPrice"))
			.netItemPrice(prepareBigDecimal(obj, "netItemPrice"))
			.baseItemPrice(prepareBigDecimal(obj, "baseItemPrice"))
			.grossItemPrice(prepareBigDecimal(obj, "grossItemPrice"))
			.revenueAccount(nullStringToNull(obj, "revenueAccount"))
			.costCenter(nullStringToNull(obj, "costCenter"))
			.pos(pos)
			.build();

		JSONArray jTax = new JSONArray();
		jTax = obj.getJSONArray("taxPayments");
		if (!jTax.isNull(0))
		{
			for (int i = 0; i <= jTax.length() - 1; i++)
			{
				JSONObject tax = new JSONObject();
				tax = jTax.getJSONObject(i);
				final TaxPayments taxO = new TaxPayments(tax.getString("salesTax"),
					prepareBigDecimal(tax, "currentTaxRate"), prepareBigDecimal(tax, "amount"));
				final List<TaxPayments> taxL = new ArrayList<TaxPayments>();
				taxL.add(taxO);
				sale.setTaxPayments(taxL);
			}
		}

		return sale;
	}
}
