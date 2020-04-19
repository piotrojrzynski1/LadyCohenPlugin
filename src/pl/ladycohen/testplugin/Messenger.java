package pl.ladycohen.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Messenger {

	public boolean TryHandleCommand(CommandSender sender, Command command, String[] args) {
		if(command.getName().equalsIgnoreCase("napisz"))
		{
			SendMessage(sender, command, args);
			return true;
		}
		return false;
	}
	
	private void SendMessage(CommandSender sender, Command command, String[] args) {
		String playerName = args[0];
		Player player = Bukkit.getPlayer(playerName);

		String message = sender.getName();
		message+= ": ";
		
		for(int i=1; i<args.length; i++) {
			message+=args[i] + " ";
		}
		
		player.sendMessage(message);
	}
}
