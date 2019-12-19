package framework.entry;

import java.time.LocalDate;

public interface Entry {
	public double getAmount(); 
	public LocalDate getTransDate();
	public String getTransType();
}
