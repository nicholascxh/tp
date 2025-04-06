package expenseincome.expense.commands;

import expenseincome.expense.ExpenseManager;
/**
 * Represents the command to delete an expense.
 */
public class DeleteExpenseCommand extends ExpenseCommand {
    private final int index;
    /**
     * Constructs a DeleteExpenseCommand with the given index.
     *
     * @param index the index of the expense to delete
     */
    public DeleteExpenseCommand(int index) {
        this.index = index;
    }
    /**
     * Executes the command by deleting the expense from the manager.
     *
     * @param manager the ExpenseManager instance
     */
    @Override
    public void execute(ExpenseManager manager) {
        assert manager != null : "ExpenseManager instance should not be null.";
        assert index >= 1 : "Index must be positive (should be checked before calling this method).";

        manager.deleteExpense(index);
    }
}
