package link.json.uploader;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.AbstractApiObject.ApiObjectBuilder;
import domain.interfaces.HasId;

public abstract class AbstractApiObjectUploader<T extends HasId>
{

	public T post(final T value) throws JSONException
	{
		final String result = CloudLink.getConnector().postData(value.getDataType(), toJSON(value));
		final JSONObject obj = new JSONObject(result);


		return null;
	}

	public abstract ApiObjectBuilder<T> getBuilder();

	public JSONObject toJSON(final T value) throws JSONException
	{
		return getBuilder().toJSON(value);
	}

	public T fromJSON(final JSONObject obj) throws JSONException
	{
		return getBuilder().fromJSON(obj);
	}
}
