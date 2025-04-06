package expenseincome.expense.commands;

import expenseincome.expense.ExpenseManager;
import java.time.LocalDate;
/**
 * Represents the command to edit an existing expense.
 */
public class EditExpenseCommand extends ExpenseCommand {
    private final int index;
    private final String newDescription;
    private final double newAmount;
    private final LocalDate newDate;
    private final String newCategory;
    /**
     * Constructs an EditExpenseCommand with new values.
     *
     * @param index the index of the expense to edit
     * @param newDescription the new description
     * @param newAmount the new amount
     * @param newDate the new date
     * @param newCategory the new category
     */
    public EditExpenseCommand(int index, String newDescription,
                              double newAmount, LocalDate newDate, String newCategory) {
        this.index = index;
        this.newDescription = newDescription;
        this.newAmount = newAmount;
        this.newDate = newDate;
        this.newCategory = newCategory;
    }
    /**
     * Executes the command by editing the specified expense.
     *
     * @param manager the ExpenseManager instance
     */
    @Override
    public void execute(ExpenseManager manager) {
        assert manager != null : "ExpenseManager cannot be null.";
        manager.editExpense(index, newDescription, newAmount, newDate, newCategory);
    }
}
