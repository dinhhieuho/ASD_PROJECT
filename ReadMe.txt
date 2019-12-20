PATTERNS USED FOR EACH SUB-SYSTEM
-Bank
public static void debit(String accountNumber, double amount) {
		Optional<CustomerDefault> customer = dataAccess.findAccountByAccountNumber(accountNumber);
		if (customer.isPresent())
			try {
				customer.get().debit(accountNumber, amount);
			} catch (AccountNotFoundException e) {
				System.out.println("Account not found");
			} catch (BalanceInsufficientException e) {
				System.out.println("Insufficient Funds");
				e.printStackTrace();
			}
	}

	public static void credit(String accountNumber, double amount) {
		Optional<CustomerDefault> customer = dataAccess.findAccountByAccountNumber(accountNumber);
		if (customer.isPresent())
			try {
				customer.get().credit(accountNumber, amount);
			} catch (AccountNotFoundException e) {
				System.out.println("Account not found");
			}
	}

	public static void generateReport() {
		List<CustomerDefault> customer = dataAccess.findAll();
		customer.forEach(CustomerDefault::printCustomerReport);
	}