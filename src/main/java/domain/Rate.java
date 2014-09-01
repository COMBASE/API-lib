package domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Rate
{
	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
	private BigDecimal rate;
	private Date validFrom;

	public Rate(final BigDecimal rate, final Date validFrom)
	{
		super();
		this.rate = rate;
		this.validFrom = validFrom;
	}

	public BigDecimal getRate()
	{
		return rate;
	}

	public void setRate(final BigDecimal rate)
	{
		this.rate = rate;
	}

	public Date getValidFrom()
	{
		return validFrom;
	}

	public void setValidFrom(final Date validFrom)
	{
		this.validFrom = validFrom;
	}

	public JSONObject toJSON()
	{
		try
		{
			final JSONObject obj = new JSONObject();
			obj.put("rate", rate.toString());
			obj.put("validFrom", inputDf.format(validFrom));
			return obj;
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
			return null;
		}

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

		result = prime * result + ((this.rate == null) ? 0 : this.rate.hashCode());
		result = prime * result + ((this.validFrom == null) ? 0 : this.validFrom.hashCode());


		return result;
	}
}
