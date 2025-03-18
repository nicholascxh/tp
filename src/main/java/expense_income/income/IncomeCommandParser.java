package expense_income.income;

import expense_income.income.commands.HelpCommand;
import expense_income.income.commands.AddCommand;
import expense_income.income.commands.DeleteCommand;
import expense_income.income.commands.IncomeCommand;
import expense_income.income.commands.ListIncomeCommand;

public class IncomeCommandParser {
    public static IncomeCommand parseCommand(String input) {
        String[] parts = input.split(" ", 3);
        if (parts.length == 0) {
            return null;
        }

        String commandType = parts[0];

        switch (commandType) {
        case "add":
            if (parts.length < 3) {
                System.out.println("Usage: add <source> <amount>");
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
            return new ListIncomeCommand(); // List only incomes

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
