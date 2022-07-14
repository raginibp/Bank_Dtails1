import java.math.BigDecimal;

public interface BankAccount {
  public void withdraw(BigDecimal amount) throws  InsufficientBalanceException;
  public void deposit(BigDecimal amount);
}
