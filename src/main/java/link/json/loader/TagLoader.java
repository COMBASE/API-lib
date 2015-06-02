package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Tag;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

public class TagLoader extends AbstractHasNameJsonLoader<Tag>
{

	public TagLoader(final CloudLink cloudLink)
	{
		super(DataType.tag, cloudLink);
	}

	@Override
	public Tag fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Tag tag = Tag.fromJSON(obj);
		return tag;
	}

	@Override
	public Tag postAndResolve(final Tag obj) throws JSONException, ParseException,
	KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		LOGGER.debug(super.getDataType() + ": Nothing to resolve and to pre-post");

		return post(obj);
	}

	@Override
	public JSONObject toJSON(final Tag value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

}
