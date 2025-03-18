package cashflow.command;

public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Available commands:");
        System.out.println("  help     - Display available commands and usage");
        System.out.println("  overview - Display financial overview");
        System.out.println("  setup    - Interactive first-time setup");
        System.out.println("  expense    - Enter expense mode");
        System.out.println("  income    - Enter income mode");
        System.out.println("  exit     - Exit the program");
    }
}
