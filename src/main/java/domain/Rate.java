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

	public Rate(BigDecimal rate, Date validFrom)
	{
		super();
		this.rate = rate;
		this.validFrom = validFrom;
	}

	public BigDecimal getRate()
	{
		return rate;
	}

	public void setRate(BigDecimal rate)
	{
		this.rate = rate;
	}

	public Date getValidFrom()
	{
		return validFrom;
	}

	public void setValidFrom(Date validFrom)
	{
		this.validFrom = validFrom;
	}

	public JSONObject toJSON()
	{
		try
		{
			JSONObject obj = new JSONObject();
			obj.put("rate", rate.toString());
			obj.put("validFrom", inputDf.format(validFrom));
			return obj;
		}
		catch (JSONException e)
		{
			e.printStackTrace();
			return null;
		}

	}
}
