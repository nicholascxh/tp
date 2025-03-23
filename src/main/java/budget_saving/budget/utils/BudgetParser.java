package budget_saving.budget.utils;

import budget_saving.budget.command.*;
import cashflow.command.Command;
import cashflow.model.interfaces.BudgetManager;

public class BudgetParser {

    public static Command parseSetBudgetCommand(String input, BudgetManager budgetManager)
            throws NumberFormatException {
        BudgetAttributes attributes = new BudgetAttributes(input);
        String name = attributes.getName();
        double amount = attributes.getAmount();
        return new SetBudgetCommand(budgetManager, name, amount);
    }

    public static Command parseCheckBudgetCommand(String input, BudgetManager budgetManager) {
        // Expected format: check-budget (no extra parameters)
        BudgetAttributes attributes = new BudgetAttributes(input);
        int index = attributes.getIndex();
        return new CheckBudgetCommand(index, budgetManager);
    }

    public static Command parseListBudgetCommand(BudgetManager budgetManager) {
        return new ListBudgetCommand(budgetManager);
    }

    public static Command parseDeductBudgetCommand(String input, BudgetManager budgetManager)
            throws NumberFormatException {
        BudgetAttributes attributes = new BudgetAttributes(input);
        int index = attributes.getIndex();
        double amount = attributes.getAmount();
        return new DeductFromBudgetCommand(budgetManager, index, amount);
    }

    public static Command parseAddBudgetCommand(String input, BudgetManager budgetManager)
            throws NumberFormatException {
        // Expected format: add-budget n/BUDGET_NAME a/AMOUNT
        BudgetAttributes attributes = new BudgetAttributes(input);
        int index = attributes.getIndex();
        double amount = attributes.getAmount();
        return new AddToBudgetCommand(budgetManager, index, amount);
    }

    public static Command parseModifyBudgetCommand(String input, BudgetManager budgetManager)
            throws NumberFormatException {
        // Expected format: set-budget n/BUDGET_NAME a/AMOUNT
        BudgetAttributes attributes = new BudgetAttributes(input);
        int index = attributes.getIndex();
        String name = attributes.getName();
        double amount = attributes.getAmount();
        return new ModifyBudgetCommand(budgetManager, index, amount, name);
    }

}
