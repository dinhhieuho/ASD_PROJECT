package framework.fincoEntry;

import java.time.LocalDate;

public interface FincoEntry {
	public double getAmount(); 
	public LocalDate getTransDate();
	public String getTransType();
}
