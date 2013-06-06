package org.CronHeater.Abstracts;

/**
 * @author arno
 * @date 6-6-13
 * @time 20:13
 */
public abstract class Task extends MethodProvider {

    public Task(ScriptContext scx) {
        super(scx);
    }

    /**
     * Execution
     * @return
     * @throws InterruptedException
     */
    public abstract int onLoop() throws InterruptedException;

    /**
     * @return When to execute
     */
    public abstract boolean valid();
}
