package domain;

import java.text.ParseException;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Payment extends AbstractApiObject<Payment>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3413202913572354611L;
	private Cashier cashier;
	private int itemNumber;
	private String itemSequence;
	private double manualPrice;
	private Receipt receipt;
	private double itemPrice;
	private double netItemPrice;
	private double baseItemPrice;
	private String receiptNumber;
	private String serialNumber;
	private double amount;
	private Date transactionTime;
	private POS pos;
	private PaymentMethod paymentMethod;
	private Currency currency;
	private final int receiptIndex;

	protected static abstract class Init<T extends Init<T>> extends AbstractApiObject.Init<T>
	{
		private final String itemSequence = null;
		private Cashier cashier = null;
		private String receiptNumber = null;
		private double manualPrice = 0;
		private Receipt receipt = null;
		private double itemPrice = 0;
		private int itemNumber = 0;
		private Date transactionTime = null;
		private double amount = 0;
		private double netItemPrice = 0;
		private double baseItemPrice = 0;
		private String serialNumber = null;
		private POS pos = null;
		private Currency currency = null;
		private PaymentMethod paymentMethod = null;
		private int receiptIndex = 0;

		public T pos(final POS posy)
		{
			pos = posy;
			return self();
		}

		public T itemNumber(final int value)
		{
			itemNumber = value;
			return self();
		}

		public T amount(final double value)
		{
			amount = value;
			return self();
		}


		public T transactionTime(final Date value)
		{
			transactionTime = value;
			return self();
		}

		public T cashier(final Cashier cash)
		{
			cashier = cash;
			return self();
		}

		public T paymentMethod(final PaymentMethod payMeth)
		{
			paymentMethod = payMeth;
			return self();
		}

		public T receipt(final Receipt rec)
		{
			receipt = rec;
			return self();
		}

		public T receiptNumber(final String value)
		{
			receiptNumber = value;
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

		public T currency(final Currency cur)
		{
			currency = cur;
			return self();
		}

		public T receiptIndex(final int value)
		{
			this.receiptIndex = value;
			return self();
		}

		@Override
		public Payment build()
		{
			return new Payment(this);
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

	public Cashier getCashier()
	{
		return cashier;
	}

	public void setCashier(final Cashier cashier)
	{
		this.cashier = cashier;
	}

	public int getItemNumber()
	{
		return itemNumber;
	}

	public void setItemNumber(final int itemNumber)
	{
		this.itemNumber = itemNumber;
	}

	public String getItemSequence()
	{
		return itemSequence;
	}

	public void setItemSequence(final String itemSequence)
	{
		this.itemSequence = itemSequence;
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

	public String getReceiptNumber()
	{
		return receiptNumber;
	}

	public void setReceiptNumber(final String receiptNumber)
	{
		this.receiptNumber = receiptNumber;
	}

	public String getSerialNumber()
	{
		return serialNumber;
	}

	public void setSerialNumber(final String serialNumber)
	{
		this.serialNumber = serialNumber;
	}

	public POS getPos()
	{
		return pos;
	}

	public void setPos(final POS pos)
	{
		this.pos = pos;
	}

	public Receipt getReceipt()
	{
		return receipt;
	}

	public void setReceipt(final Receipt receipt)
	{
		this.receipt = receipt;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(final double amount)
	{
		this.amount = amount;
	}

	public Date getTransactionTime()
	{
		return transactionTime;
	}

	public void setTransactionTime(final Date transactionTime)
	{
		this.transactionTime = transactionTime;
	}

	public Currency getCurrency()
	{
		return currency;
	}

	public void setCurrency(final Currency currency)
	{
		this.currency = currency;
	}

	public PaymentMethod getPaymentMethod()
	{
		return paymentMethod;
	}

	public void setPaymentMethod(final PaymentMethod paymentMethod)
	{
		this.paymentMethod = paymentMethod;
	}

	public int getReceiptIndex()
	{
		return receiptIndex;
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

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();

		appendJSON(obj);

		obj.put("receiptNumber", receiptNumber);

		obj.put("cashier", cashier.getId());

		obj.put("pos", pos.getId());

		return obj;
	}

	public static Payment fromJSON(JSONObject obj) throws JSONException, ParseException
	{
		if (obj.has("result") && obj.getString("result").equalsIgnoreCase("null"))
			obj = obj.getJSONObject("result");

		// date
		final String date = obj.getString("transactionTime");
		Date tTime = null;

		tTime = inputDf.parse(date);


		final Cashier cash = new Cashier.Builder().build();
		cash.setId(obj.getString("cashier"));
		final Receipt rec = new Receipt.Builder().build();
		rec.setId(obj.getString("receipt"));
		final POS pos = new POS.Builder().build();
		pos.setId(obj.getString("pos"));
		final Currency cur = new Currency.Builder().build();
		cur.setId(obj.getString("currency"));
		final PaymentMethod payMeth = new PaymentMethod.Builder().build();
		payMeth.setId(obj.getString("paymentMethod"));
		final Payment pay = new Payment.Builder().deleted(obj.getBoolean("deleted"))
			.revision(obj.getLong("revision"))
			.id(obj.getString("uuid"))
			.amount(obj.getDouble("amount"))
			.transactionTime(tTime)
			.cashier(cash)
			.receipt(rec)
			.pos(pos)
			.currency(cur)
			.paymentMethod(payMeth)
			.build();
		return pay;
	}
}
