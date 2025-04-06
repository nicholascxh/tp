package expenseincome.expense.commands;

import expenseincome.expense.ExpenseManager;
/**
 * Abstract base class for all Expense-related commands.
 * Each subclass must implement the execute method.
 */
public abstract class ExpenseCommand {
    /**
     * Executes the command using the given ExpenseManager.
     *
     * @param manager the ExpenseManager instance
     */
    public abstract void execute(ExpenseManager manager);
}
