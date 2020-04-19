package pl.ladycohen.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	Messenger _messenger;
	EventListeners _listeners;
	
    @Override
    public void onEnable() {
    	_messenger = new Messenger();
    	_listeners = new EventListeners();
    	Bukkit.getPluginManager().registerEvents(_listeners, this);
    }

    @Override
    public void onDisable() {

    }
    
    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {
    	try {    		
    		return _messenger.TryHandleCommand(sender, command, args);
    	}
    	catch(Exception e) {
            sender.sendMessage(e.toString());
    		return false;
    	}
    }
}
