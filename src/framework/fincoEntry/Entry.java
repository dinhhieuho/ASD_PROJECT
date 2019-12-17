package framework.fincoEntry;
import java.time.LocalDate;

public class Entry implements FincoEntry{
	private double amount;
	private LocalDate date;
	
	public Entry(double amount) {
		this.amount = amount;
		date = LocalDate.now();
	}
	
	@Override
	public String toString() {
		return "Amount: $"+amount+" Date:"+date;
	}
}
