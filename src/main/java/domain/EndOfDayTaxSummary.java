package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class EndOfDayTaxSummary
{
	private BigDecimal netAmount;

	private Tax salesTax;

	private BigDecimal taxAmount;

	private EndOfDayStatement endOfDayStatement;

	public EndOfDayStatement getEndOfDayStatement()
	{
		return endOfDayStatement;
	}

	public BigDecimal getNetAmount()
	{
		return netAmount;
	}

	public Tax getSalesTax()
	{
		return salesTax;
	}

	public BigDecimal getTaxAmount()
	{
		return taxAmount;
	}

	public void setEndOfDayStatement(final EndOfDayStatement endOfDayStatement)
	{
		this.endOfDayStatement = endOfDayStatement;
	}

	public void setNetAmount(final BigDecimal netAmount)
	{
		this.netAmount = netAmount;
	}

	public void setSalesTax(final Tax salesTax)
	{
		this.salesTax = salesTax;
	}

	public void setTaxAmount(final BigDecimal taxAmount)
	{
		this.taxAmount = taxAmount;
	}

	public static EndOfDayTaxSummary fromJSON(final JSONObject obj) throws JSONException
	{

		final EndOfDayTaxSummary taxSummary = new EndOfDayTaxSummary();

		final Tax tax = new Tax.Builder().id(nullStringToNull(obj, "salesTax")).build();

		taxSummary.setNetAmount(new BigDecimal(nullStringToNull(obj, "netAmount")));
		taxSummary.setSalesTax(tax);
		taxSummary.setTaxAmount(new BigDecimal(String.valueOf(obj.getDouble("taxAmount"))));

		return taxSummary;
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
