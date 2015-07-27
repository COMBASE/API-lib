package domain;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class FinancialAccountingPosBalance
{
	public static class Builder
	{

		private Long revision = null;
		private List<FinancialAccountingPosBalanceItem> items = null;

		public FinancialAccountingPosBalance build()
		{
			return new FinancialAccountingPosBalance(this);
		}

		public Builder items(final List<FinancialAccountingPosBalanceItem> values)
		{
			this.items = values;
			return this;
		}

		public Builder revision(final Long value)
		{
			this.revision = value;
			return this;
		}

	}

	private Long revision;

	private List<FinancialAccountingPosBalanceItem> items;

	public FinancialAccountingPosBalance(final Builder builder)
	{
		this.revision = builder.revision;
		this.items = builder.items;
	}

	public List<FinancialAccountingPosBalanceItem> getItems()
	{
		return items;
	}

	public Long getRevision()
	{
		return revision;
	}

	public void setItems(final List<FinancialAccountingPosBalanceItem> items)
	{
		this.items = items;
	}

	public void setRevision(final Long revision)
	{
		this.revision = revision;
	}

	public static FinancialAccountingPosBalance fromJSON(JSONObject jObj) throws JSONException,
		ParseException
	{

		if (jObj.has("result") && nullStringToNull(jObj, "result") != null)
		{
			jObj = jObj.getJSONObject("result");
		}

		final FinancialAccountingPosBalance accountingPosBalance = new FinancialAccountingPosBalance.Builder().revision(
			jObj.getLong("revision"))
			.build();

		if (!jObj.isNull("items"))
		{
			final List<FinancialAccountingPosBalanceItem> items = new ArrayList<FinancialAccountingPosBalanceItem>();

			final JSONArray jItems = jObj.getJSONArray("items");

			for (int i = 0; i < jItems.length(); i++)
			{
				final JSONObject jItem = jItems.getJSONObject(i);

				final FinancialAccountingPosBalanceItem accountingPosBalanceItem = FinancialAccountingPosBalanceItem.fromJSON(jItem);

				items.add(accountingPosBalanceItem);
			}

			accountingPosBalance.setItems(items);
		}

		return accountingPosBalance;

	}

	/**
	 *
	 * @param obj
	 * @param value
	 * @return
	 * @throws JSONException
	 */
	protected static String nullStringToNull(final JSONObject obj, final String value)
		throws JSONException
	{
		if (obj.getString(value).equalsIgnoreCase("null"))
			return null;
		return obj.getString(value);
	}

}
