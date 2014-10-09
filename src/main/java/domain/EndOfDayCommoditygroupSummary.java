package domain;

import java.math.BigDecimal;

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

	public void setCommodityGroup(final CommodityGroup commodityGroup)
	{
		this.commodityGroup = commodityGroup;
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

	public static EndOfDayCommoditygroupSummary fromJSON(
		final JSONObject jEndOfDayCommoditygroupSummary)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
