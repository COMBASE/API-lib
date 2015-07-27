package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONException;
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


	public BigDecimal getCancalledItemsCount()
	{
		return cancalledItemsCount;
	}

	public BigDecimal getCancalledReceiptsAmount()
	{
		return cancalledReceiptsAmount;
	}

	public BigDecimal getCancalledReceiptsCount()
	{
		return cancalledReceiptsCount;
	}

	public Cashier getCashier()
	{
		return cashier;
	}

	public EndOfDayStatement getEndOfDayStatement()
	{
		return endOfDayStatement;
	}

	public BigDecimal getReceiptsAmount()
	{
		return receiptsAmount;
	}

	public BigDecimal getReceiptsCount()
	{
		return receiptsCount;
	}

	public BigDecimal getReturnsAmount()
	{
		return returnsAmount;
	}

	public BigDecimal getReturnsCount()
	{
		return returnsCount;
	}

	public BigDecimal getVoidedReceiptsAmount()
	{
		return voidedReceiptsAmount;
	}

	public BigDecimal getVoidedReceiptsCount()
	{
		return voidedReceiptsCount;
	}

	public void setCancalledItemsAmount(final BigDecimal cancalledItemsAmount)
	{
		this.cancalledItemsAmount = cancalledItemsAmount;
	}

	public void setCancalledItemsCount(final BigDecimal cancalledItemsCount)
	{
		this.cancalledItemsCount = cancalledItemsCount;
	}

	public void setCancalledReceiptsAmount(final BigDecimal cancalledReceiptsAmount)
	{
		this.cancalledReceiptsAmount = cancalledReceiptsAmount;
	}

	public void setCancalledReceiptsCount(final BigDecimal cancalledReceiptsCount)
	{
		this.cancalledReceiptsCount = cancalledReceiptsCount;
	}

	public void setCashier(final Cashier cashier)
	{
		this.cashier = cashier;
	}

	public void setEndOfDayStatement(final EndOfDayStatement endOfDayStatement)
	{
		this.endOfDayStatement = endOfDayStatement;
	}

	public void setReceiptsAmount(final BigDecimal receiptsAmount)
	{
		this.receiptsAmount = receiptsAmount;
	}

	public void setReceiptsCount(final BigDecimal receiptsCount)
	{
		this.receiptsCount = receiptsCount;
	}

	public void setReturnsAmount(final BigDecimal returnsAmount)
	{
		this.returnsAmount = returnsAmount;
	}

	public void setReturnsCount(final BigDecimal returnsCount)
	{
		this.returnsCount = returnsCount;
	}

	public void setVoidedReceiptsAmount(final BigDecimal voidedReceiptsAmount)
	{
		this.voidedReceiptsAmount = voidedReceiptsAmount;
	}

	public void setVoidedReceiptsCount(final BigDecimal voidedReceiptsCount)
	{
		this.voidedReceiptsCount = voidedReceiptsCount;
	}

	public static EndOfDayCashierSummary fromJSON(final JSONObject jEndOfDayCashierSummary)
	{
		final EndOfDayCashierSummary cashierSummary = new EndOfDayCashierSummary();


		return cashierSummary;
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
