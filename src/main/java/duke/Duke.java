package duke;

import duke.exception.DukeException;

import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    private static final Ui ui = null;
    private static final Parser parser = null;
    private static TaskList tasklist = new TaskList();
    private static Command command;

    public static void main(String[] args) throws DukeException {
        String line = "____________________________________________________________\n";
        System.out.println(ui.printLogo());
        System.out.println(ui.greet());
        String commandType = parser.getCommand();
        Storage storage;
        try {
            storage = new Storage();
            tasklist = storage.loadTaskList();
        } catch (DukeException e) {
            throw new DukeException("Cannot load file.\n");
        }

        while(!commandType.equals("bye")) {
            command = new Command(commandType);
            command.execute(tasklist);
            commandType = parser.getCommand();
        }
        storage.saveTaskList(tasklist);
        System.out.println(line + "Bye. Hope to see you again soon!\n" + line);
    }

}
