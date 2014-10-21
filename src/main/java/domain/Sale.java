package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


public class Sale extends AbstractApiObject
{
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
	private int receiptIndex;
	private double quantity;
	private POS pos;
	private Receipt receipt;
	private double manualPrice;
	private double itemPrice;
	private double grossItemPrice;
	private double netItemPrice;
	private double baseItemPrice;
	private String serialNumber;
	private List<TaxPayments> taxPayments;

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
		private int receiptIndex = 0;
		private double quantity = 0;
		private Receipt receipt = null;
		private double manualPrice = 0;
		private double itemPrice = 0;
		private double grossItemPrice = 0;
		private double netItemPrice = 0;
		private double baseItemPrice = 0;
		private String serialNumber = null;
		private POS pos;
		private final List<TaxPayments> taxPayments = new ArrayList<TaxPayments>();

		public T pos(final POS posy)
		{
			pos = posy;
			return self();
		}

		public T taxPayments(final TaxPayments taxPayment)
		{
			taxPayments.add(taxPayment);
			return self();
		}

		public T taxPayments(final Collection<TaxPayments> coll)
		{
			for (final TaxPayments taxPay : coll)
			{
				taxPayments.add(taxPay);
			}
			return self();
		}

		public T article(final Product prod)
		{
			article = prod;
			return self();
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

		public T bookingTime(final Date time)
		{
			bookingTime = time;
			return self();
		}

		public T description(final String txt)
		{
			description = txt;
			return self();
		}

		public T infoTexts(final String txt)
		{
			infoTexts = txt;
			return self();
		}

		public T sector(final Sector sec)
		{
			sector = sec;
			return self();
		}

		public T receiptNumber(final String value)
		{
			receiptNumber = value;
			return self();
		}

		public T receiptIndex(final int value)
		{
			receiptIndex = value;
			return self();
		}

		public T quantity(final double value)
		{
			quantity = value;
			return self();
		}

		public T receipt(final Receipt rec)
		{
			this.receipt = rec;
			return self();
		}

		public T manualPrice(final double value)
		{
			manualPrice = value;
			return self();
		}

		public T itemPrice(final double value)
		{
			itemPrice = value;
			return self();
		}

		public T grossItemPrice(final double value)
		{
			grossItemPrice = value;
			return self();
		}

		public T netItemPrice(final double value)
		{
			netItemPrice = value;
			return self();
		}

		public T baseItemPrice(final double value)
		{
			baseItemPrice = value;
			return self();
		}

		public T serialNumber(final String value)
		{
			serialNumber = value;
			return self();
		}

		@Override
		public Sale build()
		{
			return new Sale(this);
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
	}

// public JSONObject toJSON()
// {
// final JSONObject obj = new JSONObject();
// try
// {
// obj.put("deleted", deleted);
// obj.put("revision", revision);
// obj.put("uuid", uuid);
// obj.put("bookingTime", bookingTime);
// obj.put("description", description);
// obj.put("infoTexts", infoTexts);
// obj.put("sector", sector);
// obj.put("receiptNumber", receiptNumber);
// obj.put("receiptIndex", receiptIndex);
// obj.put("quantity", quantity);
//
// if (cashier != null)
// obj.put("cashier", cashier.getUuid());
// if (article != null)
// obj.put("article", article.getUuid());
// if (commodityGroup != null)
// obj.put("commodityGroup", commodityGroup.getUuid());
// if (sector != null)
// obj.put("sector", sector.getUuid());
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
// public static Sale fromJSON(JSONObject obj) throws JSONException
// {
// if (obj.has("result") && obj.getString("result") != null)
// obj = obj.getJSONObject("result");
//
//
// final Product prod = new Product.Builder(null).build();
// prod.setUuid(obj.getString("article"));
//
// final Cashier cash = new Cashier.Builder(null).build();
// cash.setUuid(obj.getString("cashier"));
//
// final CommodityGroup grp = new CommodityGroup.Builder(null).build();
// grp.setUuid(obj.getString("commodityGroup"));
//
// final Sector sec = new Sector.Builder(null).build();
// sec.setUuid(obj.getString("sector"));
//
// final Receipt rec = new Receipt.Builder().build();
// rec.setUuid(obj.getString("receipt"));
//
// final POS pos = new POS.Builder(null).build();
// pos.setUuid(obj.getString("pos"));
//
// // date
// Date bTime = null;
// try
// {
// final String date = obj.getString("bookingTime");
// bTime = inputDf.parse(date);
// }
// catch (final ParseException e)
// {
// e.printStackTrace();
// }
//
// final Sale sale = new Sale.Builder().deleted(obj.getBoolean("deleted"))
// .revision(obj.getString("revision"))
// .uuid(obj.getString("uuid"))
// .article(prod)
// .cashier(cash)
// .commodityGroup(grp)
// .bookingTime(bTime)
// .description(obj.getString("description"))
// .infoTexts(obj.getString("infoTexts"))
// .sector(sec)
// .receiptNumber(obj.getString("receiptNumber"))
// .receiptIndex(obj.getInt("receiptIndex"))
// .quantity(obj.getDouble("quantity"))
// .receipt(rec)
// .itemPrice(obj.getDouble("itemPrice"))
// .netItemPrice(obj.getDouble("netItemPrice"))
// .baseItemPrice(obj.getDouble("baseItemPrice"))
// .grossItemPrice(obj.getDouble("grossItemPrice"))
// .pos(pos)
// .build();
//
// JSONArray jTax = new JSONArray();
// jTax = obj.getJSONArray("taxPayments");
// if (!jTax.isNull(0))
// {
// for (int i = 0; i <= jTax.length() - 1; i++)
// {
// JSONObject tax = new JSONObject();
// tax = jTax.getJSONObject(i);
// final TaxPayments taxO = new TaxPayments(tax.getString("salesTax"),
// tax.getDouble("currentTaxRate"), tax.getDouble("amount"));
// final List<TaxPayments> taxL = new ArrayList<TaxPayments>();
// taxL.add(taxO);
// sale.setTaxPayments(taxL);
// }
// }
//
// return sale;
// }
//
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

	public Product getArticle()
	{
		return this.article;
	}

	public void setArticle(final Product article)
	{
		this.article = article;
	}

	public Cashier getCashier()
	{
		return this.cashier;
	}

	public void setCashier(final Cashier cashier)
	{
		this.cashier = cashier;
	}

	public CommodityGroup getCommodityGroup()
	{
		return this.commodityGroup;
	}

	public void setCommodityGroup(final CommodityGroup grp)
	{
		this.commodityGroup = grp;
	}

	public Date getBookingTime()
	{
		return this.bookingTime;
	}

	public void setBookingTime(final Date bookingTime)
	{
		this.bookingTime = bookingTime;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(final String txt)
	{
		this.description = txt;
	}

	public String getInfoTexts()
	{
		return this.infoTexts;
	}

	public void setInfoTexts(final String infoTexts)
	{
		this.infoTexts = infoTexts;
	}

	public Sector getSector()
	{
		return this.sector;
	}

	public void setSector(final Sector sec)
	{
		this.sector = sec;
	}

	public String getReceiptNumber()
	{
		return this.receiptNumber;
	}

	public void setReceiptNumber(final String number)
	{
		this.receiptNumber = number;
	}

	public int getReceiptIndex()
	{
		return this.receiptIndex;
	}

	public void setReceiptIndex(final int index)
	{
		this.receiptIndex = index;
	}

	public double getQuantity()
	{
		return this.quantity;
	}

	public void setQuantity(final int quant)
	{
		this.quantity = quant;
	}

	public Receipt getReceipt()
	{
		return receipt;
	}

	public void setReceipt(final Receipt receipt)
	{
		this.receipt = receipt;
	}

	public double getManualPrice()
	{
		return manualPrice;
	}

	public void setManualPrice(final double manualPrice)
	{
		this.manualPrice = manualPrice;
	}

	public double getItemPrice()
	{
		return itemPrice;
	}

	public void setItemPrice(final double itemPrice)
	{
		this.itemPrice = itemPrice;
	}

	public double getGrossItemPrice()
	{
		return grossItemPrice;
	}

	public void setGrossItemPrice(final double grossItemPrice)
	{
		this.grossItemPrice = grossItemPrice;
	}

	public double getNetItemPrice()
	{
		return netItemPrice;
	}

	public void setNetItemPrice(final double netItemPrice)
	{
		this.netItemPrice = netItemPrice;
	}

	public double getBaseItemPrice()
	{
		return baseItemPrice;
	}

	public void setBaseItemPrice(final double baseItemPrice)
	{
		this.baseItemPrice = baseItemPrice;
	}

	public String getSerialNumber()
	{
		return serialNumber;
	}

	public void setSerialNumber(final String serialNumber)
	{
		this.serialNumber = serialNumber;
	}

	public void setQuantity(final double quantity)
	{
		this.quantity = quantity;
	}

	public POS getPos()
	{
		return pos;
	}

	public void setPos(final POS pos)
	{
		this.pos = pos;
	}

	public List<TaxPayments> getTaxPayments()
	{
		return taxPayments;
	}

	public void setTaxPayments(final List<TaxPayments> taxPayments)
	{
		this.taxPayments = taxPayments;
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


}
