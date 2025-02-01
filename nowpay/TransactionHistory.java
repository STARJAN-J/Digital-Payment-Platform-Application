package StarjanProject.Digital_Payment_Platform_App.nowpay;

import java.time.LocalDate;

public class TransactionHistory {
    private LocalDate date;
    private String toName;
    private String sign;
    private double amount;

    // Constructors
    public TransactionHistory() {

    }
    public TransactionHistory(LocalDate date, String toName, String sign, double amount) {
        this.date = date;
        this.toName = toName;
        this.sign = sign;
        this.amount = amount;
    }

    // Getters
    public LocalDate getDate() {
        return date;
    }

    public String getToName() {
        return toName;
    }

    public double getAmount() {
        return amount;
    }

    // Setters
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionHistory [date= " + date + ", Name= " + toName + ", amount= " + sign + amount + "]";
    }

    
    

    

}
