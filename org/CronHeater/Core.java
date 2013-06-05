package org.CronHeater;

import org.CronHeater.ScriptContext.ScriptContext;
import org.CronHeater.Tasks.Bank;
import org.CronHeater.Tasks.Superheat;
import org.CronHeater.Tasks.Tasks;
import org.osbot.script.Script;
import org.osbot.script.ScriptManifest;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: arno
 * Date: 5-6-13
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */
@ScriptManifest(name = "CronHeater", author = "Articron", version = 0.1D, info = "AIO superheater by Articron!")
public class Core extends Script {

    ArrayList<Tasks> tasks = new ArrayList<Tasks>();
    private ScriptContext scx;

    public int onLoop() throws InterruptedException {
        log("STARTING THE LOOP") ;
        for (Tasks task: tasks) {
            if (task.valid())
                return task.onLoop();
        }
        return 1000;
    }

    public void onStart() {
        //STARTED!
        log("STARTED UP");
        loadSCX();
        loadTasks();

    }

    private void loadSCX() {
        log("LOADED SCX");
        this.scx = new ScriptContext(this);
    }

    private void loadTasks() {
        log("LOADED SUPERHEAT TASK");
        //tasks.add(new Bank(scx));
        tasks.add(new Superheat(scx));
    }

    private void setUserInput() {  }


}
