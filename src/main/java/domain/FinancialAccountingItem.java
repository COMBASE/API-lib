package domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class FinancialAccountingItem
{
	public static class Builder
	{
		private Date day = null;
		private String costCenter = null;
		private String revenueAccount = null;
		private String type = null;
		private String typeDescription = null;
		private String taxId = null;
		private BigDecimal value = null;

		public FinancialAccountingItem build()
		{
			return new FinancialAccountingItem(this);
		}

		public Builder costCenter(final String value)
		{
			this.costCenter = value;
			return this;
		}

		public Builder day(final Date value)
		{
			this.day = value;
			return this;
		}

		public Builder revenueAccount(final String value)
		{
			this.revenueAccount = value;
			return this;
		}

		public Builder taxId(final String value)
		{
			this.taxId = value;
			return this;
		}

		public Builder type(final String value)
		{
			this.type = value;
			return this;
		}

		public Builder typeDescription(final String value)
		{
			this.typeDescription = value;
			return this;
		}

		public Builder value(final BigDecimal value)
		{
			this.value = value;
			return this;
		}

	}

	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd");


	private Date day;

	private String costCenter;

	private String revenueAccount;

	private String type;

	private String typeDescription;

	private String taxId;

	private BigDecimal value;

	public FinancialAccountingItem(final Builder builder)
	{
		super();
		this.day = builder.day;
		this.costCenter = builder.costCenter;
		this.revenueAccount = builder.revenueAccount;
		this.type = builder.type;
		this.typeDescription = builder.typeDescription;
		this.taxId = builder.taxId;
		this.value = builder.value;
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
		final FinancialAccountingItem other = (FinancialAccountingItem)obj;
		if (costCenter == null)
		{
			if (other.costCenter != null)
				return false;
		}
		else if (!costCenter.equals(other.costCenter))
			return false;
		if (day == null)
		{
			if (other.day != null)
				return false;
		}
		else if (!day.equals(other.day))
			return false;
		if (revenueAccount == null)
		{
			if (other.revenueAccount != null)
				return false;
		}
		else if (!revenueAccount.equals(other.revenueAccount))
			return false;
		if (taxId == null)
		{
			if (other.taxId != null)
				return false;
		}
		else if (!taxId.equals(other.taxId))
			return false;
		if (type == null)
		{
			if (other.type != null)
				return false;
		}
		else if (!type.equals(other.type))
			return false;
		if (typeDescription == null)
		{
			if (other.typeDescription != null)
				return false;
		}
		else if (!typeDescription.equals(other.typeDescription))
			return false;
		if (value == null)
		{
			if (other.value != null)
				return false;
		}
		else if (!value.equals(other.value))
			return false;
		return true;
	}

	public String getCostCenter()
	{
		return costCenter;
	}

	public Date getDay()
	{
		return day;
	}

	public String getRevenueAccount()
	{
		return revenueAccount;
	}

	public String getTaxId()
	{
		return taxId;
	}

	public String getTypeDescription()
	{
		return typeDescription;
	}

	public String getTypes()
	{
		return type;
	}

	public BigDecimal getValue()
	{
		return value;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((costCenter == null) ? 0 : costCenter.hashCode());
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((revenueAccount == null) ? 0 : revenueAccount.hashCode());
		result = prime * result + ((taxId == null) ? 0 : taxId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((typeDescription == null) ? 0 : typeDescription.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	public void setCostCenter(final String costCenter)
	{
		this.costCenter = costCenter;
	}

	public void setDay(final Date day)
	{
		this.day = day;
	}

	public void setRevenueAccount(final String revenueAccount)
	{
		this.revenueAccount = revenueAccount;
	}

	public void setTaxId(final String taxId)
	{
		this.taxId = taxId;
	}

	public void setTypeDescription(final String typeDescription)
	{
		this.typeDescription = typeDescription;
	}

	public void setTypes(final String types)
	{
		this.type = types;
	}

	public void setValue(final BigDecimal value)
	{
		this.value = value;
	}

	public static FinancialAccountingItem fromJSON(final JSONObject obj) throws JSONException,
	ParseException
	{
		final FinancialAccountingItem financialAccountingItem = new FinancialAccountingItem.Builder().costCenter(
			nullStringToNull(obj, "costCenter"))
			.day(prepareDate(obj, "day"))
			.revenueAccount(nullStringToNull(obj, "revenueAccount"))
			.typeDescription(nullStringToNull(obj, "typeDescription"))
			.type(nullStringToNull(obj, "type"))
			.taxId(nullStringToNull(obj, "taxId"))
			.value(prepareBigDecimal(obj, "value"))
			.build();

		return financialAccountingItem;
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

	private static BigDecimal prepareBigDecimal(final JSONObject obj, final String bigDecimalString)
		throws JSONException
	{
		if (!obj.isNull(bigDecimalString) &&
			!nullStringToNull(obj, bigDecimalString).equalsIgnoreCase("null"))
			return new BigDecimal(nullStringToNull(obj, bigDecimalString));
		return null;
	}

	private static Date prepareDate(final JSONObject obj, final String dateString)
		throws ParseException, JSONException
	{
		@SuppressWarnings("unused")
		Date date = null;
		if (!obj.isNull(dateString) || !nullStringToNull(obj, dateString).equalsIgnoreCase("null"))
			return date = inputDf.parse(nullStringToNull(obj, dateString));
		return null;
	}

}
