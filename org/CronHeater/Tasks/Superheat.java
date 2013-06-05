package org.CronHeater.Tasks;

import org.CronHeater.ScriptContext.Methods;
import org.CronHeater.ScriptContext.ScriptContext;


/**
 * Created with IntelliJ IDEA.
 * User: arno
 * Date: 5-6-13
 * Time: 15:18
 * To change this template use File | Settings | File Templates.
 */
public class Superheat extends Tasks {

    public Superheat(ScriptContext task) {
        super(task);
    }

    @Override
    public int onLoop() throws InterruptedException {
         if (!context.client.getInterface(192).isValid())
             context.client.getInterface(548).getChild(53).interact();
             context.client.getInterface(192).getChild(25).interact("Cast");
            Methods.waitFor(new Condition() {
                @Override
                public boolean validate() {
                    return context.client.getInterface(548).isValid();
                }
            },1000L);

        int slotToInteract = context.client.getInventory().getSlotForId(context.bars.getOre()[0]);
        context.client.getInventory().interactWithSlot(slotToInteract,"Cast");

        return 0;
    }

    @Override
    public boolean valid() {
        return context.client.getInventory().contains(561) && context.client.getInventory().contains(context.bars.getOre()[0]);
    }
}
