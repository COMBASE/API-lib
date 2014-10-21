/**
 * Copyright 2012 COMBASE AG
 */
package domain.interfaces;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * @author Gordon Bosch
 * 
 */
public interface HasJSON<T>
{
	public void readJSON(final JSONObject obj) throws JSONException;

	public void writeJSON(final JSONObject obj) throws JSONException;

}
