package org.CronHeater;

import org.CronHeater.Abstracts.ScriptContext;
import org.CronHeater.Abstracts.Task;
import org.CronHeater.Data.OreData;
import org.CronHeater.Data.Variables;
import org.CronHeater.GUI.Gui;
import org.CronHeater.Tasks.Antiban;
import org.CronHeater.Tasks.Banking;
import org.CronHeater.Tasks.Superheating;
import org.osbot.script.Script;
import org.osbot.script.ScriptManifest;

import java.util.ArrayList;

/**
 * @author arno
 * @date 6-6-13
 * @time 20:03
 */


@ScriptManifest(name = "CronHeater Reloaded", author = "Articron", info = "Should try nature heating", version = 1.0)
public class Core extends Script {

    ArrayList<Task> taskList = new ArrayList <Task>();
    ScriptContext scx;
    public static int inputIndex = -1;
    public OreData ores;


    public int onLoop() throws InterruptedException {
       for (Task task: taskList) {
           if (task.valid()) {
               return task.onLoop();
           }
       }
        return 500;
    }

    private void loadSCX() {
      this.scx = new ScriptContext(this);
        log("SCX LOADED");
    }

     private void loadEnum() {
         ores = ores.forId(inputIndex);
     }




    private void loadTasksToScript() {
        taskList.add(new Superheating(this.scx));
        taskList.add(new Banking(this.scx));
        taskList.add(new Antiban(this.scx));
        log("TASKS LOADED IN");
    }

    public void onStart() {
     loadSCX();
     loadTasksToScript();
     loadEnum();
    }
}
