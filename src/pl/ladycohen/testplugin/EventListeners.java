package pl.ladycohen.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.RegisteredServiceProvider;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;

public class EventListeners implements Listener {
	GroupLibrary _groupLibrary = new GroupLibrary();
	LuckPerms _perms;

	public EventListeners(){
		Bukkit.getLogger().info("Wczytywanie LuckPerms do LadyCohenPlugin");
		RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
		if (provider != null) {
			Bukkit.getLogger().info("Wczytano dostawcê LuckPerms");
		    _perms = provider.getProvider();
		}
		else{
			Bukkit.getLogger().severe("Nie za³adowano providera LuckPerms");
		}
	}
	
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
    	try {
	    	LuckyGroup group = getPlayerGroup(event.getPlayer(), event.getMessage().equalsIgnoreCase("dajrange"));
	    	
	    	if(group!=null) {
	    		event.setFormat(group.FormattedName + ChatColor.BLUE + "%11s: " + ChatColor.WHITE + " %s");
	    	}
    	}
    	catch(Exception e){
            event.getPlayer().sendMessage(e.toString());
    	}
    }
    
    public LuckyGroup getPlayerGroup(Player player, boolean logging) {
    	UserManager userManager = _perms.getUserManager();
    	if(userManager==null)
    		player.sendMessage("nie znaleziono menad¿era grup");
        
    	User user = userManager.getUser(player.getUniqueId());
    	if(user==null)
            player.sendMessage("nie znaleziono u¿ytkownika " +player.getName());
    		
    	String groupName = user.getPrimaryGroup();
    	
    	if(groupName==null)
            player.sendMessage("nie znaleziono grupy u¿ytkownika");
    	
    	if(logging)
    		player.sendMessage("Jesteœ w grupie g³ównej: "+groupName);
    	    	
    	if(logging) {
    		player.sendMessage("Masz uprawnienia:");
            for (PermissionAttachmentInfo permission : player.getEffectivePermissions())
            {
        		player.sendMessage(permission.getPermission());
            }
    	}
    	    	
        for (LuckyGroup group : _groupLibrary.GetGroups()) {
            if (group.Name.equalsIgnoreCase(groupName)) {
                return group;
            }
        }
        
        return null;
    }
}