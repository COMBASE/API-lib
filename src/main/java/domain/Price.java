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

	public Price(Pricelist priceList, Date validFrom, BigDecimal value)
	{
		super();
		this.priceList = priceList;
		this.validFrom = validFrom;
		this.value = value;
	}

	public JSONObject toJSON()
	{
		JSONObject obj = new JSONObject();
		try
		{
			obj.put("priceList", priceList.getUuid());
			obj.put("validFrom", inputDf.format(validFrom));
			obj.put("value", value);
			return obj;
		}
		catch (JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public Pricelist getPriceList()
	{
		return priceList;
	}

	public void setPriceList(Pricelist priceList)
	{
		this.priceList = priceList;
	}

}
