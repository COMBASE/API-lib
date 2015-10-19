package domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;



public class AccountTransaction extends AbstractApiObject<AccountTransaction>
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
		private Account account = null;

		private Receipt receipt = null;

		private Cashier cashier = null;

		private POS pos = null;

		private BigDecimal amount = null;

		private Date bookingTime = null;

		private Integer receiptIndex = null;

		private String description = null;

		private List<String> serialNumbers = null;

		public String voucherNumber = null;


		public T account(final Account acc)
		{
			account = acc;
			return self();
		}


		public T amount(final BigDecimal value)
		{
			amount = value;
			return self();
		}


		public T bookingTime(final Date value)
		{
			bookingTime = value;
			return self();
		}


		@Override
		public AccountTransaction build()
		{
			return new AccountTransaction(this);
		}


		public T cashier(final Cashier cash)
		{
			cashier = cash;
			return self();
		}


		public T description(final String value)
		{
			description = value;
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
			receiptIndex = value;
			return self();
		}


		public T serialNumbers(final List<String> values)
		{
			serialNumbers = values;
			return self();
		}


		public T voucherNumber(final String value)
		{
			voucherNumber = value;
			return self();
		}
	}


	private static final long serialVersionUID = -6707310291148051948L;

	private Account account;

	private Receipt receipt;

	private Cashier cashier;

	private POS pos;

	private BigDecimal amount;

	private Date bookingTime;

	private Integer receiptIndex;

	private String description;

	private List<String> serialNumbers;


	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}


	public void setAccount(final Account account)
	{
		this.account = account;
	}


	public void setReceiptIndex(final Integer receiptIndex)
	{
		this.receiptIndex = receiptIndex;
	}


	public void setSerialNumbers(final List<String> serialNumbers)
	{
		this.serialNumbers = serialNumbers;
	}


	private String voucherNumber;


	public AccountTransaction(final Init<?> init)
	{
		super(init);
		setAccount(init.account);
		setReceipt(init.receipt);
		setCashier(init.cashier);
		setPos(init.pos);
		setAmount(init.amount);
		setBookingTime(init.bookingTime);
		setReceiptIndex(init.receiptIndex);
		setDescription(init.description);
		setSerialNumbers(init.serialNumbers);
		setVoucherNumber(init.voucherNumber);
	}


	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}


	public Account getAccount()
	{
		return account;
	}


	public BigDecimal getAmount()
	{
		return amount;
	}


	public Date getBookingTime()
	{
		return bookingTime;
	}


	public Cashier getCashier()
	{
		return cashier;
	}


	public String getDescription()
	{
		return description;
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


	public List<String> getSerialNumbers()
	{
		return serialNumbers;
	}


	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = super.hashCode();

		result = prime * result + (description == null ? 0 : description.hashCode());
		result = prime * result + (account == null ? 0 : account.hashCode());
		result = prime * result + (bookingTime == null ? 0 : bookingTime.hashCode());
		result = prime * result + (cashier == null ? 0 : cashier.hashCode());
		result = prime * result + (pos == null ? 0 : pos.hashCode());
		result = prime * result + (receipt == null ? 0 : receipt.hashCode());
		result = prime * result + (amount == null ? 0 : amount.hashCode());
		result = prime * result + (receiptIndex == 0 ? 0 : receiptIndex.hashCode());

		return result;
	}


	public void setAmount(final BigDecimal amount)
	{
		this.amount = amount;
	}


	public void setBookingTime(final Date bookingTime)
	{
		this.bookingTime = bookingTime;
	}


	public void setCashier(final Cashier cashier)
	{
		this.cashier = cashier;
	}


	public void setDescription(final String description)
	{
		this.description = description;
	}


	public void setPos(final POS pos)
	{
		this.pos = pos;
	}


	public void setReceipt(final Receipt receipt)
	{
		this.receipt = receipt;
	}


	public void setReceiptIndex(final int receiptIndex)
	{
		this.receiptIndex = receiptIndex;
	}


	@Override
	public JSONObject toJSON() throws JSONException
	{
		JSONObject obj = new JSONObject();

		obj = super.appendJSON(obj);

		obj.put("account", account.getId());
		obj.put("receipt", receipt.getId());
		obj.put("cashier", cashier.getId());
		obj.put("pos", pos.getId());
		obj.put("amount", amount);
		obj.put("bookingTime", bookingTime);
		obj.put("receiptIndex", receiptIndex);
		obj.put("description", description);
		obj.put("voucherNumber", voucherNumber);

		if (serialNumbers != null)
		{
			final JSONArray array = new JSONArray();
			for (final String number : serialNumbers)
				if (number != null)
					array.put(number);
			obj.put("serialNumbers", array);
		}

		return obj;
	}


	public static AccountTransaction fromJSON(JSONObject obj) throws JSONException, ParseException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
			obj = obj.getJSONObject("result");

		final Account account = new Account.Builder().build();
		account.setId(nullStringToNull(obj, "account"));

		final Receipt rec = new Receipt.Builder().build();
		rec.setId(nullStringToNull(obj, "receipt"));

		final Cashier cash = new Cashier.Builder().build();
		cash.setId(nullStringToNull(obj, "cashier"));

		final POS pos = new POS.Builder().build();
		pos.setId(nullStringToNull(obj, "pos"));

		List<String> serialNumbers = null;
		if (!obj.isNull("serialNumbers"))
		{
			final JSONArray jSerialNumbers = obj.getJSONArray("serialNumbers");
			if (jSerialNumbers.length() > 0)
			{
				if (serialNumbers == null)
					serialNumbers = new ArrayList<>();
				for (int i = 0; jSerialNumbers.length() > i; i++)
					serialNumbers.add(jSerialNumbers.getString(i));

			}
		}

		final AccountTransaction accountTransaction = new AccountTransaction.Builder().//
		deleted(obj.getBoolean("deleted")).//
		revision(obj.getLong("revision")).//
		id(nullStringToNull(obj, "uuid")).//
		receipt(rec).//
		cashier(cash).//
		pos(pos).//
		account(account).//
		amount(prepareBigDecimal(obj, "amount")).//
		bookingTime(prepareDate(obj, "bookingTime")).//
		receiptIndex(obj.getInt("receiptIndex")).//
		description(nullStringToNull(obj, "description")).//
		serialNumbers(serialNumbers).//
		voucherNumber(nullStringToNull(obj, "voucherNumber")).//
		build();

		return accountTransaction;
	}


	public String getVoucherNumber()
	{
		return voucherNumber;
	}


	public void setVoucherNumber(final String voucherNumber)
	{
		this.voucherNumber = voucherNumber;
	}

}
