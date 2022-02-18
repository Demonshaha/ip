package command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class DoneCommand extends Command {
    private final int taskIndex;
    private final String type;

    /**
     * The constructor of DoneCommand
     * @param taskIndex the task index that will be executed
     * @param type the string indicates the task will be mark as done or not done
     */
    public DoneCommand(int taskIndex, String type) {
        this.taskIndex = taskIndex;
        this.type = type;
    }

    /**
     * A method to execute DoneCommand
     * @param taskList duke's task list
     * @param ui duke's ui
     * @param storage duke's storage
     * @return A string generated by ui
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        if(this.type.contains("unmark")) {
            taskList.getTask(taskIndex).markAsNotDone();
            return ui.generateResponse("Nice! I've marked this task as not done yet:\n" +
                    taskList.getTask(taskIndex) + "\n");
        }
        else {
            taskList.getTask(taskIndex).markAsDone();
            return ui.generateResponse("Nice! I've marked this task as done yet:\n" +
                    taskList.getTask(taskIndex) + "\n");
        }
    }
}
