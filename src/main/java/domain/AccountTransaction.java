package domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

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

	public AccountTransaction(final Init<?> init)
	{
		super(init);
		account = init.account;
		receipt = init.receipt;
		cashier = init.cashier;
		pos = init.pos;
		amount = init.amount;
		bookingTime = init.bookingTime;
		receiptIndex = init.receiptIndex;
		description = init.description;
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = super.hashCode();

		result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
		result = prime * result + ((this.account == null) ? 0 : this.account.hashCode());
		result = prime * result + ((this.bookingTime == null) ? 0 : this.bookingTime.hashCode());
		result = prime * result + ((this.cashier == null) ? 0 : this.cashier.hashCode());
		result = prime * result + ((this.pos == null) ? 0 : this.pos.hashCode());
		result = prime * result + ((this.receipt == null) ? 0 : this.receipt.hashCode());
		result = prime * result + ((this.amount == null) ? 0 : this.amount.hashCode());
		result = prime * result + ((this.receiptIndex == 0) ? 0 : this.receiptIndex.hashCode());

		return result;
	}

	public void setAccount(final Account account)
	{
		this.account = account;
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

		return obj;
	}

	public static AccountTransaction fromJSON(JSONObject obj) throws JSONException, ParseException
	{
		if (obj.has("result") && obj.getString("result") != null)
		{
			obj = obj.getJSONObject("result");
		}

		final Account account = new Account.Builder().build();
		account.setId(obj.getString("account"));

		final Receipt rec = new Receipt.Builder().build();
		rec.setId(obj.getString("receipt"));

		final Cashier cash = new Cashier.Builder().build();
		cash.setId(obj.getString("cashier"));

		final POS pos = new POS.Builder().build();
		pos.setId(obj.getString("pos"));

		final AccountTransaction accountTransaction = new AccountTransaction.Builder().deleted(
			obj.getBoolean("deleted"))
			.revision(obj.getLong("revision"))
			.id(obj.getString("uuid"))
			.receipt(rec)
			.cashier(cash)
			.pos(pos)
			.account(account)
			.amount(prepareBigDecimal(obj, "amount"))
			.bookingTime(prepareDate(obj, "bookingTime"))
			.receiptIndex(obj.getInt("receiptIndex"))
			.description(obj.getString("description"))
			.build();
		return accountTransaction;
	}


}
