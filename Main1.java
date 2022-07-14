import java.math.BigDecimal;

class Main {
  public static void main(String args[]) throws InsufficientBalanceException, MinimumBalanceException {
    ICICI Owner_1 = new ICICI("Ragini", BigDecimal.valueOf(25000),Acc_Type.CURRENT,BigDecimal.valueOf(500));
    HDFC Owner_2 = new HDFC("Nidhi", BigDecimal.valueOf(5000),Acc_Type.SAVING,BigDecimal.valueOf(500));
    //Owner_1.withdraw(BigDecimal.valueOf(30000));
    UPI nidhi = new UPI(92347, Owner_2);
    UPI Ragini = new UPI(237647, Owner_1);
    nidhi.transfer(BigDecimal.valueOf(4000), Ragini);
  }
}