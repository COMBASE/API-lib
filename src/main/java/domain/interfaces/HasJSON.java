package domain.interfaces;

import org.codehaus.jettison.json.JSONObject;

import domain.AbstractApiObject;

public interface HasJSON<T extends AbstractApiObject>
{
	T fromJSON(final JSONObject obj);

	JSONObject toJSON();
}
