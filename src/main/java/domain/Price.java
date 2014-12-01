package domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Price
{
	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
	private Pricelist priceList;
	private Date validFrom;
	private BigDecimal value;
	private OrganizationalUnit organizationalUnit;

	public Price(final Pricelist priceList, final Date validFrom, final BigDecimal value,
		final OrganizationalUnit organizationalUnit)
	{
		super();
		this.priceList = priceList;
		this.validFrom = validFrom;
		this.value = value;
		this.organizationalUnit = organizationalUnit;
	}

	/**
	 * old contructor
	 * 
	 * @param priceList
	 * @param validFrom
	 * @param value
	 */
	public Price(final Pricelist priceList, final Date validFrom, final BigDecimal value)
	{
		super();
		this.priceList = priceList;
		this.validFrom = validFrom;
		this.value = value;
	}

	public JSONObject toJSON()
	{
		final JSONObject obj = new JSONObject();
		try
		{
			obj.put("priceList", priceList.getId());
			obj.put("validFrom", inputDf.format(validFrom));
			obj.put("value", value);
			if (organizationalUnit != null)
				obj.put("organizationalUnit", organizationalUnit.getId());
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


		return result;
	}

}
