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
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		final AssortmentValidity assortmentValidity = new AssortmentValidity();

		final Assortment assortment = new Assortment.Builder().id(obj.getString("assortment"))
			.build();

		assortmentValidity.setAssortment(assortment);

		assortmentValidity.setValidFrom(inputDf.parse(obj.getString("validFrom")));

		assortmentValidity.setValidTo(inputDf.parse(obj.getString("validTo")));

		return assortmentValidity;
	}

	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();

		obj.put("assortment", assortment.getId());
		obj.put("validFrom", validFrom);
		obj.put("validTo", validTo);

		return obj;
	}

	public Assortment getAssortment()
	{
		return assortment;
	}

	public void setAssortment(final Assortment assortment)
	{
		this.assortment = assortment;
	}

	public Date getValidTo()
	{
		return validTo;
	}

	public void setValidTo(final Date validTo)
	{
		this.validTo = validTo;
	}

	public Date getValidFrom()
	{
		return validFrom;
	}

	public void setValidFrom(final Date validFrom)
	{
		this.validFrom = validFrom;
	}


}
