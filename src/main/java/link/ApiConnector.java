package link;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;

/**
 * This Class is our Interface to the Cloud
 * 
 * @author Gordon Bosch
 * 
 */
public class ApiConnector
{
	private final String cloudURL;
	private final String token;

	public ApiConnector(String cloudURL, String token)
	{
		super();
		this.cloudURL = cloudURL;
		this.token = token;
	}

	/**
	 * trustAllCerts is accepting all Certs in Case we are handling a Https-Connection
	 */
	private final static TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager()
	{
		@Override
		public X509Certificate[] getAcceptedIssuers()
		{
			return null;
		}

		@Override
		public void checkClientTrusted(X509Certificate[] certs, String authType)
		{
		}

		@Override
		public void checkServerTrusted(X509Certificate[] certs, String authType)
		{
		}
	} };

	/**
	 * applies our low-security Profile to our Connection
	 */
	private void setupConnection()
	{
		try
		{
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Gets an Object from the Cloud
	 * 
	 * @param type
	 * @param reference
	 * @return
	 * @throws IOException 
	 */
	public StringBuffer fetchData(DataType type, String reference) throws IOException
	{	
		String url;
		String slash = "";
		
		
		if (!cloudURL.endsWith("/"))
			slash = "/";
		
			url = cloudURL + slash + token + "/" + type.getReference() + reference;
				
		
		URL obj;
		obj = new URL(url);
		URLConnection con;
		if (cloudURL.contains("https"))
		{
			setupConnection();
			con = (HttpsURLConnection)obj.openConnection();
		}
		else
		{
			con = (HttpURLConnection)obj.openConnection();
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null)
		{
			response.append(inputLine);
		}
		in.close();
		//System.out.println("APICON:GET -> Type:"+type.getReference()+" JSON="+response.toString());
		return response;

	}

	/**
	 * saves a JSONObject in the Cloud
	 * 
	 * @param type
	 * @param obj
	 * @return
	 */
	public boolean postData(DataType type, JSONObject obj)
	{
		String slash = "";
		if (!cloudURL.endsWith("/"))
			slash = "/";
		String url = cloudURL + slash + token + "/" + type.getReference() + "/save/";
		try
		{
			String uuid = null;
			int nr = 0;
			if (obj.has("uuid") && !obj.opt("uuid").equals(null))
			{
				nr = CloudLink.getNumberByUuid(type, obj.opt("uuid").toString());
			}
			else
			{
				if (obj.has("number") && !obj.opt("number").equals(null))
					uuid = CloudLink.getUUIDByNumber(type, obj.opt("number").toString());
				else
				{
					if (obj.opt("name") != null && obj.opt("name").toString().length() > 0)
					{
						uuid = CloudLink.getUUIDByName(type, obj.opt("name").toString());
						nr = CloudLink.getNumberByName(type, obj.opt("name").toString());
					}
				}
			}
			if (uuid != null)
				obj.put("uuid", uuid);
			if (nr > 0)
				obj.put("number", nr);
			URL posturl = new URL(url);
			HttpURLConnection con;
			if (cloudURL.contains("https"))
			{
				setupConnection();
				con = (HttpsURLConnection)posturl.openConnection();
			}
			else
			{
				con = (HttpURLConnection)posturl.openConnection();
			}
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.setConnectTimeout(10000);
			con.setReadTimeout(10000);
			con.setUseCaches(false);
			con.setRequestProperty("Content-Type", "application/json");
			con.connect();

			OutputStream out = con.getOutputStream();
			OutputStreamWriter wr = new OutputStreamWriter(out, "UTF-8");
			wr.write(obj.toString());
			wr.flush();
			wr.close();
			if (out != null)
				out.close();
			if (con.getResponseCode() == 200)
			{
				System.out.println("APICON:POST -> Type:"+type.getReference()+" JSON="+obj.toString());
				con.disconnect(); // Disconnect
				return true;
			}
			else
			{
				System.out.println("ERR: APICON:POST -> Type:"+type.getReference()+" JSON="+obj.toString());

				con.disconnect(); // Disconnect
				System.out.println("Error: " + con.getResponseMessage() + ":" +
					con.getResponseCode());
				return false;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
		catch (JSONException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * saves a JSONArray in the Cloud
	 * 
	 * @param type
	 * @param obj
	 * @return
	 */
	public boolean postData(DataType type, JSONArray obj)
	{
		String slash = "";
		if (!cloudURL.endsWith("/"))
			slash = "/";
		String url = cloudURL + slash + token + "/" + type.getReference() + "/saveAll/";
		try
		{
			URL posturl = new URL(url);
			HttpURLConnection con;
			if (cloudURL.contains("https"))
			{
				setupConnection();
				con = (HttpsURLConnection)posturl.openConnection();
			}
			else
			{
				con = (HttpURLConnection)posturl.openConnection();
			}
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.setConnectTimeout(10000);
			con.setReadTimeout(10000);
			con.setUseCaches(false);
			con.setRequestProperty("Content-Type", "application/json");
			con.connect();

			OutputStream out = con.getOutputStream();
			OutputStreamWriter wr = new OutputStreamWriter(out, "UTF-8");
			wr.write(obj.toString());
			wr.flush();
			wr.close();
			if (out != null)
				out.close();
			if (con.getResponseCode() == 200)
			{
				System.out.println("APICON:POST -> Type:"+type.getReference()+" JSON="+obj.toString());
				con.disconnect(); // Disconnect
				return true;
			}
			else
			{
				System.out.println("ERR: APICON:POST -> Type:"+type.getReference()+" JSON="+obj.toString());

				con.disconnect(); // Disconnect
				System.out.println("Error: " + con.getResponseMessage() + ":" +
					con.getResponseCode());
				return false;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
