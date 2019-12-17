package framework.notification;

import framework.fincoCustomer.FincoCustomer;

public class Notification implements INotification {
	private FincoCustomer fcustomer;
	private String accountNumber;
	private String status = "pending";

	public Notification(FincoCustomer fcustomer, String accountNumber) {
		this.fcustomer = fcustomer;
		this.accountNumber = accountNumber;
	}

	public void execute() {
		fcustomer.sendEmail(accountNumber);
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
