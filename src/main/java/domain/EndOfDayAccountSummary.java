package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class EndOfDayAccountSummary
{

	private Account account = null;

	public BigDecimal amount = null;

	public EndOfDayStatement endOfDayStatement = null;

	public BigDecimal transactions = null;

	public Account getAccount()
	{
		return account;
	}

	public BigDecimal getAmount()
	{
		return amount;
	}

	public EndOfDayStatement getEndOfDayStatement()
	{
		return endOfDayStatement;
	}


	public BigDecimal getTransactions()
	{
		return transactions;
	}


	public void setAccount(final Account account)
	{
		this.account = account;
	}


	public void setAmount(final BigDecimal amount)
	{
		this.amount = amount;
	}


	public void setEndOfDayStatement(final EndOfDayStatement endOfDayStatement)
	{
		this.endOfDayStatement = endOfDayStatement;
	}


	public void setTransactions(final BigDecimal transactions)
	{
		this.transactions = transactions;
	}


	public static EndOfDayAccountSummary fromJSON(final JSONObject obj) throws JSONException
	{

		final EndOfDayAccountSummary endOfDayAccountSummary = new EndOfDayAccountSummary();

		final Account account = new Account.Builder().id(nullStringToNull(obj, "account")).build();

		endOfDayAccountSummary.setAccount(account);

		endOfDayAccountSummary.setAmount(new BigDecimal(String.valueOf(obj.getDouble("amount"))));

		endOfDayAccountSummary.setTransactions(new BigDecimal(
			String.valueOf(obj.getDouble("transactions"))));

		return endOfDayAccountSummary;
	}


	/**
	 *
	 * @param obj
	 * @param value
	 * @return
	 * @throws JSONException
	 */
	protected static String nullStringToNull(final JSONObject obj, final String value)
		throws JSONException
	{
		if (obj.getString(value).equalsIgnoreCase("null"))
			return null;
		return obj.getString(value);
	}
}
