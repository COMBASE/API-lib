package domain;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class AccountTransaction extends AbstractApiObject
{
	private Account account;
	private Receipt receipt;
	private Cashier cashier;
	private POS pos;
	private double amount;
	private Date bookingTime;
	private int receiptIndex;
	private String description;


	private AccountTransaction(final Builder builder)
	{
		super(builder);
		account = builder.account;
		receipt = builder.receipt;
		cashier = builder.cashier;
		pos = builder.pos;
		amount = builder.amount;
		bookingTime = builder.bookingTime;
		receiptIndex = builder.receiptIndex;
		description = builder.description;
	}

	public static class Builder extends ApiObjectBuilder<AccountTransaction>
	{
		private Account account = null;
		private Receipt receipt = null;
		private Cashier cashier = null;
		private POS pos = null;
		private double amount = 0;
		private Date bookingTime = null;
		private int receiptIndex = 0;
		private String description = null;

		public Builder account(final Account acc)
		{
			account = acc;
			return this;
		}

		public Builder receipt(final Receipt rec)
		{
			receipt = rec;
			return this;
		}

		public Builder cashier(final Cashier cash)
		{
			cashier = cash;
			return this;
		}

		public Builder pos(final POS posy)
		{
			pos = posy;
			return this;
		}

		public Builder amount(final double value)
		{
			amount = value;
			return this;
		}

		public Builder bookingTime(final Date value)
		{
			bookingTime = value;
			return this;
		}

		public Builder receiptIndex(final int value)
		{
			receiptIndex = value;
			return this;
		}

		public Builder description(final String value)
		{
			description = value;
			return this;
		}

		@Override
		public AccountTransaction build()
		{
			return new AccountTransaction(this);
		}
	}

	public JSONObject toJSON()
	{
		final JSONObject obj = new JSONObject();
		try
		{
			obj.put("account", account.getId());
			obj.put("receipt", receipt.getUuid());
			obj.put("cashier", cashier.getUuid());
			obj.put("pos", pos.getUuid());
			obj.put("amount", amount);
			obj.put("bookingTime", bookingTime);
			obj.put("receiptIndex", receiptIndex);
			obj.put("description", description);
			return obj;
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static AccountTransaction fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		// date
		final String date = obj.getString("bookingTime");
		Date bTime = null;
		try
		{
			bTime = getInputdf().parse(date);
		}
		catch (final ParseException e)
		{
			e.printStackTrace();
		}

		final Account account = new Account.Builder().build();
		account.setId(obj.getString("account"));
		final Receipt rec = new Receipt.Builder().build();
		rec.setUuid(obj.getString("receipt"));
		final Cashier cash = new Cashier.Builder(null).build();
		cash.setUuid(obj.getString("cashier"));
		final POS pos = new POS.Builder(null).build();
		pos.setUuid(obj.getString("pos"));
		final AccountTransaction accountTransaction = new AccountTransaction.Builder().deleted(
			obj.getBoolean("deleted"))
			.revision(obj.getString("revision"))
			.receipt(rec)
			.cashier(cash)
			.pos(pos)
			.account(account)
			.amount(obj.getDouble("amount"))
			.bookingTime(bTime)
			.receiptIndex(obj.getInt("receiptIndex"))
			.description(obj.getString("description"))
			.build();
		return accountTransaction;
	}

	public boolean post() throws IOException
	{
		/*
		 * if (account != null && account.getUuid() == null) account.post();
		 */
		if (receipt != null && receipt.getUuid() == null)
			receipt.post();
		if (cashier != null && cashier.getUuid() == null)
			cashier.post();
		if (pos != null && pos.getUuid() == null)
			pos.post();
		return CloudLink.getConnector().postData(DataType.accountTransaction, this.toJSON());

	}

	public String getUuid()
	{
		return uuid;
	}

	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	@Override
	public String getRevision()
	{
		return revision;
	}

	public void setRevision(final String revision)
	{
		this.revision = revision;
	}

	@Override
	public boolean isDeleted()
	{
		return deleted;
	}

	@Override
	public void setDeleted(final boolean deleted)
	{
		this.deleted = deleted;
	}

	public Receipt getReceipt()
	{
		return receipt;
	}

	public void setReceipt(final Receipt receipt)
	{
		this.receipt = receipt;
	}

	public Cashier getCashier()
	{
		return cashier;
	}

	public void setCashier(final Cashier cashier)
	{
		this.cashier = cashier;
	}

	public POS getPos()
	{
		return pos;
	}

	public void setPos(final POS pos)
	{
		this.pos = pos;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(final double amount)
	{
		this.amount = amount;
	}

	public Date getBookingTime()
	{
		return bookingTime;
	}

	public void setBookingTime(final Date bookingTime)
	{
		this.bookingTime = bookingTime;
	}

	public int getReceiptIndex()
	{
		return receiptIndex;
	}

	public void setReceiptIndex(final int receiptIndex)
	{
		this.receiptIndex = receiptIndex;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	public Account getAccount()
	{
		return account;
	}

	public void setAccount(final Account account)
	{
		this.account = account;
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
		result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
		result = prime * result + ((this.revision == null) ? 0 : this.revision.hashCode());
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
		result = prime * result + ((this.account == null) ? 0 : this.account.hashCode());
		result = prime * result + ((this.bookingTime == null) ? 0 : this.bookingTime.hashCode());
		result = prime * result + ((this.cashier == null) ? 0 : this.cashier.hashCode());
		result = prime * result + ((this.pos == null) ? 0 : this.pos.hashCode());
		result = prime * result + ((this.receipt == null) ? 0 : this.receipt.hashCode());


		return result;
	}


}
