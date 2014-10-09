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

	public static EndOfDayAccountSummary fromJSON(final JSONObject obj) throws JSONException
	{

		final EndOfDayAccountSummary endOfDayAccountSummary = new EndOfDayAccountSummary();

		final Account account = new Account.Builder().uuid(obj.getString("account")).build();

		endOfDayAccountSummary.setAccount(account);

		endOfDayAccountSummary.setAmount(new BigDecimal(String.valueOf(obj.getDouble("amount"))));

		endOfDayAccountSummary.setTransactions(new BigDecimal(
			String.valueOf(obj.getDouble("transactions"))));

		return endOfDayAccountSummary;
	}

	public Account getAccount()
	{
		return account;
	}


	public void setAccount(final Account account)
	{
		this.account = account;
	}


	public BigDecimal getAmount()
	{
		return amount;
	}


	public void setAmount(final BigDecimal amount)
	{
		this.amount = amount;
	}


	public EndOfDayStatement getEndOfDayStatement()
	{
		return endOfDayStatement;
	}


	public void setEndOfDayStatement(final EndOfDayStatement endOfDayStatement)
	{
		this.endOfDayStatement = endOfDayStatement;
	}


	public BigDecimal getTransactions()
	{
		return transactions;
	}


	public void setTransactions(final BigDecimal transactions)
	{
		this.transactions = transactions;
	}
}
