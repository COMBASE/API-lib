package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class PosBalance
{
	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
	private boolean deleted;
	private String revision;
	private String uuid;
	private POS pos;
	private Cashier cashier;
	private Date createTime;
	private Date finishTime;
	private Collection<ItemSummary> itemSummaries;
	private double balanceAttempts;
	private double expectedTotal;
	private double actualTotal;

	public PosBalance(final Builder builder)
	{
		this.deleted = builder.deleted;
		this.revision = builder.revision;
		this.uuid = builder.uuid;
		this.pos = builder.pos;
		this.cashier = builder.cashier;
		this.createTime = builder.createTime;
		this.finishTime = builder.finishTime;
		this.itemSummaries = builder.itemSummaries;
		this.balanceAttempts = builder.balanceAttempts;
		this.expectedTotal = builder.expectedTotal;
		this.actualTotal = builder.actualTotal;
	}

	public static class Builder
	{
		private boolean deleted = false;
		private String revision = null;
		private String uuid = null;
		private POS pos = null;
		private Cashier cashier = null;
		private Date createTime = null;
		private Date finishTime = null;
		private Collection<ItemSummary> itemSummaries = null;
		private double balanceAttempts = 0;
		private double expectedTotal = 0;
		private double actualTotal = 0;

		public Builder deleted(final boolean value)
		{
			this.deleted = value;
			return this;
		}

		public Builder revision(final String value)
		{
			this.revision = value;
			return this;
		}

		public Builder uuid(final String value)
		{
			this.uuid = value;
			return this;
		}

		public Builder pos(final POS value)
		{
			this.pos = value;
			return this;
		}

		public Builder cashier(final Cashier value)
		{
			this.cashier = value;
			return this;
		}

		public Builder createTime(final Date value)
		{
			this.createTime = value;
			return this;
		}

		public Builder finishTime(final Date value)
		{
			this.finishTime = value;
			return this;
		}

		public Builder itemSummaries(final Collection<ItemSummary> value)
		{
			this.itemSummaries = value;
			return this;
		}

		public Builder itemSummaries(final ItemSummary value)
		{
			itemSummaries.add(value);
			return this;
		}

		public Builder balanceAttempts(final int value)
		{
			this.balanceAttempts = value;
			return this;
		}

		public Builder expectedTotal(final double value)
		{
			this.expectedTotal = value;
			return this;
		}

		public Builder actualTotal(final double value)
		{
			this.actualTotal = value;
			return this;
		}

		public PosBalance build()
		{
			return new PosBalance(this);
		}
	}


	public static PosBalance fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		final Collection<ItemSummary> itemSummaryObjs = new ArrayList<ItemSummary>();
		final JSONArray itemSummaries = obj.getJSONArray("itemSummaries");
		for (int i = 0; i <= itemSummaries.length() - 1; i++)
		{
			final JSONObject itemSummary = itemSummaries.getJSONObject(i);
			final ItemSummary itemSummaryObj = ItemSummary.fromJSON(itemSummary);
			itemSummaryObjs.add(itemSummaryObj);
		}

		final POS pos = new POS.Builder(null).uuid(obj.getString("pos")).build();
		final Cashier cashier = new Cashier.Builder(null).uuid(obj.getString("cashier")).build();

		// date
		Date createTimeFormatted = null;
		Date finishTimeFormatted = null;
		try
		{
			String date = obj.getString("createTime");
			createTimeFormatted = inputDf.parse(date);
			date = obj.getString("finishTime");
			finishTimeFormatted = inputDf.parse(date);
		}
		catch (final ParseException e)
		{
			e.printStackTrace();
		}

		final PosBalance posBalance = new PosBalance.Builder().deleted(obj.getBoolean("deleted"))
			.revision(obj.getString("revision"))
			.uuid(obj.getString("uuid"))
			.pos(pos)
			.cashier(cashier)
			.createTime(createTimeFormatted)
			.finishTime(finishTimeFormatted)
			.itemSummaries(itemSummaryObjs)
			.balanceAttempts(obj.getInt("balanceAttempts"))
			.expectedTotal(obj.getDouble("expectedTotal"))
			.actualTotal(obj.getDouble("actualTotal"))

			.build();


		return posBalance;


	}

	public boolean isDeleted()
	{
		return deleted;
	}


	public void setDeleted(final boolean deleted)
	{
		this.deleted = deleted;
	}


	public String getRevision()
	{
		return revision;
	}


	public void setRevision(final String revision)
	{
		this.revision = revision;
	}


	public String getUuid()
	{
		return uuid;
	}


	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}


	public POS getPos()
	{
		return pos;
	}


	public void setPos(final POS pos)
	{
		this.pos = pos;
	}


	public Cashier getCashier()
	{
		return cashier;
	}


	public void setCashier(final Cashier cashier)
	{
		this.cashier = cashier;
	}


	public Date getCreateTime()
	{
		return createTime;
	}


	public void setCreateTime(final Date createTime)
	{
		this.createTime = createTime;
	}


	public Date getFinishTime()
	{
		return finishTime;
	}


	public void setFinishTime(final Date finishTime)
	{
		this.finishTime = finishTime;
	}


	public Collection<ItemSummary> getItemSummaries()
	{
		return itemSummaries;
	}


	public void setItemSummaries(final Collection<ItemSummary> itemSummaries)
	{
		this.itemSummaries = itemSummaries;
	}


	public double getBalanceAttempts()
	{
		return balanceAttempts;
	}


	public void setBalanceAttempts(final double balanceAttempts)
	{
		this.balanceAttempts = balanceAttempts;
	}


	public double getExpectedTotal()
	{
		return expectedTotal;
	}


	public void setExpectedTotal(final double expectedTotal)
	{
		this.expectedTotal = expectedTotal;
	}


	public double getActualTotal()
	{
		return actualTotal;
	}


	public void setActualTotal(final double actualTotal)
	{
		this.actualTotal = actualTotal;
	}
}
