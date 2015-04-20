package domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class FullReceipt extends AbstractNumberApiObject<FullReceipt>
{

	public static class Builder extends Init<Builder>
	{

		@Override
		protected Builder self()
		{
			return this;
		}

	}
	protected static abstract class Init<T extends Init<T>> extends AbstractNumberApiObject.Init<T>
	{
		private Receipt receipt = null;
		private Collection<AccountTransaction> accountTransaction = null;
		private Collection<Payment> payment = null;
		private Collection<Sale> sale = null;


		public T accountTransaction(final AccountTransaction accountTransaction)
		{
			this.accountTransaction.add(accountTransaction);
			return self();
		}

		public T accountTransaction(final Collection<AccountTransaction> col)
		{
			this.accountTransaction = col;
			return self();
		}

		@Override
		public FullReceipt build()
		{
			return new FullReceipt(this);
		}

		public T payment(final Collection<Payment> col)
		{
			this.payment = col;
			return self();
		}

		public T payment(final Payment payment)
		{
			this.payment.add(payment);
			return self();
		}

		public T receipt(final Receipt receipt)
		{
			this.receipt = receipt;
			return self();
		}

		public T sale(final Collection<Sale> col)
		{
			this.sale = col;
			return self();
		}


		public T sale(final Sale sale)
		{
			this.sale.add(sale);
			return self();
		}
	}

	private static final long serialVersionUID = -9145829363016175720L;

	public static FullReceipt fromJSON(JSONObject obj) throws JSONException, ParseException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");


		final FullReceipt fullReceipt = new FullReceipt.Builder().deleted(
			obj.getJSONObject("receipt").getBoolean("deleted"))
			.id(obj.getJSONObject("receipt").getString("uuid"))
			.revision(obj.getJSONObject("receipt").getLong("revision"))
			.number(obj.getJSONObject("receipt").getString("number"))
			.build();

		// receipt
		final JSONObject jReceipt = obj.getJSONObject("receipt");
		final Receipt receipt = Receipt.fromJSON(jReceipt);

		final POS pos = new POS.Builder().id(jReceipt.getString("pos"))
			.number(jReceipt.getString("posNr"))
			.build();
		receipt.setPos(pos);

		final OrganizationalUnit organizationalUnit = new OrganizationalUnit.Builder().id(
			jReceipt.getString("organizationalUnit"))
			.number(jReceipt.getString("organizationalUnitNr"))
			.build();
		receipt.setOrganizationalUnit(organizationalUnit);

		if (!obj.isNull("receipt") && !obj.getJSONObject("receipt").isNull("customer"))
		{
			final Customer customer = new Customer.Builder().id(jReceipt.getString("customer"))
				.number(jReceipt.getString("customerNr"))
				.zipCode(jReceipt.getString("customerZip"))
				.build();
			receipt.setCustomer(customer);
		}


		fullReceipt.setReceipt(receipt);

		// accountTransaction
		if (!obj.isNull("accountTransactions"))
		{
			final JSONArray jAAccountTransaction = obj.getJSONArray("accountTransactions");
			for (int i = 0; i <= jAAccountTransaction.length() - 1; i++)
			{
				final JSONObject jAccountTransaction = jAAccountTransaction.getJSONObject(i);
				final AccountTransaction accountTransaction = AccountTransaction.fromJSON(jAccountTransaction);
				final Account account = new Account.Builder().id(
					jAccountTransaction.getString("account"))
					.number(jAccountTransaction.getString("accountNr"))
					.name(jAccountTransaction.getString("accountDescription"))
					.build();
				accountTransaction.setAccount(account);
				fullReceipt.addAccountTransaction(accountTransaction);
			}
		}

		// payment
		if (!obj.isNull("payments"))
		{
			final JSONArray jAPayment = obj.getJSONArray("payments");
			for (int i = 0; i <= jAPayment.length() - 1; i++)
			{
				final JSONObject jPayment = jAPayment.getJSONObject(i);
				final Payment payment = Payment.fromJSON(jPayment);
				final Currency currency = new Currency.Builder().id(jPayment.getString("currency"))
					.key(jPayment.getString("currencyKey"))
					.build();
				payment.setCurrency(currency);
				final PaymentMethod paymentMethods = new PaymentMethod.Builder().name(
					jPayment.getString("paymentMethodName"))
					.id(jPayment.getString("paymentMethod"))
					.number(jPayment.getString("paymentMethodNr"))
					.build();
				payment.setPaymentMethod(paymentMethods);
				fullReceipt.addPayment(payment);
			}
		}

		// sale
		if (!obj.isNull("sales"))
		{
			final JSONArray jASale = obj.getJSONArray("sales");
			for (int i = 0; i <= jASale.length() - 1; i++)
			{
				final JSONObject jSale = jASale.getJSONObject(i);
				final Sale sale = Sale.fromJSON(jSale);

				Product_Code code = null;
				if (!jSale.isNull("articleEAN"))
					code = new Product_Code(jSale.getString("articleEAN"), new BigDecimal(1));


				final Product product = new Product.Builder().number(jSale.getString("articleNr"))
					.codes(code)
					.id(jSale.getString("article"))
					.build();
				sale.setArticle(product);
				fullReceipt.addSale(sale);
			}
		}

		return fullReceipt;
	}

	private Receipt receipt;

	private Collection<AccountTransaction> accountTransaction;
	private Collection<Payment> payment;

	private Collection<Sale> sale;

	public FullReceipt(final Init<?> init)
	{
		super(init);
		this.receipt = init.receipt;
		this.accountTransaction = init.accountTransaction;
		this.payment = init.payment;
		this.sale = init.sale;

	}

	public void addAccountTransaction(final AccountTransaction accountTransaction)
	{
		if (this.accountTransaction == null)
			this.accountTransaction = new ArrayList<AccountTransaction>();
		this.accountTransaction.add(accountTransaction);
	}

	public void addPayment(final Payment payment)
	{
		if (this.payment == null)
			this.payment = new ArrayList<Payment>();
		this.payment.add(payment);
	}

	public void addSale(final Sale sale)
	{
		if (this.sale == null)
			this.sale = new ArrayList<Sale>();
		this.sale.add(sale);
	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public Collection<AccountTransaction> getAccountTransaction()
	{
		return accountTransaction;
	}

	public Collection<Payment> getPayment()
	{
		return payment;
	}

	public Receipt getReceipt()
	{
		return receipt;
	}

	public Collection<Sale> getSale()
	{
		return sale;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.receipt == null) ? 0 : this.receipt.hashCode());
		result = prime * result +
			((this.accountTransaction == null) ? 0 : this.accountTransaction.hashCode());
		result = prime * result + ((this.payment == null) ? 0 : this.payment.hashCode());
		result = prime * result + ((this.sale == null) ? 0 : this.sale.hashCode());

		return result;
	}

	public void setAccountTransaction(final Collection<AccountTransaction> accountTransaction)
	{
		this.accountTransaction = accountTransaction;
	}

	public void setPayment(final Collection<Payment> payment)
	{
		this.payment = payment;
	}

	public void setReceipt(final Receipt receipt)
	{
		this.receipt = receipt;
	}

	public void setSale(final Collection<Sale> sale)
	{
		this.sale = sale;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		JSONObject obj = new JSONObject();
		obj = appendJSON(obj);
		return obj;
	}

}
