package net.panda.fullpvp.tournaments.file;

import java.io.File;
import org.bukkit.plugin.Plugin;

import net.panda.fullpvp.FullPvP;

import org.bukkit.configuration.file.YamlConfiguration;

public class TournamentFile extends YamlConfiguration {
	
    private static TournamentFile config;
    private Plugin plugin;
    private File configFile;
    
    public static TournamentFile getConfig() {
        if (TournamentFile.config == null) {
            TournamentFile.config = new TournamentFile();
        }
        return TournamentFile.config;
    }
    
    private Plugin main() {
        return FullPvP.getInstance();
    }
    
    public TournamentFile() {
        this.plugin = this.main();
        this.configFile = new File(this.plugin.getDataFolder(), "tournament.yml");
        this.saveDefault();
        this.reload();
    }
    
    public void reload() {
        try {
            super.load(this.configFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void save() {
        try {
            super.save(this.configFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void saveDefault() {
        this.plugin.saveResource("tournament.yml", false);
    }
}
