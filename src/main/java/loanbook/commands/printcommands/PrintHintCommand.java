package loanbook.commands.printcommands;

import utils.io.IOHandler;
import utils.textcolour.TextColour;

public class PrintHintCommand extends PrintMessageCommand {
    public PrintHintCommand(String message) {
        super(message);
    }

    @Override
    public void execute() {
        if (message != null) {
            IOHandler.writeOutputWithColour(message, TextColour.GREEN);
        }
    }
}
