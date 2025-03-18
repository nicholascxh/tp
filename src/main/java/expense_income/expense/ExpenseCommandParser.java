package expense_income.expense;

import expense_income.expense.commands.HelpCommand;
import expense_income.expense.commands.AddCommand;
import expense_income.expense.commands.DeleteCommand;
import expense_income.expense.commands.ExpenseCommand;
import expense_income.expense.commands.ListExpenseCommand;

public class ExpenseCommandParser {

    public static ExpenseCommand parseCommand(String input) {
        String[] parts = input.split(" ", 3);
        if (parts.length == 0) {
            return null;
        }

        String commandType = parts[0];

        switch (commandType) {
        case "add":
            if (parts.length < 3) {
                System.out.println("Usage: add <desc> <amount>");
                return null;
            }
            try {
                double amount = Double.parseDouble(parts[2]);
                return new AddCommand(parts[1], amount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a valid number.");
                return null;
            }

        case "list":
            return new ListExpenseCommand(); // List only expenses

        case "delete":
            if (parts.length < 2) {
                System.out.println("Usage: delete <number>");
                return null;
            }
            try {
                int index = Integer.parseInt(parts[1]);
                return new DeleteCommand(index);
            } catch (NumberFormatException e) {
                System.out.println("Invalid index. Please enter a number.");
                return null;
            }
        case "help":
            return new HelpCommand();
        default:
            return null;
        }
    }
}
