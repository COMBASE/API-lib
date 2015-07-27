package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONException;
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

	public BigDecimal getDiscountAmount()
	{
		return discountAmount;
	}

	public EndOfDayStatement getEndOfDayStatement()
	{
		return endOfDayStatement;
	}

	public BigDecimal getItems()
	{
		return items;
	}

	public BigDecimal getRevenue()
	{
		return revenue;
	}

	public void setCustomerGroup(final CustomerGroup customerGroup)
	{
		this.customerGroup = customerGroup;
	}

	public void setDiscountAmount(final BigDecimal discountAmount)
	{
		this.discountAmount = discountAmount;
	}

	public void setEndOfDayStatement(final EndOfDayStatement endOfDayStatement)
	{
		this.endOfDayStatement = endOfDayStatement;
	}

	public void setItems(final BigDecimal items)
	{
		this.items = items;
	}

	public void setRevenue(final BigDecimal revenue)
	{
		this.revenue = revenue;
	}

	public static EndOfDayCustomergroupSummary fromJSON(final JSONObject obj) throws JSONException
	{

		final EndOfDayCustomergroupSummary customergroupSummary = new EndOfDayCustomergroupSummary();

		final CustomerGroup customerGroup = new CustomerGroup.Builder().id(
			nullStringToNull(obj, "customerGroup")).build();

		customergroupSummary.setCustomerGroup(customerGroup);

		customergroupSummary.setDiscountAmount(new BigDecimal(
			String.valueOf(obj.getDouble("discountAmount"))));

		customergroupSummary.setItems(new BigDecimal(String.valueOf(obj.getDouble("items"))));

		customergroupSummary.setRevenue(new BigDecimal(String.valueOf(obj.getDouble("revenue"))));

		return customergroupSummary;

	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
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
