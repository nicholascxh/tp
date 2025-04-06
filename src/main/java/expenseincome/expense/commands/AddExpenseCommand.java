package expenseincome.expense.commands;

import expenseincome.expense.ExpenseManager;
import java.time.LocalDate;
/**
 * Represents the command to add an expense entry.
 * It takes the description, amount, date, and category of the expense
 * and delegates the logic to the ExpenseManager.
 */
public class AddExpenseCommand extends ExpenseCommand {
    private final String description;
    private final double amount;
    private final LocalDate date;
    private final String category;
    /**
     * Constructs an AddExpenseCommand with the provided expense details.
     *
     * @param description the description of the expense
     * @param amount the amount spent
     * @param date the date the expense occurred
     * @param category the category of the expense
     */
    public AddExpenseCommand(String description, double amount, LocalDate date, String category) {
        assert description != null && !description.trim().isEmpty() : "Expense description cannot be empty.";
        assert amount > 0 : "Expense amount must be greater than zero.";
        assert date != null : "Expense date cannot be null.";
        assert category != null : "Expense category cannot be null.";

        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }
    /**
     * Executes the command by adding the expense to the manager.
     *
     * @param manager the ExpenseManager that manages expenses
     */
    @Override
    public void execute(ExpenseManager manager) {
        assert manager != null : "ExpenseManager instance cannot be null.";

        manager.addExpense(description, amount, date, category);
    }
}
