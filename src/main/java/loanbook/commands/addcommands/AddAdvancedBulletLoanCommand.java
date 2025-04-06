package loanbook.commands.addcommands;

import loanbook.LoanManager;
import loanbook.interest.Interest;
import loanbook.loan.AdvancedBulletLoan;
import loanbook.loan.Loan;
import utils.money.Money;
import utils.contacts.Person;

import java.time.LocalDate;
import java.util.ArrayList;

public class AddAdvancedBulletLoanCommand extends AddSimpleBulletLoanCommand {
    protected Interest interest;

    public AddAdvancedBulletLoanCommand(LoanManager loans, String description, Person lender, Person borrower,
                                        Money money, LocalDate startDate, Interest interest) {
        super(loans, description, lender, borrower, money, startDate, null);
        this.interest = interest;
    }

    public AddAdvancedBulletLoanCommand(LoanManager loans, String description, Person lender, Person borrower,
                                        Money money, LocalDate startDate, LocalDate returnDate, Interest interest) {
        super(loans, description, lender, borrower, money, startDate, returnDate);
        this.interest = interest;
    }

    public AddAdvancedBulletLoanCommand(LoanManager loans, String description, Person lender, Person borrower,
                                        Money money, LocalDate startDate, LocalDate returnDate, Interest interest,
                                        ArrayList<String> tags) {
        super(loans, description, lender, borrower, money, startDate, returnDate, tags);
        this.interest = interest;
    }

    @Override
    public void execute() {
        Loan loan = new AdvancedBulletLoan(description, lender, borrower, money, startDate, returnDate, interest);
        loan.addTags(tags);
        loans.add(loan);
        System.out.println("Advanced Bullet Loan added: " + loan.basicInfo());
    }
}
