package domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Payment extends AbstractApiObject<Payment>
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
		private final String itemSequence = null;
		private Cashier cashier = null;
		private String receiptNumber = null;
		private Double manualPrice = null;
		private Receipt receipt = null;
		private Double itemPrice = null;
		private Integer itemNumber = null;
		private Date transactionTime = null;
		private BigDecimal amount = null;
		private Double netItemPrice = null;
		private Double baseItemPrice = null;
		private String serialNumber = null;
		private POS pos = null;
		private Currency currency = null;
		private PaymentMethod paymentMethod = null;
		private Integer receiptIndex = null;

		public T amount(final BigDecimal value)
		{
			amount = value;
			return self();
		}

		public T baseItemPrice(final double value)
		{
			baseItemPrice = value;
			return self();
		}

		@Override
		public Payment build()
		{
			return new Payment(this);
		}


		public T cashier(final Cashier cash)
		{
			cashier = cash;
			return self();
		}

		public T currency(final Currency cur)
		{
			currency = cur;
			return self();
		}

		public T itemNumber(final int value)
		{
			itemNumber = value;
			return self();
		}

		public T itemPrice(final double value)
		{
			itemPrice = value;
			return self();
		}

		public T manualPrice(final double value)
		{
			manualPrice = value;
			return self();
		}

		public T netItemPrice(final double value)
		{
			netItemPrice = value;
			return self();
		}

		public T paymentMethod(final PaymentMethod payMeth)
		{
			paymentMethod = payMeth;
			return self();
		}

		public T pos(final POS posy)
		{
			pos = posy;
			return self();
		}

		public T receipt(final Receipt rec)
		{
			receipt = rec;
			return self();
		}

		public T receiptIndex(final int value)
		{
			this.receiptIndex = value;
			return self();
		}

		public T receiptNumber(final String value)
		{
			receiptNumber = value;
			return self();
		}

		public T serialNumber(final String value)
		{
			serialNumber = value;
			return self();
		}

		public T transactionTime(final Date value)
		{
			transactionTime = value;
			return self();
		}
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -3413202913572354611L;

	private Cashier cashier;

	private Integer itemNumber;
	private String itemSequence;
	private Double manualPrice;
	private Receipt receipt;
	private Double itemPrice;
	private Double netItemPrice;
	private Double baseItemPrice;
	private String receiptNumber;
	private String serialNumber;
	private BigDecimal amount;
	private Date transactionTime;
	private POS pos;
	private PaymentMethod paymentMethod;

	private Currency currency;

	private final Integer receiptIndex;

	private Payment(final Init<?> init)
	{
		super(init);
		cashier = init.cashier;
		receipt = init.receipt;
		receiptNumber = init.receiptNumber;
		manualPrice = init.manualPrice;
		itemPrice = init.itemPrice;
		amount = init.amount;
		transactionTime = init.transactionTime;
		itemNumber = init.itemNumber;
		netItemPrice = init.netItemPrice;
		baseItemPrice = init.baseItemPrice;
		serialNumber = init.serialNumber;
		itemSequence = init.itemSequence;
		pos = init.pos;
		currency = init.currency;
		paymentMethod = init.paymentMethod;
		receiptIndex = init.receiptIndex;
	}

// public boolean post() throws IOException
// {
//
// if (cashier != null && cashier.getUuid() == null)
// cashier.post();
// return CloudLink.getConnector().postData(DataType.sale, this.toJSON());
// }

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public BigDecimal getAmount()
	{
		return amount;
	}

	public double getBaseItemPrice()
	{
		return baseItemPrice;
	}

	public Cashier getCashier()
	{
		return cashier;
	}

	public Currency getCurrency()
	{
		return currency;
	}

	public int getItemNumber()
	{
		return itemNumber;
	}

	public double getItemPrice()
	{
		return itemPrice;
	}

	public String getItemSequence()
	{
		return itemSequence;
	}

	public double getManualPrice()
	{
		return manualPrice;
	}

	public double getNetItemPrice()
	{
		return netItemPrice;
	}

	public PaymentMethod getPaymentMethod()
	{
		return paymentMethod;
	}

	public POS getPos()
	{
		return pos;
	}

	public Receipt getReceipt()
	{
		return receipt;
	}

	public int getReceiptIndex()
	{
		return receiptIndex;
	}

	public String getReceiptNumber()
	{
		return receiptNumber;
	}

	public String getSerialNumber()
	{
		return serialNumber;
	}

	public Date getTransactionTime()
	{
		return transactionTime;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = prime * result + ((this.itemSequence == null) ? 0 : this.itemSequence.hashCode());
		result = prime * result + ((this.serialNumber == null) ? 0 : this.serialNumber.hashCode());
		result = prime * result + ((this.cashier == null) ? 0 : this.cashier.hashCode());
		result = prime * result + ((this.currency == null) ? 0 : this.currency.hashCode());
		result = prime * result +
			((this.paymentMethod == null) ? 0 : this.paymentMethod.hashCode());
		result = prime * result + ((this.pos == null) ? 0 : this.pos.hashCode());
		result = prime * result + ((this.receipt == null) ? 0 : this.receipt.hashCode());
		result = prime * result +
			((this.transactionTime == null) ? 0 : this.transactionTime.hashCode());


		return result;
	}

	public void setAmount(final BigDecimal amount)
	{
		this.amount = amount;
	}

	public void setBaseItemPrice(final double baseItemPrice)
	{
		this.baseItemPrice = baseItemPrice;
	}

	public void setCashier(final Cashier cashier)
	{
		this.cashier = cashier;
	}

	public void setCurrency(final Currency currency)
	{
		this.currency = currency;
	}

	public void setItemNumber(final int itemNumber)
	{
		this.itemNumber = itemNumber;
	}

	public void setItemPrice(final double itemPrice)
	{
		this.itemPrice = itemPrice;
	}

	public void setItemSequence(final String itemSequence)
	{
		this.itemSequence = itemSequence;
	}

	public void setManualPrice(final double manualPrice)
	{
		this.manualPrice = manualPrice;
	}

	public void setNetItemPrice(final double netItemPrice)
	{
		this.netItemPrice = netItemPrice;
	}

	public void setPaymentMethod(final PaymentMethod paymentMethod)
	{
		this.paymentMethod = paymentMethod;
	}

	public void setPos(final POS pos)
	{
		this.pos = pos;
	}

	public void setReceipt(final Receipt receipt)
	{
		this.receipt = receipt;
	}

	public void setReceiptNumber(final String receiptNumber)
	{
		this.receiptNumber = receiptNumber;
	}

	public void setSerialNumber(final String serialNumber)
	{
		this.serialNumber = serialNumber;
	}

	public void setTransactionTime(final Date transactionTime)
	{
		this.transactionTime = transactionTime;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();

		appendJSON(obj);

		obj.put("receiptNumber", receiptNumber);

		obj.put("cashier", cashier.getId());

		if (pos != null)
		{
			obj.put("pos", pos.getId());
		}

		return obj;
	}

	public static Payment fromJSON(JSONObject obj) throws JSONException, ParseException
	{
		if (obj.has("result") && nullStringToNull(obj, "result").equalsIgnoreCase("null"))
		{
			obj = obj.getJSONObject("result");
		}

		final Cashier cash = new Cashier.Builder().build();
		cash.setId(nullStringToNull(obj, "cashier"));
		final Receipt rec = new Receipt.Builder().build();
		rec.setId(nullStringToNull(obj, "receipt"));
		final POS pos = new POS.Builder().build();
		pos.setId(nullStringToNull(obj, "pos"));
		final Currency cur = new Currency.Builder().build();
		cur.setId(nullStringToNull(obj, "currency"));
		final PaymentMethod payMeth = new PaymentMethod.Builder().build();
		payMeth.setId(nullStringToNull(obj, "paymentMethod"));
		final Payment pay = new Payment.Builder().deleted(obj.getBoolean("deleted"))
			.revision(obj.getLong("revision"))
			.id(nullStringToNull(obj, "uuid"))
			.amount(prepareBigDecimal(obj, "amount"))
			.transactionTime(prepareDate(obj, "transactionTime"))
			.cashier(cash)
			.receipt(rec)
			.pos(pos)
			.currency(cur)
			.paymentMethod(payMeth)
			.receiptIndex(obj.getInt("receiptIndex"))
			.build();
		return pay;
	}
}
