/**
 * Copyright 2012 COMBASE AG
 */
package link.thread;

import java.util.concurrent.Callable;

import link.CloudLink;

import org.codehaus.jettison.json.JSONArray;

import domain.DataType;
import error.ArticleCodeMustBeUniqueException;

/**
 * @author Gordon Bosch
 *
 */

public class PostListThread implements Callable<String>
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

	public String getReturn()
	{
		return ret;
	}

	@Override
	public String call() throws ArticleCodeMustBeUniqueException
	{
		ret = CloudLink.getConnector().postData(type, array);

		return ret;
	}
}
