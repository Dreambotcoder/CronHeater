package org.CronHeater.Abstracts;

import org.CronHeater.Core;
import org.osbot.script.rs2.Client;
import org.osbot.script.rs2.model.Player;

/**
 * @author arno
 * @date 6-6-13
 * @time 20:13
 */
public class ScriptContext {

    public Core script;
    private Player player;
    public Client client;

    public ScriptContext(Core script){
      this.script = script;
      this.player = this.script.myPlayer();
      this.client = this.script.client;
    }

    public Player myPlayer() {
        return player;
    }

}

