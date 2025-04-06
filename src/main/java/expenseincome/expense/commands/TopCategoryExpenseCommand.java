package expenseincome.expense.commands;

import expenseincome.expense.ExpenseManager;
/**
 * Represents the command to show the top spending category.
 */
public class TopCategoryExpenseCommand extends ExpenseCommand {
    /**
     * Executes the command to display the top spending category.
     *
     * @param manager the ExpenseManager instance
     */
    @Override
    public void execute(ExpenseManager manager) {
        assert manager != null : "ExpenseManager cannot be null.";
        manager.printTopCategory();
    }
}
