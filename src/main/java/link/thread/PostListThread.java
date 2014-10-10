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

	public PostListThread(final JSONArray array)
	{
		super();
		this.array = array;
	}

	@Override
	public void run()
	{
// System.out.println("start: " + new Date());
		CloudLink.getConnector().postData(DataType.product, array);
// System.out.println("end: " + new Date());
	}
}
