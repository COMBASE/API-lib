package domain;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class FinancialAccounting
{
	public static class Builder
	{
		private Long revision = null;
		private List<FinancialAccountingItem> items = null;

		public FinancialAccounting build()
		{
			return new FinancialAccounting(this);
		}

		public Builder items(final List<FinancialAccountingItem> values)
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

	private List<FinancialAccountingItem> items;

	public FinancialAccounting(final Builder builder)
	{
		setRevision(builder.revision);
		setItems(builder.items);
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final FinancialAccounting other = (FinancialAccounting)obj;
		if (items == null)
		{
			if (other.items != null)
				return false;
		}
		else if (!items.equals(other.items))
			return false;
		if (revision == null)
		{
			if (other.revision != null)
				return false;
		}
		else if (!revision.equals(other.revision))
			return false;
		return true;
	}

	public List<FinancialAccountingItem> getItems()
	{
		return items;
	}

	public Long getRevision()
	{
		return revision;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((revision == null) ? 0 : revision.hashCode());
		return result;
	}

	public void setItems(final List<FinancialAccountingItem> items)
	{
		this.items = items;
	}

	public void setRevision(final Long revision)
	{
		this.revision = revision;
	}

	public static FinancialAccounting fromJSON(JSONObject jObj) throws JSONException,
	ParseException
	{
		if (jObj.has("result") && jObj.getString("result") != null)
		{
			jObj = jObj.getJSONObject("result");
		}

		final FinancialAccounting financialAccounting = new FinancialAccounting.Builder().revision(
			jObj.getLong("revision")).build();

		if (!jObj.isNull("items"))
		{
			final List<FinancialAccountingItem> items = new ArrayList<FinancialAccountingItem>();

			final JSONArray jItems = jObj.getJSONArray("items");

			for (int i = 0; i < jItems.length(); i++)
			{
				final JSONObject jItem = jItems.getJSONObject(i);

				final FinancialAccountingItem financialAccountingItem = FinancialAccountingItem.fromJSON(jItem);

				items.add(financialAccountingItem);
			}

			financialAccounting.setItems(items);
		}

		return financialAccounting;
	}

}
