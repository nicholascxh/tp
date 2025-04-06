package expenseincome.expense.commands;

import expenseincome.expense.ExpenseManager;
/**
 * Represents the command to list all expenses.
 */
public class ListExpenseCommand extends ExpenseCommand {
    /**
     * Executes the command by listing all expenses using the manager.
     *
     * @param expenseManager the ExpenseManager instance
     */
    @Override
    public void execute(ExpenseManager expenseManager) {
        assert expenseManager != null : "ExpenseManager instance cannot be null.";
        expenseManager.listExpenses();
    }
}
