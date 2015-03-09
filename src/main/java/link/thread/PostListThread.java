package link.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.Callable;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.codehaus.jettison.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.DataType;
import error.ApiNotReachableException;

public class PostListThread implements Callable<String>
{

	private final static Logger LOGGER = LoggerFactory.getLogger(PostListThread.class);

	private final String cloudURL;
	private final String token;
	private final DataType type;
	private final JSONArray obj;
	private String ret;

	public PostListThread(final String cloudURL, final String token, final DataType type,
		final JSONArray jsonArray)
	{

		super();

		this.cloudURL = cloudURL;

		this.token = token;

		this.type = type;

		this.obj = jsonArray;

	}

	public String getReturn()
	{
		return ret;
	}

	/**
	 * applies our low-security Profile to our Connection
	 */
	private void setupConnection()
	{
		try
		{
			final SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		}
		catch (final Exception e)
		{
			LOGGER.error(e.getMessage());
		}
	}

	private final static TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager()
	{
		@Override
		public void checkClientTrusted(final X509Certificate[] certs, final String authType)
		{
		}

		@Override
		public void checkServerTrusted(final X509Certificate[] certs, final String authType)
		{
		}

		@Override
		public X509Certificate[] getAcceptedIssuers()
		{
			return null;
		}
	} };

	@Override
	public String call() throws ApiNotReachableException
	{

		String slash = "";
		if (!cloudURL.endsWith("/"))
			slash = "/";
		final String url = cloudURL + slash + token + "/" + type.getReference() + "/saveAll/";
		try
		{
			final URL posturl = new URL(url);
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
			con.setConnectTimeout(3000000);
			con.setReadTimeout(3000000);
			con.setUseCaches(false);
			con.setRequestProperty("Content-Type", "application/json");
			con.connect();

			final OutputStream out = con.getOutputStream();
			final OutputStreamWriter wr = new OutputStreamWriter(out, "UTF-8");
			wr.write(obj.toString());
			wr.flush();
			wr.close();
			if (out != null)
				out.close();
			if (con.getResponseCode() == 200)
			{
				final BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream(), "UTF-8"));
				String inputLine;
				final StringBuilder response = new StringBuilder();
				while ((inputLine = in.readLine()) != null)
				{
					response.append(inputLine);
				}
				in.close();
				LOGGER.info("APICON:POST -> Type:" + type.getReference());
				con.disconnect(); // Disconnect

				ret = response.toString();

				return response.toString();

			}

			// ErrorCode 400 handling
			else
			{
				final BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream(), "UTF-8"));
				String inputLine;
				final StringBuilder response = new StringBuilder();
				while ((inputLine = in.readLine()) != null)
				{
					response.append(inputLine);
				}
				in.close();

				LOGGER.error("APICON:FAILED POST -> Type:" + type.getReference());

				con.disconnect(); // Disconnect
				LOGGER.error(String.valueOf(con.getResponseCode()));
				return response.toString();
			}
		}
		catch (final IOException e)
		{
			LOGGER.error(type.toString() + obj.toString(), e);
			throw new ApiNotReachableException(url, null);
		}
	}
}