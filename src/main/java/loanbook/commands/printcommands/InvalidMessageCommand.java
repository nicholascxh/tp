package loanbook.commands.printcommands;

import utils.io.IOHandler;
import utils.textcolour.TextColour;

public class InvalidMessageCommand extends PrintMessageCommand {
    public InvalidMessageCommand(String message) {
        super(message);
    }

    @Override
    public void execute() {
        if (message != null) {
            IOHandler.writeOutputWithColour(message, TextColour.RED);
        }
    }
}
