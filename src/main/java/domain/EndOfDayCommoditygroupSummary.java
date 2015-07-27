package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class EndOfDayCommoditygroupSummary
{
	private static final long serialVersionUID = 1323305921130600428L;

	private CommodityGroup commodityGroup;

	private BigDecimal discountAmount;

	private BigDecimal items;

	private BigDecimal revenue;

	private EndOfDayStatement endOfDayStatement;

	public CommodityGroup getCommodityGroup()
	{
		return commodityGroup;
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

	public void setCommodityGroup(final CommodityGroup commodityGroup)
	{
		this.commodityGroup = commodityGroup;
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

	public static EndOfDayCommoditygroupSummary fromJSON(final JSONObject obj) throws JSONException
	{

		final EndOfDayCommoditygroupSummary commoditygroupSummary = new EndOfDayCommoditygroupSummary();

		final CommodityGroup commodityGroup = new CommodityGroup.Builder().id(
			nullStringToNull(obj, "commodityGroup")).build();

		commoditygroupSummary.setCommodityGroup(commodityGroup);

		commoditygroupSummary.setDiscountAmount(new BigDecimal(
			String.valueOf(obj.getDouble("discountAmount"))));

		commoditygroupSummary.setItems(new BigDecimal(String.valueOf(obj.getDouble("items"))));

		commoditygroupSummary.setRevenue(new BigDecimal(String.valueOf(obj.getDouble("revenue"))));


		return commoditygroupSummary;

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
