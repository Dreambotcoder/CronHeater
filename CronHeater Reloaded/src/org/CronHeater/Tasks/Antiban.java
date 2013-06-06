package org.CronHeater.Tasks;

import org.CronHeater.Abstracts.ScriptContext;
import org.CronHeater.Abstracts.Task;

/**
 * @author arno
 * @date 6-6-13
 * @time 20:31
 */
public class Antiban extends Task {

    public Antiban(ScriptContext scx) {
        super(scx);
    }

    /**
     * Execution
     *
     * @return
     * @throws InterruptedException
     */
    @Override
    public int onLoop() throws InterruptedException {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * @return When to execute
     */
    @Override
    public boolean valid() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
