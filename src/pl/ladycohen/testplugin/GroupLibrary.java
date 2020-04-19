package pl.ladycohen.testplugin;

import java.util.ArrayList;
import org.bukkit.ChatColor;

public class GroupLibrary {
	
	public ArrayList<LuckyGroup> GetGroups(){
    	return new ArrayList<LuckyGroup>() {{
    	    add(new LuckyGroup(
    	    		"W£AŒCICIEL",
    	    		ChatColor.UNDERLINE.toString() + ChatColor.MAGIC.toString()+"[W£AŒCICIEL]"
    	    		));
    	    add(new LuckyGroup(
    	    		"Administrator",
    	    		ChatColor.AQUA.toString()+"[ADMINISTRATOR]"
    	    		));
    	    add(new LuckyGroup(
    	    		"pomocnik_admina",
    	    		ChatColor.YELLOW.toString()+"[POMOCNIK ADMINA]"
    	    		));
    	    add(new LuckyGroup(
    	    		"Moderator",
    	    		ChatColor.DARK_GREEN.toString()+"[MODERATOR]"
    	    		));
    	    add(new LuckyGroup(
    	    		"YouTuber",
    	    		ChatColor.RED.toString()+"[YOU"+ChatColor.WHITE.toString()+"TUBER]"
    	    		));
    	    add(new LuckyGroup(
    	    		"S-VIP",
    	    		ChatColor.DARK_RED.toString()+"[S-VIP]"
    	    		));
    	    add(new LuckyGroup(
    	    		"VIP",
    	    		ChatColor.GRAY.toString()+"[VIP]"
    	    		));
    	}};
	}
}