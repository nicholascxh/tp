package expense_income.expense;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ExpenseManager {
    private static final Logger logger = Logger.getLogger(ExpenseManager.class.getName());
    private List<Expense> expenses;

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(String description, double amount, LocalDate date, String category) {
        try {
            if (description == null || description.trim().isEmpty()) {
                throw new IllegalArgumentException("Expense description cannot be empty.");
            }
            if (amount <= 0) {
                throw new IllegalArgumentException("Expense amount must be greater than zero.");
            }
            if (category == null || category.trim().isEmpty()) {
                throw new IllegalArgumentException("Expense category cannot be empty.");
            }

            Expense expense = new Expense(description, amount, date, category);
            expenses.add(expense);
            logger.log(Level.INFO, "Added expense: {0}", expense);
            System.out.println("Added: " + expense);
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING, "Failed to add expense", e);
            System.out.println("Failed to add expense. " + e.getMessage());
        }
    }

    public void listExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }
        System.out.println("Expense List:");
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println((i + 1) + ". " + expenses.get(i));
        }
    }

    public void deleteExpense(int index) {
        try {
            logger.log(Level.INFO, "Attempting to delete expense at index: {0}", index);

            if (index < 1 || index > expenses.size()) {
                throw new IllegalArgumentException("Invalid index: must be between 1 and " + expenses.size());
            }

            Expense removed = expenses.remove(index - 1);
            logger.log(Level.INFO, "Deleted expense: {0}", removed);
            System.out.println("Deleted: " + removed);
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING, "Failed to delete expense at index: " + index, e);
            System.out.println("Failed to delete expense. " + e.getMessage());
        }
    }

    public void editExpense(int index, String newDescription, double newAmount, LocalDate newDate, String newCategory) {
        try {
            logger.log(Level.INFO, "Editing expense at index {0} to new values: {1}, ${2}, {3}, category={4}",
                    new Object[]{index, newDescription, newAmount, newDate, newCategory});

            if (index < 1 || index > expenses.size()) {
                throw new IllegalArgumentException("Invalid index: must be between 1 and " + expenses.size());
            }
            if (newDescription == null || newDescription.trim().isEmpty()) {
                throw new IllegalArgumentException("New description cannot be empty.");
            }
            if (newAmount <= 0) {
                throw new IllegalArgumentException("New amount must be greater than zero.");
            }
            if (newCategory == null || newCategory.trim().isEmpty()) {
                throw new IllegalArgumentException("Category cannot be empty.");
            }

            Expense expense = expenses.get(index - 1);
            expense.setDescription(newDescription);
            expense.setAmount(newAmount);
            expense.setDate(newDate);
            expense.setCategory(newCategory);
            logger.log(Level.INFO, "Updated expense: {0}", expense);
            System.out.println("Updated: " + expense);
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING, "Failed to edit expense at index: " + index, e);
            System.out.println("Failed to edit expense. " + e.getMessage());
        }
    }

    public void sortExpensesByDate(boolean mostRecentFirst) {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to sort.");
            return;
        }

        logger.log(Level.INFO, "Sorting expenses by date. Order: {0}",
                mostRecentFirst ? "most recent first" : "oldest first");

        expenses.sort((e1, e2) -> {
            if (mostRecentFirst) {
                return e2.getDate().compareTo(e1.getDate());
            } else {
                return e1.getDate().compareTo(e2.getDate());
            }
        });

        System.out.println("Expenses sorted by " + (mostRecentFirst ? "most recent" : "oldest") + " first.");
        listExpenses();  // Show sorted list
    }

    public int getExpenseCount() {
        return expenses.size();
    }

    public Expense getExpense(int i) {
        return expenses.get(i);
    }
}
