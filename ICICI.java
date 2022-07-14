import java.math.BigDecimal;
public class ICICI extends Account implements BankAccount {

public ICICI(String owner, BigDecimal balance,Acc_Type acc_type , BigDecimal minBal) throws MinimumBalanceException{
        super(owner, balance ,acc_type,minBal);
        super.setMinBal(BigDecimal.valueOf(1000));
        super.setOverDrafLimit(BigDecimal.valueOf(0.1));
        }

@Override
public void withdraw(BigDecimal Amount) throws InsufficientBalanceException  {
        try{
        super.withdraw(Amount);
        System.out.println(Amount+ " Withdraw from " +getOwner());
        System.out.println("Available amount is "+getBalance());
        }
        catch(InsufficientBalanceException e){
        e.getMessage();
        throw new InsufficientBalanceException("Insufficient Balance!!");

        }
}

@Override
public void deposit(BigDecimal Amount) {
        super.deposit(Amount);
        System.out.println(Amount+ " Deposited to " +getOwner());
        System.out.println("Available amount is " +getBalance());

        }
}