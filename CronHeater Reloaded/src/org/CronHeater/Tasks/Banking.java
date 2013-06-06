package org.CronHeater.Tasks;

import org.CronHeater.Abstracts.ScriptContext;
import org.CronHeater.Abstracts.Task;
import org.CronHeater.Data.Variables;
import org.osbot.script.MethodProvider;
import org.osbot.script.rs2.model.RS2Object;

/**
 * @author arno
 * @date 6-6-13
 * @time 20:23
 */
public class Banking extends Task {


    public Banking(ScriptContext scx) {
        super(scx);
    }

    @Override
    public int onLoop() throws InterruptedException {
        methods.script.log("BANKING NODE CALLED");
        RS2Object bank = methods.script.closestObjectForName("Bank booth");
        if (bank.exists() && bank != null && bank.getPosition().distance(methods.myPlayer().getPosition()) <=5) {
            while (!methods.client.getBank().isOpen()) {
            bank.interact("Bank");
                methods.script.sleep(1000);
            }

            if (methods.client.getBank().isOpen()) {
                methods.client.getBank().depositAllExcept(Variables.NATURE_RUNE);
                methods.script.sleep(MethodProvider.random(1337,1495));
                    methods.client.getBank().withdrawAll(444);
                    methods.script.sleep(MethodProvider.random(500,700));

                methods.client.getBank().close();
            }

        }
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public boolean valid() {
        return !methods.client.getInventory().contains(444);
    }
}
