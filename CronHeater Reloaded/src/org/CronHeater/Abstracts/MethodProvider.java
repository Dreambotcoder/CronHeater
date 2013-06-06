package org.CronHeater.Abstracts;

import org.osbot.script.Script;

/**
 * @author arno
 * @date 6-6-13
 * @time 20:13
 */
public abstract class MethodProvider  {

    protected ScriptContext methods;

    public MethodProvider(ScriptContext scx) {
        this.methods = scx;
    }



    public interface Condition {
        public boolean validate();
    }
}
