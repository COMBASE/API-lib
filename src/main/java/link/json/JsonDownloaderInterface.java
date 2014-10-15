package link.json;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import error.ApiNotReachableException;

/**
 * Initialize this class or extend it in order to shortcut proper JSON formatting. Offers several
 * methods for downloading JSON from KORONA.POS Cloud. Please refer to method description.
 * 
 * @author mas
 * 
 */
public interface JsonDownloaderInterface
{

	/**
	 * returns the corresponding org.jettison.JSONObject by name from KORONA.POS Cloud
	 * 
	 * @param name
	 * @return
	 * @throws ApiNotReachableException
	 */
	public JSONObject downloadByName(String name) throws ApiNotReachableException;

	/**
	 * returns the corresponding org.jettison.JSONObject by number from KORONA.POS Cloud
	 * 
	 * @param number
	 * @return
	 * @throws ApiNotReachableException
	 */
	public JSONObject downloadByNumber(String number) throws ApiNotReachableException;

	/**
	 * for proper use you have to ensure that the JSONDownloader Object is kept alive as long you
	 * haven't got all needed JsonObjects!
	 * 
	 * returns an org.jettison.JSONArray of all org.jettison.JSONObjects having the same or greater
	 * revision than the given one from KORONA.POS Cloud. This method is used to download a certain
	 * number of JSONObjects procede them and downloader the next amount of JSONOBjects. Each method
	 * call increases the offset. Ensure to stop looping as this method returns null.
	 * 
	 * @param number
	 * @return JSONArray
	 * @throws ApiNotReachableException
	 */
	public JSONArray downloadByOffset(long revision) throws ApiNotReachableException;

	/**
	 * Returns an org.jettison.JSONArray of all JSONObjects equal or greater than given revision.
	 * 
	 * @param number
	 * @return
	 * @throws ApiNotReachableException
	 */
	public JSONArray downloadByRevision(long revision) throws ApiNotReachableException;

	/**
	 * returns the corresponding org.jettison.JSONObject by UUID from KORONA.POS Cloud
	 * 
	 * @param number
	 * @return
	 * @throws ApiNotReachableException
	 */
	public JSONObject downloadByUUID(String uuid) throws ApiNotReachableException;

	/**
	 * returns an org.jettison.JSONArray of all org.jettison.JSONObjects having the same or greater
	 * revision than the given one from KORONA.POS Cloud.
	 * 
	 * @param revision
	 * @return
	 * @throws ApiNotReachableException
	 */
	public JSONArray downloadAllByOffset(long revision) throws ApiNotReachableException;
}
