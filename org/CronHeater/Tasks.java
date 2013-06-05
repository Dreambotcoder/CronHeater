import org.osbot.script.rs2.model.RS2Object;

/**
 * Created with IntelliJ IDEA.
 * User: arno
 * Date: 5-6-13
 * Time: 20:19
 * To change this template use File | Settings | File Templates.
 */
public class Tasks extends CronSuperHeater {

    public Tasks(CronSuperHeater heater) {
       this.heater = heater;

    }

    CronSuperHeater heater;

    public void setupTasks(final TasksContract Task)  {
        Tasks superheat = new Tasks(heater) {
                public int onLoop() throws InterruptedException {
                    heater.log("Activated heater task");
                    if (!heater.client.getInterface(192).isValid())
                        heater.client.getInterface(548).getChild(53).interact();
                    heater.client.getInterface(192).getChild(25).interact("Cast");
                    heater.client.getInventory().interactWithId(CronSuperHeater.ore.getOre()[0],"Cast");
                    heater.sleep(heater.gRandom(1200,1800));
                    return 500;//
                }

           public boolean valid() {
               return heater.client.getInventory().contains(561) && heater.client.getInventory().contains(CronSuperHeater.ore.getOre()[0]);
           }
       };

        Tasks doBanking = new Tasks(this) {
            public int onLoop() throws InterruptedException {
                heater.log("BANKING STARTED");
                RS2Object bank = heater.closestObjectForName("Bank booth");
                if (bank != null && bank.exists() && bank.getPosition().distance(heater.client.getMyPlayer().getPosition()) <= 8) {
                    bank.interact("Bank");
                    while (!heater.client.getBank().isOpen())
                        heater.sleep(50);
                } else
                    heater.walk(bank);
                if (heater.client.getBank().isOpen()) {
                    heater.client.getBank().depositAllExcept(561);
                    for (int j = 0; j < CronSuperHeater.ore.getOre().length; j++)
                        heater.client.getBank().withdraw(CronSuperHeater.ore.getOre()[j],CronSuperHeater.ore.getAmount()[j]);
                }
                heater.client.getBank().close();
                return 500;
            }

            public boolean valid() {
                return !heater.client.getInventory().contains(CronSuperHeater.ore.getOre()[0]) && heater.client.getInventory().contains(561);
            }
        };



        heater.tasksToScript(doBanking, superheat);
        heater.log("TASKS ADDED FROM TASKS CLASS");
    }
}
