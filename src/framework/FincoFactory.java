package framework;
import java.time.LocalDate;

public interface FincoFactory {
	public Customer createCustomer(String name, String street, String city, String state, int zip, String email);
	public Entry createEntry(double amount, LocalDate date);
	public Account createAccount();
}
