import Practice_2.BankAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void depositShouldIncreaseBalance() {
        BankAccount account = new BankAccount("toJ3stK0nt0wT3st0wymTaske", 100.0);
        account.deposit(50.0);
        System.out.println(account.getBalance());
    }
}