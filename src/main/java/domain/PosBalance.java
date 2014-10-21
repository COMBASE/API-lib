package domain;

import java.util.Collection;
import java.util.Date;

public class PosBalance extends AbstractApiObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3747780830697069675L;
	private POS pos;
	private Cashier cashier;
	private Date createTime;
	private Date finishTime;
	private Collection<ItemSummary> itemSummaries;
	private int balanceAttempts;
	private double expectedTotal;
	private double actualTotal;
	private int zCount;

	protected static abstract class Init<T extends Init<T>> extends AbstractApiObject.Init<T>
	{
		private POS pos = null;
		private Cashier cashier = null;
		private Date createTime = null;
		private Date finishTime = null;
		private Collection<ItemSummary> itemSummaries = null;
		private int balanceAttempts = 0;
		private double expectedTotal = 0;
		private double actualTotal = 0;
		private int zCount = 0;

		public T pos(final POS value)
		{
			this.pos = value;
			return self();
		}

		public T cashier(final Cashier value)
		{
			this.cashier = value;
			return self();
		}

		public T createTime(final Date value)
		{
			this.createTime = value;
			return self();
		}

		public T finishTime(final Date value)
		{
			this.finishTime = value;
			return self();
		}

		public T itemSummaries(final Collection<ItemSummary> value)
		{
			this.itemSummaries = value;
			return self();
		}

		public T itemSummaries(final ItemSummary value)
		{
			itemSummaries.add(value);
			return self();
		}

		public T balanceAttempts(final int value)
		{
			this.balanceAttempts = value;
			return self();
		}

		public T expectedTotal(final double value)
		{
			this.expectedTotal = value;
			return self();
		}

		public T actualTotal(final double value)
		{
			this.actualTotal = value;
			return self();
		}

		public T zCount(final int value)
		{
			this.zCount = value;
			return self();
		}

		@Override
		public PosBalance build()
		{
			return new PosBalance(this);
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

	public PosBalance(final Init<?> init)
	{
		super(init);
		this.pos = init.pos;
		this.cashier = init.cashier;
		this.createTime = init.createTime;
		this.finishTime = init.finishTime;
		this.itemSummaries = init.itemSummaries;
		this.balanceAttempts = init.balanceAttempts;
		this.expectedTotal = init.expectedTotal;
		this.actualTotal = init.actualTotal;
		this.zCount = init.zCount;
	}

// public static PosBalance fromJSON(JSONObject obj) throws JSONException
// {
// if (obj.has("result") && obj.getString("result") != null)
// obj = obj.getJSONObject("result");
//
// final Collection<ItemSummary> itemSummaryObjs = new ArrayList<ItemSummary>();
// final JSONArray itemSummaries = obj.getJSONArray("itemSummaries");
//
// for (int i = 0; i <= itemSummaries.length() - 1; i++)
// {
// final JSONObject itemSummary = itemSummaries.getJSONObject(i);
// final ItemSummary itemSummaryObj = ItemSummary.fromJSON(itemSummary);
// itemSummaryObjs.add(itemSummaryObj);
// }
//
// final POS pos = new POS.Builder(null).uuid(obj.getString("pos")).build();
// final Cashier cashier = new Cashier.Builder(null).uuid(obj.getString("cashier")).build();
//
// // date
// Date createTimeFormatted = null;
// Date finishTimeFormatted = null;
// try
// {
// String date = obj.getString("createTime");
// createTimeFormatted = inputDf.parse(date);
// date = obj.getString("finishTime");
// finishTimeFormatted = inputDf.parse(date);
// }
// catch (final ParseException e)
// {
// e.printStackTrace();
// }
//
// final PosBalance posBalance = new PosBalance.Builder().deleted(obj.getBoolean("deleted"))
// .revision(obj.getString("revision"))
// .uuid(obj.getString("uuid"))
// .pos(pos)
// .cashier(cashier)
// .createTime(createTimeFormatted)
// .finishTime(finishTimeFormatted)
// .itemSummaries(itemSummaryObjs)
// .balanceAttempts(obj.getInt("balanceAttempts"))
// .expectedTotal(obj.getDouble("expectedTotal"))
// .actualTotal(obj.getDouble("actualTotal"))
// .zCount(obj.getInt("zCount"))
// .build();
//
//
// return posBalance;
//
//
// }

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


	public int getBalanceAttempts()
	{
		return balanceAttempts;
	}


	public void setBalanceAttempts(final int balanceAttempts)
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

	public int getzCount()
	{
		return zCount;
	}

	public void setzCount(final int zCount)
	{
		this.zCount = zCount;
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
		result = prime * result + ((this.pos == null) ? 0 : this.pos.hashCode());
		result = prime * result + ((this.cashier == null) ? 0 : this.cashier.hashCode());
		result = prime * result + ((this.createTime == null) ? 0 : this.createTime.hashCode());
		result = prime * result + ((this.finishTime == null) ? 0 : this.finishTime.hashCode());
		result = prime * result +
			((this.itemSummaries == null) ? 0 : this.itemSummaries.hashCode());
		result = prime * result + ((this.balanceAttempts == 0) ? 0 : this.balanceAttempts);
		result = prime * result +
			((this.expectedTotal == 0) ? 0 : Double.valueOf(this.expectedTotal).hashCode());
		result = prime * result +
			((this.actualTotal == 0) ? 0 : Double.valueOf(this.actualTotal).hashCode());
		result = prime * result + ((this.zCount == 0) ? 0 : this.zCount);


		return result;
	}
}
