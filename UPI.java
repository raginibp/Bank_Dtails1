import java.math.BigDecimal;

public class UPI {

  private int UPIid;
  Account account;

  public UPI(int UPIid, Account account) {
    this.UPIid = UPIid;
    this.account = account;
  }

  public void transfer(BigDecimal Amount, UPI destination) throws InsufficientBalanceException {
    if (this == destination) {
      System.out.println(" Can't transfer in same account");
    } else {
      try {
        this.account.withdraw(Amount);
        destination.account.deposit(Amount);
      } catch (InsufficientBalanceException e) {
        throw new InsufficientBalanceException("Oops!! Insufficient Balance");
      }
    }
  }
  public int getUPIid() {
    return UPIid;
  }

  public void setUPIid(int UPIid) {
    this.UPIid = UPIid;
  }

}
