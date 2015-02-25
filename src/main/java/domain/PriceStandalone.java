package domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class PriceStandalone extends AbstractNumberApiObject<PriceStandalone>
{

	public static class Builder extends Init<Builder>
	{

		@Override
		protected Builder self()
		{
			return this;
		}

	}

	protected static abstract class Init<T extends Init<T>> extends AbstractNumberApiObject.Init<T>
	{
		private Pricelist priceList = null;
		private Date validFrom = null;
		private BigDecimal value = null;
		private OrganizationalUnit organizationalUnit = null;
		private String ident = null;


		@Override
		public PriceStandalone build()
		{
			return new PriceStandalone(this);
		}

		public T priceList(final Pricelist value)
		{
			this.priceList = value;
			return self();
		}

		public T validFrom(final Date value)
		{
			this.validFrom = value;
			return self();
		}

		public T value(final BigDecimal value)
		{
			this.value = value;
			return self();
		}

		public T organizationalUnit(final OrganizationalUnit value)
		{
			this.organizationalUnit = value;
			return self();
		}

		public T ident(final Product product)
		{
			if (product.getId() != null)
				this.ident = product.getId();
			else
				this.ident = product.getNumber();

			return self();
		}

	}

	private static final long serialVersionUID = 608163316096818194L;

	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

	private Pricelist priceList;
	private Date validFrom;
	private BigDecimal value;
	private OrganizationalUnit organizationalUnit;
	private final String ident;

	public PriceStandalone(final Init<?> init)
	{
		super(init);
		this.organizationalUnit = init.organizationalUnit;
		this.priceList = init.priceList;
		this.validFrom = init.validFrom;
		this.value = init.value;
		this.ident = init.ident;
	}

	@Override
	public JSONObject toJSON()
	{

		final JSONObject obj = new JSONObject();

		try
		{

			obj.put("ident", ident);

			if (priceList != null)
				if (priceList.getId() != null)
					obj.put("priceList", priceList.getId());
				else
					obj.put("priceList", priceList.getNumber());

			if (validFrom != null)
				obj.put("validFrom", inputDf.format(validFrom));

			obj.put("value", value);

			if (organizationalUnit != null)
				if (organizationalUnit.getId() != null)
					obj.put("organizationalUnit", organizationalUnit.getId());
				else
					obj.put("organizationalUnit", organizationalUnit.getNumber());

			return obj;

		}
		catch (final JSONException e)
		{

			e.printStackTrace();

			return null;

		}
	}

	public Pricelist getPriceList()
	{
		return priceList;
	}

	public void setPriceList(final Pricelist priceList)
	{
		this.priceList = priceList;
	}

	public BigDecimal getValue()
	{
		return value;
	}

	public OrganizationalUnit getOrganizationalUnit()
	{
		return organizationalUnit;
	}

	public void setValue(final BigDecimal value)
	{
		this.value = value;
	}

	public void setOrganizationalUnit(final OrganizationalUnit organizationalUnit)
	{
		this.organizationalUnit = organizationalUnit;
	}

	public Date getValidFrom()
	{
		return validFrom;
	}

	public void setValidFrom(final Date validFrom)
	{
		this.validFrom = validFrom;
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

		result = prime * result + ((this.priceList == null) ? 0 : this.priceList.hashCode());
		result = prime * result + ((this.validFrom == null) ? 0 : this.validFrom.hashCode());
		result = prime * result + ((this.value == null) ? 0 : this.value.hashCode());
		result = prime * result + ((this.ident == null) ? 0 : this.ident.hashCode());

		return result;
	}

}
