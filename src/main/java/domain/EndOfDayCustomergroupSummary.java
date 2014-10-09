package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONObject;

public class EndOfDayCustomergroupSummary
{
	private static final long serialVersionUID = 7946723890754545248L;

	private CustomerGroup customerGroup;

	private BigDecimal discountAmount;

	private BigDecimal items;

	private BigDecimal revenue;

	private EndOfDayStatement endOfDayStatement;

	public CustomerGroup getCustomerGroup()
	{
		return customerGroup;
	}

	public void setCustomerGroup(final CustomerGroup customerGroup)
	{
		this.customerGroup = customerGroup;
	}

	public BigDecimal getDiscountAmount()
	{
		return discountAmount;
	}

	public void setDiscountAmount(final BigDecimal discountAmount)
	{
		this.discountAmount = discountAmount;
	}

	public BigDecimal getItems()
	{
		return items;
	}

	public void setItems(final BigDecimal items)
	{
		this.items = items;
	}

	public BigDecimal getRevenue()
	{
		return revenue;
	}

	public void setRevenue(final BigDecimal revenue)
	{
		this.revenue = revenue;
	}

	public EndOfDayStatement getEndOfDayStatement()
	{
		return endOfDayStatement;
	}

	public void setEndOfDayStatement(final EndOfDayStatement endOfDayStatement)
	{
		this.endOfDayStatement = endOfDayStatement;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	public static EndOfDayCustomergroupSummary fromJSON(
		final JSONObject jEndOfDayCustomergroupSummary)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
