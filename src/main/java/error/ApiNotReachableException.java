package error;

public class ApiNotReachableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3069686403943129407L;
	
	private final String url;
	
	public ApiNotReachableException(String url, Throwable cause)
	{
		super(cause);
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	@Override
	public String getLocalizedMessage() {
		StringBuilder ret = new StringBuilder();
		ret.append("Could not reach API with url: ");
		ret.append(getUrl());
		ret.append("\n");
		ret.append(super.getLocalizedMessage());
		return ret.toString();
	}
}
