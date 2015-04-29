package domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class FinancialAccountingPosBalanceItem
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

		public FinancialAccountingPosBalanceItem build()
		{
			return new FinancialAccountingPosBalanceItem(this);
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

	public FinancialAccountingPosBalanceItem(final Builder builder)
	{
		this.costCenter = builder.costCenter;
		this.day = builder.day;
		this.revenueAccount = builder.revenueAccount;
		this.taxId = builder.taxId;
		this.type = builder.type;
		this.typeDescription = builder.typeDescription;
		this.value = builder.value;
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

	public String getType()
	{
		return type;
	}

	public String getTypeDescription()
	{
		return typeDescription;
	}

	public BigDecimal getValue()
	{
		return value;
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

	public void setType(final String type)
	{
		this.type = type;
	}

	public void setTypeDescription(final String typeDescription)
	{
		this.typeDescription = typeDescription;
	}

	public void setValue(final BigDecimal value)
	{
		this.value = value;
	}

	public static FinancialAccountingPosBalanceItem fromJSON(final JSONObject jObj)
		throws JSONException, ParseException
	{
		final FinancialAccountingPosBalanceItem accountingPosBalanceItem = new FinancialAccountingPosBalanceItem.Builder().costCenter(
			jObj.getString("costCenter"))
			.day(prepareDate(jObj, "day"))
			.revenueAccount(jObj.getString("revenueAccount"))
			.typeDescription(jObj.getString("typeDescription"))
			.type(jObj.getString("type"))
			.taxId(jObj.getString("taxId"))
			.value(prepareBigDecimal(jObj, "value"))
			.build();

		return accountingPosBalanceItem;
	}

	private static BigDecimal prepareBigDecimal(final JSONObject obj, final String bigDecimalString)
		throws JSONException
	{
		if (!obj.isNull(bigDecimalString) &&
			!obj.getString(bigDecimalString).equalsIgnoreCase("null"))
			return new BigDecimal(obj.getString(bigDecimalString));
		return null;
	}

	private static Date prepareDate(final JSONObject obj, final String dateString)
		throws ParseException, JSONException
	{
		@SuppressWarnings("unused")
		Date date = null;
		if (!obj.isNull(dateString) || !obj.getString(dateString).equalsIgnoreCase("null"))
			return date = inputDf.parse(obj.getString(dateString));
		return null;
	}

}
