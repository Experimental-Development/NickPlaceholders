package me.experimental.files;
/*
    
    This file is licensed by ExperimentalX. Unless you have
    specific permission from ExperimentalX, you are not
    permitted to touch this file at all. It is open
    sourced so you can see how I did it, not for
    you to copy off of it.
    
    Please. If you are trying to learn, don't copy off of
    other people, see what they did, and try to do it better.
    See if you can figure out why it works the way it does.
    
    This was written by ExperimentalX on 7/5/2022 for
    NickPlaceholders
    
*/

import me.experimental.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Data {

    private static String fileName = "data.yml";

    private Main plugin;
    private FileConfiguration manager = null;
    private File file = null;

    public Data(Main plugin) {
        this.plugin = plugin;
        saveDefault();
    }
    public void reload() {
        if(file == null) {
            this.file = new File(this.plugin.getDataFolder(), fileName);
        }
        this.manager = new YamlConfiguration().loadConfiguration(file);
        InputStream defaultStream = this.plugin.getResource(fileName);
        if(defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.manager.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration get() {
        if(manager == null) {
            reload();
        }
        return this.manager;
    }

    public void save() throws IOException {
        if(manager == null || file == null) {
            return;
        }
        this.get().save(file);
    }

    public void saveDefault() {
        if(this.file == null) {
            this.file = new File(this.plugin.getDataFolder(), fileName);
        }
        if(!(this.file.exists())) {
            this.plugin.saveResource(fileName, false);
        }
    }
}
