package expense_income.expense.commands;

public class HelpCommand extends ExpenseCommand {

    @Override
    public void execute(expense_income.expense.ExpenseManager expenseManager) {
        System.out.println("=== Expense Commands Help ===");
        System.out.println("add <description> <amount>  - Add a new expense");
        System.out.println("list                        - List all expenses");
        System.out.println("delete <number>             - Delete an expense by index");
        System.out.println("help                        - Show this help menu");
        System.out.println("exit                        - Exit Expense Mode");
    }
}
