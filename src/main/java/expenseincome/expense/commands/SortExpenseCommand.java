package expenseincome.expense.commands;

import expenseincome.expense.ExpenseManager;
/**
 * Represents the command to sort expenses by date.
 */
public class SortExpenseCommand extends ExpenseCommand {
    private final boolean mostRecentFirst;
    /**
     * Constructs the sort command.
     *
     * @param mostRecentFirst true to sort by most recent first, false for oldest first
     */
    public SortExpenseCommand(boolean mostRecentFirst) {
        this.mostRecentFirst = mostRecentFirst;
    }
    /**
     * Executes the command by sorting expenses.
     *
     * @param manager the ExpenseManager instance
     */
    @Override
    public void execute(ExpenseManager manager) {
        manager.sortExpensesByDate(mostRecentFirst);
    }
}
