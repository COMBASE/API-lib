package domain.interfaces;

import java.io.IOException;

import error.ApiNotReachableException;

public interface IsPostable
{
	boolean post() throws IOException, ApiNotReachableException;
}
