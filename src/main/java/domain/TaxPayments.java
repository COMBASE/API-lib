package domain;


public class TaxPayments
{
	private String salesTax;
	private double currentTaxRate;
	private double amount;

	public TaxPayments(final String salesTax, final double currentTaxRate, final double amount)
	{
		super();
		this.salesTax = salesTax;
		this.currentTaxRate = currentTaxRate;
		this.amount = amount;
	}

	public String getSalesTax()
	{
		return salesTax;
	}

	public void setSalesTax(final String salesTax)
	{
		this.salesTax = salesTax;
	}

	public double getCurrentTaxRate()
	{
		return currentTaxRate;
	}

	public void setCurrentTaxRate(final double currentTaxRate)
	{
		this.currentTaxRate = currentTaxRate;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(final double amount)
	{
		this.amount = amount;
	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = prime * result + ((this.salesTax == null) ? 0 : this.salesTax.hashCode());


		return result;
	}


}
