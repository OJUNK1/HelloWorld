package co.yedam.bank;
	
public class BankApp {	
	//싱글톤 방식.
	private static BankApp instance = new BankApp();
	
	//필드
	Account[] accounts;
	int accNo = 0;

	// 생성자
	private BankApp() {
		accounts = new Account[5];
	}
	
	public static BankApp getInstance() {
		return instance;
	}
	// 메소드

	// 계좌등록
	void registerAccount(Account acc) {
		accounts[accNo++] = acc;
	}

	// 계좌목록확인
	void accountList(String accountNo) {
		for (int i = 0; i < accNo; i++) {
			if (accounts[i] != null && accounts[i].accountNumber.equals(accountNo)) {
				System.out.printf("계좌번호: %s, 예금주: %s \n", accountNo, accounts[i].accountHolder);
			}

		}
	}

	// 계좌입금기능
	int deposit(String accountNo, int depo) {
		for (int i = 0; i < accNo; i++) {
			if (accounts[i] != null && accounts[i].accountNumber.equals(accountNo)) {
				accounts[i].balance += depo;
				return 0;
			}
		}
		return 1;
	}

	// 계좌출금기능
	int withDraw(String accountNo, int withD) {
		
		for (int i = 0; i < accNo; i++) {
			if (accounts[i] != null && accounts[i].accountNumber.equals(accountNo)) {
				accounts[i].balance -= withD;
				return 0;
			}
		}
		return 1;
	}

	void checkBalance(String accountNo) {

		for (int i = 0; i < accNo; i++) {
			if (accounts[i] != null && accounts[i].accountNumber.equals(accountNo)) {
				int amount = accounts[i].balance;
				System.out.println("계좌잔액은 " + amount + "원입니다.");
			}
		}
	}
}
