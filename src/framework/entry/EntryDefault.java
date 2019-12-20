package framework.entry;

import java.time.LocalDate;

public class EntryDefault implements Entry {
	private double amount;
	private LocalDate date;
	private String transType;

	public EntryDefault(double amount) {
		this.amount = amount;
		date = LocalDate.now();
	}

	public EntryDefault(double amount, String transType) {
		this.amount = amount;
		date = LocalDate.now();
		this.transType = transType;
	}

	@Override
	public String toString() {
		return "Amount: $" + amount + " Date:" + date;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public LocalDate getTransDate() {
		return date;
	}

	@Override
	public String getTransType() {
		return transType;
	}
}
