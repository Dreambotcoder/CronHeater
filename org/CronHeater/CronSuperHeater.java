import org.osbot.script.Script;
import org.osbot.script.ScriptManifest;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: arno
 * Date: 5-6-13
 * Time: 20:04
 * To change this template use File | Settings | File Templates.
 */
@ScriptManifest(name = "CronSuperHeater", author = "Articron", version = 1.0D, info = "Superheater, please follow the instructions on the GUI.")
public class CronSuperHeater extends Script {

    ArrayList<Tasks> state = new ArrayList<Tasks>();
    public static int configIndex = -1, mouseSpeed = 12;
    static Configs ore;



    private void loadConfig() {
      ore = Configs.forId(configIndex);
    }

    public int onLoop() throws InterruptedException {
       for (Tasks task: state) {
           log("LOOPING");
           if (task.valid())
           {
               return task.onLoop();
           }
       }
        return 500;
    }

    public void onStart(){
    new GUI();
        while (configIndex == -1) {
            try {  sleep(1000);  } catch (InterruptedException e) { }
        }
      client.setMouseSpeed(mouseSpeed);
    loadConfig();

}

    public void tasksToScript(Tasks... task) {
        for (Tasks tasks: task) {
        state.add(tasks);
}
        log("Tasks have been interpretated and brought to script");
}

}
