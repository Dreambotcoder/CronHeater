
public abstract class TasksContract  {

    protected Tasks heater;


    public TasksContract(Tasks heater) {
        this.heater = heater;
    }

    /**
     * What actions to perform on the task
     */
    public abstract int onLoop() throws InterruptedException;

    /**
     * checks if task is to be executed
     * @return
     */
    public abstract boolean valid();
}