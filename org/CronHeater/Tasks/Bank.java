package org.CronHeater.Tasks;

import org.CronHeater.ScriptContext.ScriptContext;

/**
 * Created with IntelliJ IDEA.
 * User: arno
 * Date: 5-6-13
 * Time: 15:18
 * To change this template use File | Settings | File Templates.
 */
public class Bank extends Tasks {

    public Bank(ScriptContext context) {
        super(context);
    }

    /**
     * Code to execute on task
     */
    @Override
    public int onLoop() throws InterruptedException {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * @return if we should start the task
     */
    @Override
    public boolean valid() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
