package framework.fincoEntry;

import java.time.LocalDate;

public class Entry implements FincoEntry {
	private double amount;
	private LocalDate date;
	private String transType;

	public Entry(double amount) {
		this.amount = amount;
		date = LocalDate.now();
	}

	public Entry(double amount, String transType) {
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
