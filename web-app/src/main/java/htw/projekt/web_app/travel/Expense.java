package htw.projekt.web_app.travel;

import java.time.LocalDate;

public class Expense {
    private long expenseID;
    private String Titel;
    private long amount;
    private LocalDate expenseDate;

    public Expense() {
    }

    public Expense(long expenseID, String titel, long amount, LocalDate expenseDate) {
        this.expenseID = expenseID;
        Titel = titel;
        this.amount = amount;
        this.expenseDate = expenseDate;
    }

    public long getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(long expenseID) {
        this.expenseID = expenseID;
    }

    public String getTitel() {
        return Titel;
    }

    public void setTitel(String titel) {
        Titel = titel;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }
}
