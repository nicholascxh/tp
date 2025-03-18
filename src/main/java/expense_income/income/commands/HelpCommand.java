package expense_income.income.commands;

public class HelpCommand extends IncomeCommand {

    @Override
    public void execute(expense_income.income.IncomeManager expenseManager) {
        System.out.println("=== Income Commands Help ===");
        System.out.println("add <description> <amount>  - Add a new income");
        System.out.println("list                        - List all income");
        System.out.println("delete <number>             - Delete an income by index");
        System.out.println("help                        - Show this help menu");
        System.out.println("exit                        - Exit Income Mode");
    }
}
