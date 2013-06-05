package org.CronHeater.Tasks;

import org.CronHeater.ScriptContext.Methods;
import org.CronHeater.ScriptContext.ScriptContext;

/**
 * Created with IntelliJ IDEA.
 * User: arno
 * Date: 5-6-13
 * Time: 15:14
 * To change this template use File | Settings | File Templates.
 */
public abstract class Tasks extends Methods {

    Tasks task;

    public Tasks(ScriptContext context) {
       super(context);
    }
    /**
     * Code to execute on task
     */
    public abstract int onLoop() throws InterruptedException;

    /**
     *
     * @return if we should start the task
     */
    public abstract boolean valid();

}
