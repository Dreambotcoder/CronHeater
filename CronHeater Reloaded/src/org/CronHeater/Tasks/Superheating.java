package org.CronHeater.Tasks;

import org.CronHeater.Abstracts.MethodProvider;
import org.CronHeater.Abstracts.ScriptContext;
import org.CronHeater.Abstracts.Task;
import org.CronHeater.Data.Variables;

/**
 * @author arno
 * @date 6-6-13
 * @time 20:23
 */
public class Superheating extends Task {


    public Superheating(ScriptContext scx) {
        super(scx);
    }

    @Override                                     //lol
    public int onLoop() throws InterruptedException {
        methods.script.log("SUPERHEAT NODE STARTED");
          if (!methods.client.getInterface(192).isVisible())
              methods.client.getInterface(548).getChild(53).interact();
        methods.script.sleep(1000);
        methods.client.getInterface(192).getChild(25).interact("Cast");
        methods.script.sleep(1000);
        methods.client.getInventory().interactWithId(444, "Cast");
        return 500;
    }


    @Override
    public boolean valid() {
        return methods.client.getInventory().contains(444) && methods.client.getInventory().contains(Variables.NATURE_RUNE);
    }
}
