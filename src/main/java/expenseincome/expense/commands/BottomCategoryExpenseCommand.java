package expenseincome.expense.commands;

import expenseincome.expense.ExpenseManager;
/**
 * Represents the command to show the bottom (least) spending category.
 */
public class BottomCategoryExpenseCommand extends ExpenseCommand {
    /**
     * Executes the command to display the bottom spending category.
     *
     * @param manager the ExpenseManager instance
     */
    @Override
    public void execute(ExpenseManager manager) {
        assert manager != null : "ExpenseManager cannot be null.";
        manager.printBottomCategory();
    }
}
