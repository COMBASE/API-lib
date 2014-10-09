package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONObject;

public class EndOfDayCashierSummary
{
	private BigDecimal cancalledItemsAmount = null;

	private BigDecimal cancalledItemsCount = null;

	private BigDecimal cancalledReceiptsAmount = null;

	private BigDecimal cancalledReceiptsCount = null;

	private Cashier cashier = null;

	private BigDecimal receiptsAmount = null;

	private BigDecimal receiptsCount = null;

	private BigDecimal returnsAmount = null;

	private BigDecimal returnsCount = null;

	private BigDecimal voidedReceiptsAmount = null;

	private BigDecimal voidedReceiptsCount = null;

	private EndOfDayStatement endOfDayStatement = null;

	public BigDecimal getCancalledItemsAmount()
	{
		return cancalledItemsAmount;
	}

	public void setCancalledItemsAmount(final BigDecimal cancalledItemsAmount)
	{
		this.cancalledItemsAmount = cancalledItemsAmount;
	}

	public BigDecimal getCancalledItemsCount()
	{
		return cancalledItemsCount;
	}

	public void setCancalledItemsCount(final BigDecimal cancalledItemsCount)
	{
		this.cancalledItemsCount = cancalledItemsCount;
	}

	public BigDecimal getCancalledReceiptsAmount()
	{
		return cancalledReceiptsAmount;
	}

	public void setCancalledReceiptsAmount(final BigDecimal cancalledReceiptsAmount)
	{
		this.cancalledReceiptsAmount = cancalledReceiptsAmount;
	}

	public BigDecimal getCancalledReceiptsCount()
	{
		return cancalledReceiptsCount;
	}

	public void setCancalledReceiptsCount(final BigDecimal cancalledReceiptsCount)
	{
		this.cancalledReceiptsCount = cancalledReceiptsCount;
	}

	public Cashier getCashier()
	{
		return cashier;
	}

	public void setCashier(final Cashier cashier)
	{
		this.cashier = cashier;
	}

	public BigDecimal getReceiptsAmount()
	{
		return receiptsAmount;
	}

	public void setReceiptsAmount(final BigDecimal receiptsAmount)
	{
		this.receiptsAmount = receiptsAmount;
	}

	public BigDecimal getReceiptsCount()
	{
		return receiptsCount;
	}

	public void setReceiptsCount(final BigDecimal receiptsCount)
	{
		this.receiptsCount = receiptsCount;
	}

	public BigDecimal getReturnsAmount()
	{
		return returnsAmount;
	}

	public void setReturnsAmount(final BigDecimal returnsAmount)
	{
		this.returnsAmount = returnsAmount;
	}

	public BigDecimal getReturnsCount()
	{
		return returnsCount;
	}

	public void setReturnsCount(final BigDecimal returnsCount)
	{
		this.returnsCount = returnsCount;
	}

	public BigDecimal getVoidedReceiptsAmount()
	{
		return voidedReceiptsAmount;
	}

	public void setVoidedReceiptsAmount(final BigDecimal voidedReceiptsAmount)
	{
		this.voidedReceiptsAmount = voidedReceiptsAmount;
	}

	public BigDecimal getVoidedReceiptsCount()
	{
		return voidedReceiptsCount;
	}

	public void setVoidedReceiptsCount(final BigDecimal voidedReceiptsCount)
	{
		this.voidedReceiptsCount = voidedReceiptsCount;
	}

	public EndOfDayStatement getEndOfDayStatement()
	{
		return endOfDayStatement;
	}

	public void setEndOfDayStatement(final EndOfDayStatement endOfDayStatement)
	{
		this.endOfDayStatement = endOfDayStatement;
	}

	public static EndOfDayCashierSummary fromJSON(final JSONObject jEndOfDayCashierSummary)
	{
		final EndOfDayCashierSummary cashierSummary = new EndOfDayCashierSummary();


		return cashierSummary;
	}
}
