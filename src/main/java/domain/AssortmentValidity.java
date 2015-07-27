package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * used by OrganizationalUnit
 *
 * @author mas
 *
 */
public class AssortmentValidity
{
	protected static final SimpleDateFormat inputDf = new SimpleDateFormat(
		"yyyy-MM-dd'T'HH:mm:ssXXX");
	private Assortment assortment;
	private Date validFrom;
	private Date validTo;

	public AssortmentValidity fromJSON(JSONObject obj) throws JSONException, ParseException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
		{
			obj = obj.getJSONObject("result");
		}

		final AssortmentValidity assortmentValidity = new AssortmentValidity();

		final Assortment assortment = new Assortment.Builder().id(
			nullStringToNull(obj, "assortment")).build();

		assortmentValidity.setAssortment(assortment);

		assortmentValidity.setValidFrom(inputDf.parse(nullStringToNull(obj, "validFrom")));

		assortmentValidity.setValidTo(inputDf.parse(nullStringToNull(obj, "validTo")));

		return assortmentValidity;
	}

	public Assortment getAssortment()
	{
		return assortment;
	}

	public Date getValidFrom()
	{
		return validFrom;
	}

	public Date getValidTo()
	{
		return validTo;
	}

	public void setAssortment(final Assortment assortment)
	{
		this.assortment = assortment;
	}

	public void setValidFrom(final Date validFrom)
	{
		this.validFrom = validFrom;
	}

	public void setValidTo(final Date validTo)
	{
		this.validTo = validTo;
	}

	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();

		obj.put("assortment", assortment.getId());
		if (validFrom != null)
		{
			obj.put("validFrom", inputDf.format(validFrom));
		}
		if (validTo != null)
		{
			obj.put("validTo", inputDf.format(validTo));
		}

		return obj;
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
