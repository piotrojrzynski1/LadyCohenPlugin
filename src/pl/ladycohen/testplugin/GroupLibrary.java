package pl.ladycohen.testplugin;

import java.util.ArrayList;
import org.bukkit.ChatColor;

public class GroupLibrary {
	
	public ArrayList<LuckyGroup> GetGroups(){
    	return new ArrayList<LuckyGroup>() {{
    	    add(new LuckyGroup("WŁAŚCICIEL", ChatColor.UNDERLINE.toString() + ChatColor.MAGIC.toString()));
    	    add(new LuckyGroup("Administrator", ChatColor.AQUA.toString()));
    	    add(new LuckyGroup("pomocnik_admina", ChatColor.YELLOW.toString()));
    	    add(new LuckyGroup("Moderator", ChatColor.DARK_GREEN.toString()));
    	    add(new LuckyGroup("YouTuber", ChatColor.RED.toString()));
    	    add(new LuckyGroup("S-VIP", ChatColor.DARK_RED.toString()));
    	    add(new LuckyGroup("VIP", ChatColor.GRAY.toString()));
    	}};
	}
}