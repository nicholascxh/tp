package loanbook.commands;

import loanbook.commands.printcommands.PrintMessageCommand;
import utils.textcolour.TextColour;

import static budgetsaving.budget.command.BudgetGeneralCommand.DASH;
import static budgetsaving.budget.command.BudgetGeneralCommand.LINE_SEPARATOR;

public class LoanHelpCommand extends PrintMessageCommand {

    public LoanHelpCommand() {
        super("Here's a list of loan commands:\n"
                + LINE_SEPARATOR + '\n'
                + TextColour.PURPLE + DASH + "\"add\": add a loan.\n" + TextColour.RESET
                + TextColour.GREEN + DASH + "\"list\": view the list of all loans recorded.\n" + TextColour.RESET
                + TextColour.YELLOW + DASH + "\"show X\": show the details of the Xth loan in the list.\n"
                + TextColour.RESET
                + TextColour.BLUE + DASH + "\"edit X [attribute]\": edit the specified attribute of the Xth loan.\n"
                + TextColour.RESET
                + TextColour.CYAN + DASH + "\"delete X\": delete the Xth loan.\n" + TextColour.RESET
                + TextColour.PURPLE + DASH + "\"return X\": set the Xth loan as returned.\n" + TextColour.RESET
                + TextColour.GREEN + DASH + "\"unreturn X\": set the Xth loan as not returned.\n" + TextColour.RESET
                + TextColour.YELLOW + DASH + "\"find\": find loans. Type \"help find\" for more details.\n"
                + TextColour.RESET
                + DASH + "\"exit\": Exit loan program.\n"
                + LINE_SEPARATOR);
    }
}
