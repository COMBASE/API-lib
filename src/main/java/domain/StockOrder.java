package domain;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class StockOrder extends AbstractNumberApiObject<StockOrder>
{

	private static final long serialVersionUID = -2586046426436166290L;

	private final Date requiredFrom;
	private final Date requiredTo;
	private final Date pickUpDate;
	private final Date autoFinalization;
	private final Boolean autoSend;
	private final Date posFinalizationTime;
	private final Date dispatchNotificationCreationTime;
	private final Date stockReceiptCreationTime;
	private final Date stockReceiptFinalizationTime;
	private final Date returnCreationTime;
	private final Date bookingTime;
	private final Date createTime;
	private final Boolean send;
	private final String currency;
	private final String specialOfferCode;
	private final String bookedBy;
	private final String createdBy;
	private final String target;
	private final String supplier;
	private final String source;
	private final String description;
	private final List<StockOrderItem> items;

	public StockOrder(final Init<?> init)
	{
		super(init);
		requiredFrom = init.requiredFrom;
		requiredTo = init.requiredTo;
		pickUpDate = init.pickUpDate;
		autoFinalization = init.autoFinalization;
		autoSend = init.autoSend;
		posFinalizationTime = init.posFinalizationTime;
		dispatchNotificationCreationTime = init.dispatchNotificationCreationTime;
		stockReceiptCreationTime = init.stockReceiptCreationTime;
		stockReceiptFinalizationTime = init.stockReceiptFinalizationTime;
		returnCreationTime = init.returnCreationTime;
		bookingTime = init.bookingTime;
		createTime = init.createTime;

		send = init.send;

		currency = init.currency;
		specialOfferCode = init.specialOfferCode;
		bookedBy = init.bookedBy;
		createdBy = init.createdBy;
		target = init.target;
		supplier = init.supplier;
		source = init.source;
		description = init.description;
		items = init.items;
	}

	protected static abstract class Init<T extends Init<T>> extends AbstractNumberApiObject.Init<T>
	{
		private Date requiredFrom = null;
		private Date requiredTo = null;
		private Date pickUpDate = null;
		private Date autoFinalization = null;
		private Boolean autoSend = null;
		private Date posFinalizationTime = null;
		private Date dispatchNotificationCreationTime = null;
		private Date stockReceiptCreationTime = null;
		private Date stockReceiptFinalizationTime = null;
		private Date returnCreationTime = null;
		private Date bookingTime = null;
		private Date createTime = null;

		private Boolean send = null;

		private String currency = null;
		private String specialOfferCode = null;
		private String bookedBy = null;
		private String createdBy = null;
		private String target = null;
		private String supplier = null;
		private String source = null;
		private String description = null;
		private List<StockOrderItem> items = null;

		public T requiredFrom(final Date value)
		{
			this.requiredFrom = value;
			return self();
		}

		public T requiredTo(final Date value)
		{
			this.requiredTo = value;
			return self();
		}

		public T pickUpDate(final Date value)
		{
			this.pickUpDate = value;
			return self();
		}

		public T autoFinalization(final Date value)
		{
			this.autoFinalization = value;
			return self();
		}

		public T autoSend(final Boolean value)
		{
			this.autoSend = value;
			return self();
		}

		public T posFinalizationTime(final Date value)
		{
			this.posFinalizationTime = value;
			return self();
		}

		public T dispatchNotificationCreationTime(final Date value)
		{
			this.dispatchNotificationCreationTime = value;
			return self();
		}

		public T stockReceiptCreationTime(final Date value)
		{
			this.stockReceiptCreationTime = value;
			return self();
		}

		public T stockReceiptFinalizationTime(final Date value)
		{
			this.stockReceiptFinalizationTime = value;
			return self();
		}

		public T returnCreationTime(final Date value)
		{
			this.returnCreationTime = value;
			return self();
		}

		public T bookingTime(final Date value)
		{
			this.bookingTime = value;
			return self();
		}

		public T createTime(final Date value)
		{
			this.createTime = value;
			return self();
		}

		public T send(final Boolean value)
		{
			this.send = value;
			return self();
		}

		public T currency(final String value)
		{
			this.currency = value;
			return self();
		}

		public T specialOfferCode(final String value)
		{
			this.specialOfferCode = value;
			return self();
		}

		public T bookedBy(final String value)
		{
			this.bookedBy = value;
			return self();
		}

		public T createdBy(final String value)
		{
			this.createdBy = value;
			return self();
		}

		public T target(final String value)
		{
			this.target = value;
			return self();
		}

		public T supplier(final String value)
		{
			this.supplier = value;
			return self();
		}

		public T source(final String value)
		{
			this.source = value;
			return self();
		}

		public T description(final String value)
		{
			this.description = value;
			return self();
		}

		public T items(final List<StockOrderItem> value)
		{
			this.items = value;
			return self();
		}

		@Override
		public StockOrder build()
		{
			return new StockOrder(this);
		}
	}

	public static class Builder extends Init<Builder>
	{

		@Override
		protected Builder self()
		{
			return this;
		}

	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = super.hashCode(result);
		result = prime * result + ((this.requiredFrom == null) ? 0 : this.requiredFrom.hashCode());
		result = prime * result + ((this.requiredTo == null) ? 0 : this.requiredTo.hashCode());
		result = prime * result + ((this.pickUpDate == null) ? 0 : this.pickUpDate.hashCode());
		result = prime * result +
			((this.autoFinalization == null) ? 0 : this.autoFinalization.hashCode());
		result = prime * result + ((this.autoSend == null) ? 0 : this.autoSend.hashCode());
		result = prime * result +
			((this.posFinalizationTime == null) ? 0 : this.posFinalizationTime.hashCode());
		result = prime *
			result +
			((this.dispatchNotificationCreationTime == null) ? 0
				: this.dispatchNotificationCreationTime.hashCode());
		result = prime *
			result +
			((this.stockReceiptCreationTime == null) ? 0 : this.stockReceiptCreationTime.hashCode());
		result = prime *
			result +
			((this.stockReceiptFinalizationTime == null) ? 0
				: this.stockReceiptFinalizationTime.hashCode());
		result = prime * result +
			((this.returnCreationTime == null) ? 0 : this.returnCreationTime.hashCode());
		result = prime * result + ((this.bookingTime == null) ? 0 : this.bookingTime.hashCode());
		result = prime * result + ((this.createTime == null) ? 0 : this.createTime.hashCode());
		result = prime * result + ((this.send == null) ? 0 : this.send.hashCode());
		result = prime * result + ((this.currency == null) ? 0 : this.currency.hashCode());
		result = prime * result +
			((this.specialOfferCode == null) ? 0 : this.specialOfferCode.hashCode());
		result = prime * result + ((this.bookedBy == null) ? 0 : this.bookedBy.hashCode());
		result = prime * result + ((this.createdBy == null) ? 0 : this.createdBy.hashCode());
		result = prime * result + ((this.target == null) ? 0 : this.target.hashCode());
		result = prime * result + ((this.supplier == null) ? 0 : this.supplier.hashCode());
		result = prime * result + ((this.source == null) ? 0 : this.source.hashCode());
		result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
		result = prime * result + ((this.items == null) ? 0 : this.items.hashCode());

		return result;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		appendJSON(obj);

		if (requiredFrom != null)
			obj.put("requiredFrom", inputDf.format(requiredFrom));

		if (requiredTo != null)
			obj.put("requiredTo", inputDf.format(requiredTo));

		if (pickUpDate != null)
			obj.put("pickUpDate", inputDf.format(pickUpDate));

		if (autoFinalization != null)
			obj.put("autoFinalization", inputDf.format(autoFinalization));

		obj.put("autoSend", autoSend);

		if (posFinalizationTime != null)
			obj.put("posFinalizationTime", inputDf.format(posFinalizationTime));

		if (dispatchNotificationCreationTime != null)
			obj.put("dispatchNotificationCreationTime",
				inputDf.format(dispatchNotificationCreationTime));

		if (stockReceiptCreationTime != null)
			obj.put("stockReceiptCreationTime", inputDf.format(stockReceiptCreationTime));

		if (stockReceiptFinalizationTime != null)
			obj.put("stockReceiptFinalizationTime", inputDf.format(stockReceiptFinalizationTime));

		if (returnCreationTime != null)
			obj.put("returnCreationTime", inputDf.format(returnCreationTime));

		if (bookingTime != null)
			obj.put("bookingTime", inputDf.format(bookingTime));

		if (createTime != null)
			obj.put("createTime", inputDf.format(createTime));

		obj.put("send", send);
		obj.put("currency", currency);
		obj.put("specialOfferCode", specialOfferCode);
		obj.put("bookedBy", bookedBy);
		obj.put("createdBy", createdBy);
		obj.put("target", target);
		obj.put("supplier", supplier);
		obj.put("source", source);
		obj.put("description", description);
		obj.put("items", items);

		return obj;
	}

	public static StockOrder fromJSON(final JSONObject obj) throws ParseException, JSONException
	{

		List<StockOrderItem> items = null;
		if (!obj.isNull("items"))
		{
			items = new ArrayList<StockOrderItem>();
			final JSONArray jsonItems = obj.getJSONArray("items");
			for (int i = 0; i < jsonItems.length(); i++)
			{
				final JSONObject jsonItem = jsonItems.getJSONObject(i);
				final StockOrderItem item = StockOrderItem.fromJSON(jsonItem);
				items.add(item);
			}
		}

		final StockOrder stockOrder = new StockOrder.Builder().deleted(obj.getBoolean("deleted"))
			.number(obj.getString("number"))
			.id(obj.getString("uuid"))
			.revision(obj.getLong("revision"))
			.autoFinalization(prepareDate(obj, "autoFinalization"))
			.autoSend(obj.getBoolean("autoSend"))
			.bookedBy(obj.getString("bookedBy"))
			.bookingTime(prepareDate(obj, "bookingTime"))
			.createdBy(obj.getString("createdBy"))
			.createTime(prepareDate(obj, "createTime"))
			.currency(obj.getString("currency"))
			.description(obj.getString("description"))
			.dispatchNotificationCreationTime(prepareDate(obj, "dispatchNotificationCreationTime"))
			.pickUpDate(prepareDate(obj, "pickUpDate"))
			.posFinalizationTime(prepareDate(obj, "posFinalizationTime"))
			.requiredFrom(prepareDate(obj, "requiredFrom"))
			.requiredTo(prepareDate(obj, "requiredTo"))
			.returnCreationTime(prepareDate(obj, "returnCreationTime"))
			.send(obj.getBoolean("send"))
			.source(obj.getString("source"))
			.specialOfferCode(obj.getString("specialOfferCode"))
			.stockReceiptCreationTime(prepareDate(obj, "stockReceiptCreationTime"))
			.stockReceiptFinalizationTime(prepareDate(obj, "stockReceiptFinalizationTime"))
			.supplier(obj.getString("supplier"))
			.target(obj.getString("target"))
			.items(items)

			.build();

		return stockOrder;
	}
}
