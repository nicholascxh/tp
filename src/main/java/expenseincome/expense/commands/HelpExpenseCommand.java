package expenseincome.expense.commands;

import expenseincome.expense.ExpenseManager;
/**
 * Represents the help command in expense mode.
 */
public class HelpExpenseCommand extends ExpenseCommand {
    /**
     * Executes the help command.
     *
     * @param manager the ExpenseManager instance (not used)
     */
    @Override
    public void execute(ExpenseManager manager) {
        System.out.println("Expense Command Help:");
        System.out.println("  add <description> <amount> <category> [yyyy-mm-dd]");
        System.out.println("    - Adds a new expense.");
        System.out.println("    - Description must be ONE word (use '-' for spacing).");
        System.out.println("    - Example: add Lunch 12.5 Food 2025-04-01");
        System.out.println();

        System.out.println("  edit <index> <newDescription> <newAmount> <newCategory> [yyyy-mm-dd]");
        System.out.println("    - Edits an existing expense at the given index.");
        System.out.println("    - Use '-' for spaces in newDescription.");
        System.out.println("    - Example: edit 1 Dinner-At-Home 20.0 Food 2025-04-01");
        System.out.println();

        System.out.println("  delete <index>");
        System.out.println("    - Deletes the expense at the given index.");
        System.out.println("    - Example: delete 3");
        System.out.println();

        System.out.println("  list");
        System.out.println("    - Lists all recorded expenses.");
        System.out.println();

        System.out.println("  list category <categoryName>");
        System.out.println("    - Lists expenses for the specified category.");
        System.out.println("    - Example: list category Food");
        System.out.println();

        System.out.println("  sort recent");
        System.out.println("    - Sorts expenses from most recent to oldest.");
        System.out.println("  sort oldest");
        System.out.println("    - Sorts expenses from oldest to most recent.");
        System.out.println();

        System.out.println("  top");
        System.out.println("    - Displays the top spending category.");
        System.out.println("  bottom");
        System.out.println("    - Displays the lowest spending category.");
        System.out.println();

        System.out.println("  help");
        System.out.println("    - Displays this help message.");

        System.out.println("  exit");
        System.out.println("    - Exit expense mode.");
    }
}
