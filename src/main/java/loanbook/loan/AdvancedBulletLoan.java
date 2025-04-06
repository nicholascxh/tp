package loanbook.loan;

import loanbook.interest.Interest;
import utils.money.Money;
import utils.contacts.Person;

import java.math.BigDecimal;
import java.time.LocalDate;

import static loanbook.interest.InterestType.SIMPLE;

/**
 * Advanced loans are loans that apply interests.
 */
public class AdvancedBulletLoan extends Loan {
    protected Money outstandingBalance;
    protected Interest interest;
    protected int incrementCount;

    public AdvancedBulletLoan(String description, Person lender, Person borrower, Money money,
                              LocalDate startDate, Interest interest) throws DateUndefinedException {
        super(description, lender, borrower, money);
        if (startDate == null) {
            throw new DateUndefinedException("Start date not defined");
        }
        this.interest = interest;
        this.startDate = startDate;
        outstandingBalance = money;
        incrementCount = 0;
    }

    public AdvancedBulletLoan(String description, Person lender, Person borrower, Money money,
                              LocalDate startDate, LocalDate returnDate, Interest interest) throws DateUndefinedException {
        super(description, lender, borrower, money, startDate, returnDate);
        if (startDate == null) {
            throw new DateUndefinedException("Start date not defined");
        }
        this.interest = interest;
        outstandingBalance = money;
        incrementCount = 0;
    }

    /**
     * A method to show how much has to be returned.
     * @return a <code>Money</code> class representing the outstanding balance.
     */
    @Override
    public Money getBalance() {
        calculateBalance();
        return outstandingBalance;
    }

    public int incrementCount() {
        return incrementCount;
    }

    @Override
    public void setStart(LocalDate date) {
        this.startDate = date;
        calculateBalance();
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
        calculateBalance();
    }

    /**
     * Updates the outstanding balance by the date this method is called.
     */
    public void calculateBalance() {
        if (startDate == null) {
            throw new DateUndefinedException("Missing start date");
        }
        LocalDate date = startDate;
        Money balance = new Money(principal.getCurrency(), principal.getAmount());
        incrementCount = 0;
        while (date.plus(interest.period()).isBefore(LocalDate.now())) {
            if (interest.type() == SIMPLE) {
                BigDecimal increment = this.principal.getAmount().multiply(BigDecimal.valueOf(interest.rate() / 100));
                balance.increment(increment);
            } else {
                balance.increment(interest.rate());
            }
            incrementCount++;
            date = date.plus(interest.period());
        }
        outstandingBalance = balance;
    }

    /**
     * Displays the basic information of the loan.
     * @return a ready-to-print <code>String</code> containing all necessary information.
     */
    @Override
    public String basicInfo() {
        calculateBalance();
        return "Lender: [" + lender.getName()
                + "]    Borrower: [" + borrower.getName()
                + "]    Amount: " + principal
                + "    Start Date: " + startDate
                + (returnDate == null ? "" : "    Return Date: " + returnDate) + '\n'
                + "    Interest: " + interest + '\n'
                + "    Outstanding Balance: " + outstandingBalance + '\n'
                + (isReturned ? "    Returned" : "    Not Returned");
    }

    /**
     * Shows all details of this loan.
     * @return a ready-to-print <code>String</code> containing all information. Multiple lines.
     */
    @Override
    public String showDetails() {
        calculateBalance();
        return super.showDetails()
                + "Interest: " + interest + '\n'
                + "Outstanding Balance: " + outstandingBalance + '\n'
                + (isReturned ? "Returned" : "Not Returned");
    }

    /**
     * A method used to create storage files easily.
     * @return a <code>String</code> that stores every information of this loan and can be read by
     *     <code>LoanSaveManager</code>.
     */
    @Override
    public String forSave() {
        return "<AdvancedBulletLoanStart>\n" +
                super.forSave() +
                "<IsReturned>" + isReturned + '\n' +
                "<Interest>" + interest.forSave() + '\n' +
                "<AdvancedBulletLoanEnd>";
    }

    @Override
    public String getType()
    {
        return "Overview";
    }
    @Override
    public double getAmount()
    {
        return 0;
    }

    @Override
    public LocalDate getDate(){
        return startDate;
    }
}
