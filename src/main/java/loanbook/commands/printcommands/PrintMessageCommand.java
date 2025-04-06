package loanbook.commands.printcommands;

import loanbook.commands.LoanCommand;

public class PrintMessageCommand extends LoanCommand {
    protected String message;
    public PrintMessageCommand(String message) {
        this.message = message;
    }

    @Override
    public void execute() {
        if (message != null) {
            System.out.println(message);
        }
    }
}
