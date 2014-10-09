package domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class EndOfDayStatement
{
	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

	private final long revision;

	private final String uuid;

	private final boolean deleted;

	private final List<EndOfDayAccountSummary> accountSummaries;

	private final List<EndOfDayCashierSummary> cashierSummaries;

	private final List<EndOfDayCommoditygroupSummary> commodityGroupSummaries;

	private final List<EndOfDayCustomergroupSummary> customerGroupSummaries;

	private Date finishTime;

	private final List<EndOfDayPaymentSummary> paymentSummaries;

	private long receiptCount;

	private final List<EndOfDayTaxSummary> taxSummaries;

	private long zCount;

	private POS pos;

	public EndOfDayStatement(final Builder builder)
	{
		revision = builder.revision;

		uuid = builder.uuid;

		deleted = builder.deleted;

		accountSummaries = builder.accountSummaries;

		cashierSummaries = builder.cashierSummaries;

		commodityGroupSummaries = builder.commodityGroupSummaries;

		customerGroupSummaries = builder.customerGroupSummaries;

		finishTime = builder.finishTime;

		paymentSummaries = builder.paymentSummaries;

		receiptCount = builder.receiptCount;

		taxSummaries = builder.taxSummaries;

		zCount = builder.zCount;

		pos = builder.pos;
	}

	public static class Builder
	{

		private long revision = 0l;

		private String uuid = null;

		private boolean deleted = false;

		private List<EndOfDayAccountSummary> accountSummaries = new ArrayList<EndOfDayAccountSummary>();

		private List<EndOfDayCashierSummary> cashierSummaries = new ArrayList<EndOfDayCashierSummary>();

		private List<EndOfDayCommoditygroupSummary> commodityGroupSummaries = new ArrayList<EndOfDayCommoditygroupSummary>();

		private List<EndOfDayCustomergroupSummary> customerGroupSummaries = new ArrayList<EndOfDayCustomergroupSummary>();

		private Date finishTime;

		private List<EndOfDayPaymentSummary> paymentSummaries = new ArrayList<EndOfDayPaymentSummary>();

		private long receiptCount;

		private List<EndOfDayTaxSummary> taxSummaries = new ArrayList<EndOfDayTaxSummary>();

		private long zCount;

		private POS pos;

		public Builder revision(final long value)
		{
			this.revision = value;
			return this;
		}

		public Builder uuid(final String value)
		{
			this.uuid = value;
			return this;
		}

		public Builder deleted(final boolean value)
		{
			this.deleted = value;
			return this;
		}

		public Builder accountSummaries(final List<EndOfDayAccountSummary> value)
		{
			this.accountSummaries = value;
			return this;
		}

		public Builder cashierSummaries(final List<EndOfDayCashierSummary> value)
		{
			this.cashierSummaries = value;
			return this;
		}

		public Builder commodityGroupSummaries(final List<EndOfDayCommoditygroupSummary> value)
		{
			this.commodityGroupSummaries = value;
			return this;
		}

		public Builder customerGroupSummaries(final List<EndOfDayCustomergroupSummary> value)
		{
			this.customerGroupSummaries = value;
			return this;
		}

		public Builder finishTime(final Date value)
		{
			this.finishTime = value;
			return this;
		}

		public Builder paymentSummaries(final List<EndOfDayPaymentSummary> value)
		{
			this.paymentSummaries = value;
			return this;
		}

		public Builder receiptCount(final long value)
		{
			this.receiptCount = value;
			return this;
		}

		public Builder taxSummaries(final List<EndOfDayTaxSummary> value)
		{
			this.taxSummaries = value;
			return this;
		}

		public Builder zCount(final long value)
		{
			this.zCount = value;
			return this;
		}

		public Builder pos(final POS value)
		{
			this.pos = value;
			return this;
		}

		public EndOfDayStatement build()
		{
			return new EndOfDayStatement(this);
		}
	}

	public static EndOfDayStatement fromJSON(JSONObject obj) throws JSONException
	{

		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		final List<EndOfDayAccountSummary> endOfDayAccountSummaries = new ArrayList<EndOfDayAccountSummary>();
		EndOfDayAccountSummary endOfDayAccountSummary = null;

		final List<EndOfDayCashierSummary> cashierSummaries = new ArrayList<EndOfDayCashierSummary>();
		EndOfDayCashierSummary cashierSummary = null;

		final List<EndOfDayCommoditygroupSummary> commoditygroupSummaries = new ArrayList<EndOfDayCommoditygroupSummary>();
		EndOfDayCommoditygroupSummary commoditygroupSummary = null;

		final List<EndOfDayCustomergroupSummary> customergroupSummaries = new ArrayList<EndOfDayCustomergroupSummary>();
		EndOfDayCustomergroupSummary customergroupSummary = null;

		final List<EndOfDayPaymentSummary> dayPaymentSummaries = new ArrayList<EndOfDayPaymentSummary>();
		EndOfDayPaymentSummary paymentSummary = null;

		final List<EndOfDayTaxSummary> dayTaxSummaries = new ArrayList<EndOfDayTaxSummary>();
		EndOfDayTaxSummary taxSummary = null;

		// AccountSummaries
		final JSONArray jEndOfDayAccountSummaries = obj.getJSONArray("accountSummaries");
		if (jEndOfDayAccountSummaries.length() != 0)
			for (int i = 0; i < jEndOfDayAccountSummaries.length(); i++)
			{
				final JSONObject jEndOfDayAccountSummary = jEndOfDayAccountSummaries.getJSONObject(i);
				endOfDayAccountSummary = EndOfDayAccountSummary.fromJSON(jEndOfDayAccountSummary);
				if (endOfDayAccountSummary != null)
					endOfDayAccountSummaries.add(endOfDayAccountSummary);
			}

		// CashierSummaries
		final JSONArray jEndOfDayCashierSummaries = obj.getJSONArray("cashierSummaries");
		if (jEndOfDayCashierSummaries.length() != 0)
			for (int i = 0; i < jEndOfDayAccountSummaries.length(); i++)
			{
				final JSONObject jEndOfDayCashierSummary = jEndOfDayCashierSummaries.getJSONObject(i);
				cashierSummary = EndOfDayCashierSummary.fromJSON(jEndOfDayCashierSummary);
			}

		// CommodityGroup
		final JSONArray jEndOfDayCommoditygroupSummaries = obj.getJSONArray("commodityGroupSummaries");
		if (jEndOfDayCommoditygroupSummaries.length() != 0)
			for (int i = 0; i < jEndOfDayCommoditygroupSummaries.length(); i++)
			{
				final JSONObject jEndOfDayCommoditygroupSummary = jEndOfDayCommoditygroupSummaries.getJSONObject(i);
				commoditygroupSummary = EndOfDayCommoditygroupSummary.fromJSON(jEndOfDayCommoditygroupSummary);
			}

		// CustomerGroup
		final JSONArray jEndOfDayCustomergroupSummaries = obj.getJSONArray("customerGroupSummaries");
		if (jEndOfDayCustomergroupSummaries.length() != 0)
			for (int i = 0; i < jEndOfDayCustomergroupSummaries.length(); i++)
			{
				final JSONObject jEndOfDayCustomergroupSummary = jEndOfDayCustomergroupSummaries.getJSONObject(i);
				customergroupSummary = EndOfDayCustomergroupSummary.fromJSON(jEndOfDayCustomergroupSummary);
			}

		// Payment
		final JSONArray jEndOfDayPaymentSummaries = obj.getJSONArray("paymentSummaries");
		if (jEndOfDayPaymentSummaries.length() != 0)
			for (int i = 0; i < jEndOfDayPaymentSummaries.length(); i++)
			{
				final JSONObject jEndOfDayPaymentSummary = jEndOfDayPaymentSummaries.getJSONObject(i);
				paymentSummary = EndOfDayPaymentSummary.fromJSON(jEndOfDayPaymentSummary);
			}

		// Tax
		final JSONArray jEndOfDayTaxSummaries = obj.getJSONArray("taxSummaries");
		if (jEndOfDayTaxSummaries.length() != 0)
			for (int i = 0; i < jEndOfDayTaxSummaries.length(); i++)
			{
				final JSONObject jEndOfDayTaxSummary = jEndOfDayTaxSummaries.getJSONObject(i);
				taxSummary = EndOfDayTaxSummary.fromJSON(jEndOfDayTaxSummary);
			}


		final EndOfDayStatement endOfDayStatement = new EndOfDayStatement.Builder().deleted(
			obj.getBoolean("deleted"))
			.revision(obj.getLong("revision"))
			.uuid(obj.getString("uuid"))
			.accountSummaries(endOfDayAccountSummaries)
			.build();

		return endOfDayStatement;

	}

	public Date getFinishTime()
	{
		return finishTime;
	}

	public void ListFinishTime(final Date finishTime)
	{
		this.finishTime = finishTime;
	}

	public long getReceiptCount()
	{
		return receiptCount;
	}

	public void ListReceiptCount(final long receiptCount)
	{
		this.receiptCount = receiptCount;
	}

	public long getzCount()
	{
		return zCount;
	}

	public void ListzCount(final long zCount)
	{
		this.zCount = zCount;
	}

	public POS getPos()
	{
		return pos;
	}

	public void ListPos(final POS pos)
	{
		this.pos = pos;
	}

	public long getRevision()
	{
		return revision;
	}

	public String getUuid()
	{
		return uuid;
	}

	public boolean isDeleted()
	{
		return deleted;
	}

	public List<EndOfDayAccountSummary> getAccountSummaries()
	{
		return accountSummaries;
	}

	public List<EndOfDayCashierSummary> getCashierSummaries()
	{
		return cashierSummaries;
	}

	public List<EndOfDayCommoditygroupSummary> getCommodityGroupSummaries()
	{
		return commodityGroupSummaries;
	}

	public List<EndOfDayCustomergroupSummary> getCustomerGroupSummaries()
	{
		return customerGroupSummaries;
	}

	public List<EndOfDayPaymentSummary> getPaymentSummaries()
	{
		return paymentSummaries;
	}

	public List<EndOfDayTaxSummary> getTaxSummaries()
	{
		return taxSummaries;
	}

}
