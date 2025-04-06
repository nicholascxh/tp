package expenseincome.expense.commands;

import expenseincome.expense.ExpenseManager;
/**
 * Represents the command to list expenses filtered by category.
 */
public class ListCategoryExpenseCommand extends ExpenseCommand {
    private final String category;

    /**
     * Constructs the command with a specific category filter.
     *
     * @param category the category to filter by
     */
    public ListCategoryExpenseCommand(String category) {
        this.category = category;
    }
    /**
     * Executes the command by listing expenses in the specified category.
     *
     * @param expenseManager the ExpenseManager instance
     */
    @Override
    public void execute(ExpenseManager expenseManager) {
        assert expenseManager != null : "ExpenseManager cannot be null.";
        expenseManager.listExpensesByCategory(category);
    }
}
