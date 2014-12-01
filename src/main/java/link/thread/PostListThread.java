/**
 * Copyright 2012 COMBASE AG
 */
package link.thread;

import link.CloudLink;

import org.codehaus.jettison.json.JSONArray;

import domain.DataType;

/**
 * @author Gordon Bosch
 * 
 */
public class PostListThread extends Thread
{
	JSONArray array;
	DataType type;
	String ret;

	public PostListThread(final DataType type, final JSONArray array)
	{
		super();
		this.array = array;
		this.type = type;
	}

	@Override
	public void run()
	{
// System.out.println("start: " + new Date());
		ret = CloudLink.getConnector().postData(type, array);
// System.out.println("end: " + new Date());
	}

	public String getReturn()
	{
		return ret;
	}
}
