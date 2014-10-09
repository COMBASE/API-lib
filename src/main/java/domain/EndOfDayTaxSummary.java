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

	public BigDecimal getNetAmount()
	{
		return netAmount;
	}

	public void setNetAmount(final BigDecimal netAmount)
	{
		this.netAmount = netAmount;
	}

	public Tax getSalesTax()
	{
		return salesTax;
	}

	public void setSalesTax(final Tax salesTax)
	{
		this.salesTax = salesTax;
	}

	public BigDecimal getTaxAmount()
	{
		return taxAmount;
	}

	public void setTaxAmount(final BigDecimal taxAmount)
	{
		this.taxAmount = taxAmount;
	}

	public EndOfDayStatement getEndOfDayStatement()
	{
		return endOfDayStatement;
	}

	public void setEndOfDayStatement(final EndOfDayStatement endOfDayStatement)
	{
		this.endOfDayStatement = endOfDayStatement;
	}

	public static EndOfDayTaxSummary fromJSON(final JSONObject obj) throws JSONException
	{

		final EndOfDayTaxSummary taxSummary = new EndOfDayTaxSummary();

		final Tax tax = new Tax.Builder(null, null).uuid(obj.getString("salesTax")).build();

		taxSummary.setNetAmount(new BigDecimal(obj.getString("netAmount")));
		taxSummary.setSalesTax(tax);
		taxSummary.setTaxAmount(new BigDecimal(String.valueOf(obj.getDouble("taxAmount"))));

		return taxSummary;
	}
}
