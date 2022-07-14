import java.math.BigDecimal;

abstract class Account {
    private String owner;
    private BigDecimal balance;
    private final Acc_Type acc_type;
    private BigDecimal minBal = new BigDecimal(0);
    private BigDecimal overDrafLimit = new BigDecimal(0);


    public Account(String owner,BigDecimal balance, Acc_Type acc_type, BigDecimal minBal) throws MinimumBalanceException{
        this.owner = owner;
        this.acc_type = acc_type;
        this.minBal = minBal;
        try {
            if (balance.compareTo(this.minBal) >= 0) {
                this.balance = balance;
            } else {
                throw new MinimumBalanceException("Alert!! Minimum Balance is require.");
            }
        } catch (MinimumBalanceException e) {
            //e.getMessage();
            throw new MinimumBalanceException("Alert!! Minimum Balance is require.");
        }
    }


    public void withdraw(BigDecimal amount) throws InsufficientBalanceException {
        try {
            if (CheckBal(amount)) {
                this.balance = this.balance.subtract(amount);
            } else {
                throw new InsufficientBalanceException("Insufficient Balance!");
            }
        } catch (InsufficientBalanceException e) {
            e.getMessage();
            throw new InsufficientBalanceException("Insufficient Balance!");
        }

    }

    public void deposit(BigDecimal Amount) {
        balance = this.balance.add(Amount);
        // System.out.println("Deposited amount is " + Amount + " and Total Balance is " + this.getBalance() + " of " + this.owner);

    }

    public boolean CheckBal(BigDecimal amount) {
        if (this.acc_type == Acc_Type.CURRENT) {
            BigDecimal overDraft = overDrafLimit.multiply(this.balance);
            BigDecimal temp_bal = this.balance.add(overDraft);
            return temp_bal.compareTo(amount) >= 0;
        } else {
            return this.balance.compareTo(amount) >= 0;
        }
    }
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Acc_Type getAcc_type() {
        return acc_type;
    }

    public BigDecimal getMinBal() {
        return minBal;
    }

    public void setMinBal(BigDecimal minBal) {
        this.minBal = minBal;
    }

    public BigDecimal getOverDrafLimit() {
        return overDrafLimit;
    }

    public void setOverDrafLimit(BigDecimal overDrafLimit) {
        this.overDrafLimit = overDrafLimit;
    }

}