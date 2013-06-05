package org.CronHeater.ScriptContext;

import org.CronHeater.Core;
import org.CronHeater.Variables.Enumerations;
import org.osbot.script.rs2.Client;
import org.osbot.script.rs2.model.Player;

/**
 * Created with IntelliJ IDEA.
 * User: arno
 * Time: 15:23
 * To change this template use File | Settings | File Templates.
 */
public class ScriptContext {

    public Core core;
    public Client client;
    public Player player;
    public Enumerations bars;

    public ScriptContext(Core core) {
        this.core = core;
        this.client = this.core.client;
        this.player = this.client.getMyPlayer();
        bars = bars.forOre(4);
    }
}
