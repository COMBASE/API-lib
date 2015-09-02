package domain;

import java.math.BigDecimal;


public class TaxPayments
{
	private String salesTax;
	private BigDecimal currentTaxRate;
	private BigDecimal amount;
	private BigDecimal netAmount;
	private BigDecimal grossAmount;

	public TaxPayments(final String salesTax, final BigDecimal currentTaxRate,
		final BigDecimal amount, final BigDecimal netAmount, final BigDecimal grossAmount)
	{
		super();
		this.salesTax = salesTax;
		this.currentTaxRate = currentTaxRate;
		this.amount = amount;
		this.netAmount = netAmount;
		this.grossAmount = grossAmount;
	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public BigDecimal getAmount()
	{
		return amount;
	}

	public BigDecimal getCurrentTaxRate()
	{
		return currentTaxRate;
	}

	public BigDecimal getGrossAmount()
	{
		return grossAmount;
	}

	public BigDecimal getNetAmount()
	{
		return netAmount;
	}

	public String getSalesTax()
	{
		return salesTax;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = prime * result + ((this.salesTax == null) ? 0 : this.salesTax.hashCode());


		return result;
	}

	public void setAmount(final BigDecimal amount)
	{
		this.amount = amount;
	}

	public void setCurrentTaxRate(final BigDecimal currentTaxRate)
	{
		this.currentTaxRate = currentTaxRate;
	}

	public void setGrossAmount(final BigDecimal grossAmount)
	{
		this.grossAmount = grossAmount;
	}

	public void setNetAmount(final BigDecimal netAmount)
	{
		this.netAmount = netAmount;
	}

	public void setSalesTax(final String salesTax)
	{
		this.salesTax = salesTax;
	}


}
