package org.CronHeater.ScriptContext;

import org.CronHeater.Core;
import org.osbot.script.Script;

/**
 * Created with IntelliJ IDEA.
 * User: arno
 * Date: 5-6-13
 * Time: 15:34
 * To change this template use File | Settings | File Templates.
 */
public abstract class Methods {

    protected ScriptContext context;

    public Methods(ScriptContext context) {
        this.context = context;
    }


    public static boolean waitFor(Condition c, long timeout) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        while (startTime + timeout > System.currentTimeMillis() && !c.validate()) {
            if (context.client.getMyPlayer().isMoving()) {
                startTime = System.currentTimeMillis();
            }
            context.core.sleep(Script.random(10, 50));
        }
        return c.validate();
    }

    public interface Condition {
        public boolean validate();
    }

}
